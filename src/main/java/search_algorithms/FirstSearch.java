package search_algorithms;

import data_type.OurQueue;
import data_type.OurStack;

import java.util.*;
import java.util.function.Function;

public class FirstSearch<T> extends Search<T>{//T is the type of the state
    public FirstSearch(char type){//type is either 'B' or 'D' or 'A'
        switch (type) {
            case 'B' -> frontier = new OurQueue<>();
            case 'D' -> frontier = new OurStack<>();
            default -> System.err.println("wrong choice");
        }
<<<<<<< Updated upstream

        explored = new HashSet<>();
        visited = new HashSet<>();
        childParent = new HashMap<>();
        neighbors = new Neighbors<>();
        depth = 0 ;
        reachedGoalState = false;
=======
        explored = new HashSet<>() ;
        visited = new HashSet<>() ;
        childParent = new HashMap<>() ;
        depth = new HashMap<>() ;
        neighbors = new Neighbors<>() ;
        toGoalPathCost = -1 ;
        reachedGoalState = false ;
>>>>>>> Stashed changes
    }


    @Override
    public boolean search(T initialState, T goalState) {

        //push the initial state in the frontier and to frontier U explored hashset
        frontier.push(initialState);
        childParent.put(initialState, initialState);
        visited.add(initialState);
        //initialize current state variable
        T currentState ;
        while(! frontier.isEmpty())
        {
            //start with getting the front value in the frontier
            currentState = frontier.pop();
            //add this state to explored hashset and check if we reached the goal state
            explored.add(currentState);
            if(goalState.equals(currentState))
            {
                reachedGoalState = true;
                return reachedGoalState;
            }

            //if the current state is not the goal state then get its neighbors and
            //push them to frontier, frontier U explored hashset and to the parent-child hashmap
            for(T neighbor : neighbors.getNeighbors(currentState))
            {
                if(visited.contains(neighbor))
                {
                    frontier.push(neighbor);
                    childParent.put(neighbor, currentState);
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
    public Integer getDepth() { return depth; }

    //as here the cost of each step is one
    public Integer getCostOfPath() { return depth ; }

    @Override
    public ArrayList<T> getNodesExpanded() { return new ArrayList<>(explored); }

    @Override
    public ArrayList<T> getPath(T initialState , T goalState ) {
        //get the path from the goal state to the initial state
        T state = (reachedGoalState)? goalState : null ;
        //initialize the path to goal arraylist
        ArrayList<T> pathToGoal = new ArrayList<>();

        //iterate till we reach the initial state
        while (!(state.equals(initialState) || state.equals(null)))
        {
            pathToGoal.add(state);
            state = getParent(state);
        }
        //also assign the depth of the path to the depth variable here
        depth = pathToGoal.size();
        return pathToGoal;
    }
}
