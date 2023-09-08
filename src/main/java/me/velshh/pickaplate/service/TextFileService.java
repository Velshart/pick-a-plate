package me.velshh.pickaplate.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class TextFileService {
    private List<String> englishWords;
    private List<String> polishWords;

    public TextFileService() {
        loadFiles();
    }

    private void loadFiles() {
        Path englishWordsFilePath = Path.of("englishwords.txt");
        Path polishWordsFilePath = Path.of("polishwords.txt");
        try {
            this.englishWords = Files.readAllLines(englishWordsFilePath);
            this.polishWords = Files.readAllLines(polishWordsFilePath);

        }catch (IOException ex) {
            this.englishWords = Collections.emptyList();
            this.polishWords = Collections.emptyList();

        }
    }

    public List<String> getEnglishWords() {
        return englishWords;
    }

    public List<String> getPolishWords() {
        return polishWords;
    }
}
