import java.util.ArrayList;
import java.util.Scanner;
public class BookDrawer extends Drawer {
    Scanner scanner = new Scanner(System.in);
    String item1, item2, item3, item4, item5,item6;//item7;
    boolean isbookopen;
    String chosenItem;
    ArrayList<String>items=new ArrayList<>();

    public BookDrawer() {
        super();
        this.item1 = "rusty nail";
        this.item2 = "crumped note";
        this.item3 = "rusty key";
        this.item4 = "brown note";
        this.item5 = "scratched coin";
        this.item6 = "business card";
        //this.item7="old newspaper";
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        //items.add(item7);
        //don't call anyfunction in here
    }

    public void bookDrawerChoices(){
        System.out.println("You are in front of the Drawer with a book on the top. What do you want to do?");
        String command=scanner.nextLine();
        command = command.toLowerCase();
        if(command.contains("open")&&(command.contains("book"))) {
            System.out.println("You open the book. It is an empty notebook with nothing written in it.Still,");
            this.isbookopen=true;
            bookDrawerChoices();
        } else if(command.contains("open it")){
            System.out.println("You open the book. It is an empty notebook with nothing written in it. Still,");
            this.isbookopen=true;
            bookDrawerChoices();
        }else if(command.contains("take")&&(command.contains("book"))) {
            System.out.println("You open the notebook. It is an empty book with nothing writter in it");
            this.isbookopen=true;
            bookDrawerChoices();
        }else if(command.contains("close")&&(command.contains("book"))) {
            if(this.isbookopen) {
                System.out.println("You closed the book. Still,");
                bookDrawerChoices();
            }else{
                System.out.println("The notebook is not open.");
                bookDrawerChoices();
            }
        } else if((command.contains("close it"))){
            if(this.isbookopen) {
                System.out.println("You closed the book. Still,");
                bookDrawerChoices();
            }else{
                System.out.println("The notebook is not open.");
                bookDrawerChoices();
            }
        }
        else if(command.contains("open")&&(command.contains("drawer"))) {
            openDrawer();
        }else if (command.contains("open")&&(!command.contains("book"))) {
            System.out.println("You used 'open' in a way I don't understand");
            bookDrawerChoices();
        }else if(command.contains("move")&&(command.contains("around"))) {
            System.out.println("You move around the desk. There is nothing on the other side except the wall");
        }else if(command.contains("go")&&(command.contains("around"))) {
            System.out.println("You move around the desk. There is nothing on the other side except the wall");
        } else if (command.contains("open")&&(!command.contains("it"))) {
            System.out.println("You used 'open' in a way I don't understand");
            bookDrawerChoices();
        } else if(command.contains("close")&&(!command.contains("book"))) {
            System.out.println("You used 'close' in a way I don't understand");
            bookDrawerChoices();
        } else if(command.contains("close")&&(!command.contains("it"))) {
            System.out.println("You used 'close' in a way I don't understand");
            bookDrawerChoices();
        }
        else{
            System.out.println("Sorry, I don't understand what you mean.");
            bookDrawerChoices();
        }
    }

    public void openDrawer() {
        System.out.print("Opening the drawer...");
        System.out.println("The top drawer is opened. You see these items");
        for(String item:items) {
            System.out.print(item +", ");
        }
        drawerChoices();
    }

