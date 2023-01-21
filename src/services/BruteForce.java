package services;

import controller.ParameterInput;

import java.nio.file.Path;
import java.util.Arrays;

import static constans.Alfabet.RU;

public class BruteForce extends IOFoundation {
    public Path getInputFile() {
        return inputFile;
    }

    public Path getOutputFile() {
        return outputFile;
    }

    private Path inputFile;
    private Path outputFile;

    public BruteForce() {
        this.inputFile = ParameterInput.enterInputFile();
        this.outputFile = ParameterInput.enterOutFile();
    }

    public void bruteForce(Path inputFile, Path outputFile) {
        char[] messageArray = fileToCharArray(inputFile);
        char[] massageCopyArray;
        char[] lettersArray = RU;

        for (int key = 0; key < messageArray.length; key++) {
            massageCopyArray = Arrays.copyOf(messageArray, messageArray.length);
            messageArray = decoder(key, messageArray, lettersArray);
            double spaceFrequencyResult = spaceFrequency(messageArray);
            double letterAaFrequencyResult = letterAaFrequency(messageArray);

            if (spaceFrequencyResult >= 0.120 && spaceFrequencyResult <= 0.170 && letterAaFrequencyResult >= 0.040 && letterAaFrequencyResult <= 0.090) {
                charArrayToFile(messageArray, outputFile);
                break;
            }
            messageArray = massageCopyArray;
        }
    }
    public double spaceFrequency(char[] decoderArray) {
        double count = 0;
        for (char c : decoderArray) {
            if (c == ' ') {
                count++;
            }
        }
        return count / decoderArray.length;
    }

    public double letterAaFrequency(char[] decoderArray) {
        double count = 0;
        for (char c : decoderArray) {
            if (c == 'А' || c == 'а') {
                count++;
            }
        }
        return count / decoderArray.length;
    }

    public char[] decoder(int key, char[] message, char[] letters) {
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (message[i] == letters[j]) {
                    int num = j - key < 0 ? (j - key) * -1 : j - key;
                    int index = num % (letters.length - 1);
                    message[i] = letters[index];
                    break;
                }
            }
        }
        return message;
    }
}
