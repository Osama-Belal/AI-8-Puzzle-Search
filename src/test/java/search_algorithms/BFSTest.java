package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void SearchAndFindGoal() {
        var bfs = new FirstSearch<>('B');
        boolean searchResult = bfs.search(120345678, 12345678);
        assertTrue(searchResult);
    }

    @Test
    void SearchAndNotFindGoal() {
        var bfs = new FirstSearch<>('B');
        boolean searchResult = bfs.search(123456870, 12345678);
        assertFalse(searchResult);
    }
}