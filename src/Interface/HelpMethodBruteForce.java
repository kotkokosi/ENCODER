package Interface;

import java.util.ArrayList;

public interface HelpMethodBruteForce {
    boolean spaceFrequency(ArrayList<Character> decoderArray);

    boolean letterAaFrequency(ArrayList<Character> decoderArray);

    ArrayList<Character> actionToCode(int key, ArrayList<Character> message, ArrayList<Character> ruAlphabet);

    int position(int nowMarkRu, int key, int ruAlphabetLength);
}
