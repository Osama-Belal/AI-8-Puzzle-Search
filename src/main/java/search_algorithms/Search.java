package search_algorithms;

import data_type.Frontier;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Search<T> {
    Frontier<T> frontier;
    HashSet<T> explored;
    HashSet<T> visited;
    HashMap<T, T> childParent;
    Neighbors<T> neighbors ;
    Integer depth ;

    boolean reachedGoalState;


    public abstract boolean search(T initialState, T goalState);
    public abstract T getParent(T state);
    public abstract Integer getDepth();
    public abstract Integer getCostOfPath();
    public abstract ArrayList<T> getNodesExpanded();
    public abstract ArrayList<T> getPath(T initialState, T goalState);

}
