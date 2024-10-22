package main.java.week_27_SQL_newFeatures_readWriteFiles.readWriteExample_Java11;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Person {
    private String name;
    private int age;
    private double gpa;

    Person(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
}

