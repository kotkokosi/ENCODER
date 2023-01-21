package services;

import controller.ParameterInput;

import java.nio.file.Path;

import static constans.Alfabet.RU;

public class Decoder extends IOFoundation {
    public Path getInputFile() {
        return inputFile;
    }

    public Path getOutputFile() {
        return outputFile;
    }

    public int getKey() {
        return key;
    }

    private Path inputFile;
    private Path outputFile;
    private int key;

    public Decoder() {
        this.key = ParameterInput.enterKey();
        this.inputFile = ParameterInput.enterInputFile();
        this.outputFile = ParameterInput.enterOutFile();
    }

    public void decoding(int key, Path inputFile, Path outputFile) {
        char[] message = fileToCharArray(inputFile);
        char[] letters = RU;

        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (message[i] == letters[j]) {
                    int index = Math.abs(key) % (letters.length - 1);
                    int num = Math.abs(j - index);
                    message[i] = letters[num];
                    break;
                }
            }
        }
        charArrayToFile(message, outputFile);
    }
}
