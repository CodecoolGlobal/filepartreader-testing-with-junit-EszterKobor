import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = null;
        this.fromLine = 1;
        this.toLine = 1;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine) {

        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String read() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return content;
    }

    public String readLines () throws IOException {
        String content = read();
        String[] lines = content.split("/n");
        String[] partLines = Arrays.copyOfRange(lines, fromLine.intValue(), toLine.intValue() + 1);
        String partContent = String.join("/n", partLines);
        return partContent;
    }


}
