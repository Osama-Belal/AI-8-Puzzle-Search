package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

<<<<<<< Updated upstream
    @Test
    void SearchAndFindGoal() {
        var bfs = new FirstSearch<>('B');
        boolean searchResult = bfs.search(120345678, 12345678);
=======
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
        long starttime = System.nanoTime();
        boolean searchResult = bfs.search(125340678L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+bfs.getNodesExpanded());
        System.out.println("Depth:"+bfs.getDepth());
        System.out.println("Cost of path:"+bfs.getCostOfPath());
        System.out.println("Path:"+bfs.getPath(125340678L, goalState));
>>>>>>> Stashed changes
        assertTrue(searchResult);
    }

    @Test
<<<<<<< Updated upstream
    void SearchAndNotFindGoal() {
        var bfs = new FirstSearch<>('B');
        boolean searchResult = bfs.search(123456870, 12345678);
=======
    void SearchAndFindGoalWithIncreasedStepsOne()
    {
        long starttime = System.nanoTime();
        boolean searchResult = bfs.search(142658730L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "nanoSec");
        System.out.println("Nodes expanded:"+bfs.getNodesExpanded());
        System.out.println("Depth:"+bfs.getDepth());
        System.out.println("Cost of path:"+bfs.getCostOfPath());

        assertTrue(searchResult);

    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsTwo()
    {
        long starttime = System.nanoTime();
        boolean searchResult = bfs.search(102754863L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "nanoSec");
        System.out.println("Nodes expanded:"+bfs.getNodesExpanded());
        System.out.println("Depth:"+bfs.getDepth());
        System.out.println("Cost of path:"+bfs.getCostOfPath());

        assertTrue(searchResult);

    }

    @Test
    void SearchAndNotFindGoal()
    {
        long starttime = System.nanoTime();
        boolean searchResult = bfs.search(123456870L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "nanoSec");
        System.out.println("Nodes expanded:"+bfs.getNodesExpanded());
        System.out.println("Depth:"+bfs.getDepth());
        System.out.println("Cost of path:"+bfs.getCostOfPath());
>>>>>>> Stashed changes
        assertFalse(searchResult);
    }
}