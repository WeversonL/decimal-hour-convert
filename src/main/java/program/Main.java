package program;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String CUSTOM_MESSAGE = "%.2f%n";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter path of file with hours: ");
        String path = sc.nextLine();

        try {

            Path inputPath = Paths.get(path);
            List<String> lines = Files.readAllLines(inputPath);

            List<Float> decimalConvertedList = lines.stream()
                    .map(LocalTime::parse)
                    .map(Main::getDecimalTime)
                    .toList();

            System.out.println("-----");
            decimalConvertedList.forEach(hour -> System.out.printf(CUSTOM_MESSAGE, hour));
            System.out.println("-----");

        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }

    }

    private static float getDecimalTime(LocalTime hour) {
        return hour.getHour() + (float) hour.getMinute() / 60;
    }

}