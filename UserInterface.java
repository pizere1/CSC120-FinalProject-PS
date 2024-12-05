import java.util.Scanner;

public class UserInterface {

    public static Prisoner prisoner;

    private static void showStatus() {
        System.out.println("\n=== Prisoner Status ===");
        System.out.println("Name: " + prisoner.getName());
        System.out.println("State: " + prisoner.getStatus());
        System.out.println("Position: X = " + prisoner.x + ", Y = " + prisoner.y + ", Z = " + prisoner.z);
        System.out.println("Crime: " + prisoner.getCrime());
        System.out.println("=========================");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------\n");
        System.out.println("WELCOME TO CHANDRA BIHAR PRISON.");
        System.out.println("------------------------------------\n");
        System.out.println("Enter a name for your player");
        String name = scanner.nextLine();
        System.out.println("Enter an age for your player");
        int age = scanner.nextInt();
        System.out.println("Enter any random 3 digit number");
        int prisonerNumber = scanner.nextInt();
        scanner.close();

        Prisoner player = new Prisoner(name, age, "Prisoner", "Heist", prisonerNumber, Status.IN_JAIL);

        System.out.println( "\n You wakeup inside a gray room. You have number "+ prisonerNumber +" written on your jumpsuit.\n You remember nothing about who you are or how you reached here. \n"+  
        "Your mind is blank as the walls of the room. You are less safe inside these walls than anywhere else.\n" );
       System.out.println(" You need to figure out an escape. You look around and see a box in your room.");

        while (true){
           // showStatus();

           Scanner scanner1 = new Scanner(System.in);
            System.out.print("\nEnter command: ");
            String command = scanner1.nextLine().toLowerCase().trim();
            scanner1.close();

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
            } else if (command.equals("reverse")) {
                prisoner.goback();
            } else if (command.equals("get location")) {
               // building.getlocation();
            } else if (command.contains("move")&&!command.contains("east")&&!command.contains("west")&&!command.contains("north")&&!command.contains("south")&&!command.contains("up")&&!command.contains("down")){
                System.out.println("Incomplete command.");
            } else {
                System.out.println("Unknown command. Try again.");
            }
        }
    }

}

