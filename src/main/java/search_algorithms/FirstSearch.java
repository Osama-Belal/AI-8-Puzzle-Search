package search_algorithms;

import data_type.OurQueue;
import data_type.OurStack;

import java.util.*;
import java.util.function.Function;

public class FirstSearch<T> extends Search<T>{//T is the type of the state
    public FirstSearch(char type){
        //type is either 'B' or 'D' or 'A'
        switch (type) {
            case 'B' -> frontier = new OurQueue<>();
            case 'D' -> frontier = new OurStack<>();
            default -> System.err.println("wrong choice");
        }
        explored = new HashSet<>() ;
        visited = new HashSet<>() ;
        childParent = new HashMap<>() ;
        depth = new HashMap<>() ;
        neighbors = new Neighbors<>() ;
        toGoalPathCost = 0 ;
        reachedGoalState = false ;
    }


    @Override
    public boolean search(T initialState, T goalState) {

        //push the initial state in the frontier and to frontier U explored hashset
        frontier.push(initialState);
        childParent.put(initialState, initialState);
        visited.add(initialState);
        depth.put(initialState, 0);

        //initialize current state variable
        T currentState ;
        while(! frontier.isEmpty())
        {
            //start with getting the front value in the frontier
            currentState = frontier.pop();
            maxDepth = Math.max(maxDepth, depth.get(currentState));
            explored.add(currentState);

            if(goalState.equals(currentState))
            {
                reachedGoalState = true;
                toGoalPathCost = depth.get(currentState);
                return reachedGoalState;
            }

            //if the current state is not the goal state then get its neighbors and
            //push them to frontier, frontier U explored hashset and to the parent-child hashmap
            for(T neighbor : neighbors.getNeighbors(currentState))
            {
                if(!(visited.contains(neighbor)))
                {
                    frontier.push(neighbor);
                    childParent.put(neighbor, currentState);
                    depth.put(neighbor, depth.get(currentState) + 1);
                    visited.add(neighbor);
                }
            }
        }

        //didn't find the goal state
        return false;
    }

    @Override
    public T getParent(T state) { return childParent.get(state); }

    @Override
    public Integer getDepth() { return maxDepth; }

    //as here the cost of each step is one
    public Integer getCostOfPath() { return toGoalPathCost ; }

    @Override
    public Integer getNodesExpanded() { return explored.size(); }

    @Override
    public ArrayList<T> getPath(T initialState , T goalState ) {
        //get the path from the goal state to the initial state
        ArrayList<T> pathToGoal = new ArrayList<>();
        T state = (reachedGoalState)? goalState : null ;

        //iterate till we reach the initial state
        while (!(state.equals(initialState) || state.equals(null)))
        {
            pathToGoal.add(state);
            state = getParent(state);
        }
        //also assign the depth of the path to the depth variable here
        toGoalPathCost = pathToGoal.size();
        return pathToGoal;
    }
}
