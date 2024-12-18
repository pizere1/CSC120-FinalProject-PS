import java.util.ArrayList;
import java.util.Scanner;
public class TheBox {
    /**
     * Attributes
     */
    public int prisonerNumber;
    Scanner scanner = new Scanner(System.in);
    String userInput;
    Scanner sc = new Scanner(System.in);
    boolean isCracked = false;
    boolean isOpen=false;
    boolean wasOpened = false;
    String pocketKnife="pocket knife";
    String key="key";
    String rope="rope";
    String pickedItem;
    boolean itemInHand;
    boolean doorUnlocked = false;
    public ArrayList<String> boxContent=new ArrayList<>();
    /**
     * Constructor for the box class
     */
    public TheBox(int prisonerNumber){
        this.prisonerNumber = prisonerNumber;
        boxContent();
    }

    /**
     * Function for adding contents to the box
     */
    private void boxContent(){
        boxContent.add(pocketKnife);
        boxContent.add(key);
        boxContent.add(rope);
    }

    /**
     * function for checking if the door in unlocked
     * @return the door close/opening status
     */
    public boolean isDoorUnlocked(){
        return doorUnlocked;
    }

    /**
     * Function for choices when interacting with the box
     */
    public void boxChoices(){
        System.out.println("There is a box in front of you.");
        userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();
        if(userInput.contains("open")){
            openBoX();
        } else if (userInput.contains("open")&&!(userInput.contains("box")) && !(userInput.contains("open it"))){
            System.out.println("You used 'open' in a way I don't understand.");
            boxChoices();
        } else{
            System.out.println("Sorry, I don't understand. Try again.");
            boxChoices();
        }
    }

    /**
     * Function for breaking the code to open the box
     * @param code takes in a code
     * @return if it true or false
     */
    private boolean codeBreaking(int code){
        if (code == prisonerNumber){
            this.isCracked=true;
            this.isOpen=true;
        } else{
            this.isCracked=false;
        }
        return isCracked;
    }

    /**
     * Function to go to the door
     */
    public void goToDoor(){
        if (doorUnlocked == false){
            System.out.println("You're at the door. You see a lock. What is your next move?");
        } else{
            System.out.println("You've already moved past the door.");
        }
    }

    /**
     * Function to open the doorlock
     */
    public void openLock(){
        if (itemInHand == true){
            if (pickedItem.contains("pocket knife")){
                System.out.println("Door Unlocked.");
                doorUnlocked = true;
            }  else {
                System.out.println("You picked the wrong item. Try again");
                openBoX();
            } } else {
            System.out.println(" You need to find an item to unlock the door. Consider everything around you.");
        }
    }

    /**
     * Function to open the box
     */
    public void openBoX(){
        if(this.wasOpened==true){
            System.out.println("Reopening the box.");
            boxContent.remove(pickedItem);
            boxDisplay();
        } else{
            System.out.println("To open the box you need to enter its code. Your hint lies within the choices you made. The ripple is protected by a triple.");
            try {
                int code = sc.nextInt();
                while (!codeBreaking(code)){
                    System.out.println("Please try again");
                    openBoX();
                }
                sc.nextLine();
                boxDisplay();
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter a valid integer" );
                sc.nextLine();
                openBoX();
            }
        }
    }

    /**
     * Function to display the contents of the box
     */
    private void boxDisplay(){
        System.out.print("The box contains the following items: ");
        System.out.println(boxContent);
        System.out.println("Pick one item");
        String pickedItem=sc.nextLine();
        grab(pickedItem);
    }

    /**
     * Function to grab an item
     * @param item takes in the name of the item
     */
    private void grab(String item){
        pickedItem=item.toLowerCase();
        if(boxContent.contains(pickedItem)){
            System.out.println("You have taken the " + pickedItem);
            System.out.println("The box got closed again");
            itemInHand = true;
        }  else if(item.contains("knife")){
            pickedItem="pocket knife";
            System.out.println("You have taken the knife");
            System.out.println("The box got closed again");
            itemInHand = true;
        }else{
            System.out.println("There is no "+ pickedItem +" in the box. Choose between the three.");
            boxDisplay();
        }
    }
}
