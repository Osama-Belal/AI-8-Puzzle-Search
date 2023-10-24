package search_algorithms;

import java.util.ArrayList;

class Neighbors<T> {
    ArrayList<T> neighborsList = new ArrayList<>();
    ArrayList<Long> ib = new ArrayList<>();
    long newState;

    private long fastPower(long base, long power) {
        long result = 1;
        //recursive
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return base;
        }
        if (power % 2 == 0) {
            result = fastPower(base, power / 2);
            return result * result;
        }
        else {
            result = fastPower(base, (power - 1) / 2);
            return result * result * base;
        }
    }

    public long swapDigits(long stateLong, long indexOfZero, long possibleNeighbor)
    {
        long bbb = fastPower(10, 8 - indexOfZero) ;
        long digitIndex = fastPower(10, 8 - possibleNeighbor) ;
        long digit = (stateLong / digitIndex) % 10 ;
        return (stateLong - digit * digitIndex + digit * bbb) ;
    }

    ArrayList<T> getNeighbors(T state) {
        neighborsList.clear();
        ib.clear();
        if (state instanceof Long stateLong) {
            long indexOfZero = Long.toString(stateLong).indexOf('0');
            long zeroRow = indexOfZero / 3 ;
            long zeroCol = indexOfZero % 3 ;
            if (zeroCol > 0) {ib.add(indexOfZero - 1);}
            if (zeroCol < 2) {ib.add(indexOfZero + 1);}
            if (zeroRow > 0) {ib.add(indexOfZero - 3);}
            if (zeroRow < 2) {ib.add(indexOfZero + 3);}
            for (long possibleNeighbor : ib) {
                newState = swapDigits(stateLong, indexOfZero, possibleNeighbor);
                neighborsList.add((T) (Long) newState);
            }
        }
        System.out.println(neighborsList);
        return neighborsList;
    }
}
