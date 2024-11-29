
// parent class for all people used in the game
public class People{

    /**
     * attributes required for people name, their age and what position or title they have within the game 
     * e.g. cellmate, security,etc.
     */
    public String name;
    private int age;
    protected String title;

    public People(String name, int age, String title){
        this.name = name;
        this.age = age;
        this.title = title;
    }

    public static void main(String[] args){
        People Prisoner = new People("Luva", 46, "Prisoner");

    }
}