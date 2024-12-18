
// parent class for all people used in the game
public class People{

    /**
     * attributes required for people name, their age and what position or title they have within the game 
     * e.g. cellmate, security,etc.
     */
    private String name;
    private int age;

    /**
     * Constructor for people
     * @param name takes in their name
     * @param age takes in their age
     */
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * Function for getting the person's name
     * @return their name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Function for getting their age
     * @return their age
     */
    public int getAge(){
        return this.age;
    }
}
