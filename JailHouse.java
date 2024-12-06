import java.util.ArrayList;
public class JailHouse {
   private ArrayList<Room>jailHouse=new ArrayList<Room>();
   public int wallcount=0;
   boolean isadeadend;
   private int jailhousey1limit;
   private int jailhousey2limit;
   private int jailhousex1limit;
   private int jailhousex2limit;
   public JailHouse(){
       this.jailhousey1limit = -6;
       this.jailhousey2limit = 12;
       this.jailhousex1limit = 0;
       this.jailhousex2limit = 12;
       initialize();
   }
   public void initialize(){
       Room cell1 = new Room("Prison Cell", 0, 4,0, 0,4, 11);
       Room clueroom1=new Room("Knot Lodge", 0,4,6,0,-2,31);
       Room clueroom2=new Room("Storage room", -2,4, 2,0,6,71);
       Room Escaperoom=new Room("Toxins Storage",-2,8,-6,12,-2,51);
       Room Bathroom=new Room("Bathroom",-2, 10,2,12,4,91);
       Room Alarming_cell=new Room("Prison Cell",-2, 4,-2,0,2,111);
       Room Locking_room=new Room("Old Locker room",-2,4,-6,0,-2,101);
       Features Staircasetop=new Features("Staircase", 0,10,6,12,8,131);
       jailHouse.add(cell1);
       jailHouse.add(clueroom1);
       jailHouse.add(clueroom2);
       jailHouse.add(Escaperoom);
       jailHouse.add(Bathroom);
       jailHouse.add(Alarming_cell);
       jailHouse.add(Locking_room);
       jailHouse.add(Staircasetop);
   }
//    public void declaredLocation(int z, int x1, int y1, int x2){
    // if (z == 0 &&  x1 == 4 && y1 == 0 &&  x2 == 0 && y2 == 4){

    // }
//    }

   public void getLocation(Prisoner p){
    wallcount = 0; // Reset wall count for every call
    System.out.print("You are currently at (" + p.getX() + "," + p.getY() + "," + p.getZ() + ").");
    for (Room r : jailHouse) {
        if (p.getX() == r.x1 && p.getY() == r.y1 && p.getZ() == r.z) { // If they are at the entrance
            System.out.println(" You are at the entrance of " + r.roomName + ".");
        } else {
            wallcount++;
        }
    }
    if (wallcount == jailHouse.size()) { // If not at the entrance of any room
        System.out.println("There are walls on both sides. Keep moving.");
    } else if (wallcount == (jailHouse.size() - 1)) {
        System.out.println("There is also a wall on the opposite side.");
    }
}

//    public void getLocation(Prisoner p){
    //    System.out.print("You are currently at (" +p.getX()+","+p.getY()+","+p.getZ()+").");
    //    for(Room r:jailHouse){
        //    if(p.getX()==r.x1 && p.getY()==r.y1 && p.getZ()==r.z){//If they are currently at the entrance
               // System.out.print("You are currently at (" +p.getX()+","+p.getY()+","+p.getZ()+").");
            //    System.out.println(" You are at the entrance of " +r.roomName+".");
        //    } else{
            //    this.wallcount++;
        //    }
    //    }
    //    if(this.wallcount==jailHouse.size()){//If they are not at the entrance of any room
        //    System.out.println("There are walls on both side . Keep moving");
    //    } else if(wallcount==(jailHouse.size()-1)){
        //    System.out.println("There is also a wall on the opposite side");
    //    } else{
    //    }
  //}
   public void canEnterRoom(Prisoner p, Room room) {
       int x = p.getX();
       int y = p.getY();
       int z = p.getZ();
       for(Room feature : jailHouse) {
           if ((feature.x1==x)&&(feature.y1==y)&&(feature.z==z)){
               System.out.println("You can enter "+feature.roomName);
           } else{
               System.out.println("You can not enter "+feature.roomName +" from here.");
           }
       }
   }
   public boolean isIsadeadend(int x, int y){
       if(x<this.jailhousex1limit){
           this.isadeadend=true;
       }else if(x>this.jailhousex2limit){
           this.isadeadend=true;
       }else if(y<this.jailhousey1limit){
           this.isadeadend=true;
       } else if(y>this.jailhousey2limit){
           this.isadeadend=true;
       }else{
           this.isadeadend=false;
       }
       return this.isadeadend;
   }

   public void returnLocation(Prisoner p) {
    // Loop through all rooms in the jailhouse
    for (Room r : jailHouse) {
        // Check if the prisoner is to the east of the room
        if (p.getY() == r.y1 && p.getZ() == r.z && p.getX() < r.x1 && r.x1 < r.x2) {
            System.out.println("There is " + r.roomName + " to your east.");
        }
        // Check if the prisoner is to the west of the room
        else if (p.getY() == r.y1 && p.getZ() == r.z && p.getX() > r.x2 && r.x2 > r.x1) {
            System.out.println("There is " + r.roomName + " to your west.");
        }
    }
}

public static void main(String[] args) {
    JailHouse jh=new JailHouse();
    System.out.println(jh.jailHouse.get(0).roomName);


}


//    public void returnLocation(Prisoner p){
    //  for(Room r:jailHouse){
        //  if((p.getX()-2)==r.x1 && p.getY()==r.y1 && p.getZ()==r.z && r.x1>r.x2){
        //  System.out.println(" There is " +r.roomName+" on your east.");
        //  }
        //    if((p.getX()+2)==r.x1 && p.getY()==r.y1 && p.getZ()==r.z && r.x1<r.x2){
            //    System.out.println(" There is " +r.roomName+" on your west.");
        //    } 
    //    }
    // }
}