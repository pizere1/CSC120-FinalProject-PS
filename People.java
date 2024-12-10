
// parent class for all people used in the game
public class People{

    /**
     * attributes required for people name, their age and what position or title they have within the game 
     * e.g. cellmate, security,etc.
     */
    private String name;
    private int age;


    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
    //public static void main(String[] args){
       // People Prisoner = new People("Luva", 46, "Prisoner");

    //}
}