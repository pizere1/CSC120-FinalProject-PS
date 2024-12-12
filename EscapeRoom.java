import java.util.Scanner;
public class EscapeRoom extends Room{
    /*Attributes*/
    public String roomName;
    Scanner input = new Scanner(System.in);
    boolean isinsidetheroom;
   
    MugDrawer md = new MugDrawer();
    //BookDrawer bd = new BookDrawer();
    //CactusPotDrawer cpt=new CactusPotDrawer();
   //DeskLampDrawer dl=new DeskLampDrawer();
    //PictureFrameDrawer pf=new PictureFrameDrawer();
    
    /**
     * constructor for escape room
     * @param roomname take in the room name
     * @param x the x for location
     * @param y the y location of the room
     * @param z the z location of the room
     * @param roomnumber takes in the room number
     */
    public EscapeRoom(String roomname, int x, int y, int z, int roomnumber){
        super(roomname, x, y, z, roomnumber);
        this.roomName ="Toxins Store";
        System.out.println();
        System.out.println("The door creaks behind you before the lock metals cling in place. You have entered another room.");
        CoGasJar cgj = new CoGasJar();
        roomStructure();
    }
    //public void initialize(){}
     /**
     * Function to display the room structure to the player
     */
    public void roomStructure(){
        System.out.print("In the room, there is a wooden desk and a black compartment");
        //a filing cabinet, a metallic drawer, a picture frame hanging on the wall.");
        commands();
    }
    /**
     * Overriden function to exit the room which does not allow a player to exit the escape room
     */
    public void exitRoom(Prisoner p){
        System.out.println("You cannot exit this room. The lock blocks from outside.");
    }
    /**
     * The function to hand the room commands
     */    
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
              //  bd.bookDrawerChoices();
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
    public static void main(String[] args){
        EscapeRoom escapeRoom=new EscapeRoom("yes", 4, -2, -2, 01);
       //BookDrawer bd = new BookDrawer();
    }
}
