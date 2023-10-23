package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void SearchAndFindGoal() {
        var firstSearch = new FirstSearch<>('B');
        boolean searchResult = firstSearch.search(120345678, 12345678);
        assertTrue(searchResult);
    }

    @Test
    void SearchAndNotFindGoal() {
        var firstSearch = new FirstSearch<>('B');
        boolean searchResult = firstSearch.search(123456870, 12345678);
        assertFalse(searchResult);
    }
}