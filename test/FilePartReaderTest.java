import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private String testFilePath = "test/resources/test.txt";

    @Test
    public void TestReadingThrowsIOException() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(testFilePath, 1, 5);
        assertThrows(IOException.class, () -> filePartReader.read());

    }

    @Test
    public void testReadingWholeFile() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(testFilePath, 1, 5);
        String expected = "I am testing if i wrote the right code\n" +
                "Madam is a Palindromes\n" +
                "More  than one  space\n" +
                "new Line\n";
        assertEquals(expected, filePartReader.read());

    }

}