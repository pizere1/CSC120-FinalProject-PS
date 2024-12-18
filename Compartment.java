import java.util.ArrayList;
import java.util.Scanner;

public class Compartment extends Drawer{
    /**
     * Attributes
     */
    public String item3,item4,item5;
    public ArrayList<String>itemsd=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    //public static boolean hasaCrowbar=false;
    public boolean hasaCrowbar=false;
    public boolean isinfrontofcomp=false;
    public boolean compartmentisopen=false;
    public String chosenItem;

    /**
     * Constructor for the MugDrawer class
     */
    public  Compartment (){
        super();
        this.item3="rusted crowbar";
        this.item4="yellow newspaper clipping";
        this.item5="pair of broken glasses";
        this.itemsd.add(item3);
        this.itemsd.add(item4);
        this.itemsd.add(item5);
    }
    public boolean HasaCrowbar(){
        return hasaCrowbar;
    }
    /**
     * Function for player to choose what to do when before the drawer
     */
    public void atCompartment() {
        System.out.println(" You are in front of the compartment.");
        this.isinfrontofcomp=true;
    }
    public void openCompartment() {
        if(this.isinfrontofcomp==false){
            System.out.println("You should be in front of the compartment to open it.");
        }else{
       System.out.println(" It has a three digit lock and an attached keypad with digits 0,7,6,3,5,2,4,9,1.");
       codereading();
        }
    }
    public void codereading(){
        System.out.println("Enter your code.");
        try {
            int code = sc.nextInt();
            while (!codecracking(code)){
                System.out.println("Please try again");
                codereading();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input. Please enter a valid integer" );
            sc.nextLine();
            codereading();
        }
    }
    public boolean codecracking (int code) {
        if(code==621){
            System.out.println("You cracked the code.");
            this.compartmentisopen=true;
            display();
        } else{
            System.out.println("Sorry, that quite didn't work.Try again");
            this.compartmentisopen=false;
            codereading();
        }
        return this.compartmentisopen;
    }
    public void display(){
        System.out.print("Opening the compartment...");
        System.out.println("The compartment is opened. You see these items");
        for(String item:itemsd) {
            System.out.print(item +"; ");
        }
        drawerchoice();
    }
    public void drawerchoice(){
        System.out.println(" ");
        System.out.println("Do you want to pick an item from the compartment or close the compartment?");
        String answer = scanner.nextLine();
        if(answer.contains("pick")||answer.contains("choose")){
            pickanitem();
        } else if(answer.contains("close")){
            this.closeDrawer();
            //this.compartmentisopen=false;
           // this.quit();
        }else{
            System.out.println("Sorry. I am quite not sure about what you want.");
            drawerchoice();
        }
    }
    public void closeDrawer(){
        if(this.isinfrontofcomp==true){
            if(this.compartmentisopen==true){
                System.out.println("You have closed the compartment.");
            }else{
                System.out.println("The compartment was already closed.");
            }
        }else {
            System.out.println("You should be close to the compartment to close or open it.");
        }
        //this.compartmentisopen=false;
    }
    public void pickanitem(){
        if(this.isinfrontofcomp==false){
            System.out.println("You should be close to the compartment  to pick its item.");
        }else{
            if(this.compartmentisopen==false){
                System.out.println("First open the compartment.");
            }else{
                actualpicking();
            }
        }
    }
    public void actualpicking(){
        System.out.print("Pick any item from ");
        for(String item:itemsd) {
            System.out.print(item +"; ");
        }
        String pickedItem=scanner.nextLine();
        choseOptions(pickedItem);
    }
    public void choseOptions(String pickedItem) {
        if(pickedItem.contains("crowbar")) {
            System.out.println("You have taken the crowbar");
            this.hasaCrowbar=true;
            chosenItem="crowbar";
            playerChoices(chosenItem);
        } else if(pickedItem.contains ("newspaper")){
            System.out.println("You have taken the yellow newspaper clipping.It's letters looks smeared by some liquid that it is unreadable");
            chosenItem="newspaper";
            playerChoices(chosenItem);
        }else if(pickedItem.contains("glasses")){
            System.out.println("You have taken the pair of glasses");
            chosenItem="glasses";
            playerChoices(chosenItem);
        } else{
            System.out.println("There is no " + pickedItem + " in the drawer.");
            System.out.println("Do you still want to pick an item");
            String answer = scanner.nextLine();
            if(answer.contains("pick")||(answer.contains("choose"))){
                actualpicking();
            }else if(answer.contains("yes")||((answer.contains("want"))&&!(answer.contains("no")))){
                actualpicking();
            }else if((answer.contains("no")||(answer.contains("don't"))||(answer.contains("not")))){
                System.out.println("You didn't pick an item.");
                finalChoices();
            } else{

            }
        }
    }
    public void playerChoices(String theItem) {
        System.out.println("Do you want to put "+theItem +" back in or take it with you. ");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("put")&&(choice.contains("back")&&(choice.contains(theItem)))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalChoices();
        } else if(choice.contains("put")&&(choice.contains("down")&&(choice.contains(theItem)))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalChoices();
        } else if(choice.contains("put it")&&(choice.contains("back"))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalChoices();
        }else if(choice.contains("put it")&&(choice.contains("down"))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalChoices();
        }else if (choice.contains("take")||(choice.contains(theItem))) {
            System.out.println("You have taken and kept " + theItem);
            finalChoices();
        }else if (choice.contains("take it")){
            System.out.println("You have taken and kept " + theItem);
            finalChoices();
        } else{
            System.out.println("Sorry, I don't understand what you mean.");
            playerChoices(theItem);
        }
    }
    public void finalChoices(){
        System.out.println("Do you want to pick another item or close the compartment?");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("pick")||(choice.contains("choose"))){
            actualpicking();
        }else if(choice.contains("close")||(choice.contains("leave"))){
            closeDrawer();
        } else{
            System.out.println("Sorry, I am unsure what you mean.");
            this.finalChoices();
        }
    }
}
