package services;

import Interface.ActionBruteForce;
import Interface.HelpMethodBruteForce;
import controller.ParameterInput;
import java.nio.file.Path;
import java.util.ArrayList;


public class BruteForce extends IOFoundation implements ActionBruteForce, HelpMethodBruteForce {
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

    public void bruteForce(Path inputFile, Path outputFile, ArrayList<Character> language) {
        ArrayList<Character> messageArray = fileToCharArray(inputFile);
        ArrayList<Character> massageCopyArray = messageArray;

        for (int key = 0; key < messageArray.size(); key++) {
            messageArray = actionToCode(key, messageArray, language);
            if (spaceFrequency(messageArray) && letterAaFrequency(messageArray)) {
                charArrayToFile(messageArray, outputFile);
                break;
            }
            messageArray = massageCopyArray;
        }
    }

    public boolean spaceFrequency(ArrayList<Character> decoderArray) {
        double result =(double) decoderArray.stream()
                .filter(c -> (c == ' '))
                .count() / decoderArray.size();
        return result >= 0.120 && result <= 0.170;
    }

    public boolean letterAaFrequency(ArrayList<Character> decoderArray) {
        double result =(double) decoderArray.stream()
                .filter(c -> (c == 'А' || c == 'а'))
                .count() / decoderArray.size();
        return result >= 0.040 && result <= 0.090;
    }

    public ArrayList<Character> actionToCode(int key, ArrayList<Character> message, ArrayList<Character> ruAlphabet) {
        for (int i = 0; i < message.size(); i++) {
            for (int j = 0; j < ruAlphabet.size(); j++) {
                if (message.get(i) == ruAlphabet.get(j)) {
                    message.set(i, ruAlphabet.get(position(j, key, ruAlphabet.size())));
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
