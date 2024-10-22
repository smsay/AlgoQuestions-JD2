package main.java.week_27_SQL_newFeatures_readWriteFiles.readWriteExample_Java11;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ScannerExample {
    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        File file = new File("a01_weeks/src/main/java/week_27_SQL_newFeatures_readWriteFiles/readWriteExample_Java11/data.txt");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\s+");

        List<Person> people = new ArrayList<>();
        while (scanner.hasNext()) {
            String name = scanner.next();
            int age = scanner.nextInt();
            double gpa = scanner.nextDouble();

            people.add(new Person(name, age, gpa));
        }
        System.out.println("people = " + people);

        scanner.close();

    }
}

