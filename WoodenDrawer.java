import java.util.ArrayList;
import java.util.Scanner;
public class WoodenDrawer extends Drawer {
    /**
     *Attributes
     */
    Scanner scanner = new Scanner(System.in);
    String item1, item2, item3, item5,item6;
    boolean isbookopen,isinfrontofdrawer=false;
    boolean hasouritem=false;
    boolean hasanote=false;
    boolean drawerIsOpen=false;
    String chosenItem;
    ArrayList<String>items=new ArrayList<>();
    /**
     *Constructor for the book drawer classes which initializes its components
     */
    public WoodenDrawer() {
        super();
        this.item1 = "rusty nail";
        this.item2 = "crumped note";
        this.item3 = "rusty key";
        this.item5 = "scratched coin";
        this.item6 = "business card";
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item5);
        items.add(item6);

    }
    /**
     *the function to handle the user's interaction with the drawer
     */
    public void bookdrawer(){
        System.out.println("You are in front of the Drawer with a book on the top.");
        this.isinfrontofdrawer=true;
    }
    public void openbook(){
        if(this.isinfrontofdrawer==false){
            System.out.println("You should be close to the book or open it.");
        }else {
        System.out.println("You open the book. It is an empty notebook with nothing written in it.");
        this.isbookopen=true;
        this.hasouritem=true;
        }
    }
    public void closebook(){
        if(this.isinfrontofdrawer==false){
            System.out.println("You should be close to the book or open it.");
        }else {
            if(this.isbookopen==true){
                System.out.println("You closed the book.");
                this.isbookopen=false;
            }else{
                System.out.println("You didn't even open the book.");
            }
            //this.hasouritem=true;
        }
    }
    public void leavedrawer(){
        this.isinfrontofdrawer=false;
        System.out.println("You have left the drawer side.");
    }

    public void putback(String item){
        if (this.hasouritem==false){
            System.out.println("You don't have the item from this drawer.");
        }else{
            System.out.println("You have put back the item in the drawer.");
        }
    }
    public void openDrawer(){
        if(this.isinfrontofdrawer==false){
            System.out.println("You should be close to the drawer to open it.");
        }else{
            System.out.println("Opening the wooden desk drawer...");
            System.out.println("The drawer is opened. You see these items");
            for(String item:items) {
                System.out.print(item + ", ");
            }
            System.out.println(" ");
            this.drawerIsOpen=true;
            drawerchoice();
        }
    }
    public void drawerchoice(){
        System.out.println(" ");
        System.out.println("Do you want to pick an item from the drawer or close the drawer?");
        String answer = scanner.nextLine();
        if(answer.contains("pick")||answer.contains("choose")){
            pickanitem();
        }else if(answer.contains("close")){
            closeDrawer();
        }else{
            System.out.println("I am quite not sure what you meant.");
            drawerchoice();
        }
    }
    public void closeDrawer(){
        if(this.isinfrontofdrawer==true){
            if(this.drawerIsOpen==true){
                System.out.println("You have closed the drawer.");
                this.drawerIsOpen=false;
            }else{
                System.out.println("The drawer was already closed.");
            }
        }else {
            System.out.println("You should be close to the drawer to close or open it.");
        }
    }
    public void pickanitem(){
        if(this.isinfrontofdrawer==false){
            System.out.println("You should be close to the drawer to pick its item.");
        }else{
            if(this.drawerIsOpen==false){
                System.out.println("First open the drawer.");
            }else{
                actualpicking();
            }
        }
    }
    public void actualpicking(){
        System.out.print("Pick any item from ");
        for(String item:items) {
            System.out.print(item +"; ");
        }
        String pickedItem=scanner.nextLine();
        pickedItem=pickedItem.toLowerCase();
        choseOptions(pickedItem);
    }
    public void choseOptions(String item){
        if(item.contains("nail")) {
            System.out.println(" Some rusty dust are on your finger where you are holding the nail");
            chosenItem="nail";
            playerChoices(chosenItem);
        } else if(item.contains("note")){
            this.hasouritem=true;
            this.hasanote=true;
            System.out.println();
            System.out.println(" Scribbled on the paper in blue ink are the words \n " +
                        "\n " +
                    "With every turn, you move toward the goal,For the answer is hidden, but part of the whole.\n" +
                        " What am I, that seeks to one, A mystery unraveled when the journey’s begun?");
            chosenItem="note";
            playerChoices(chosenItem);
        }else if(item.contains("key")){
            this.hasouritem=true;
            System.out.println("You have taken the rusty key. It's edges are bitten and the middle bitting was broken flat.");
            chosenItem="key";
            playerChoices(chosenItem);

        }else if(item.contains("coin")){
            this.hasouritem=true;
            System.out.println("You have taken the scratched coin.");
            chosenItem="coin";
            playerChoices(chosenItem);

        }else if(item.contains("card")){
            this.hasouritem=true;
            System.out.println("You now have a green business card. " +
                    " It is old and worn, with faded colors and a name APRITURNS above a slightly tarnished logo.");
            chosenItem="card";
            playerChoices(chosenItem);
        }else{
            System.out.println("Sorry, there is no such item in the drawer");
            drawerchoice();
        }
    }
    public void playerChoices(String theItem) {
        System.out.println(" ");
        System.out.println("Do you want to put "+theItem +" back in or take it with you. ");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("put")&&(choice.contains("back")&&(choice.contains(theItem)))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            this.finalChoices();
        } else if(choice.contains("put")&&(choice.contains("down")&&(choice.contains(theItem)))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            this.finalChoices();
        } else if(choice.contains("put it")&&(choice.contains("back"))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            this.finalChoices();
        }else if(choice.contains("put it")&&(choice.contains("down"))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            this.finalChoices();
        }else if (choice.contains("take")||(choice.contains(theItem))) {
            System.out.println("You have taken and kept " + theItem);
            this.finalChoices();
        } else{
            System.out.println("Sorry, I don't understand what you mean.");
            playerChoices(theItem);
        }
    }
    public void finalChoices(){
        System.out.println("Do you want to pick another item or close the drawer.");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("pick")||(choice.contains("choose"))){
            actualpicking();
        }else if(choice.contains("close")||(choice.contains("leave"))){
            closeDrawer();
            this.drawerIsOpen=false;
        } else{
            System.out.println("Sorry, I am unsure what you mean.");
            this.finalChoices();
        }
    }
}
