import java.util.Arrays;

public class Prisoner extends People {
    protected String crime;
    private int prisonerNumber;
    public int x;
    int maxX;
    int minX;
    int maxY;
    int minY;
    int maxZ;
    int minZ;
    public int y;
    public int z;
    private String lastMove;
    protected Status status;
    public String[] allCommands;


    /**
     * constructor
     * @param name of the player
     * @param age of the player
     * @param title would be player/ prisoner
     * @param crime would be the crime he'd committed to be in the prison
     * @param prisonerNumber would be his unique identity number in the prison
     * use x, y, and z axis to change locations
     */

    public Prisoner (String name, int age, String crime, int prisonerNumber, Status status){
        super(name, age);
        this.crime = crime;
        this.prisonerNumber = prisonerNumber;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.maxX = 4;
        this.minX = 0;
        this.maxY = 2;
        this.minY = -2;
        this.maxZ = 0;
        this.minZ = -2;



        this.lastMove = "";
        this.status = status;

    }
    //methods

    public Status getStatus(){
        return this.status;
    }

    public String getCrime(){
        return this.crime;
    }

    /**
     * sends the player to east direction by subtracting 2 value to x axis.
     */
     public void goEast(){
        if (this.x - 2 >= minX) { // Check if within bounds
            this.x -= 2;
            this.lastMove = "east";
        } else {
            System.out.println("You can't move east. There's a wall.");
        }
    }

    /**
     * sends the player to west direction by adding 2 value to x axis.
     */

    public void goWest(){
        if (this.x + 2 <= maxX) { // Check if within bounds
            this.x += 2;
            this.lastMove = "west";
        } else {
            System.out.println("You can't move west. There's a wall or locked door.");
        }
    }
    /**
     * sends the player to west direction by adding 2 value to x axis
     */

    public void goNorth(){
        if (this.y + 2 <= maxY) { // Check if within bounds
            this.y += 2;
            this.lastMove = "north";
        } else {
            System.out.println("You can't move north. There's a wall or locked door.");
        }
    }

    /**
     * sends the player to south direction by subtracting 2 value to y axis
     */

    public void goSouth(){
        if (this.y-2 >= minY){
            this.y -=2;
         this.lastMove = "south";
        } else{
            System.out.println("You can't move south. There's wall or locked door");
        }
        //getlocation
    }

    /**
     * sends the player to down by subtracting 2 from z axis
     */
    public void goDown(){
        if (this.z - 2 >= minZ){
            if (x == 4 && y == 2 && z == 0){
                this.z -= 2;
                this.lastMove = "down";
            } else {
                System.out.println("You need to be near the stairs to go down. ");
            }           
        } else {
            System.out.println("you can't go beyond this floor.");
        }
        
        //getlocation
    }

    /**
     * sends the player to down by adding 2 to z axis
     */
    public void goUp(){
        if (this.z + 2 <= maxZ){
            if (x == 4 && y == 2 && z == -2){
                this.z += 2;
                this.lastMove = "up";
            } else{
                System.out.println("You need to be near the stairs to climb up.");
            }
        } else {
            System.out.println("you can't go beyond this floor.");
        }
       
       
        //getlocation
    }

    /**
     * reverses the last move
     */
       

    public void goback() {
        if (this.lastMove.equals("east")) {
            this.x += 2;  
            //getlocation()
        } else if (this.lastMove.equals("west")) {
            this.x -= 2; 
            //getlocation()
        } else if (this.lastMove.equals("down")) {
            this.z += 2;  
            //getlocation()
        } else if (this.lastMove.equals("up")) {
            this.z -= 2; 

        } else if (this.lastMove.equals("north")) {
            this.y -= 2;  
        } else if (this.lastMove.equals("south")) {
                this.y += 2; 
        } else {
            System.out.println("No previous move to undo.");
        }

        this.lastMove = ""; //Reseetting into empty set again because we've reversed the direction
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getZ(){
        return this.z;
    }

    public void setLocation(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void getHelp(){
        String arrayAsString = Arrays.toString(allCommands);
        System.out.println(arrayAsString); 

    }

    public static void main(String[] args) {
        String allCommands[] = {"move 'directions' (e.g. move east, move up, etc.)","reverse", "help", "quit"};
    }


}


//thoughts for now 

//have a get location class in building or somewhere

// have a location limit (like a maximum value of axis)