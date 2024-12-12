public class CoGasJar {
    /**
    * Constructor for the Carbon Monoxide Gas Jar Class, also calls display function to display what happened
    */
    public CoGasJar() {
        display();
    }
     /**
    * function to display the information about the carbon monoxide gas jar
    */
    public void display(){
        System.out.println(" You just knocked down a Carbon Monoxide Gas Jar, it will fill the room\n" +
                "in five minutes.Unless you find a way out, you'll be at a fatal risk.");
        System.out.println("**********************************************************************");
    }
    /**
    * a function to deny the user anything they try to do with the gas jar because they cannot
    */
    public void tryOperation(){
        System.out.println("The mistake was already made, you cannot do anything to this jar, just find your way out.");
    }
}
