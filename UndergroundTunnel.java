import java.util.Scanner;
public class UndergroundTunnel {
    /**
     * Attributes
     */
    public boolean opened=false;
    Scanner sc=new Scanner(System.in);
    /**
     * Constructor for the underground Tunnel class
     */
    public UndergroundTunnel() {
    }


//    public void open(String item){
//        if(item.equals("old crowbar")){
//            System.out.println("The floor block is removed. There are downward steps.");
//            this.opened = true;
//        } else {
//            System.out.println(item + " cannot help you do that.");
//            this.opened = false;
//        }
//    }
    /**
     * Function for opening the underground tunnel
     * @param c Compartment instance
     */
    public void opentunnel(Compartment c){
        if(c.hasaCrowbar){
            System.out.println("The tile is removed. There are downward steps in the hole.");
            this.opened = true;
        } else {
            System.out.println("You have no right item that can help you do that.");
        }
    }

    /**
     * Function to descend into the tunnel
     */
    public void descend(){
        if(opened==true){
            //System.out.println("You descend through the square opening and climb down the steps .");
            //theEnd();
            finalEscape();
        } else {
            System.out.println("Sorry. You don't have anywhere to descend to");
        }
    }

    /**
     * Function for ending the game
     */
    public void theEnd(){
        System.out.println("****************YAY!! YOU WON******************.");

    }
    public void finalEscape(){
        System.out.println("What else do you want to do now that you cracked the floor??");
        String choice=sc.nextLine();
        choice = choice.toLowerCase();
        if((choice.contains("go")||choice.contains("climb"))&&(choice.contains("down"))){
            System.out.println("The hole is pitch black with no hint of what it contains. Do you really want to go there?");
            String answer=sc.nextLine();
            if(answer.contentEquals("yes")){
                System.out.println("You step into the dark hole, your feet find a ladder inside the whole and you descend");
                theEnd();
            } else if(answer.contains("no")||answer.contains("do not")||answer.contains("don't")){
                System.out.println("The gas continues to cover the room, you might be a greater risk staying in this room");
               // finalEscape();
            }else{
                System.out.println("I am not quite sure what you mean by that.");
                finalEscape();
            }
        }else if(choice.contains("descend")||(choice.contains("go")&&choice.contains("in"))){
            System.out.println("The hole is pitch black with no hint of what it contains. Do you really want to go there?");
            String answer=sc.nextLine();
            choice = choice.toLowerCase();
            if(answer.contentEquals("yes")){
                System.out.println("You step into the dark hole, your feet find a ladder inside the whole and you descend");
                theEnd();
            } else if(answer.contains("no")||answer.contains("do not")||answer.contains("don't")){
                System.out.println("The gas continues to cover the room, you might be a greater risk staying in this room");
                //finalEscape();
            }else{
                System.out.println("I am not quite sure what you mean by that.");
                finalEscape();
            }
        }else if(choice.contains("enter")&&(choice.contains("hole"))){
            System.out.println("The hole is pitch black with no hint of what it contains. Do you really want to go there?");
            String answer=sc.nextLine();
            answer = answer.toLowerCase();
            if(answer.contentEquals("yes")){
                System.out.println("You step into the dark hole, your feet find a ladder inside the whole and you descend");
                theEnd();
            } else if(answer.contains("no")||answer.contains("do not")||answer.contains("don't")){
                System.out.println("The gas continues to cover the room, you might be a greater risk staying in this room");
            }else{
                System.out.println("I am not quite sure what you mean by that.");
                finalEscape();
            }
        }else{
            System.out.println("I am not quite sure what you mean by that.");
            finalEscape();
        }
    }
}
