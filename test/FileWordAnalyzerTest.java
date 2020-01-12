import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private String testFile = "test/resources/test2.txt";
    private FilePartReader filePartReader = new FilePartReader();

    @Test
    public void testAlphabeticalSorting() {
        filePartReader.setup(testFile, 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("alphabetically", "check", "it","lets", "see"));
        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstring() {
        filePartReader.setup(testFile, 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("alphabetically");
        expected.add("lets");
        ArrayList<String> actual = new ArrayList<>(fileWordAnalyzer.getWordsContainingSubstring("et"));
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void getStringsWhichPalindromes() {
        filePartReader.setup(testFile, 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("plolp", "madam", "a"));
        ArrayList<String> actual = new ArrayList<>(fileWordAnalyzer.getStringsWhichPalindromes());
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);

    }



}