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

}

