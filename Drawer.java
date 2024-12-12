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

//    private void grab(String item){
//        pickedItem=item.toLowerCase();
//        for(String i:items) {
//            if(pickedItem.contains(i)) {
//                this.chosenItem=i;
//                System.out.print("You have taken the " + this.chosenItem+". ");
//                chosenOptions(this.chosenItem);
//                break;
//            } else{
//                System.out.println("There is no "+ pickedItem +" in the box. Choose between the available items.");
//                drawerChoices();
//            }
//        }
//    }
    public void choseOptions(String item){}

}
