package search_algorithms;

import data_type.OurQueue;
import data_type.OurStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FirstSearch<T> extends Search<T>{
    public FirstSearch(char type){
        switch (type) {
            case 'B' -> frontier = new OurQueue<>();
            case 'D' -> frontier = new OurStack<>();
            default -> System.err.println("wrong choice");
        }

        explored = new HashSet<>();
        visited = new HashSet<>();
        childParent = new HashMap<>();
        neighbors = new Neighbors<>();
        depth = 0 ;
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
                return true;
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
        T state = goalState ;
        ArrayList<T> pathToGoal = new ArrayList<>();
        while (!state.equals(initialState))
        {
            pathToGoal.add(state);
            state = getParent(state);
        }
        depth = pathToGoal.size();
        return new ArrayList<>();
    }
}
