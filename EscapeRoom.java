import java.util.*;
public class EscapeRoom extends Room {
    public EscapeRoom(String roomname, int x, int y, int z, int roomnumber){
        super(roomname, x, y, z, roomnumber);
        this.roomName ="Toxins Store";
    }
    ArrayList<String>Help=new ArrayList<>();
    public void helpline(){
        String commands=("* open / close drawer, open / close book");
        String command=("* open / close book");
        String command1=("* put it back /take it");
        String command2=("* yes / no");
        String command3=("* choose/leave");
        String command4=("* quit / help");
        String command5=("* exit / look around");
        String command6=("* open tile/ decend / climb down");
        Help.add(command);
        Help.add(command1);
        Help.add(command2);
        Help.add(command3);
        Help.add(command4);
        Help.add(command5);
        Help.add(commands);
        Help.add(command6);
        System.out.println("Here are the commands you can use in this interface");
        for(String s:Help){
            System.out.println(s);
        }
        // System.out.println(Help);
    }
    public void mainThing() {

        Scanner in = new Scanner(System.in);

        //EscapeRoom es=new EscapeRoom("Thisone", 2,3,4,22);
        //EscapeRoomInterface esi=new EscapeRoomInterface();

        //MugDrawer md=new MugDrawer();
        //BookDrawer be=new BookDrawer();
        //PictureFrame pf=new PictureFrame();

        UndergroundTunnel tunnel=new UndergroundTunnel();
        Compartment comp=new Compartment();
        Frame f=new Frame();
        WoodenDrawer w=new WoodenDrawer();
        //tunnel.opentunnel(comp);

        System.out.println();
        System.out.println("The door locks behind you. You have entered another room.");
        CoGasJar cgj = new CoGasJar();
        System.out.print("In the room, there is a wooden drawer on one side, a metal compartment facing it and a picture frame on the floor.");

        while (true) {
            System.out.println();

            System.out.print("\nEnter command: ");
            String command = in.nextLine().toLowerCase().trim();

            if (command.contains("quit")) {
                System.out.println("Quitting game...");
                break;
            } else if (command.contains("exit") && (command.contains("game"))) {
                System.out.println("Quitting game...");
                break;
            } else if (command.contains("exit") && (command.contains("room"))) {
                System.out.println("You cannot exit this room. The lock blocks from outside.");
            } else if (command.contains("exit") && !((command.contains("room")) || (command.contains("game")))) {
                System.out.println("Type the full command with what you want to exit");
            } else if (command.contains("help")) {
                helpline();
            } else if (command.contains("look around")) {
                System.out.print("In the room, there is a wooden drawer on one side, a metal compartment facing it and a picture frame on the floor.");
            } else if (command.contains("go")) {
                if (command.contains("wooden") || (command.contains("drawer"))) {
                    //be.bookDrawerChoices();
                    w.bookdrawer();
                } else if (command.contains("compartment") || (command.contains("metallic"))) {
                    //md.mugDrawerChoices();
                    comp.atCompartment();
                } else if (command.contains("frame") || (command.contains("picture"))) {
                    // pf.initialize();
                    f.gotoframe();
                } else if (command.contains("frame")) {
                    // pf.initialize();
                    f.gotoframe();
                } else if (command.contains("door")) {
                    System.out.println("You go to the door, it is locked. You cannot exit from here. Find another escape before you die.");
                } else if (command.contains("wall")) {
                    System.out.println("You stand next the wall.");
                } else {
                    System.out.println("Please type a full command with a place in this room or check for a typo.");
                }
            } else if (command.contains("open")) {
                if (command.contains("wooden") || (command.contains("drawer"))) {
                    //be.openDrawer();
                    w.openDrawer();
                } else if (command.contains("compartment") || (command.contains("metallic"))) {
                    //md.mugDrawerChoices();
                    comp.openCompartment();
                } else if (command.contains("frame") || (command.contains("picture"))) {
                    System.out.println("You cannot open the picture frame");
                } else if (command.contains("door")) {
                    System.out.println("You cannot exit this room. The lock blocks from outside.");
                }else if(command.contains("book")){
                    w.openbook();
                } else if(command.contains("open it")){
                    System.out.println("Please specify what you want to open");
                }else {
                    System.out.println("Sorry. Use open in a full command on an object in this room, or check for a typo.");
                }
            }else if(command.contains("descend")){
                tunnel.descend();
            } else if(command.contains("climb")){
                if(command.contains("down")){
                    tunnel.descend();
                } else if(command.contains("up")){
                    System.out.println("You cannot climb up anything in this room.");
                }else {
                    System.out.println("Sorry. Please use climb in an upwards/downwards direction.");
                }
            } else if(command.contains("close")){
                if (command.contains("wooden") || (command.contains("drawer"))) {
                    //be.openDrawer();
                    w.closeDrawer();
                } else if (command.contains("compartment") || (command.contains("metallic"))) {
                    //md.mugDrawerChoices();
                    comp.closeDrawer();
                } else if (command.contains("frame") ||(command.contains("picture"))) {
                    System.out.println("You cannot close the picture frame");
                } else if (command.contains("door")) {
                    System.out.println("You actually couldn't even open the door. The lock blocks from outside.");
                }else if(command.contains("book")){
                    w.closebook();
                } else if(command.contains("close it")){
                    System.out.println("Please specify what you want to close");
                }else {
                    System.out.println("Sorry. Use open in a full command on an object in this room, or check for a typo.");
                }
            }  else if(command.contains("pick")&&((command.contains("frame")) || (command.contains("picture")))){
                f.pickup();
            }else if(command.contains("pick")&&!((command.contains("frame")) || (command.contains("picture")))){
                System.out.println("If not the picture frame, first open a feature to pick something from.");
            } else if(((command.contains("see"))||(command.contains("check")))&&(command.contains("frame")||command.contains("picture"))){
                f.observe();
            } else if(((command.contains("look"))||(command.contains("observe")))&&(command.contains("frame")||command.contains("picture"))){
                f.observe();
            } else if(command.contains("break")&&command.contains("crack")){
                tunnel.opentunnel(comp);
            }else if(command.contains("pry")&&(command.contains("open"))){
                tunnel.opentunnel(comp);
            }else if(command.contains("enter")&&(command.contains("hole"))){
                tunnel.descend();
            } else if(command.contains("enter")){
                System.out.println("You have nothing to enter to.");
            }else{
                System.out.println("Unknown command. Try again.");
            }
        }

    }
    public static void main(String[] args) {
        EscapeRoom esc = new EscapeRoom("e",3,3,4,32);
    }
}
