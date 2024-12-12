public class Room {

    public int x, y, z, roomnumber;
    public String roomName = null;

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

