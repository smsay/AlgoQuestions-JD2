package main.java.week_08;

public class ThiefFoxRefactored {

    public static void main(String[] args) {
        checkSuspect("Fox1", true, "BLACK", true, 3);
        checkSuspect("Fox2", true, "BLACK", true, 2);
        checkSuspect("Fox3", true, "BLACK", true, 3);
        checkSuspect("Fox4", false, "GRAY", true, 3);
    }

    private static void checkSuspect(String foxName, boolean wearsCoat, String coatColor, boolean hasATorch, int bagCount) {
        if (wearsCoat && coatColor.equals("BLACK") && hasATorch && bagCount == 3) {
            System.out.println("\uD83E\uDD8A " + foxName + " is one of the suspects! \uD83E\uDD14");
        } else {
            System.out.println("\uD83E\uDD8A " + foxName + " cleared of charges!");
        }
    }
}

