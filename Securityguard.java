public class Securityguard extends People { 

    public String operation;

    public Securityguard (String name, int age, String title){
        super(name, age, title);
       String operation = "Takes people back to Jail";
    }

    public void catchPlayer(){
          System.out.println("You're caught. The security guards are taking you back to the prison. No way to escape. Game Over.");
        }

    public void operation(){
        System.out.println(operation);
    }
}
    //capture
