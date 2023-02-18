package services;

import java.util.ArrayList;
import java.util.Scanner;

import static constans.Alphabet.RU_ALPHABET;
import static constans.Alphabet.UA_ALPHABET;
import static constans.MessageForSelection.ADVICE;
import static constans.MessageForSelection.CHOISE_TO_LANGUAGE;

public class Language {
    private static ArrayList<Character> language;

    public static ArrayList<Character> getLanguage() {
        return language;
    }

    public void setLanguage() {
        System.out.print(CHOISE_TO_LANGUAGE);
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String s = sc.nextLine();
                if (s.equals("1")) {
                    Language.language = (ArrayList<Character>) RU_ALPHABET;
                    break;
                } else if (s.equals("2")) {
                    Language.language = (ArrayList<Character>) UA_ALPHABET;
                    break;
                } else {
                    System.out.println("-".repeat(120));
                    System.out.print(ADVICE + "\uD83D\uDCA9 \n" + CHOISE_TO_LANGUAGE);
                }
            }
        }
    }
}
