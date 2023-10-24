package search_algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeuristicSearchTest {

    HeuristicSearch<Long> heuristicSearchM = new HeuristicSearch<>('M');
    HeuristicSearch<Long> heuristicSearchE = new HeuristicSearch<>('E');

    @Test
    void manhattanDistance() {
        int dist = heuristicSearchM.manhattanDistance(243657801L);
        assertEquals(3+3+2+3+1+1+1+2+2, dist);
    }

    @Test
    void euclideanDistance() {
    }

    @Test
    void search() {
    }

    @Test
    void getParent() {
    }

    @Test
    void getDepth() {
    }

    @Test
    void getCostOfPath() {
    }

    @Test
    void getNodesExpanded() {
    }

    @Test
    void getPath() {
    }
}