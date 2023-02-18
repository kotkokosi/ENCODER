package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class IOFoundation {

    public ArrayList<Character> fileToCharArray(Path inputFile) {
        try (BufferedReader buffer = Files.newBufferedReader(inputFile)) {
            StringBuilder str = new StringBuilder();
            while (buffer.ready()) {
                str.append((char) buffer.read());
            }
            return (ArrayList<Character>) (str.toString()).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void charArrayToFile(ArrayList<Character> message, Path outputFile) {
        try (BufferedWriter buffer = Files.newBufferedWriter(Files.createFile(outputFile))) {
            buffer.write(message.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
