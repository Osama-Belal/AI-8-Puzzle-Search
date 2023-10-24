package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    FirstSearch bfs = new FirstSearch<>('B');
    @Test
    void SearchAndFindGoal()
    {
        boolean searchResult = bfs.search(125340678L, 12345678L);
        assertTrue(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsOne()
    {
        boolean searchResult = bfs.search(142658730L, 12345678L);
        assertTrue(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }

    @Test
    void SearchAndFindGoalWithIncreasedStepsTwo()
    {
        boolean searchResult = bfs.search(102754863L, 12345678L);
        assertTrue(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }

    @Test
    void SearchAndNotFindGoal()
    {
        boolean searchResult = bfs.search(123456870L, 12345678L);
        assertFalse(searchResult);
        System.out.println(bfs.getNodesExpanded());
    }
}