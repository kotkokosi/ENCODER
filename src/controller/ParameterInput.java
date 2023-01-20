package controller;

import java.nio.file.Path;
import java.util.Scanner;

import static constans.MessageForSelection.*;

public class ParameterInput {
    public static final Scanner sc = new Scanner(System.in);

    public static int enterMode() {
        System.out.print(CHOISE_TO_ENCODING);
        while (true) {
            String s = sc.nextLine();
            if (s.equals("1") || s.equals("2") || s.equals("3")) {
                return Integer.parseInt(s);
            } else {
                System.out.println("-".repeat(120));
                System.out.print(ADVICE + "\uD83D\uDCA9 \n" + CHOISE_TO_ENCODING);
            }
        }

    }

    public static int enterKey() {
        System.out.println("-".repeat(120));
        System.out.print(KEY_TO_ENCODING);
        while (true) {
            if (sc.hasNextInt()) {
                int key = sc.nextInt();
                sc.nextLine();
                return key;
            } else if (sc.hasNextLine()) {
                sc.nextLine();
                System.out.println("-".repeat(120));
                System.out.print(ADVICE + "\uD83D\uDCA9 \n" + KEY_TO_ENCODING);
            }
        }

    }

    public static Path enterInputFile() {
        System.out.println("-".repeat(120));
        System.out.print(FILE_TO_READ);
        while (true) {
            Path s = Path.of(sc.nextLine());
            if (s.toString().endsWith("txt")) {
                return s;
            } else {
                System.out.println("-".repeat(120));
                System.out.print(ADVICE + "\uD83D\uDCA9 \n" + TXT);
            }
        }
    }


    public static Path enterOutFile() {
        System.out.println("-".repeat(120));
        System.out.print(FILE_TO_RECORD);
        while (true) {
            Path s = Path.of(sc.nextLine());
            if (s.toString().endsWith("txt")) {
                sc.close();
                return s;
            } else {
                System.out.println("-".repeat(120));
                System.out.print(ADVICE + "\uD83D\uDCA9 \n" + TXT);
            }
        }
    }
}
