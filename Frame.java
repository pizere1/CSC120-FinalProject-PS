import javax.swing.*;
import java.util.Scanner;
public class Frame {
    Scanner sc = new Scanner(System.in);
    Boolean hasaCrowbar = false;
    boolean isbeforeframe=false;
    boolean seentheCrack=false;
    /**
     * Function for interacting with the picture frame
     */

    public void gotoframe() {
        System.out.println("You are in front of the picture frame.");
        this.isbeforeframe=true;
    }
    public void observe(){
        if(isbeforeframe==false){
            System.out.println("You should be close to the picture frame to look at it.");
        }else{
            System.out.println("In the frame is a picture of a building with APRITURNS written carelessly in a marker.");
        }
    }
    public void pickup(){
        if(isbeforeframe==false){
            System.out.println("You should be close to the picture frame to pick it up.");
        }else{
            System.out.println("In the frame is a picture of a building with APRITURNS written carelessly in a marker.");
            System.out.println("Below the picture frame is four-inch loose crack across the wooden tiles");
            this.seentheCrack=true;
        }
    }
}
