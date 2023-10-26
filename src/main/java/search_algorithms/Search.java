package search_algorithms;

import data_type.Frontier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Search<T> {
    Frontier<T> frontier;
    HashSet<T> explored;
    HashSet<T> visited;
    HashMap<T, T> childParent;
    HashMap<T, Integer> depth;
    Neighbors<T> neighbors;
    Integer maxDepth = 0;
    Integer toGoalPathCost = 0;

    long startTime = 0;
    long endTime = 0;
    long runningTime = 0;

    boolean reachedGoalState = false;


    public abstract boolean search(T initialState, T goalState);
    public abstract T getParent(T state);
    public abstract Integer getDepth();
    public abstract Integer getCostOfPath();
    public abstract Integer getNodesExpanded();
    public abstract long getRunningTime();
    public abstract ArrayList<T> getPath(T initialState, T goalState);
    public boolean isReachedGoalState() { return reachedGoalState; }

}
