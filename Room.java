public class Room {
    /*Attributes*/
    public int x, y, z, roomnumber;
    public String roomName = null;
    
    /**
     * constructor for the Room class
     * @param roomname takes in the name of the room
     * @param x the x location of the room
     * @param y the y location
     * @param z the floor number (z) for the room
     * @param roomnumber takes in the room number
     */

    public Room(String roomname, int x, int y, int z, int roomnumber) {
        this.x = x;
        this.y = y;
        this.roomnumber = roomnumber;

        if (roomname != null) {
            this.roomName = roomname;
        }

        if (z < 2 && z >= 0) {
            this.z = z;
        } else {
            this.z = 1;
        }
    }
     

    // public boolean isInfrontofroom(Prisoner p) {
        // if (p.getX() == x1 && p.getY() == y1 && p.getZ() == z) {
            // System.out.println("You are in front of the room");
            // return true;
        // } else {
            // return false;
        // }
    // }
    // public boolean isInsideRoom(Prisoner p) {
        // if(x1<x2){
            // if (p.getX() >= x1 && p.getX() <=x2 && p.getY() >= y1 && p.getY() <= y2 && p.getZ() == z) {
                // this.isinsidetheroom=true;
            // }else{
                // this.isinsidetheroom=false;
            // }
        // }else if(x2<x1){
            // if (p.getX() <=x1 && p.getX() >=x2 && p.getY() >= y1 && p.getY() <= y2 && p.getZ()==z) {
                // this.isinsidetheroom=true;
            // } else {
                // this.isinsidetheroom=false;
            // }
        // }
        // return this.isinsidetheroom;
    // }

    // public void enterRoom(Prisoner p) {
        // if(!isInsideRoom(p)){
            // if (isInfrontofroom(p)) {
                // if (this.x1 > this.x2) {
                    // p.goEast();
                    // System.out.println("You entered the room");
                // } else if (this.x1 < this.x2) {
                    // p.goWest();
                // System.out.println("You entered the room");
                // }
            // }
        // }
    // }
    // public void exitRoom(Prisoner p) {
        // if(x1>x2){
        // p.setLocation(this.x1+2, this.y1,this.z);
        // } else if(x2>x1){
            // p.setLocation(this.x1-2, this.y1,this.z);
        // }
    // }

    // public String getRoomName() {
        // return roomName;
    // }
//this.activeroom=-1??
}

