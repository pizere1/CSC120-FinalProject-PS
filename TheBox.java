import java.util.ArrayList;
import java.util.Scanner;
public class TheBox {
    public TheBox(){
        boxContent();
    }
    Scanner scanner = new Scanner(System.in);
    String userInput;
    Scanner sc = new Scanner(System.in);
    boolean isCracked = false;
    boolean isOpen=false;
    boolean wasOpened = false;
    String pocketKnife="pocketKnife";
    String key="key";
    String rope="rope";
    String pickedItem;
    public ArrayList<String> boxContent=new ArrayList<>();
    private void boxContent(){
        boxContent.add(pocketKnife);
        boxContent.add(key);
        boxContent.add(rope);
    }

    public void boxChoices(){
        System.out.println("There is a box in front of you.");
        userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();
        if(userInput.contains("open")&&(userInput.contains("box"))){
            openBoX();
        } else if(userInput.contains("open it")){
            openBoX();
        } else if (userInput.contains("open")&&!(userInput.contains("box")) && !(userInput.contains("open it"))){
            System.out.println("You used 'open' in a way I don't understand.");
            boxChoices();
        } else{
            System.out.println("Sorry, I don't understand. Try again.");
            boxChoices();
        }
    }

    private boolean codeBreaking(String code){
        if (code.equals("z1m")){
            this.isCracked=true;
            this.isOpen=true;
        } else{
            this.isCracked=false;
        }
        return isCracked;
    }
    public void openBoX(){
        if(this.wasOpened==true){
           System.out.println("The box was closed. You can only open it once.");
        } else{
        System.out.println("First Enter the code. The hint is your only companion.");
        String code=sc.nextLine();
        while (!codeBreaking(code)){
            System.out.println("Please try again");
            code=sc.nextLine();
            codeBreaking(code);
        }
        if(this.isCracked==true){
            this.wasOpened=true;
            System.out.println("You have opened the box");
            boxDisplay();
        }
        }
    }
    private void boxDisplay(){
        System.out.print("The box contains the following items: ");
        System.out.println(boxContent);
        System.out.println("Pick one item");
        String pickedItem=sc.nextLine();
        grab(pickedItem);
    }
    private void grab(String item){
        pickedItem=item.toLowerCase();
        if(boxContent.contains(pickedItem)){
            System.out.println("You have taken the " + pickedItem);
            System.out.println("The box got reclosed again");
        } else{
            System.out.println("There is no "+ pickedItem +" in the box. Choose between the three.");
            boxDisplay();
        }
    }

    public static void main(String[] args) {
        //System.out.println("You wake up inside a gray room. You are wearing a dark purple jumpsuit which has the number 213 on the right arm \n" +
//                "You remember nothing about who you are or why you reached here. Your mind is blank as the walls of the room, except for only " +
//                "three phrases for company\n\n'The end will always matter but the middle will draw evasion" +
//                "Most crimes are tolerated but murderers were badly stained.\nYou are less safe inside those walls than anywhere else.'");

        TheBox theBox=new TheBox();
        theBox.boxChoices();
    }
}
