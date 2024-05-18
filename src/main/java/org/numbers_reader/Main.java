package org.numbers_reader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar numbers_reader-jar.jar [path]");
            return;
        }
        final Path path = Paths.get(args[0]);
        try {
            NumbersReader numbersReader = new NumbersReader(path);
            if (numbersReader.isEmpty()) {
                System.out.println("No numbers found");
                return;
            }
            System.out.println("Min: " + numbersReader.getMin());
            System.out.println("Max: " + numbersReader.getMax());
            System.out.println("Sum: " + numbersReader.getSum());
            System.out.println("Mult: " + numbersReader.getMult());
        } catch (IOException e) {
            System.out.println("Error reading file: " + path.toAbsolutePath());
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}