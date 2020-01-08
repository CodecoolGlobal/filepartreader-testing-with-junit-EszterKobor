import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically () {
        String content = filePartReader.readLines();
        ArrayList<String> wordArrayList = new ArrayList<String>(Arrays.asList(content.split("\\s+")));
        Collections.sort(wordArrayList);
        return wordArrayList;
    }

    public List getWordsContainingSubstring (String subString) {
        String content = filePartReader.readLines();
        ArrayList<String> wordsContainingSubstring = new ArrayList<String>();
        for(String word : content.split("\\s+")) {
            if (word.contains(subString)) {
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;
    }

    public List getStringsWhichPalindromes () {
        String content = filePartReader.readLines();
        ArrayList<String> palindromes = new ArrayList<String>();
        for(String word : content.split("\\s+")) {
            StringBuilder reversedWord = new StringBuilder();
            reversedWord.append(word);
            reversedWord = reversedWord.reverse();
            if (word.equals(reversedWord)) {
                palindromes.add(word);
            }
        }
        return palindromes;

    }

}
