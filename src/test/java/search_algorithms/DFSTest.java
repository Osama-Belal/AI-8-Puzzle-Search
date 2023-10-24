package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    FirstSearch dfs = new FirstSearch<>('D');
    long goalState = 123456780L;
    @Test
    void SearchAndFindGoal()
    {
        boolean searchResult = dfs.search(125340678L, goalState);
        assertTrue(searchResult);
        System.out.println(dfs.getNodesExpanded());
    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsOne()
    {
        boolean searchResult = dfs.search(142658730L, goalState);
        assertTrue(searchResult);
        System.out.println(dfs.getNodesExpanded());
    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsTwo()
    {
        boolean searchResult = dfs.search(102754863L, goalState);
        assertTrue(searchResult);
        System.out.println(dfs.getNodesExpanded());
    }

    @Test
    void SearchAndNotFindGoal()
    {
        boolean searchResult = dfs.search(123456870L, goalState);
        assertFalse(searchResult);
        System.out.println(dfs.getNodesExpanded());
    }
}