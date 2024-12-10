import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * A room in front of the escape room
 * just pressurizes the 
 */
public class AlarmRoom {

    public AlarmRoom(Securityguard sguard) {
    }

    public void warning(){
        Securityguard sguard = new Securityguard("Swikriti", 21);
        System.out.println("The Alarm has gone off. The Security Guards are after you. Find your escape quick before they catch you.");
        sguard.catchPlayer();
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

}
