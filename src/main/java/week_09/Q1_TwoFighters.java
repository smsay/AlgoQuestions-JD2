package main.java.week_09;
/*
Create a function that returns the name of the winner in a fight between two fighters.
Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
Both health and damagePerAttack will be integers larger than 0. You can mutate the Fighter objects.

Example:
  declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"

  Lew attacks Harry; Harry now has 3 health.
  Harry attacks Lew; Lew now has 6 health.
  Lew attacks Harry; Harry now has 1 health.
  Harry attacks Lew; Lew now has 2 health.
  Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.
public class Fighter {
  public String name;
  public int health, damagePerAttack;
  public Fighter(String name, int health, int damagePerAttack) {
    this.name = name;
    this.health = health;
    this.damagePerAttack = damagePerAttack;
  }
}
 */

public class Q1_TwoFighters {

    public static void main(String[] args) {
        // example 1
        Fighter tom = new Fighter();
        Fighter harry = new Fighter();
        tom.setInfo("Tom", 10, 2);
        harry.setInfo("Harry", 5, 4);

        // example 2
        Fighter jerry = new Fighter();
        Fighter harald = new Fighter();
        jerry.setInfo("Jerry", 30, 3);
        harald.setInfo("Harald", 20, 5);

        System.out.println(declareWinner(tom, harry, "Tom").equals("Tom wins"));
        System.out.println(declareWinner(tom, harry, "Tom").equals("Tom wins"));
        System.out.println(declareWinner(jerry, harald, "Jerry").equals("Harald wins"));

        // extra
        harry.setInfo("Harry", 20, 4);
        jerry.setInfo("Jerry", 30, 3);
        System.out.println(declareWinner(jerry, harry, "Harry").equals("Jerry wins"));
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attacker = fighter1.name.equals(firstAttacker) ? fighter1 : fighter2;
        Fighter defender = fighter1.name.equals(firstAttacker) ? fighter2 : fighter1;

        while (true) {
            defender.health = defender.health - attacker.damagePerAttack;

            if (defender.health <= 0) {
                return attacker.name + " wins";
            }

            // Swap attacker and defender for the next round
            Fighter temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    public static String declareWinner2(Fighter fighter1, Fighter fighter2, String attacker) {
        do {
            if (attacker.equals(fighter1.name)) {
                fighter2.health -= fighter1.damagePerAttack;
                attacker = fighter2.name;
            } else {
                fighter1.health -= fighter2.damagePerAttack;
                attacker = fighter1.name;
            }
        } while (fighter1.health > 0 && fighter2.health > 0);

        if (fighter2.health > 0) {
            return fighter2.name + " wins";
        } else {
            return fighter1.name + " wins";
        }
    }

    public static String declareWinner3(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attacker, defender;

        if (firstAttacker.equals(fighter1.name)) {
            attacker = fighter1;
            defender = fighter2;
        } else {
            attacker = fighter2;
            defender = fighter1;
        }
        while (true) {
            defender.health -= attacker.damagePerAttack;
            if (defender.health <= 0) {
                return attacker.name + " wins";  // attacker wins
            }
            attacker.health -= defender.damagePerAttack;
            if (attacker.health <= 0) {
                return defender.name + " wins";  // defender wins
            }
        }

    }
}

