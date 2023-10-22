package search_algorithms;

import data_type.Frontier;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Search<T> {
    Frontier<T> frontier;
    HashSet<T> explored;
    HashSet<T> visited;
    HashMap<T, T> parent;

    public abstract void search(T initialState, T goalState);

    public abstract T getParent(T state);

    public abstract T getDepth(T state);

    public abstract T getStatesExplored();

    public abstract T[] getNeighbors(T state);

    public abstract T[] getPath(T state);

}
