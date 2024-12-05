public class Room {
    // Room boundary defined by (x1, y1) for top-left and (x2, y2) for bottom-right
    public int x1, y1, x2, y2, z, roomnumber;
    public String roomName = "<Unknown name>";
    boolean isinsidetheroom;
    public Room(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Room(String roomname, int z, int x1, int y1, int roomnumber) {
        this.x1 = x1;
        this.y1 = y1;
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

    public Room(String roomtype, int z, int x1, int y1, int x2, int y2, int roomnumber) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.roomnumber = roomnumber;
        if (roomtype != null) {
            this.roomName = roomtype;
        }
        if (z < 2 && z >= 0) {
            this.z = z;
        } else {
            this.z = 1;
        }
    }

    public boolean isInfrontofroom(Prisoner p) {
        if (p.getX() == x1 && p.getY() == y1 && p.getZ() == z) {
            System.out.println("You are in front of the room");
            return true;
        } else {
            return false;
        }
    }
    public boolean isInsideRoom(Prisoner p) {
        if(x1<x2){
            if (p.getX() >= x1 && p.getX() <=x2 && p.getY() >= y1 && p.getY() <= y2 && p.getZ() == z) {
                this.isinsidetheroom=true;
            }else{
                this.isinsidetheroom=false;
            }
        }else if(x2<x1){
            if (p.getX() <=x1 && p.getX() >=x2 && p.getY() >= y1 && p.getY() <= y2 && p.getZ()==z) {
                this.isinsidetheroom=true;
            } else {
                this.isinsidetheroom=false;
            }
        }
        return this.isinsidetheroom;
    }

    public void enterRoom(Prisoner p) {
        if(!isInsideRoom(p)){
            if (isInfrontofroom(p)) {
                if (this.x1 > this.x2) {
                    p.goEast();
                    System.out.println("You entered the room");
                } else if (this.x1 < this.x2) {
                    p.goWest();
                System.out.println("You entered the room");
                }
            }
        }
    }

    public String getRoomName() {
        return roomName;
    }
//this.activeroom=-1??
}

