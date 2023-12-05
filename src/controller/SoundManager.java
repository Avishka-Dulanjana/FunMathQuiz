package controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SoundManager {
    private Clip clip;

    public void playBackgroundMusic(String filePath) {
        try {
            URL soundFile = getClass().getResource(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile.getFile()));

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void stopBackgroundMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
