public class Securityguard extends People {
    /**
     * Attributes
     */
    public String operation;

    /**
     * Constructor the Security guard class
     * @param name takes in their name
     * @param age takes in their age
     */
    public Securityguard (String name, int age){
        super(name, age);
        String operation = "Takes people back to Jail";
    }

    /**
     * Function to catch the player
     */
    public void catchPlayer(){
        System.out.println("You're caught. The security guards are taking you back to the prison. No way to escape. Game Over.");
        //break;
    }

    /**
     * Function to print their operation
     */
    public void operation(){
        System.out.println(operation);
    }
}
