package Interface;

import java.nio.file.Path;

public interface Action {
    void actionToCode(int key, Path inputFile, Path outputFile);
}
