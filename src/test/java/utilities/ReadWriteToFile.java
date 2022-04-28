package utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadWriteToFile {

    public static void main(String[] args) throws IOException {

        Path filePath;
        filePath = Paths.get("src/test/resources/file_for_demo");

        String fileContent = new String(Files.readAllBytes(filePath));
        System.out.println(fileContent);

        Files.write(filePath, (System.lineSeparator() + "Test").getBytes(StandardCharsets.UTF_8));
        Files.write(
                Paths.get("src/test/resources/file_for_demo"),
                "\r\nNewTestMessage".getBytes(),
                StandardOpenOption.APPEND);
    }
}
