public class Prisoner extends People {
    protected String crime;
    private int prisonerNumber;
    public int x;
    public int y;
    public int z;
    private String lastMove;
    protected Status status;


    /**
     * constructor
     * @param name of the player
     * @param age of the player
     * @param title would be player/ prisoner
     * @param crime would be the crime he'd committed to be in the prison
     * @param prisonerNumber would be his unique identity number in the prison
     * use x, y, and z axis to change locations
     */

    public Prisoner (String name, int age, String title, String crime, int prisonerNumber, Status status){
        super(name, age , title);
        this.crime = crime;
        this.prisonerNumber = prisonerNumber;
        this.x = 0;
        this.y = 0;
        this.z = 0;
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
        this.x -= 2;
        this.lastMove = "east";
        //getlocation
    }

    /**
     * sends the player to west direction by adding 2 value to x axis.
     */

    public void goWest(){
        this.x += 2;
        this.lastMove = "west";
        //getlocation
    }

    /**
     * sends the player to west direction by adding 2 value to x axis
     */

    public void goNorth(){
        this.y+= 2;
        this.lastMove = "north";
        //getlocation
    }

    /**
     * sends the player to south direction by subtracting 2 value to y axis
     */

    public void goSouth(){
        this.y -=2;
        this.lastMove = "south";
        //getlocation
    }

    /**
     * sends the player to down by subtracting 2 from z axis
     */
    public void goDown(){
        this.z -= 2;
        this.lastMove = "down";
        //getlocation
    }

    /**
     * sends the player to down by adding 2 to z axis
     */
    public void goUp(){
        this.z += 2;
        this.lastMove = "up";
        //getlocation
    }

    public void escape(){
        //stil to think ??????
    }

    /**
     * reverses the last move
     */

     public void climb(){
        this.z +=2;
        this.lastMove = "climb";
     }

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


}


//thoughts for now 

//have a get location class in building or somewhere

// have a location limit (like a maximum value of axis)