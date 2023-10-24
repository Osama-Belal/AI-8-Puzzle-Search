package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    FirstSearch bfs = new FirstSearch<>('B');
    long goalState = 12345678L;
    Integer minDepth = 0;
    Integer maxDepth = 0;
    Integer minPathCost = 0;
    Integer maxPathCost = 0;

    Integer minNodesExpanded = 0;
    Integer maxNodesExpanded = 0;
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

    @Test
    void getDepth() {
        bfs.search(123456870L, goalState);
        assertTrue( (minDepth <= bfs.getDepth() && bfs.getDepth() <= maxDepth));
    }

    @Test
    void getCostOfPath() {
        bfs.search(123456870L, goalState);
        assertTrue( (minPathCost <= bfs.getCostOfPath() && bfs.getCostOfPath() <= maxPathCost));
    }

    @Test
    void getNodesExpanded() {
        bfs.search(123456870L, goalState);
        assertTrue( (minNodesExpanded <= bfs.getNodesExpanded() && bfs.getNodesExpanded() <= maxNodesExpanded));
    }

}