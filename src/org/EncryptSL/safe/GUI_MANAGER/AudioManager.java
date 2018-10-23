package org.EncryptSL.safe.GUI_MANAGER;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {


    public void loopmusic() {
        AudioInputStream audioIn;
        Clip clip;
        try {
            URL url = getClass().getResource("/resources/keygen.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            //I've tried both of the following:
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
