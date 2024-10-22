package main.java.week_08;

public class Notebook {
    public static void main(String[] args) {
        String weekPrefix = "Week: ";
        String dayPrefix = "\tDay: ";

        //outer loop will iterate over weeks
        for (int weekCounter = 1; weekCounter < 5; weekCounter++) {
            System.out.println(weekPrefix + weekCounter);

            //inner loop will iterate over days of week
            // we need to start from 1 for each week
            //that's why we are assigning 1 to dayCounter for each week
            for (int dayCounter = 1; dayCounter < 8; dayCounter++) {
                System.out.println(dayPrefix + dayCounter);
            }
        }
        withWhileDoWhileLoop();
    }

    public static void withWhileDoWhileLoop(){
        String weekPrefix = "Week: ";
        String dayPrefix = "   Day: ";

        int weekCounter = 1;
        while (weekCounter <= 4){
            System.out.println(weekPrefix + weekCounter);
            int dayCounter = 1;
            do {
                System.out.println(dayPrefix + dayCounter);
                dayCounter++;
            } while (dayCounter <= 7);

            weekCounter++;
        }
    }
}
