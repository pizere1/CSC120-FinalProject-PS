public class CellMate extends People { //prisoner number - 621


/**
 * 
 */
    public int prisonerNumber;
    public static Prisoner prisoner;

    public CellMate(String name, int age, int prisonerNumber){
        super(name, age);
        this.prisonerNumber = 621;
    }

    public void cellMateInfo(){
        System.out.println("This is all the information you'll need about him.\n");
        System.out.println("Name: "+this.getName());
        System.out.println("Age:" + this.getAge());
        System.out.println("Prisoner Number:" + prisonerNumber);

    }

    public void speak(){
        UserInterface ui = new UserInterface();
        Prisoner player = new Prisoner();
        if (player.getX() == 2 && player.getY() == -2 && player.getZ() == 0){
        System.out.println("They say freedom is buried deep, hidden where the air grows cold and the walls weep. Find the path that leads you down a level across where the alarms sleep.\n"+ 
        "Remember me when you get there and you’ll find your way out.");
        }
    }

    public static void main(String[] args) {
       
    }
}
