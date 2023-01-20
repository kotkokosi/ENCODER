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
        int key1 = Math.abs(key);
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (message[i] == letters[j]) {
                    int num = j - key1 < 0 ? (j - key1) * -1 : j - key1;
                    int index = num % (letters.length - 1);
                    message[i] = letters[index];
                    break;
                }
            }
        }
        charArrayToFile(message, outputFile);
    }
}
