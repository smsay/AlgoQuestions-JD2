package main.java.week_09;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void main(String[] args) {

        //Format examples
        LocalDate date = LocalDate.now();
        System.out.println("\nDefault format of LocalDate= " + date);  // 2023-12-28
        System.out.println("specific format : " + date.format(DateTimeFormatter.ofPattern("d-MMM-y")));
        // 28-Dec-2023
        System.out.println("specific format : " + date.format(DateTimeFormatter.ofPattern("d-MMM-yy")));
        // 28-Dec-23
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Default format of LocalDateTime= " + dateTime);    // 2023-12-28T23:00:04.535844800
        System.out.println("specific format : " + dateTime.format(DateTimeFormatter.ofPattern("d-MMM-y HH:mm:ss")));
        Instant timestamp = Instant.now();                          // 28-Dec-2023 23:00:04
        System.out.println("Default format of Instant= " + timestamp); // 2023-12-28T20:00:04.536841900Z
        System.out.println("LocalDateTime.from(timestamp) = " + LocalDateTime.from(timestamp.atZone(ZoneId.of("Europe/Rome"))));
        System.out.println("LocalDateTime.from(timestamp) = " + LocalDateTime.from(timestamp.atZone(ZoneId.systemDefault())));

        //Parse examples
        LocalDateTime dt = LocalDateTime.parse("27-Apr-2014 21:39:48",
                DateTimeFormatter.ofPattern("d-MMM-y HH:mm:ss"));
        System.out.println("Default format after parsing = " + dt + "\n");  // 2014-04-27T21:39:48
    }
}
