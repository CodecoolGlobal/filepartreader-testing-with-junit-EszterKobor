import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private String testFilePath = "test/resources/test.txt";

    @Test
    public void TestReadPartGiveBackException() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("valami", 1, 3);
        assertEquals("file is not founded", filePartReader.readLines());
    }

    @Test
    public void TestReadFirstline() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(testFilePath, 1, 1);
        String expected = "I am testing if i wrote the right code";
        assertEquals(expected, filePartReader.readLines());
    }

    @Test
    public void TestReadFirstTwolines() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(testFilePath, 1, 2);
        String expected = "I am testing if i wrote the right code\nMadam is a Palindromes";
        assertEquals(expected, filePartReader.readLines());
    }

    @Test
    public void TestReadingThrowsIOException() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("valami", 1, 5);
        assertThrows(IOException.class, () -> filePartReader.read());

    }

    @Test
    public void testReadingWholeFile() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(testFilePath, 1, 4);
        String expected = "I am testing if i wrote the right code\n" +
                "Madam is a Palindromes\n" +
                "More  than one  space\n" +
                "new Line\n";
        assertEquals(expected, filePartReader.read());
    }

    @Test
    public void testIsFromLineBelow1ThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup(testFilePath, 0, 2);
        });
    }

    @Test
    public void testIsToLineBelowFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup(testFilePath, 3, 2);
        });
    }

}