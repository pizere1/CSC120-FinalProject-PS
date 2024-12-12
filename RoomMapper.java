import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class RoomMapper {
    private HashMap<String, String> roomMap;
    EscapeRoom es=new EscapeRoom("ER",4,-2,-2,12);

    public RoomMapper() {
        roomMap = new HashMap<>();
    
    }

    /**
     * Adds a room to the map
     * @param roomName the room of the name
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
    public void addRoom(String roomName, int x, int y, int z) {
        String key = generateKey(x, y, z);
        roomMap.put(key, roomName);
    }

    // Get the room name for a given coordinate
    public String getLocation(int x, int y, int z) {
        String key = generateKey(x, y, z);
        return roomMap.getOrDefault(key, "Walls"); // Return room name or default message
    }

    public void evaluateLocation(int x, int y, int z, RoomMapper mapper, CellMate cellMate) {
        String location = mapper.getLocation(x, y, z);
    
        switch (location) {
            case "Hallway in front of the cellmate at cell 12, End of Hallway on South":
                System.out.println("You see your cellmate in the cell nearby.");
                System.out.println("You can type 'speak' to talk to him.");
                break;
    
            case "Alarm Room":
                System.out.println("An alarm blares loudly as you enter the room!");
                this.playSound();
                break;
    
            case "ER":
                System.out.println("Congratulations! You've reached the escape room.");
                es.roomStructure();
                break;
    
            default:
                System.out.println("You are now in: " + location);
                break;
        }
    }    

    public void lookAround(int x, int y, int z){
        System.out.println("\n Nearby Locations:\n");
        System.out.println("North: " + getLocation(x, y + 2, z));
        System.out.println("South: " + getLocation(x, y - 2, z));
        System.out.println("East: " + getLocation(x - 2, y, z));
        System.out.println("West: " + getLocation(x + 2, y, z));
    }



    public void playSound() {
        try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/sdumre/Downloads/mixkit-facility-alarm-sound-999.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
           ex.printStackTrace();
     }
    }   


    public void clueCheck(int x, int y, int z, CellMate cellMate){
        if (x == 2 && y == -2 && z == 0){
            cellMate.cellMateInfo();
            System.out.println("You should consider speaking to him.\n");
        }
    }
    private String generateKey(int x, int y, int z) {
        return x + "," + y + "," + z; // changes coordinates to string
    }

    public static void main(String[] args) {
        RoomMapper mapper = new RoomMapper();
        CellMate cellMate = new CellMate("RamHari", 14, 621);


        // Add rooms
        mapper.addRoom("Prison Cell", 0, 0, 0); //1
        mapper.addRoom("Hallway in front of cell 11", 2, 0, 0);// 2
        mapper.addRoom("Hallway in front of the cellmate at cell 12, End of Hallway on South", 2, -2, 0);//3
        mapper.addRoom("Cellmate's Cell", 0, -2, 0);//4
        mapper.addRoom("Hallway Right to the Bathroom", 2, 2, 0); //5
        mapper.addRoom("Bathroom", 4, 2, 0); //6
        mapper.addRoom("End of Hallway on North", 2, 4, 0); //7
        mapper.addRoom("Window on East End", 0, 4, 0);//8
        mapper.addRoom("Start of The Stair", 4, 6, 0);//9
        mapper.addRoom("Downstairs Lower Level- end of the stairs", 4, 6, -2);//10
        mapper.addRoom(" Hallway- Lower level, infront of the stairs ", 2, 6, -2);//11
        mapper.addRoom("Hallway at the Lower Level", 2, 0, -2);//12
        mapper.addRoom("Susipcious Passage Way", 4, 0, -2);//13
        mapper.addRoom("Alarm Room", 0, -2, -2);//14
        mapper.addRoom("ESCAPE ROOM", 4, -2, -2);//15


        System.out.println(mapper.getLocation(0, 0, 0)); // Output: Prison Cell
    }
}
