import java.util.Scanner;
public class UserInterface {
    /**
     * Attributes
     */
    public static Prisoner prisoner;

    /**
     * Functions to show the player's status
     */
    private static void showStatus() {
        System.out.println("\n=== Prisoner Status ===");
        System.out.println("Name: " + prisoner.getName());
        System.out.println("State: " + prisoner.getStatus());
        System.out.println("Position: X = " + prisoner.x + ", Y = " + prisoner.y + ", Z = " + prisoner.z);
        System.out.println("Crime: " + prisoner.getCrime());
        System.out.println("=========================");
    }

    /**
     * Main function
     * @param args takes in string arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("------------------------------------\n");
        System.out.println("WELCOME TO CHANDRA BIHAR PRISON.");
        System.out.println("------------------------------------\n");
        System.out.println("Enter a name for your player");
        String name = in.nextLine();

        int age = 0;
        while (age < 1 || age>120){
            System.out.println("Enter an age for your player");
            try {
                age = in.nextInt();
                if(age < 1 || age>120){
                    System.out.print("Try a valid age, bro. ");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter a valid positive integer for age" );
                in.nextLine();
            }
        }

        int prisonerNumber = 0;
        while (prisonerNumber < 100 || prisonerNumber >= 1000){
            System.out.println("Enter any random 3 digit number");

            try {
                prisonerNumber = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter a valid 3 digit positive integer" );
                in.nextLine();
            }
        }
        in.nextLine();

        Prisoner player = new Prisoner(name, age, "Heist", prisonerNumber, Status.IN_JAIL);
        RoomMapper mapper = new RoomMapper();
        TheBox theBox=new TheBox(prisonerNumber);
        CellMate cellMate = new CellMate("RamHari", 14, 621);
        //EscapeRoom escapeRoom = new EscapeRoom("Escape Room", 4 , -2, -2, 9);

        mapper.addRoom("Cellmate's Cell", 0, -2, 0);//1
        mapper.addRoom("End of Hallway on South", 2, -2, 0);//2
        mapper.addRoom("Bathroom", 4, -2, 0); //3

        mapper.addRoom("Your Prison Cell", 0, 0, 0); //1
        mapper.addRoom("Hallway in front of cell 11", 2, 0, 0);// 2
        mapper.addRoom("Open Space", 4,0, 0);

        mapper.addRoom("Window on East End", 0, 2, 0);//8
        mapper.addRoom("Main Door, End of Hallway on North", 2, 2, 0); //7
        mapper.addRoom("Ground Floor- Stairs", 4, 2, 0);//9


        mapper.addRoom("Basement stairs", 4, 2, -2);//10
        mapper.addRoom("Middle of the Hallway in north end", 2, 4, -2);//11
        mapper.addRoom("Hallway of East End", 0, 2, -2);

        mapper.addRoom("Open Space", 4, 0, -2);
        mapper.addRoom("Hallway", 2, 0, -2);//10
        mapper.addRoom("Jailer's Office", 0, 0, -2);

        mapper.addRoom("AR", 0, -2, -2);//14
        mapper.addRoom("Hallway ending South", 2, -2, -2);
        mapper.addRoom("ER", 4, -2, -2);//15


        System.out.println( "\n You wakeup inside a gray room. You have number "+ prisonerNumber +" written on your jumpsuit.\n You remember nothing about who you are or how you reached inside this PRISON. \n"+
                "Your mind is blank as the walls of the room. You are less safe inside these walls than anywhere else.\n" );
        System.out.println(" You need to figure out an escape. You look around to find a door infront of you and a box in your room.\n What is your next move?");

        while (true){

            System.out.print("\nEnter command: ");
            String command = in.nextLine().toLowerCase().trim();

            if (command.equals("quit")) {
                System.out.println("Quitting game...");
                break;
            } else if (command.contains("move") || command.contains("go")) {
                if (!theBox.isDoorUnlocked()){
                    System.out.println("The door is locked. You cannot move until you unlock the door.");
                    continue;
                }
                if (command.contains("east")){
                    player.goEast();
                } else if (command.contains ("west")){
                    player.goWest();
                } else if (command.contains("north")){
                    player.goNorth();
                } else if (command.contains("south")){
                    player.goSouth();
                } else if (command.contains("up")){
                    player.goUp();
                } else if (command.contains("down")){
                    player.goDown();
                } else if (command.contains("door")){
                    theBox.goToDoor();
                } else {
                    System.out.println("Please type full command.");
                }
                System.out.println("you're at: " + mapper.getLocation(player.getX(),player.getY(),player.getZ()));
                mapper.evaluateLocation(player.getX(), player.getY(), player.getZ(), mapper, cellMate);
                // } else if (command.contains("escape")) {
                // player.escape();
            } else if (command.contains("status")) {
                showStatus();
            } else if (command.contains("reverse") || command.contains("undo"))  {
                player.goback();
                mapper.getLocation(player.getX(),player.getY(),player.getZ());
            } else if (command.equals("get location")){
                String location = mapper.getLocation(player.getX(),player.getY(),player.getZ());
                System.out.println("you're at: "+location);
            } else if (command.equals("look around")){
                mapper.lookAround(player.getX(), player.getY(), player.getZ());
            } else if (command.contains("open") | command.contains("unlock") ){
                if (command.contains("box")){
                    theBox.openBoX();
                } else if (command.contains("door") || command.contains("lock")){
                    if (!theBox.isDoorUnlocked()){
                        theBox.openLock();
                        if (theBox.isDoorUnlocked()){
                            player.x +=2;
                            System.out.println("you're at: " + mapper.getLocation(player.getX(),player.getY(),player.getZ()));
                        }

                    }
                } else {
                    System.out.println("Please type full command.");
                }
            } else if (command.equals("speak")){
                if (player.getX() == 2 && player.getY() == -2 && player.getZ() == 0) {
                    cellMate.cellMateInfo();
                    cellMate.speak(player);
                } else {
                    System.out.println("There's no one here to speak to.");
                }
            } else if (command.equals("go to door")){
                theBox.goToDoor();
            } else if (command.equals("open door") || command.equals("open lock")) {
                theBox.openLock();
                player.x+=2;
            } else if (command.contains("help")){
                System.out.println("All required Commands:\n");
                player.getHelp();
            }
            else {
                System.out.println("Unknown command. Try again.");
            }


        }
    }
}
