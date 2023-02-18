package Interface;

import java.util.ArrayList;

public interface HelpMethodBrutteForce {
    boolean spaceFrequency(ArrayList<Character> decoderArray);

    boolean letterAaFrequency(ArrayList<Character> decoderArray);

    ArrayList<Character> actionToCode(int key, ArrayList<Character> message, ArrayList<Character> ruAlphabetLength);

    int position(int nowMarkRu, int key, int ruAlphabetLength);
}
