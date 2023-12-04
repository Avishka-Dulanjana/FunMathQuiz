package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import repo.DatabaseConnection;

import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import GUI.GameGui;

public class HomeGui extends JFrame {

	private JPanel contentPane;
	public JLabel lbl_username;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGui frame = new HomeGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public HomeGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeGui.class.getResource("/res/SignUpPage.jpg")));
//		contentPane.setVisible(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,  "Exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION)==0) {
					HomeGui.this.dispose();
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
		
		JLabel lblNewLabel_1 = new JLabel("\"Unlock Your Inner Math Genius! Welcome to the Math IQ Game, where fun and learning go hand in hand. Sharpen your mathematical skills, challenge your brain, and embark on an exciting journey of numbers and logic. Are you ready to conquer the world of math puzzles and become a true Math IQ champion? Let's dive in and prove that math can be both entertaining and rewarding!\"");
		lblNewLabel_1.setVerticalAlignment(JLabel.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(245, 421, 325, 131);
		
		JButton btn_quit = new JButton("QUIT");
		btn_quit.setForeground(new Color(255, 255, 255));
		btn_quit.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
		btn_quit.setBorder(null);
		btn_quit.setBackground(new Color(255, 128, 64));
		btn_quit.setBounds(112, 567, 340, 56);
		
		btn_quit.addActionListener(new ActionListener() {
			/**
			 * Action Performed to Login Page
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				new LoginGui().setVisible(true);
				dispose();
			}
		});
		
		JTextArea txtrunlockYourInner = new JTextArea();
		txtrunlockYourInner.setOpaque(false);
		txtrunlockYourInner.setLineWrap(true);
		txtrunlockYourInner.setCaretColor(new Color(0, 0, 0));
		txtrunlockYourInner.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		txtrunlockYourInner.setForeground(new Color(255, 255, 255));
		txtrunlockYourInner.setDisabledTextColor(new Color(0, 0, 0));
		txtrunlockYourInner.setEditable(false);
		txtrunlockYourInner.setWrapStyleWord(true);
		txtrunlockYourInner.setSelectionColor(new Color(0, 0, 0));
		txtrunlockYourInner.setText("\"Unlock Your Inner Math Genius! Welcome to the Math IQ Game, where fun and learning go hand in hand. Sharpen your mathematical skills, challenge your brain, and embark on an exciting journey of numbers and logic. Are you ready to conquer the world of math puzzles and become a true Math IQ champion? Let's dive in and prove that math can be both entertaining and rewarding!\"");
		txtrunlockYourInner.setBounds(118, 247, 492, 141);
		panel.add(txtrunlockYourInner);
		txtrunlockYourInner.setBackground(new Color(0, 0, 0));
		
		JLabel lbl_opaque = new JLabel("");
		lbl_opaque.setBackground(new Color(0, 0, 0));
		lbl_opaque.setOpaque(true);
		lbl_opaque.setBounds(112, 242, 498, 159);
		panel.add(lbl_opaque);
		
		JLabel lbl_ = new JLabel("WELCOME");
		lbl_.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_.setForeground(Color.WHITE);
		lbl_.setFont(new Font("Nirmala UI", Font.BOLD, 55));
		lbl_.setBounds(112, 152, 290, 74);
		panel.add(lbl_);
		
		lbl_username = new JLabel("");
		lbl_username.setForeground(new Color(255, 255, 255));
		lbl_username.setFont(new Font("Nirmala UI", Font.BOLD, 55));
		lbl_username.setBounds(402, 152, 895, 74);
		panel.add(lbl_username);
		panel.add(btn_quit);
		
		JButton btn_scoreboard = new JButton("SCORE");
		
		btn_scoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreBoardGui scoreBoard = new ScoreBoardGui();
				scoreBoard.setVisible(true);
				scoreBoard.lbl_username.setText(lbl_username.getText()); // label name set to scoreboard
				scoreBoard.loadScoreTable(); // Load the score table
				dispose();
			}
		});
		btn_scoreboard.setForeground(Color.WHITE);
		btn_scoreboard.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
		btn_scoreboard.setBorder(null);
		btn_scoreboard.setBackground(new Color(255, 128, 64));
		btn_scoreboard.setBounds(112, 492, 340, 56);
		panel.add(btn_scoreboard);
		lbl_exit.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exit.setForeground(new Color(255, 255, 255));
		lbl_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_exit.setBounds(1262, 0, 45, 47);
		Color transparentColor = new Color(0, 0, 0, 0);
		panel.add(lbl_exit);
		
		JButton btn_start = new JButton("START");
		btn_start.setForeground(new Color(255, 255, 255));
		
		/**
		 * Button used to move from one JFrame to another JFrame
		 */
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameGui gamegui= new GameGui();
				gamegui.setVisible(true);
				gamegui.lbl_username.setText(lbl_username.getText()); // label name set to game GUI form
				dispose();
			}
		});
		
		btn_start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_start.setBackground(new Color(255, 255, 123));
				btn_start.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_start.setBackground(new Color(255, 128, 64));
				btn_start.setForeground(Color.white);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_start.setBackground(new Color(255, 128, 64));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_start.setBackground(new Color(255, 128, 64));
			}
		});
		btn_scoreboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_scoreboard.setBackground(new Color(255, 255, 123));
				btn_scoreboard.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_scoreboard.setBackground(new Color(255, 128, 64));
				btn_scoreboard.setForeground(Color.white);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_scoreboard.setBackground(new Color(255, 128, 64));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_scoreboard.setBackground(new Color(255, 128, 64));
			}
		});
		
		btn_quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_quit.setBackground(new Color(255, 255, 123));
				btn_quit.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_quit.setBackground(new Color(255, 128, 64));
				btn_quit.setForeground(Color.white);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_quit.setBackground(new Color(255, 128, 64));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_quit.setBackground(new Color(255, 128, 64));
			}
		});

		btn_start.setBackground(new Color(255, 128, 64));
		btn_start.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
		btn_start.setBorder(null);
		btn_start.setBounds(112, 422, 340, 56);
		panel.add(btn_start);
		
		JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
		lbl_email_1_1_1.setForeground(Color.WHITE);
		lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_email_1_1_1.setBounds(1098, 712, 177, 32);
		panel.add(lbl_email_1_1_1);
		
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setForeground(new Color(255, 255, 255));
		lbl_main_Picture.setIcon(new ImageIcon(HomeGui.class.getResource("/res/Untitled design.jpg")));
		lbl_main_Picture.setBounds(0, 0, 1307, 754);
		panel.add(lbl_main_Picture);
		setLocationRelativeTo(null);
		
		
	}
}
