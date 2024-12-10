import java.util.Scanner;
public class EscapeRoom extends Room{
    public String roomName;
    Scanner input = new Scanner(System.in);
    boolean isinsidetheroom;
    BookDrawer bd = new BookDrawer();
    MugDrawer md = new MugDrawer();
    CactusPotDrawer cpt=new CactusPotDrawer();
    DeskLampDrawer dl=new DeskLampDrawer();
    PictureFrameDrawer pf=new PictureFrameDrawer();
    public EscapeRoom(String roomname, int z, int x1, int y1,int x2, int y2, int roomnumber){
        super(roomname, z, x1, y1,x2,y2, roomnumber);
        this.roomName ="Toxins Store";
        System.out.println();
        System.out.println("The door creaks behind you before the lock metals cling in place. You have entered another room.");
        CoGasJar cgj = new CoGasJar();
        roomStructure();
    }
    //public void initialize(){}
    public void roomStructure(){
        System.out.print("In the room, there is a wooden desk and a black compartment");
        //a filing cabinet, a metallic drawer, a picture frame hanging on the wall.");
        commands();
    }
    public void exitRoom(Prisoner p){
        System.out.println("You cannot exit this room. The lock blocks from outside.");
    }
    public static void main(String[] args){
        EscapeRoom escapeRoom=new EscapeRoom("yes",2,3,4,5,2,4);
    }
    public void commands(){
        //System.out.println();
        System.out.println(" Do you want to go to any of the features?");
        String command=input.nextLine();
        command=command.toLowerCase();
        if(command.contains("no")){
            System.out.println("You can seat and wait for the gas to leak or look around for a way out");
            commands();
        } else if(command.contains("yes")){
            System.out.println("Which feature do you want to go to?");
            String feature=input.nextLine();
            feature=feature.toLowerCase();
            if(feature.contains("wooden")&&feature.contains("desk")){
                //BookDrawer bd=new BookDrawer();
                bd.bookDrawerChoices();
            }else if(feature.contains("filling")&&feature.contains("cabinet")){
                //DeskLampDrawer dl=new DeskLampDrawer();

            } else if(feature.contains("compartment")){
                MugDrawer mk=new MugDrawer();
                mk.mugDrawerChoices();

            } else if (feature.contains("metallic")&&(feature.contains("drawer"))){
                //CoGasJar cgj=new CoGasJar();

            } else if(feature.contains("frame")&&(feature.contains("picture"))){
                //PictureFrameDrawer pf=new PictureFrameDrawer();

            } else{
                System.out.print("Sorry, I don't understand what you mean. Try again.");
                commands();
            }
        }else{
            System.out.println("Sorry, I am not quite sure what you mean by that.");
            commands();
        }
    }
}
