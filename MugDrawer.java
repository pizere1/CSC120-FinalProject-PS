//import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MugDrawer extends Drawer{
    public String item1, item2, item3,item4,item5;
    public ArrayList<String>itemsd=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public  MugDrawer(){
        super();
        //this.item1="broken watch";
        //this.item2="folded old white paper";
        this.item3="rusted crowbar";
        this.item4="yellow newspaper clipping";
        this.item5="pair of broken glasses";
       // this.itemsd.add(item1);
        //this.itemsd.add(item2);
        this.itemsd.add(item3);
        this.itemsd.add(item4);
        this.itemsd.add(item5);
    }
    public void mugDrawerChoices(){
        System.out.print(" You are in front of the compartment. It has a three digit lock and an attached keypad with digits 0,7,6,3,5,2,4,9,1.");
        System.out.println("Do you want to open it or leave?");
        String answer=sc.nextLine();
        if(answer.contentEquals("open")){
            codecracking();
        }else if (answer.contentEquals("leave")){
            System.out.println("You didn't open the compartment. You are standing in the middle of the room. The gas risk grows every second");
        }else{
            System.out.println("I am not quite sure what you mean by that");}
    }
    public void codecracking(){
        System.out.println("Enter your code.");
        String code=sc.nextLine();
        if(code.equals("621")){
            opentheDrawer();
        //mugDrawerChoices();
        } else{
            System.out.println("Sorry, that quite didn't work.Try again");
            codecracking();
        }
    }
    public void opentheDrawer() {
        System.out.print("Opening the drawer...");
        System.out.println("The top drawer is opened. You see these items");
        for(String item:items) {
            System.out.print(item +", ");
        }
        thedrawerChoices();
    }
    public void thedrawerChoices() {
        System.out.println("Do you want to choose an item or leave?");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("choose")){
            System.out.print("Pick any item from");
            for(String item:items) {
                System.out.print(item +", ");
            }
            String pickedItem=scanner.nextLine();
            pickedItem = pickedItem.toLowerCase();
            //what if they say I choose
            choseOptions(pickedItem);
            //grab(pickedItem);
            // grab(chosenItem);
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
    public void choseOptions(String pickedItem) {
        if(pickedItem.contains("crowbar")) {
            System.out.println("You have taken the crowbar");
        } else if(pickedItem.contains (" newspaper")){
            System.out.println("You have taken the yellow newspaper clipping.It's letters looks smeared by some liquid that it is undreadable");
        }else if(pickedItem.contains("pair of broken glasses")){
            System.out.println("You have taken the pair of glasses");
        } else{
        System.out.println("There is no " + pickedItem + " in the drawer.");
        }
    }
    public void putback(String theItem) {
        super.putback(theItem);
    }
    public void finalchoices(){
        super.finalchoices();

    }

}
