package search_algorithms;

import data_type.Queue;
import data_type.Stack;

import java.util.HashMap;
import java.util.HashSet;

public class FirstSearch<T> extends Search<T>{
    public FirstSearch(char type){
        switch (type) {
            case 'B' -> frontier = new Queue<>();
            case 'D' -> frontier = new Stack<>();
        }

        explored = new HashSet<>();
        visited = new HashSet<>();
        parent = new HashMap<>();
    }

    @Override
    public void search(T initialState, T goalState) {

    }

    @Override
    public T getParent(T state) {
        return null;
    }

    @Override
    public T getDepth(T state) {
        return null;
    }

    @Override
    public T getStatesExplored() {
        return null;
    }

    @Override
    public T[] getNeighbors(T state) {
        return null;
    }

    @Override
    public T[] getPath(T state) {
        return null;
    }
}
