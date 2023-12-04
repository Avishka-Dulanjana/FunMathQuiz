package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import model.User;
import repo.DatabaseConnection;
import service.ScoreService;
import service.SignupService;

//import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;

import game.GameEngine;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Component;

/**
 * A graphical user interface for the Six Equation Game.
 * Allows users to play the game and tracks their score and progress.
 * Implements ActionListener to handle button clicks.
 * 
 * @author Marc Conrad
 */
public class GameGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;
	public JLabel lbl_username;
	
	// Add variables for incorrect answer tracking and score
    private int incorrectAttempts = 0;
    private int maxIncorrectAttempts = 3;
    private int score = 0;

	/**
	 * Method that is called when a button has been pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(currentGame, solution);
		int score = myGame.getScore(); 
		
		/**
		 * taking the value from getLevel method to upgrade the level
		 */
		int level=myGame.getLevel();
		if (correct) {
			System.out.println("CORRECT ANSWER..!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("AWESOME SOLDIER! LET'S GO!!!  Score: "+score);
			/**
			 * Upgraded level value set to the JLabel 
			 */
			lbl_level.setText("Level:"+level);
			/**
			 * Timer set for new Level Begins
			 */
			timer.stop();
			second =30;
			minute =0;
			lbl_timer.setText("00:30");
			countdownTimer();
			timer.start();	
			
		}
		else {
			 incorrectAttempts++;
			
			 if (incorrectAttempts >= maxIncorrectAttempts) {
	                // Game over due to too many incorrect attempts
	                EndGameGui endgame = new EndGameGui();
	                endgame.setVisible(true);
	                endgame.lbl_username.setText(lbl_username.getText());
	                endgame.lbl_score.setText("YOUR SCORE: " + score);
	                timer.stop();
	                dispose();

	                // Save the score
	                String playerUsername = lbl_username.getText();
	                int playerScore = score;
	                ScoreService.saveScore(playerUsername, playerScore);
	                
	            } else {
	            	 int remainingAttempts = maxIncorrectAttempts - incorrectAttempts;
	                // Incorrect answer, but still have attempts left
	                infoArea.setText("ANSWER INCORRECT!! ONLY " + remainingAttempts + " ATTEMPTS LEFT!!");
	             
	            }
		}
	}

	JLabel questArea = null;
	GameEngine myGame = null;
	URL currentGame = null;
	JTextArea infoArea = null;
	
	/**
	 * set variables for the components(level and time)
	 */
	JLabel lbl_level = new JLabel("Level");
	//Set timer to game
	JLabel lbl_timer;
	Font font1 = new Font("Arial", Font.PLAIN, 30);	
	Timer timer;	
	int second=0, minute=1;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
	
	
	/**
	 * Initializes the game. 
	 * @param player
	 */
	private void initGame(String player) {
		
		setBounds(100, 100, 1321, 768);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(337, 152, 700, 549);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				lbl_timer = new JLabel("");
				lbl_timer.setForeground(new Color(255, 0, 0));
				lbl_timer.setHorizontalAlignment(JLabel.CENTER);
				lbl_timer.setFont(font1);
				panel.add(lbl_timer);
				
				lbl_timer.setText("00:30");
		
				infoArea = new JTextArea(1, 40);
				infoArea.setAlignmentY(Component.CENTER_ALIGNMENT);
				infoArea.setForeground(new Color(138, 43, 226));
				infoArea.setFont(new Font("Monospaced", Font.BOLD, 26));
				panel.add(infoArea);
				
				infoArea.setEditable(false);
				infoArea.setText("WHAT IS THE CORRECT ANSWER?  SCORE: 0");
		
		JScrollPane infoPane = new JScrollPane();
		panel.add(infoPane);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
	    
	  		JScrollPane questPane = new JScrollPane(questArea);
	  		panel.add(questPane);
	  		lbl_level.setHorizontalAlignment(SwingConstants.CENTER);
	  		lbl_level.setForeground(new Color(255, 0, 0));
	  		questPane.setColumnHeaderView(lbl_level);
	  		lbl_level.setFont(new Font("Nirmala UI", Font.BOLD, 25));
	  		lbl_level.setText("Level: 1");
	    
		

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}
		
		JLabel lbl_image = new JLabel("");
		lbl_image.setIcon(new ImageIcon(GameGui.class.getResource("/res/Untitled design (1).png")));
		lbl_image.setBounds(29, 674, 75, 75);
		getContentPane().add(lbl_image);
		
		lbl_username = new JLabel("");
		lbl_username.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_username.setForeground(new Color(255, 255, 255));
		lbl_username.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lbl_username.setBounds(1073, 712, 215, 34);
		getContentPane().add(lbl_username);
		
		JLabel lblFail = new JLabel("TIME TO PLAY - HURRY UP");
		lblFail.setForeground(new Color(255, 255, 255));
		lblFail.setFont(new Font("Arial Black", Font.BOLD, 55));
		lblFail.setBounds(265, 55, 866, 87);
		getContentPane().add(lblFail);

		getContentPane().add(panel);
		panel.repaint();
		panel.setVisible(true);
		
		/**
		 * Button click events and action listener used 
		 */
		JButton btnQuite = new JButton("QUIT");
		btnQuite.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnQuite.addActionListener(new ActionListener() {
			
			
			// Application closed
			public void actionPerformed(ActionEvent e) {
				EndGameGui endgame =new EndGameGui();
				endgame.setVisible(true);
				endgame.lbl_username.setText(lbl_username.getText());
				timer.stop();
				dispose();
			} 
		});
				
		btnQuite.setBackground(new Color(255, 0, 0));
		btnQuite.setForeground(new Color(255, 255, 255));
		btnQuite.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		panel.add(btnQuite);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.setForeground(new Color(255, 255, 255));
		lbl_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exit.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lbl_exit.setBounds(1272, 10, 39, 34);
		getContentPane().add(lbl_exit);
		
		JLabel lbl_game_back = new JLabel("");
		lbl_game_back.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_game_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_game_back.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		lbl_game_back.setIcon(new ImageIcon(GameGui.class.getResource("/res/GameGUI.jpg")));
		lbl_game_back.setBounds(0, 0, 1321, 768);
		getContentPane().add(lbl_game_back);
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,  "Exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION)==0) {
					timer.stop();
					GameGui.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_exit.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_exit.setForeground(Color.white);
			}
		});
		
			/**
		 	* when the time is zero the player will be redirect to the EndGame JFrame
		 	*/
			countdownTimer();
			timer.start();		

		}
		public void countdownTimer() {
	
		// References
		// https://www.youtube.com/watch?v=zWw72j-EbqI ===== game timer
		//https://www.ryisnow.online/2021/04/java-beginner-code-sample-create-timer.html
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				lbl_timer.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 30;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					lbl_timer.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
					EndGameGui endgame =new EndGameGui();
					endgame.setVisible(true);
					endgame.lbl_username.setText(lbl_username.getText());
					dispose();
				}
				
			}
		});		
	}
	/**
	 * Default player is null. 
	 */
	public GameGui() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameGui.class.getResource("/res/SignUpPage.jpg")));
		getContentPane().setPreferredSize(new Dimension(10, 10));
		getContentPane().setMaximumSize(new Dimension(32767, 32767));
		initGame(null);
		setLocationRelativeTo(null);
	}

	/**
	 * Use this to start GUI, after login.
	 * 
	 * @param player
	 */
	public GameGui(String player) {
		super();
		initGame(player);
		setLocationRelativeTo(null);
	}

	/**
	 * Main entry point into the equation game.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
	        GameGui myGUI = new GameGui();
	        myGUI.setVisible(true);
	    });

	}
}