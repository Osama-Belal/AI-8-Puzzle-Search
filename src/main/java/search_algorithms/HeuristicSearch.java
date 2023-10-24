package search_algorithms;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


public class HeuristicSearch<T extends Comparable<T>> extends Search<T> {
    boolean isManhattan;
    int initialState;
    HashMap<T, Pair<Double, T>> childParent ;

    public HeuristicSearch(char type) {
        //type is either M for Manhattan distance or E for Euclidean distance
        isManhattan = type == 'M';
        explored = new HashSet<>();
        visited = new HashSet<>();
        neighbors = new Neighbors<>();
        toGoalPathCost = 0;
        reachedGoalState = false;
        initialState = 12345678;
        childParent = new HashMap<>();
    }

    double manhattanDistance(T state) {
        int stateInt = (Integer) state;

        int manhattanDistance = 0;
        for (int i = 8; i >= 0; i--) {
            int stateDigit = stateInt % 10;
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
        int stateInt = (Integer) state;

        double euclideanDistance = 0;
        for (int i = 8; i >= 0; i--) {
            int stateDigit = stateInt % 10;
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
        PriorityQueue<Pair<Double, T>> frontier = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey().compareTo(b.getKey()), 0));
        double Fn = this.isManhattan ? manhattanDistance(initialState) : EuclideanDistance(initialState);
        frontier.add(Pair.of(Fn, initialState));
        childParent.put(initialState, Pair.of(0.0, initialState));
        visited.add(initialState);

        T currentState;
        while (!frontier.isEmpty()) {
            currentState = frontier.poll().getValue();
            explored.add(currentState);

            if (goalState.equals(currentState)) {
                reachedGoalState = true;
                return true;
            }

            for (T neighbor : neighbors.getNeighbors(currentState)) {
                if (!visited.contains(neighbor)) {
                    double depth = childParent.get(currentState).getLeft() + 1;
                    this.toGoalPathCost = (int)Math.max(this.toGoalPathCost, depth);
                    double fn = (this.isManhattan ? manhattanDistance(neighbor) : EuclideanDistance(neighbor)) + depth;
                    frontier.add(Pair.of(fn, neighbor));
                    childParent.put(neighbor, Pair.of(depth, currentState));
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }

    @Override
    public T getParent(T state) {
        return childParent.get(state).getRight();
    }

    @Override
    public Integer getDepth() {
        return this.toGoalPathCost;
    }

    @Override
    public Integer getCostOfPath() {
        return childParent.get(initialState).getLeft().intValue();
    }

    @Override
    public Integer getNodesExpanded() {
        return explored.size();
    }

    @Override
    public ArrayList<T> getPath(T initialState, T goalState) {
        ArrayList<T> path = new ArrayList<>();
        T state = (reachedGoalState) ? goalState : null;
        while (!Objects.equals(state, initialState)) {
            path.add(state);
            state = childParent.get(state).getRight();
        }
        path.add(initialState);
        Collections.reverse(path);
        return path;
    }
}
