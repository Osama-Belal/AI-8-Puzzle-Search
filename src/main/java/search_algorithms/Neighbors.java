package search_algorithms;

import java.util.ArrayList;

class Neighbors<T> {
    public int swapDigits(int state, int index1, int index2) {
        int digit1 = (state / (int) Math.pow(10, 8 - index1)) % 10;
        int digit2 = (state / (int) Math.pow(10, 8 - index2)) % 10;
        int newState = state - digit1 * (int) Math.pow(10, 8 - index1) + digit1 * (int) Math.pow(10, 8 - index2);
        newState = newState - digit2 * (int) Math.pow(10, 8 - index2) + digit2 * (int) Math.pow(10, 8 - index1);
        return newState;
    }
    ArrayList<T> getNeighbors(T state) {
        ArrayList<T> neighbors = new ArrayList<>();
        if (state instanceof Integer) {
            int stateInt = (Integer) state;
            int indexOfZero = Integer.toString(stateInt).indexOf('0');
            int row = indexOfZero / 3;
            int col = indexOfZero % 3;
            ArrayList<Integer> ib = new ArrayList<>();
            if (col > 0) {
                ib.add(indexOfZero - 1);
            }
            if (col < 2) {
                ib.add(indexOfZero + 1);
            }
            if (row > 0) {
                ib.add(indexOfZero - 3);
            }
            if (row < 2) {
                ib.add(indexOfZero + 3);
            }
            for (int i : ib) {
                int newState = swapDigits(stateInt, indexOfZero, i);
                neighbors.add((T) (Integer) newState);
            }
        }
        return neighbors;
    }


}
