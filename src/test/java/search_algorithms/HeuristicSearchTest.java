package search_algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeuristicSearchTest {

    HeuristicSearch<Long> heuristicSearchM = new HeuristicSearch<>('M');
    HeuristicSearch<Long> heuristicSearchE = new HeuristicSearch<>('E');
    long goalState = 12345678L;

    Integer minDepth = 0;
    Integer maxDepth = 0;
    Integer minPathCost = 0;
    Integer maxPathCost = 0;

    Integer minNodesExpanded = 0;
    Integer maxNodesExpanded = 0;

    @Test
    void manhattanDistanceOne() {
        int dist = heuristicSearchM.manhattanDistance(243657801L);
        assertEquals(3+3+2+3+1+1+1+2+2, dist);
    }

    @Test
    void manhattanDistanceTwo() {
        int dist = heuristicSearchM.manhattanDistance(840175236L);
        assertEquals(2+2+4+2+1+0+2+1+4, dist);
    }

//    @Test
    // TODO : fix this test
//    void euclideanDistanceOne() {
//        double dist = heuristicSearchM.manhattanDistance(243657801L);
//        assertEquals(2.24+2.24+2+1+1+0+2.24+1.41+2, dist);
//    }

//    @Test
    // TODO : fix this test
//    void euclideanDistanceTwo() {
//        int dist = heuristicSearchM.manhattanDistance(243657801L);
//        assertEquals(3+3+2+3+1+1+1+2+2, dist);
//    }

    @Test
    void searchAndFindGoalWithEuclidean() {
        long starttime = System.nanoTime();
        boolean searchResult = heuristicSearchE.search(125340678L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchE.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchE.getDepth());
        System.out.println("Cost of path:"+heuristicSearchE.getCostOfPath());
        assertTrue(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndFindGoalWithManhattan() {
        long starttime = System.nanoTime();
        boolean searchResult = heuristicSearchM.search(125340678L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchM.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchM.getDepth());
        System.out.println("Cost of path:"+heuristicSearchM.getCostOfPath());

        assertTrue(searchResult);
        System.out.println(heuristicSearchM.getNodesExpanded());
    }

    @Test
    void searchAndFindGoalIncreasedStepsOneWithEuclidean() {
        boolean searchResult = heuristicSearchE.search(142658730L, goalState);
        assertTrue(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndFindGoalIncreasedStepsOneWithManhattan() {
        long starttime = System.nanoTime();
        boolean searchResult = heuristicSearchM.search(142658730L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchM.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchM.getDepth());
        System.out.println("Cost of path:"+heuristicSearchM.getCostOfPath());

        assertTrue(searchResult);
        System.out.println(heuristicSearchM.getNodesExpanded());
    }

    @Test
    void numbersTestManhattan() {
        long starttime = System.nanoTime();
        boolean searchResult = heuristicSearchM.search(413026758L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchM.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchM.getDepth());
        System.out.println("Cost of path:"+heuristicSearchM.getCostOfPath());


        assertTrue(searchResult);

    }

    @Test
    void searchAndFindGoalIncreasedStepsTwoWithEuclidean() {
        long starttime = System.nanoTime();
        boolean searchResult = heuristicSearchE.search(102754863L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchE.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchE.getDepth());
        System.out.println("Cost of path:"+heuristicSearchE.getCostOfPath());
        assertTrue(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndFindGoalIncreasedStepsTwoWithManhattan() {
        long starttime = System.nanoTime();
        boolean searchResult = heuristicSearchM.search(102754863L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchM.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchM.getDepth());
        System.out.println("Cost of path:"+heuristicSearchM.getCostOfPath());

        assertTrue(searchResult);

    }

    @Test
    void searchAndNotFindGoalWithEuclidean() {
        boolean searchResult = heuristicSearchE.search(123456870L, goalState);
        assertFalse(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndNotFindGoalWithManhattan() {
        long starttime = System.nanoTime();

        boolean searchResult = heuristicSearchM.search(123456870L, goalState);
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + "ms");
        System.out.println("Nodes expanded:"+heuristicSearchM.getNodesExpanded());
        System.out.println("Depth:"+heuristicSearchM.getDepth());
        System.out.println("Cost of path:"+heuristicSearchM.getCostOfPath());

        assertFalse(searchResult);
        System.out.println(heuristicSearchM.getNodesExpanded());
    }


    @Test
    void getDepthManhattan() {
        heuristicSearchM.search(123456870L, goalState);
        assertTrue( (minDepth <= heuristicSearchM.getDepth() && heuristicSearchM.getDepth() <= maxDepth));
    }

    @Test
    void getCostOfPathManhattan() {
        heuristicSearchM.search(123456870L, goalState);
        assertTrue( (minPathCost <= heuristicSearchM.getCostOfPath() && heuristicSearchM.getCostOfPath() <= maxPathCost));
    }

    @Test
    void getNodesExpandedManhattan() {
        heuristicSearchM.search(123456870L, goalState);
        assertTrue( (minNodesExpanded <= heuristicSearchM.getNodesExpanded() && heuristicSearchM.getNodesExpanded() <= maxNodesExpanded));
    }


    //
    @Test
    void getDepthEuclidean() {
        heuristicSearchE.search(123456870L, goalState);
        assertTrue( (minDepth <= heuristicSearchE.getDepth() && heuristicSearchE.getDepth() <= maxDepth));
    }

    @Test
    void getCostOfPathEuclidean() {
        heuristicSearchE.search(123456870L, goalState);
        assertTrue( (minPathCost <= heuristicSearchE.getCostOfPath() && heuristicSearchE.getCostOfPath() <= maxPathCost));
    }

    @Test
    void getNodesExpandedEuclidean() {
        heuristicSearchE.search(123456870L, goalState);
        assertTrue( (minNodesExpanded <= heuristicSearchE.getNodesExpanded() && heuristicSearchE.getNodesExpanded() <= maxNodesExpanded));
    }
}