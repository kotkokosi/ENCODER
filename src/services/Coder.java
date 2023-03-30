package services;


import Interface.Action;
import Interface.HelpMethodAction;
import controller.ParameterInput;

import java.nio.file.Path;
import java.util.ArrayList;


import static constans.Alphabet.RU_ALPHABET;


public class Coder extends IOFoundation implements HelpMethodAction, Action {
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
    @Override
    public void actionToCode(int key, Path inputFile, Path outputFile) {
        ArrayList<Character> message = fileToCharArray(inputFile);
        for (int i = 0; i < message.size(); i++) {
            for (int j = 0; j < RU_ALPHABET.size(); j++) {
                if (message.get(i).equals(RU_ALPHABET.get(j))) {
                    message.set(i, RU_ALPHABET.get(position(j, key, RU_ALPHABET.size()))) ;
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
