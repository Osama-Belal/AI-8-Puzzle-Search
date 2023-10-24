package search_algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NeighborsTest {

    Neighbors neighbors = new Neighbors();

    @Test
    void swapDigits()
    {
        long result = neighbors.swapDigits(123456780, 8, 7);
        assertEquals(123456708, result);
    }

    @Test
    void swapDigitsWithZeroAtFirstDigit()
    {
        long result = neighbors.swapDigits(12345678, 0, 1);
        assertEquals(102345678, result);
    }

    @Test
    void getNeighbors()
    {
        neighbors.getNeighbors(123456780L);
        assertEquals(123456708L, neighbors.neighborsList.get(0));
        assertEquals(123450786L, neighbors.neighborsList.get(1));
    }
    @Test
    void getNeighborsOfFaultyCase()
    {
        neighbors.getNeighbors(123456870L);
        assertEquals(123456807L, neighbors.neighborsList.get(0));
        assertEquals(123450876L, neighbors.neighborsList.get(1));
    }

}