import java.util.Random;
import java.util.Scanner;
 
// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRollerInJava {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }, 
                           { { 0, 0, 1 }, { 0, 0, 0 }, { 1, 0, 0 } },
                           { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } }, 
                           { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } },
                           { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } }, 
                           { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 } } };
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceRollerInJava dice = new DiceRollerInJava();
        int count = 0;

        while (true) {
            System.out.println("Type 'odd' to get odd results, or 'even' to get even results");
            String choice = scanner.nextLine();

            System.out.println("How many dices you want to roll?");
            int dices = Integer.valueOf(scanner.nextLine());

            for (int i = 0; i < dices; i++)
            {
                int result = dice.roll();
                if (choice.equalsIgnoreCase("odd")) {
                    while ((result % 2) == 0) {
                        result = dice.roll();
                    }
                }

                if (choice.equalsIgnoreCase("even")) {
                    while ((result % 2) == 1) {
                        result = dice.roll();
                    }
                }

                System.out.println("Times the dice has been rolled: " + ++count);
                System.out.println("dice face value:" + result);
                dice.draw(result);
            }
            System.out.println("Roll again? (type no to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n") || 
                    input.equalsIgnoreCase("no")) {
                System.out.println("Bye!");
                scanner.close();
                return;
            }
        }
    }
 
    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        System.out.println("-----");
 
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----");
 
    }
 
    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}