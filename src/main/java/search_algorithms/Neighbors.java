package search_algorithms;

import java.util.ArrayList;

class Neighbors<T> {
    ArrayList<T> neighborsList = new ArrayList<>();
    ArrayList<Integer> ib = new ArrayList<>();
    long newState;

    private long fastPower(long base, long power) {
           long result = 1;
            while (power > 0) {
                if (power % 2 == 1) {
                    result *= base;
                }
                base *= base;
                power /= 2;
            }
            return result;
    }

    long swapDigits(long stateLong, long indexOfZero, long possibleNeighbor)
    {
        long zeroIndex = fastPower(10, 8 - indexOfZero) ;
        long digitIndex = fastPower(10, 8 - possibleNeighbor) ;
        long digit = (stateLong / digitIndex) % 10 ;
        return (stateLong - digit * digitIndex + digit * zeroIndex) ;
    }

    int getZeroIndex(long stateLong)
    {
        int indexOfZero = 0;
        for (int i = 0; i < 9; i++) {
            if ((stateLong % 10) == 0) {
                indexOfZero = i;
                break;
            }
            stateLong /= 10;
        }
        return 8-indexOfZero;
    }

    ArrayList<T> getNeighbors(T state) {
        neighborsList.clear();
        ib.clear();
        if (state instanceof Long stateLong) {
            int indexOfZero = getZeroIndex(stateLong);
            int zeroRow = indexOfZero / 3 ;
            int zeroCol = indexOfZero % 3 ;
            if (zeroCol > 0) {ib.add(indexOfZero - 1);}
            if (zeroCol < 2) {ib.add(indexOfZero + 1);}
            if (zeroRow > 0) {ib.add(indexOfZero - 3);}
            if (zeroRow < 2) {ib.add(indexOfZero + 3);}
            for (long possibleNeighbor : ib)
            {
                newState = swapDigits(stateLong, indexOfZero, possibleNeighbor);
                neighborsList.add((T) (Long) newState);
            }
        }

        return neighborsList;
    }
}
