import java.util.ArrayList;
import java.util.Scanner;
public class TheBox {
    
    public int prisonerNumber;
    public TheBox(int prisonerNumber){
        this.prisonerNumber = prisonerNumber;
        boxContent();
    }
    
    Scanner scanner = new Scanner(System.in);
    String userInput;
    Scanner sc = new Scanner(System.in);
    boolean isCracked = false;
    boolean isOpen=false;
    boolean wasOpened = false;
    String pocketKnife="pocketknife";
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

    private boolean codeBreaking(int code){
        if (code == prisonerNumber){
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
        int code=sc.nextInt();
        sc.nextLine();
        while (!codeBreaking(code)){
            System.out.println("Please try again");
            code=sc.nextInt();
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
}
