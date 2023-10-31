package search_algorithms;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


public class HeuristicSearch<T extends Comparable<T>> extends Search<T> {
    boolean isManhattan;
    HashMap<T, Pair<Double, T>> childParent;

    public HeuristicSearch(char type) {
        // type is either M for Manhattan distance
        // or E for Euclidean distance
        isManhattan = type == 'M';
        explored = new HashSet<>();
        visited = new HashSet<>();
        neighbors = new Neighbors<>();
        childParent = new HashMap<>();
        depth = new HashMap<>();
    }

    int manhattanDistance(T state) {
        long stateInt = (Long) state;

        int manhattanDistance = 0;
        for (int i = 8; i >= 0; i--) {
            int stateDigit = (int) stateInt % 10;
            int stateRow = i / 3;
            int stateCol = i % 3;
            int goalRow = stateDigit / 3;
            int goalCol = stateDigit % 3;
            manhattanDistance += Math.abs(stateRow - goalRow) + Math.abs(stateCol - goalCol);
            stateInt /= 10;
        }
        return manhattanDistance;
    }

    double EuclideanDistance(T state) {
        long stateInt = (Long) state;

        double euclideanDistance = 0;
        for (int i = 8; i >= 0; i--) {
            int stateDigit = (int) (stateInt % 10);
            int stateRow = i / 3;
            int stateCol = i % 3;
            int goalRow = stateDigit / 3;
            int goalCol = stateDigit % 3;
            double distance = Math.sqrt(Math.pow(stateRow - goalRow, 2) + Math.pow(stateCol - goalCol, 2));
            euclideanDistance += distance;
            stateInt /= 10;
        }
        return euclideanDistance;
    }


    // now we will implement A* search algorithm
    @Override
    public boolean search(T initialState, T goalState) {
        startTime = System.nanoTime();
        PriorityQueue<Pair<Double, T>> frontier = new PriorityQueue<>((a, b) -> Long.compare(a.getKey().compareTo(b.getKey()), 0));
        double Fn = this.isManhattan ? manhattanDistance(initialState) : EuclideanDistance(initialState);
        frontier.add(Pair.of(Fn, initialState));
        childParent.put(initialState, Pair.of(0.0, initialState));
        visited.add(initialState);
        depth.put(initialState, 0);
        T currentState;
        while (!frontier.isEmpty()) {
            currentState = frontier.poll().getValue();
            explored.add(currentState);
            maxDepth = Math.max(maxDepth, depth.get(currentState));

            if (goalState.equals(currentState)) {
                reachedGoalState = true;
                toGoalPathCost = depth.get(currentState);
                endTime = System.nanoTime();
                runningTime = ((endTime - startTime) / 1000000L);
                return true;
            }

            for (T neighbor : neighbors.getNeighbors(currentState)) {
                if (!visited.contains(neighbor)) {
                    double currDepth = depth.get(currentState) + 1;
                    double fn = (this.isManhattan ? manhattanDistance(neighbor) : EuclideanDistance(neighbor)) + currDepth;
                    frontier.add(Pair.of(fn, neighbor));
                    childParent.put(neighbor, Pair.of(currDepth, currentState));
                    visited.add(neighbor);
                    depth.put(neighbor, depth.get(currentState) + 1);
                }
                // if the neighbor is already visited
                // then check if the current path is better than the previous one
                else if (visited.contains(neighbor) && !explored.contains(neighbor)) {
                    double currDepth = depth.get(currentState) + 1;
                    if (currDepth < depth.get(neighbor)) {
                        double fn = (this.isManhattan ? manhattanDistance(neighbor) : EuclideanDistance(neighbor)) + currDepth;
                        frontier.add(Pair.of(fn, neighbor));
                        childParent.put(neighbor, Pair.of(currDepth, currentState));
                        depth.put(neighbor, depth.get(currentState) + 1);
                    }
                }
            }
        }
        endTime = System.nanoTime();
        runningTime = ((endTime - startTime) / 1000000L);
        return false;
    }

    @Override
    public T getParent(T state) {
        return childParent.get(state).getRight();
    }

    @Override
    public Integer getDepth() {
        for (Integer depthValue : depth.values()) {
            this.maxDepth = Math.max(this.maxDepth, depthValue);
        }
        return maxDepth;
    }

    @Override
    public Integer getCostOfPath() {
        return this.toGoalPathCost;
    }

    @Override
    public Integer getNodesExpanded() {
        return explored.size();
    }

    public long getRunningTime() {
        return runningTime;
    }

    @Override
    public ArrayList<T> getPath(T initialState, T goalState) {
        ArrayList<T> path = new ArrayList<>();
        T state = (reachedGoalState) ? goalState : null;

        while (!(state == null || state.equals(initialState))) {
            path.add(state);
            state = childParent.get(state).getRight();
        }
        path.add(initialState);
        Collections.reverse(path);
        return path;
    }
}
