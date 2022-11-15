import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("        STREAK         \n" +
                        "-----------------------\n" +
                        "1. Single player game\n" +
                        "2. 2-player game\n" +
                        "3. View high-score table\n" +
                        "4. Exit\n");

        System.out.print("Input selection: ");
        input = sc.nextLine();

        switch(input) {
            case "1":
                singlePlayer();
                break;
            case "2":
                twoPlayer();
                break;
            case "3":
                highScore();
                break;
            case "4":
                System.out.println("Terminating program");
                System.exit(0);
                break;
            default:
                break;
        }

    }

    public static void singlePlayer() {
        System.out.println("Single player game");
    }

    public static void twoPlayer() {
        System.out.println("Two player game");
    }

    public static void highScore() {
        System.out.println("High score");
    }

}