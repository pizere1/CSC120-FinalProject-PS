/**
*Class for a prisoner that who will interact with the player
*/
public class CellMate extends People { //prisoner number - 621


/**
 * Attributes
 */
    public int prisonerNumber;
    public static Prisoner prisoner;

/**
     * Constructor for the class
     * @param name takes in the name of the prisoner
     * @param age takes in the age of the prisoner
     * @param prisonerNumber takes in the number of the prisoner
     */
    public CellMate(String name, int age, int prisonerNumber){
        super(name, age);
        this.prisonerNumber = 621;
    }
/**
    * Function to display the information of the cellmate
    */
    public void cellMateInfo(){
        System.out.println("This is all the information you'll need about him.\n");
        System.out.println("Name: "+this.getName());
        System.out.println("Age:" + this.getAge());
        System.out.println("Prisoner Number:" + prisonerNumber);

    }
/**
    * Function for the cellmate to commuicate to the prisoner
    */
    public void speak(Prisoner player){
        if (player.getX() == 2 && player.getY() == -2 && player.getZ() == 0){
        System.out.println("They say freedom is buried deep, hidden where the air grows cold and the walls weep. Find the path that leads you down a level across where the alarms sleep.\n"+ 
        "Remember me when you get there and you’ll find your way out.");
        } else {
                System.out.println("There's no one here to speak to.");
            }
        }

    public static void main(String[] args) {
       
    }
}
