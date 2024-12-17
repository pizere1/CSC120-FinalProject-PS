
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * A room in front of the escape room, it seems safer than the 'toxins room' 
 simply to just pressurizes the prisoner to run to but it actually has an alarm.
 */
public class AlarmRoom extends Room {
    /**
    *Constructor for the alarm room
    */

    public AlarmRoom(String roomName, int x, int y, int z, int roomnumber) {
        super(roomName, x, y, z, roomnumber);
    }
/**
*The method to alert the player about a security guard approaching them
*/

    public void warning(){
        Securityguard sguard = new Securityguard("Swikriti", 21);
        System.out.println("The Alarm has gone off. The Security Guards are after you. Find your escape quick before they catch you.");
        sguard.catchPlayer();
    }
/*
*The function to play the alarm sounds
*/
;



public void playSound() {
    try {
        // Use getResource to load the file from the classpath
        URL soundFile = getClass().getClassLoader().getResource("alarm-sound.wav");

        if (soundFile == null) {
            System.out.println("Sound file not found!");
            return;
        }

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch (Exception ex) {
        System.out.println("Error playing sound: " + ex.getMessage());
    }
}

    // public void playSound() {
        // try {
            // AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/sdumre/Downloads/mixkit-facility-alarm-sound-999.wav").getAbsoluteFile());
            // Clip clip = AudioSystem.getClip();
            // clip.open(audioInputStream);
            // clip.start();
        // } catch(Exception ex) {
            // System.out.println("Error with playing sound.");
            // ex.printStackTrace();
        // }
    // }

}