    public void drawerChoices() {
        System.out.println("Do you want to choose an item or leave?");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("choose")){
            System.out.print("Pick any item from");
            for(String item:items) {
                System.out.print(item +", ");
            }
            String pickedItem=scanner.nextLine();
            choseOptions(pickedItem);//what if they say I choose
            grab(pickedItem);
            grab(chosenItem);
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

    private void grab(String item){
        pickedItem=item.toLowerCase();
        for(String i:items) {
            if(pickedItem.contains(i)) {
                this.chosenItem=i;
                System.out.print("You have taken the " + this.chosenItem+". ");
                chosenOptions(this.chosenItem);
                break;
            } else{
                System.out.println("There is no "+ pickedItem +" in the box. Choose between the available items.");
                drawerChoices();
            }
        }
    }
    public void chosenOptions(String item){
        //if(items.equals(this.items.get(0)))
        if(item.equals("rusty nail")) {
            System.out.println(" Some rusty dust are on your finger where you are holding the nail");
            playerchoices(item);
        } else if(item.equals("crumped note")){
            String answer;
            System.out.println("You have taken the crumped note. What do you want to do with it?");
            answer=scanner.nextLine();
            answer = answer.toLowerCase();
            if(answer.contains("read")) {
                System.out.println(" Scribbled on the paper in blue ink are the words \n    " +
                        "With every turn, you move toward the goal,For the answer is hidden, but part of the whole.\n" +
                        "   What am I, that seeks to one, A mystery unraveled when the journey’s begun?");
                playerchoices(item);
            } else if ((answer.contains("put")&&(answer.contains("back")))){
                putback(item);
            } else if((answer.contains("put")&&(answer.contains("down")))){
                putback(item);
            }else if((answer.contains("leave"))) {
                putback(item);
            }else{
                System.out.println("Sorry, I am not quite sure what you mean by that.");
            }
        }else if(item.equals("rusty key")){
            System.out.println("You have taken the rusty key. It's edges are bitten and the middle bitting was broken flat.");
            playerchoices(item);
        } else if(item.equals("brown note")){
            System.out.println("You have taken the folded brown note. What do you want to do with it?");
            String answer=scanner.nextLine();
            answer = answer.toLowerCase();
            if(answer.contains("read")) {
                System.out.println(" Scribbled on the paper in black ink are the words \n    " +
                               "Do you remember that night? The night we fought, the last time we were truly together?\n    " +
                        "It wasn’t just the words we exchanged—it was the silence after, the distance that began to\n   " +
                        "grow between us, the fear in your eyes that I couldn' \n" +
                        "The rest of the paper seems to have been torn off" );
                playerchoices(item);
            } else if ((answer.contains("put")&&(answer.contains("back")))){
                putback(item);
            } else if((answer.contains("put")&&(answer.contains("down")))){
                putback(item);
            }else if((answer.contains("leave"))) {
                putback(item);
            }else{
                System.out.println("Sorry, I am not quite sure what you mean by that.This was your only chance to read the paper");
                playerchoices(item);
            }
        }else if(item.equals("scratched coin")){
            System.out.println("You have taken the scratched coin.");
            playerchoices(item);
        }else if(item.equals("business card")){
            System.out.println("You now have a green business card. " +
                    " It is old and worn, with faded colors and a name APRITURNS above a slightly tarnished logo.");
            playerchoices(item);
        }else{
            System.out.println("There is no " +item+"in the drawer");
            drawerChoices();
        }
    }
    public void choseOptions(String item){
        //if(items.equals(this.items.get(0)))
        if(item.contains("rusty nail")) {
            System.out.println(" Some rusty dust are on your finger where you are holding the nail");
            playerchoices(item);
        } else if(item.contains("crumped note")){
            String answer;
            System.out.println("You have taken the crumped note. What do you want to do with it?");
            answer=scanner.nextLine();
            answer = answer.toLowerCase();
            if(answer.contains("read")) {
                System.out.println(" Scribbled on the paper in blue ink are the words \n    " +
                        "With every turn, you move toward the goal,For the answer is hidden, but part of the whole.\n" +
                        "   What am I, that seeks to one, A mystery unraveled when the journey’s begun?");
                playerchoices(item);
            } else if ((answer.contains("put")&&(answer.contains("back")))){
                putback(item);
            } else if((answer.contains("put")&&(answer.contains("down")))){
                putback(item);
            }else if((answer.contains("leave"))) {
                putback(item);
            }else{
                System.out.println("Sorry, I am not quite sure what you mean by that.");
            }
        }else if(item.contains("rusty key")){
            System.out.println("You have taken the rusty key. It's edges are bitten and the middle bitting was broken flat.");
            playerchoices(item);
        } else if(item.contains("brown note")){
            System.out.println("You have taken the folded brown note. What do you want to do with it?");
            String answer=scanner.nextLine();
            answer = answer.toLowerCase();
            if(answer.contains("read")) {
                System.out.println(" Scribbled on the paper in black ink are the words \n    " +
                        "Do you remember that night? The night we fought, the last time we were truly together?\n" +
                        "   It wasn’t just the words we exchanged—it was the silence after, the distance that began to\n" +
                        "   grow between us, the fear in your eyes that I could\n" +
                        "the rest of the paper is torn" );
                playerchoices(item);
            } else if ((answer.contains("put")&&(answer.contains("back")))){
                putback(item);
            } else if((answer.contains("put")&&(answer.contains("down")))){
                putback(item);
            }else if((answer.contains("leave"))) {
                putback(item);
            }else{
                System.out.println("Sorry, I am not quite sure what you mean by that.This was your only chance to read the paper");
                playerchoices(item);
            }
        }else if(item.contains("scratched coin")){
            System.out.println("You have taken the scratched coin.");
            playerchoices(item);
        }else if(item.contains("business card")){
            System.out.println("You now have a green business card. " +
                    " It is old and worn, with faded colors and a name APRITURNS above a slightly tarnished logo.");
            playerchoices(item);
        }else{
            System.out.println("There is no such item in the drawer");
            drawerChoices();
        }
    }
    public void playerchoices(String theItem) {
        System.out.println("Do you want to put "+theItem +" back in or take it with you. ");
        String choice=scanner.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("put")&&(choice.contains("back")&&(choice.contains(theItem)))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalchoices();
        } else if(choice.contains("put")&&(choice.contains("down")&&(choice.contains(theItem)))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalchoices();
        } else if(choice.contains("put it")&&(choice.contains("back"))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalchoices();
        }else if(choice.contains("put it")&&(choice.contains("down"))) {
            System.out.println("You have put back" +theItem +" in the drawer.");
            finalchoices();
        }else if (choice.contains("take")||(choice.contains(theItem))) {
            System.out.println("You have taken and kept " + theItem);
            finalchoices();
        } else{
            System.out.println("Sorry, I don't understand what you mean.");
            playerchoices(theItem);
        }
    }
    public void putback(String theItem) {
        //for(String t:items) {
            //if(t.contains(theItem)) {
                System.out.println("You have put back " + theItem +" in the drawer.");
                finalchoices();
//            } else {
//                System.out.println("The items "+ theItem +" was not in this drawer.");
//            }
        //}
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
}
=
