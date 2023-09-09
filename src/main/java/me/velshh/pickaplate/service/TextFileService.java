package me.velshh.pickaplate.service;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class TextFileService {
    private List<String> englishWords;
    private List<String> polishWords;
    private final BiFunction<List<String>, Character, List<String>> PLATE_GENERATING_FUNCTION = (wordList, character) -> {
        List<String> result = new ArrayList<>();

        wordList.stream()
            .filter(word -> word.charAt(0) == character)
                .map(word -> {
                    if(word.length() != 8) {
                        return character + "*" + " " + word;
                    }
                    return word;
                })
                .forEach(result::add);
        if(!result.isEmpty()) {
            return result;
        }
        return Collections.emptyList();
    };

    public TextFileService() {
        loadFiles();
    }

    public void generatePlates(boolean generatePolishPlates, boolean generateEnglishPlates, TextArea polishPlatesArea, TextArea englishPlatesArea, char firstLetter) {
        List<String> generatedEnglishPlates = new ArrayList<>();
        List<String> generatedPolishPlates = new ArrayList<>();

        if (generateEnglishPlates) {
            generatedEnglishPlates = PLATE_GENERATING_FUNCTION.apply(getEnglishWords(), firstLetter);
        }

        if (generatePolishPlates) {
            generatedPolishPlates = PLATE_GENERATING_FUNCTION.apply(getPolishWords(), firstLetter);
        }

        StringBuilder englishTextAreaContents = new StringBuilder();
        generatedEnglishPlates.forEach(plate -> englishTextAreaContents.append(plate).append("\n"));
        englishPlatesArea.setText(englishTextAreaContents.toString());

        StringBuilder polishTextAreaContents = new StringBuilder();
        generatedPolishPlates.forEach(plate -> polishTextAreaContents.append(plate).append("\n"));
        polishPlatesArea.setText(polishTextAreaContents.toString());
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


