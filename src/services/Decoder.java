package services;

import Interface.Action;
import Interface.HelpMethodAction;
import controller.ParameterInput;

import java.nio.file.Path;
import java.util.ArrayList;

import static constans.Alphabet.RU_ALPHABET;

public class Decoder extends IOFoundation implements Action, HelpMethodAction {
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

    public Decoder() {
        this.key = ParameterInput.enterKey();
        this.inputFile = ParameterInput.enterInputFile();
        this.outputFile = ParameterInput.enterOutFile();
    }

    @Override
    public void actionToCode(int key, Path inputFile, Path outputFile) {
        ArrayList<Character> message = fileToCharArray(inputFile);
        for (int i = 0; i < message.size(); i++) {
            for (int j = 0; j < RU_ALPHABET.size(); j++) {
                if (message.get(i) == RU_ALPHABET.get(j)) {
                    message.set(i, RU_ALPHABET.get(position(j, key, RU_ALPHABET.size())));
                    break;
                }
            }
        }
        charArrayToFile(message, outputFile);
    }

    @Override
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
