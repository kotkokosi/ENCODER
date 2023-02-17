package controller;

import services.BruteForce;
import services.Coder;
import services.Decoder;

import static constans.MessageForSelection.SUCCESSFULL;

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
                bruteForce.bruteForce(bruteForce.getInputFile(), bruteForce.getOutputFile());
                System.out.println(SUCCESSFULL);
            }
            default -> throw new IllegalStateException("Unexpected value: " + ParameterInput.enterMode());
        }
    }
}
