package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOFoundation {
    public char[] fileToCharArray(Path inputFile) {
        try (BufferedReader buffer = Files.newBufferedReader(inputFile)) {
            StringBuilder str = new StringBuilder();
            while (buffer.ready()) {
                str.append((char) buffer.read());
            }
            return (str.toString()).toCharArray();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void charArrayToFile(char[] message, Path outputFile) {
        try (BufferedWriter buffer = Files.newBufferedWriter(Files.createFile(outputFile))) {
            buffer.write(message);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
