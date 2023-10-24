package search_algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeuristicSearchTest {

    HeuristicSearch<Long> heuristicSearchM = new HeuristicSearch<>('M');
    HeuristicSearch<Long> heuristicSearchE = new HeuristicSearch<>('E');
    long goalState = 123456780L;

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
    void getDepth() {

    }
//
//    @Test
//    void getCostOfPath() {
//    }
//
//    @Test
//    void getNodesExpanded() {
//    }
//
//    @Test
//    void getPath() {
//    }
}