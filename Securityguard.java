public class Securityguard extends People { 

    public String operation;

    public Securityguard (String name, int age){
        super(name, age);
       String operation = "Takes people back to Jail";
    }

    public void catchPlayer(){
          System.out.println("You're caught. The security guards are taking you back to the prison. No way to escape. Game Over.");
          //break;
        }

    public void operation(){
        System.out.println(operation);
    }
}
    //capture
