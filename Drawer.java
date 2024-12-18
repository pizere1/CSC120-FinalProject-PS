import java.util.ArrayList;
import java.util.Scanner;

public class Drawer {
    /**
     * picked item will be the same for all classes, and if super.hasitem=true, first tell them to drop it
     */
    public String chosenItem="";
    public String pickedItem="";
    public Object currentdrawer=null;
    public Scanner scanner=new Scanner(System.in);
    public ArrayList<String>items;
    public Drawer() {
    }
    /***
     * constructor for the drawer class
     * @param item1, takes in the first item
     * @param item2 takes in the second item
     * @param item3 takes in the third item
     * @param item4 takes in the fourth item
     * @param item5 takes in the fifth item
     * @param item6 takes in the fifth item
     */
    public Drawer(String item1, String item2, String item3,String item4, String item5, String item6) {
        items=new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

    }
    /**
     *function for opening the drawer
     */
    public void openDrawer() {
        System.out.print("Opening the drawer...");
        System.out.println("The top drawer is opened. You see these items");
        for(String item:items) {
            System.out.print(item +", ");
        }
        drawerChoices();
    }
    /**
     * Function to manager the player's choices regarding the drawer
     */
    public void drawerChoices() {
        System.out.println("Do you want to choose an item or leave?");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("choose")){
            System.out.print("Pick any item from");
            for(String item:items) {
                System.out.print(item +", ");
            }
            String pickedItem=scanner.nextLine();//what if they say I choose
            choseOptions(pickedItem);
        } else if(choice.contains("leave")) {
            System.out.println("You didn't pick an item. You reclosed the drawer. You are still in the locked room and " +
                    "the time is going down.");
             } else{
            System.out.println("Sorry, I am not quite sure what you mean by that.");
            drawerChoices();
        }
    }

    /**
     * function for putting back an item
     * @param theItem takes in an item
     */
    public void putback(String theItem) {
        for(String t:items) {
            if(t.contains(theItem)) {
                System.out.println("You have put back " + theItem +" in the drawer.");
                finalchoices();
            } else {
                System.out.println("The item "+ theItem +" was not in this drawer.");
            }
        }
    }

    /**
     * Function for making the final choices after putting back an object
     */
    public void finalchoices(){
        System.out.println("Do you want to pick another item or close the drawer.");
        String command=scanner.nextLine();
        command = command.toLowerCase();
        if(command.contains("close")&&(command.contains("drawer"))) {
            System.out.println("You closed the drawer.");
            //maybe modify the user interface here
        } else if(command.contains("close it")) {
            System.out.println("You closed the drawer.");
        }else if(command.contains("pick")&&(command.contains("item"))){
            drawerChoices();
        }else{
            System.out.println("Sorry, I don't understand what you mean. ");
            finalchoices();
        }
    }

    /**
     * A function for deciding what to do with a chosen item, gets overriden by every child class specification
     * @param item takes in the item
     */
    public void choseOptions(String item){
        
    }

}
