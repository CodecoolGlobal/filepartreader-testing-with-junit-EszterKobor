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
        String content = new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");
        return content;
    }

    public String readLines () {
        try {
            String content = read();
            String[] lines = content.split("\n");
            String[] partLines = Arrays.copyOfRange(lines, fromLine - 1, toLine);
            String partContent = String.join("\n", partLines);
            return partContent;
        } catch (IOException exception) {
            return "file is not founded";
        }
    }


}
