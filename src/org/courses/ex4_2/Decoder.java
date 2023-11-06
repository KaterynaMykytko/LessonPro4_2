package org.courses.ex4_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {
    public static void main(String[] args) throws IOException {

        Path pathToFile = Paths.get("./Decoder.txt");

        Files.write(pathToFile, ("We are going to the cinema tomorrow, after the film " +
                "we are planing to play in the park.").getBytes(), StandardOpenOption.CREATE);

        List<String> sentence  = Files.readAllLines(pathToFile);
        String regex = "\\b(?:in|after|to)\\b";

        Pattern pattern = Pattern.compile(regex);

        sentence.forEach(s -> {
            Matcher matcher = pattern.matcher(s);

            while (matcher.find()) {
                String newSentence = matcher.replaceAll("java");
                try {
                    Files.write(pathToFile, newSentence.getBytes(),StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
