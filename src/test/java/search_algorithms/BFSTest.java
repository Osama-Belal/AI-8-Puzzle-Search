package search_algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void SearchAndFindGoal() {
        var firstSearch = new FirstSearch<>('B');
        boolean searchResult = firstSearch.search(103256489, 12345678);
        assertTrue(searchResult);
    }
}