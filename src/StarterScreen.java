
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.SoundManager;
import gui.GameGui;
import gui.LoginGui;
import repo.DatabaseConnection;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
//import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;


/**
 * The StarterScreen class represents the initial screen that is displayed
 * when the application is launched. It includes a progress bar to indicate
 * the loading progress and transitions to the LoginGui after loading.
 */
public class StarterScreen extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lbl_percentage;
	private Clip backgroundMusic;
	
	public SoundManager soundManager;
	
	private static final String MUSIC_FILE_PATH = "E:\\2023 Learning\\University Bedfordshire Degree\\Lab Session\\Projects\\Fun_Math_Quiz\\Game_Song.wav";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		StarterScreen startScreen = new StarterScreen();
		
		// Use EventQueue.invokeLater to ensure GUI updates occur on the Event Dispatch Thread
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				startScreen.setVisible(true);
			}
		});
		
		// Simulate loading progress
		LoginGui login = new LoginGui();
				try {
					for(int i=0; i<=100; i++) {
						Thread.sleep(40);
						startScreen.progressBar.setValue(i);
						startScreen.lbl_percentage.setText(Integer.toString(i)+"%");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// Hide StarterScreen and show LoginGui
				new StarterScreen().setVisible(false);
				login.setVisible(true);
				startScreen.dispose();
		
	}

	/**
	 * Create the frame.
	 */
	public StarterScreen() {
		// Set the application icon
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGui.class.getResource("/res/SignUpPage.jpg")));
		
		// Set frame properties
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 768);
		
		// Create and set up the content pane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		// Create the main panel
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
				
				// Create and set up the percentage label
				lbl_percentage = new JLabel("0%");
				lbl_percentage.setForeground(new Color(255, 255, 255));
				lbl_percentage.setFont(new Font("Stencil", Font.PLAIN, 25));
				lbl_percentage.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_percentage.setBounds(617, 642, 129, 47);
				panel.add(lbl_percentage);
				
				// Create and set up the progress bar
				progressBar = new JProgressBar();
				progressBar.setForeground(new Color(255, 0, 0));
				progressBar.setBounds(273, 621, 789, 11);
				panel.add(progressBar);
		
		// Create and set up the main picture label
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(StarterScreen.class.getResource("/res/SplashScreen.jpg")));
		lbl_main_Picture.setBounds(0, 0, 1307, 754);
		panel.add(lbl_main_Picture);
		
		// Create and set up the copyright label
		JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
		lbl_email_1_1_1.setForeground(Color.WHITE);
		lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_email_1_1_1.setBounds(1031, 722, 177, 32);
		panel.add(lbl_email_1_1_1);
		
		// Set the location of the frame to the center of the screen
		setLocationRelativeTo(null);
		
		// Load and play background music
        try {
            backgroundMusic = loadBackgroundMusic(MUSIC_FILE_PATH);
            if (backgroundMusic != null) {
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


	/**
     * Load background music from the given file path.
     *
     * @param filePath The file path of the background music.
     * @return A Clip object representing the loaded background music.
     * @throws LineUnavailableException If a Line cannot be opened because it is unavailable.
     * @throws IOException               If an I/O error occurs.
     * @throws UnsupportedAudioFileException If the file does not point to valid audio file data recognized by the system.
     */
    private Clip loadBackgroundMusic(String filePath) throws Exception {
        try {
        	URL soundFile = getClass().getResource(filePath);
        	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            return clip;
        }catch (Exception e) {
            e.printStackTrace(); // Print the stack trace
            throw e; // Rethrow the exception to signal the error
        }
    	
    }
    
    // Add a method to change the background music
    public void changeBackgroundMusic(String filePath) {
        closeBackgroundMusic();
        try {
            backgroundMusic = loadBackgroundMusic(filePath);
            if (backgroundMusic != null) {
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Close the background music clip.
     */
    private void closeBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.close();
        }
    }

    /**
     * Override the dispose method to close the background music when the frame is disposed.
     */
    @Override
    public void dispose() {
        closeBackgroundMusic();
        super.dispose();
    }
}
