package services;

import controller.ParameterInput;

import java.nio.file.Path;
import java.util.Arrays;

import static constans.Alphabet.RU_ALPHABET;

public class BruteForce extends IOFoundation {
    public Path getInputFile() {
        return inputFile;
    }

    public Path getOutputFile() {
        return outputFile;
    }

    private final Path inputFile;
    private final Path outputFile;

    public BruteForce() {
        this.inputFile = ParameterInput.enterInputFile();
        this.outputFile = ParameterInput.enterOutFile();
    }

    public void bruteForce(Path inputFile, Path outputFile) {
        char[] messageArray = fileToCharArray(inputFile);
        char[] massageCopyArray = Arrays.copyOf(messageArray, messageArray.length);

        for (int key = 0; key < messageArray.length; key++) {
            messageArray = actionToCode(key, messageArray, RU_ALPHABET);
            if (spaceFrequency(messageArray) && letterAaFrequency(messageArray)) {
                charArrayToFile(messageArray, outputFile);
                break;
            }
            messageArray = massageCopyArray;
        }
    }

    public boolean spaceFrequency(char[] decoderArray) {
        double count = 0;
        for (char c : decoderArray) {
            if (c == ' ') {
                count++;
            }
        }
        double result = count / decoderArray.length;
        return result >= 0.120 && result <= 0.170;
    }

    public boolean letterAaFrequency(char[] decoderArray) {
        double count = 0;
        for (char c : decoderArray) {
            if (c == 'А' || c == 'а') {
                count++;
            }
        }
        double result = count / decoderArray.length;
        return result >= 0.040 && result <= 0.090;
    }

    public char[] actionToCode(int key, char[] message, char[] ruAlphabetLength) {
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < ruAlphabetLength.length; j++) {
                if (message[i] == ruAlphabetLength[j]) {
                    message[i] = ruAlphabetLength[position(j, key, ruAlphabetLength.length)];
                    break;
                }
            }
        }
        return message;
    }

    public int position(int nowMarkRu, int key, int ruAlphabetLength) {
        int index = (Math.abs(key) % (ruAlphabetLength - 1));
        if (key >= 0) {
            if (nowMarkRu < index) {
                return ((ruAlphabetLength - 1) + nowMarkRu) - index;
            }
            return Math.abs(nowMarkRu - index) % (ruAlphabetLength - 1);
        } else {
            return Math.abs(nowMarkRu + index) % (ruAlphabetLength - 1);
        }
    }
}
