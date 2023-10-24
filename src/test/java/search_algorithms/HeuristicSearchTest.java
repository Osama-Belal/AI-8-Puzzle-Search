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

    @Test
    void searchAndFindGoalWithEuclidean() {
        boolean searchResult = heuristicSearchE.search(125340678L, goalState);
        assertTrue(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndFindGoalWithManhattan() {
        boolean searchResult = heuristicSearchM.search(125340678L, goalState);
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
        boolean searchResult = heuristicSearchM.search(142658730L, goalState);
        assertTrue(searchResult);
        System.out.println(heuristicSearchM.getNodesExpanded());
        System.out.println(heuristicSearchM.getPath(142658730L, goalState));
    }

    @Test
    void numbersTestManhattan() {
        boolean searchResult = heuristicSearchM.search(413026758L, goalState);
        assertTrue(searchResult);
        System.out.println(heuristicSearchM.getNodesExpanded());
        System.out.println(heuristicSearchM.getPath(413026758L, goalState).size());
    }

    @Test
    void searchAndFindGoalIncreasedStepsTwoWithEuclidean() {
        boolean searchResult = heuristicSearchE.search(102754863L, goalState);
        assertTrue(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndFindGoalIncreasedStepsTwoWithManhattan() {
        boolean searchResult = heuristicSearchM.search(102754863L, goalState);
        assertTrue(searchResult);
        System.out.println(heuristicSearchM.getNodesExpanded());
    }

    @Test
    void searchAndNotFindGoalWithEuclidean() {
        boolean searchResult = heuristicSearchE.search(123456870L, goalState);
        assertFalse(searchResult);
        System.out.println(heuristicSearchE.getNodesExpanded());
    }

    @Test
    void searchAndNotFindGoalWithManhattan() {
        boolean searchResult = heuristicSearchM.search(123456870L, goalState);
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