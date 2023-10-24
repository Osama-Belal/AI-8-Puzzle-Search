package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    FirstSearch dfs = new FirstSearch<>('D');
    long goalState = 123456780L;
    Integer minDepth = 0;
    Integer maxDepth = 0;
    Integer minPathCost = 0;
    Integer maxPathCost = 0;
    Integer minNodesExpanded = 0;
    Integer maxNodesExpanded = 0;
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

    @Test
    void getDepth() {
        dfs.search(123456870L, goalState);
        assertTrue( (minDepth <= dfs.getDepth() && dfs.getDepth() <= maxDepth));
    }

    @Test
    void getCostOfPath() {
        dfs.search(123456870L, goalState);
        assertTrue( (minPathCost <= dfs.getCostOfPath() && dfs.getCostOfPath() <= maxPathCost));
    }

    @Test
    void getNodesExpanded() {
        dfs.search(123456870L, goalState);
        assertTrue( (minNodesExpanded <= dfs.getNodesExpanded() && dfs.getNodesExpanded() <= maxNodesExpanded));
    }
}