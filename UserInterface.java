import java.util.Scanner;

public class UserInterface {

    public static Prisoner prisoner;
    public static Scanner scanner;

    private static void showStatus() {
        System.out.println("\n=== Prisoner Status ===");
        System.out.println("Name: " + prisoner.getName());
        System.out.println("State: " + prisoner.getStatus());
        System.out.println("Position: X = " + prisoner.x + ", Y = " + prisoner.y + ", Z = " + prisoner.z);
        System.out.println("Crime: " + prisoner.getCrime());
        System.out.println("=========================");
    }
    
    public static void main(String[] args) {
        System.out.println("------------------------------------\n");
        System.out.println("WELCOME TO CHANDRA BIHAR PRISON.");
        System.out.println("------------------------------------\n");
        System.out.println("Enter a name for your player");
        String name = scanner.nextLine();
        System.out.println("Enter an age for your player");
        int age = scanner.nextInt();
        System.out.println("Enter any random 3 digit number");
        int prisonerNumber = scanner.nextInt();

        System.out.println(name + " is inside Chandra Bihar Prison's cell number: 212. They re planning to escape." );
        Prisoner player = new Prisoner(name, age, "Prisoner", "Heist", prisonerNumber, Status.IN_JAIL);
        scanner = new Scanner (System.in);

        while (true){
            showStatus();

            System.out.println("You'll be playing as a prisoner named: "+ name + ". He has been convicted for Heist.");

            System.out.print("\nEnter command: ");
            String command = scanner.nextLine().toLowerCase().trim();

            if (command.equals("exit")) {
                System.out.println("Exiting game...");
                break;
            } else if (command.equals("move east")) {
                prisoner.goEast();
            } else if (command.equals("move west")) {
                prisoner.goWest();
            } else if (command.equals("move north")) {
                prisoner.goNorth();
            } else if (command.equals("move south")) {
                prisoner.goSouth();
            } else if (command.equals("move up")) {
                prisoner.goUp();
            } else if (command.equals("move down")) {
                prisoner.goDown();
            } else if (command.equals("escape")) {
                prisoner.escape();
            } else if (command.equals("status")) {
                showStatus();
            } else if (command.equals("back")) {
                prisoner.goback();
            } else {
                System.out.println("Unknown command. Try again.");
            }
        }
    }

}

