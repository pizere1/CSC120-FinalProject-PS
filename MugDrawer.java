import java.util.ArrayList;
import java.util.Scanner;

public class MugDrawer extends Drawer{
    /**
     * Attributes
     */
    public String item3,item4,item5;
    public ArrayList<String>itemsd=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    boolean hasaCrowbar=false;

    /**
     * Constructor for the MugDrawer class
     */
    public  MugDrawer(){
        super();
        this.item3="rusted crowbar";
        this.item4="yellow newspaper clipping";
        this.item5="pair of broken glasses";
        this.itemsd.add(item3);
        this.itemsd.add(item4);
        this.itemsd.add(item5);
    }

    /**
     * Function for player to choose what to do when before the drawer
     */
    public void mugDrawerChoices(){
        System.out.println(" You are in front of the compartment. It has a three digit lock and an attached keypad with digits 0,7,6,3,5,2,4,9,1.");
        System.out.println("Do you want to open it or leave?");
        String answer=sc.nextLine();
        if(answer.contentEquals("open")){
            codecreading();
        }else if (answer.contentEquals("leave")){
            System.out.println("You didn't open the compartment. You are standing in the middle of the room. The gas risk grows every second");
        }else{
            System.out.println("I am not quite sure what you mean by that");}
    }

    /**
     * Function to read the code to open the compartment
     */
    public void codecreading(){
        System.out.println("Enter your code.");
        try{
            int code=sc.nextInt();
            codecracking(code);
        }catch(Exception e){
            System.out.println("You entered an invalid code. Try again");
            codecreading();
        }
    }

    /**
     * function for checking the validity of the entered code
     * @param code takes in the code
     */
    public void codecracking (int code) {
        if(code==621){
            opentheDrawer();
        } else{
            System.out.println("Sorry, that quite didn't work.Try again");
            codecreading();
        }
    }

    /**
     * Function for opening the drawer
     */
    public void opentheDrawer() {
        System.out.print("Opening the drawer...");
        System.out.println("The drawer is opened. You see these items");
        for(String item:itemsd) {
            System.out.print(item +", ");
        }
        thedrawerChoices();
    }

    /**
     * Function for choosing items in the drawer
     */
    public void thedrawerChoices() {
        System.out.println("Do you want to choose an item or leave?");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("choose")){
            System.out.println("Pick any item from");
            for(String item:itemsd) {
                System.out.print(item +", ");
            }
            String pickedItem=scanner.nextLine();
            pickedItem = pickedItem.toLowerCase();
            choseOptions(pickedItem);

        } else if(choice.contains("leave")) {
            System.out.println("You didn't pick an item. You reclosed the drawer. You are still in the locked room and " +
                    "the time is going down.");
            //How to connect it to another drawer (maybe ask, do you want to go to another drawer?)
            //if yes, create its object and call it.
            //maybe have a super function that is called while passing the name of the drawer, and when it sees the name, it calls the constructor  of another drawe
        } else{
            System.out.println("Sorry, I am not quite sure what you mean by that.");
            drawerChoices();
        }
    }

    /**
     * Function to interact with the picked item
     * @param pickedItem takes in the item
     */
    public void choseOptions(String pickedItem) {
        if(pickedItem.contains("crowbar")) {
            System.out.println("You have taken the crowbar");
            this.hasaCrowbar=true;
        } else if(pickedItem.contains ("newspaper")){
            System.out.println("You have taken the yellow newspaper clipping.It's letters looks smeared by some liquid that it is undreadable");
        }else if(pickedItem.contains("pair of broken glasses")){
            System.out.println("You have taken the pair of glasses");
        } else{
            System.out.println("There is no " + pickedItem + " in the drawer.");
        }
    }

    /**
     * function to put back the chosen item
     * @param theItem takes in an item
     */
    public void putback(String theItem) {
        if(theItem.contains("crowbar")) {
            this.hasaCrowbar=false;
        }
        super.putback(theItem);
    }

    /**
     * Function for player's choices after putting back the item or not
     */
    public void finalchoices(){
        super.finalchoices();

    }

    /**
     * Function for interacting with the picture frame
     */
    public void pictureFrame(){
        System.out.println("You picked up a picture. It has a picture of a building with APRITURNS written in a marker");
        System.out.println("Below the picture frame is four-inch crack line between the wooden tiles");
        tileChoices();
    }

    /**
     * Function for interacting with the tile
     */
    public void tileChoices() {
        System.out.println("What do you want to do?");
        String choice = scanner.nextLine();
        choice = choice.toLowerCase();
        if (choice.contains("open") ||(choice.contains("crack"))) {
            openHole();
        } else if(choice.contains("leave") || (choice.contains("nothing"))) {
            System.out.println("The gas is covering the room you might be at a bigger risk by not doing anything");
            tileChoices();
        }else{
            System.out.println("I am not quite sure what you mean by that");
            tileChoices();
        }
    }

    /**
     * Function for opening the tilehole
     */
    public void openHole(){
        if(this.hasaCrowbar){
            System.out.println("With the crowbar, You slowly pry open the wooden tile revealing a dark entraance to a hole");
            finalEscape();
        }else{
            System.out.println("You don't have anything to open crack with.");
            thedrawerChoices();
        }
    }

    /**
     * Function for the final escape
     */
    public void finalEscape(){
        System.out.println("What else do you want to do now that you cracked the floor??");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if((choice.contains("go")||choice.contains("climb"))&&(choice.contains("down"))){
            System.out.println("The hole is pitch black with no hint of what it contains. Do you really want to go there?");
            String answer=sc.nextLine();
            if(answer.contentEquals("yes")){
                System.out.println("You step into the dark hole, your feet find a ladder inside the whole and you descend");
                theEnd();
            } else if(answer.contains("no")||answer.contains("do not")||answer.contains("don't")){
                System.out.println("The gas continues to cover the room, you might be a greater risk staying in this room");
                finalEscape();
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
                finalEscape();
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
                finalEscape();
            }else{
                System.out.println("I am not quite sure what you mean by that.");
                finalEscape();
            }
        }else{
            System.out.println("I am not quite sure what you mean by that.");
            finalEscape();
        }
    }

    /**
     * Function for the ending
     */
    public void theEnd(){
        System.out.println("****************YAY!!YOU WON******************************");
    }
}

