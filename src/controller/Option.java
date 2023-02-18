package controller;

import services.BruteForce;
import services.Coder;
import services.Decoder;
import services.Language;

import static constans.MessageForSelection.SUCCESSFULL;
import static services.Language.getLanguage;

public class Option {
    public void optionEncryption() {
        switch (ParameterInput.enterMode()) {
            case 1 -> {
                Coder coder = new Coder();
                coder.actionToCode(coder.getKey(), coder.getInputFile(), coder.getOutputFile());
                System.out.println(SUCCESSFULL);
            }
            case 2 -> {
                Decoder decoder = new Decoder();
                decoder.actionToCode(decoder.getKey(), decoder.getInputFile(), decoder.getOutputFile());
                System.out.println(SUCCESSFULL);
            }
            case 3 -> {
                BruteForce bruteForce = new BruteForce();
                bruteForce.bruteForce(bruteForce.getInputFile(), bruteForce.getOutputFile(), getLanguage());
                System.out.println(SUCCESSFULL);
            }
            case 4 -> {
                Language language = new Language();
                language.setLanguage();
                optionEncryption();
            }
            default -> throw new IllegalStateException("Unexpected value: " + ParameterInput.enterMode());
        }
    }
}
