package services;


import Interface.Action;
import Interface.ChangePosition;
import controller.ParameterInput;

import java.nio.file.Path;

import static constans.Alphabet.RU_ALPHABET;


public class Coder extends IOFoundation implements ChangePosition, Action {
    public Path getInputFile() {
        return inputFile;
    }

    public Path getOutputFile() {
        return outputFile;
    }

    public int getKey() {
        return key;
    }

    private final Path inputFile;
    private final Path outputFile;
    private final int key;

    public Coder() {
        super();
        this.key = ParameterInput.enterKey();
        this.inputFile = ParameterInput.enterInputFile();
        this.outputFile = ParameterInput.enterOutFile();
    }

    public void actionToCode(int key, Path inputFile, Path outputFile) { // Method encode
        char[] message = fileToCharArray(inputFile);
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < RU_ALPHABET.length; j++) {
                if (message[i] == RU_ALPHABET[j]) {
                    message[i] = RU_ALPHABET[position(j, key, RU_ALPHABET.length)];
                    break;
                }
            }
        }
        charArrayToFile(message, outputFile);
    }

    @Override
    public int position(int nowMarkRu, int key, int ruAlphabetLength) {
        return Math.abs(nowMarkRu + key) % (ruAlphabetLength - 1);
    }
}
