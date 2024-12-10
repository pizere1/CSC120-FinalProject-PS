// import java.util.ArrayList;
// public class JailHouse {
//    private ArrayList<Room>jailHouse=new ArrayList<Room>();
//    public int wallcount=0;
//    boolean isadeadend;
//    private int xMax;
//    private int xMin;
//    private int yMax;
//    private int yMin;
//    private int zMax;
//    private int zMin;

//    public JailHouse(){
//     this.xMax = 4;
//     this.xMin = 0;
//     this.yMax = 6;
//     this.yMin = -2;
//     this.zMax = 2;
//     this.zMin = -2;
//    }
//    public void declaredLocation(){
//        Room cell1 = new Room("Prison Cell", 0, 0,0, 11);
//        Room hallway1 = new Room("In front of your cell", 2, 0, 0, 0); // player is outside their cell
//        Room hallway2 = new Room("Middle of hallway on the first floor", 2, 2, 0, 0); // right to the 
//        Room clueroom1= new Room("Cellmate's Cell", 0,-2,0,12);
//        Room clueroom2= new Room("Storage room", 0 ,-2, -2,2);
//        Room Escaperoom=new Room("Toxins Storage",4,-2,-2,03);
//        Room Bathroom= new Room("Bathroom",4, 2, 0, 13);
//        Room Alarming_cell=new Room("Prison Cell",4, 2 , 0,0,2,111);
//        Room Locking_room=new Room("Old Locker room",4,-2,-2,0,-2,101);
//        Features Staircasetop=new Features("Staircase", 0,10,6,12,8,131);
//        jailHouse.add(cell1);
//        jailHouse.add(clueroom1);
//        jailHouse.add(clueroom2);
//        jailHouse.add(Escaperoom);
//        jailHouse.add(Bathroom);
//        jailHouse.add(Alarming_cell);
//        jailHouse.add(Locking_room);
//        jailHouse.add(Staircasetop);
//    }
// //    public void declaredLocation(int z, int x1, int y1, int x2){
//     // if (z == 0 &&  x1 == 4 && y1 == 0 &&  x2 == 0 && y2 == 4){

//     // }
// //    }

//    public void getLocation(Prisoner p){
//     wallcount = 0; // Reset wall count for every call
//     System.out.print("You are currently at (" + p.getX() + "," + p.getY() + "," + p.getZ() + ").");
//     for (Room r : jailHouse) {
//         if (p.getX() == r.x1 && p.getY() == r.y1 && p.getZ() == r.z) { // If they are at the entrance
//             System.out.println(" You are at the entrance of " + r.roomName + ".");
//         } else {
//             wallcount++;
//         }
//     }
//     if (wallcount == jailHouse.size()) { // If not at the entrance of any room
//         System.out.println("There are walls on both sides. Keep moving.");
//     } else if (wallcount == (jailHouse.size() - 1)) {
//         System.out.println("There is also a wall on the opposite side.");
//     }
// }

// //    public void getLocation(Prisoner p){
//     //    System.out.print("You are currently at (" +p.getX()+","+p.getY()+","+p.getZ()+").");
//     //    for(Room r:jailHouse){
//         //    if(p.getX()==r.x1 && p.getY()==r.y1 && p.getZ()==r.z){//If they are currently at the entrance
//                // System.out.print("You are currently at (" +p.getX()+","+p.getY()+","+p.getZ()+").");
//             //    System.out.println(" You are at the entrance of " +r.roomName+".");
//         //    } else{
//             //    this.wallcount++;
//         //    }
//     //    }
//     //    if(this.wallcount==jailHouse.size()){//If they are not at the entrance of any room
//         //    System.out.println("There are walls on both side . Keep moving");
//     //    } else if(wallcount==(jailHouse.size()-1)){
//         //    System.out.println("There is also a wall on the opposite side");
//     //    } else{
//     //    }
//   //}
//    public void canEnterRoom(Prisoner p, Room room) {
//        int x = p.getX();
//        int y = p.getY();
//        int z = p.getZ();
//        for(Room feature : jailHouse) {
//            if ((feature.x1==x)&&(feature.y1==y)&&(feature.z==z)){
//                System.out.println("You can enter "+feature.roomName);
//            } else{
//                System.out.println("You can not enter "+feature.roomName +" from here.");
//            }
//        }
//    }
//    public boolean isIsadeadend(int x, int y){
//        if(x<this.jailhousex1limit){
//            this.isadeadend=true;
//        }else if(x>this.jailhousex2limit){
//            this.isadeadend=true;
//        }else if(y<this.jailhousey1limit){
//            this.isadeadend=true;
//        } else if(y>this.jailhousey2limit){
//            this.isadeadend=true;
//        }else{
//            this.isadeadend=false;
//        }
//        return this.isadeadend;
//    }

//    public void returnLocation(Prisoner player) {
//     // Loop through all rooms in the jailhouse
//     for (Room r : jailHouse) {
//         // Check if the prisoner is to the east of the room
//         if (player.getY() == r.y1 && player.getZ() == r.z && player.getX() < r.x1 && r.x1 < r.x2) {
//             System.out.println("There is " + r.roomName + " to your east.");
//         }
//         // Check if the prisoner is to the west of the room
//         else if (player.getY() == r.y1 && player.getZ() == r.z && player.getX() > r.x2 && r.x2 > r.x1) {
//             System.out.println("There is " + r.roomName + " to your west.");
//         }
//     }
// }

// public static void main(String[] args) {
//     JailHouse jh=new JailHouse();
//     System.out.println(jh.jailHouse.get(0));


// }


// //    public void returnLocation(Prisoner p){
//     //  for(Room r:jailHouse){
//         //  if((p.getX()-2)==r.x1 && p.getY()==r.y1 && p.getZ()==r.z && r.x1>r.x2){
//         //  System.out.println(" There is " +r.roomName+" on your east.");
//         //  }
//         //    if((p.getX()+2)==r.x1 && p.getY()==r.y1 && p.getZ()==r.z && r.x1<r.x2){
//             //    System.out.println(" There is " +r.roomName+" on your west.");
//         //    } 
//     //    }
//     // }
// }