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

        mapper.addRoom("Prison Cell", 0, 0, 0); //1
        mapper.addRoom("Hallway in front of cell 11", 2, 0, 0);// 2
        mapper.addRoom("Hallway in front of the cellmate at cell 12, End of Hallway on South", 2, -2, 0);//3
        mapper.addRoom("Cellmate's Cell", 0, -2, 0);//4
        mapper.addRoom("Hallway Right to the Bathroom", 2, 2, 0); //5
        mapper.addRoom("Bathroom", 4, 2, 0); //6
        mapper.addRoom("End of Hallway on North", 2, 4, 0); //7
        mapper.addRoom("Window on East End", 0, 4, 0);//8
        mapper.addRoom("Start of The Stair", 4, 4, 0);//9
        mapper.addRoom("Downstairs Lower Level- end of the stairs", 4, 4, -2);//10
        mapper.addRoom(" Hallway- Lower level, infront of the stairs ", 2, 4, -2);//11
        mapper.addRoom("Hallway at the Lower Level", 2, 0, -2);//12
        mapper.addRoom("Suspicious Passage Way", 4, 0, -2);//13
        mapper.addRoom("Alarm Room", 0, -2, -2);//14
        mapper.addRoom("ER", 4, -2, -2);//15
        mapper.addRoom("Hallway between ER and AR", 2, -2, -2);


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
               // System.out.println("you're at: " + mapper.getLocation(player.getX(),player.getY(),player.getZ()));
            } else if (command.equals("escape")) {
                player.escape();
            } else if (command.equals("status")) {
                showStatus();
            } else if (command.equals("reverse") || command.equals("undo"))  {
                player.goback();
                mapper.getLocation(player.getX(),player.getY(),player.getZ());
            } else if (command.equals("get location")){
                String location = mapper.getLocation(player.getX(),player.getY(),player.getZ());
                System.out.println("you're at: "+location);
            } else if (command.equals("look around")){
                mapper.lookAround(player.getX(), player.getY(), player.getZ());
            } else if (command.contains("open") ){
                if (command.contains("box")){
                    theBox.openBoX();
                } else if (command.contains("door") || command.contains("lock")){
                    theBox.openLock();
                    player.x+=2;
                    System.out.println("you're at: " + mapper.getLocation(player.getX(),player.getY(),player.getZ()));
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
            } else if (command.equals("help")){
                System.out.println("All required Commands:\n");
                player.getHelp();
            }
            else {
                System.out.println("Unknown command. Try again.");
            }


        }
        }
    }


