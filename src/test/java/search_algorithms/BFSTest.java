package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    FirstSearch bfs = new FirstSearch<>('B');
    long goalState = 123456780L;
    @Test
    void SearchAndFindGoal()
    {
        boolean searchResult = bfs.search(125340678L, goalState);
        assertTrue(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsOne()
    {
        boolean searchResult = bfs.search(142658730L, goalState);
        assertTrue(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsTwo()
    {
        boolean searchResult = bfs.search(102754863L, goalState);
        assertTrue(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }

    @Test
    void SearchAndNotFindGoal()
    {
        boolean searchResult = bfs.search(123456870L, goalState);
        assertFalse(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }
}