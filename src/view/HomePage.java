package view;

import java.awt.Color;
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

import view.GameGUI;
import model.ModelDatabase;
import javax.swing.JTextArea;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/res/main_pic_01.jpg")));
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
					HomePage.this.dispose();
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
		
		JButton btn_login_1 = new JButton("QUIT");
		btn_login_1.setForeground(Color.WHITE);
		btn_login_1.setFont(new Font("Monospaced", Font.BOLD, 26));
		btn_login_1.setBorder(null);
		btn_login_1.setBackground(new Color(198, 61, 47));
		btn_login_1.setBounds(185, 530, 340, 56);
		
		btn_login_1.addActionListener(new ActionListener() {
			/**
			 * Action Performed to Login Page
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		panel.add(btn_login_1);
		
		JButton btn_login_2 = new JButton("SCORE");
		btn_login_2.setForeground(Color.WHITE);
		btn_login_2.setFont(new Font("Monospaced", Font.BOLD, 26));
		btn_login_2.setBorder(null);
		btn_login_2.setBackground(new Color(198, 61, 47));
		btn_login_2.setBounds(185, 447, 340, 56);
		panel.add(btn_login_2);
		
		JTextArea txtrunlockYourInner = new JTextArea();
		txtrunlockYourInner.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrunlockYourInner.setForeground(new Color(255, 255, 255));
		txtrunlockYourInner.setDisabledTextColor(new Color(0, 0, 0));
		txtrunlockYourInner.setEditable(false);
		txtrunlockYourInner.setWrapStyleWord(true);
		txtrunlockYourInner.setSelectionColor(new Color(0, 0, 0));
		txtrunlockYourInner.setLineWrap(true);
		txtrunlockYourInner.setText("\"Unlock Your Inner Math Genius! Welcome to the Math IQ Game, where fun and learning go hand in hand. Sharpen your mathematical skills, challenge your brain, and embark on an exciting journey of numbers and logic. Are you ready to conquer the world of math puzzles and become a true Math IQ champion? Let's dive in and prove that math can be both entertaining and rewarding!\"");
		txtrunlockYourInner.setBounds(185, 210, 494, 141);
		panel.add(txtrunlockYourInner);
		lbl_exit.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exit.setForeground(new Color(255, 255, 255));
		lbl_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_exit.setBounds(1262, 0, 45, 47);
		Color transparentColor = new Color(0, 0, 0, 0);
		txtrunlockYourInner.setBackground(transparentColor);
		txtrunlockYourInner.setOpaque(false);
		panel.add(lbl_exit);
		
		JButton btn_login = new JButton("START");
		btn_login.setForeground(new Color(255, 255, 255));
		
		/**
		 * Button used to move from one JFrame to another JFrame
		 */
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameGUI().setVisible(true);
				dispose();
			}
		});
		
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_login.setBackground(new Color(255, 255, 123));
				btn_login.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_login.setBackground(new Color(198, 61, 47));
				btn_login.setForeground(Color.white);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_login.setBackground(new Color(198, 61, 47));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_login.setBackground(new Color(198, 61, 47));
			}
		});

		btn_login.setBackground(new Color(198, 61, 47));
		btn_login.setFont(new Font("Monospaced", Font.BOLD, 26));
		btn_login.setBorder(null);
		btn_login.setBounds(185, 361, 340, 56);
		panel.add(btn_login);
		
		JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
		lbl_email_1_1_1.setForeground(Color.WHITE);
		lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_email_1_1_1.setBounds(1098, 712, 177, 32);
		panel.add(lbl_email_1_1_1);
		
		JLabel lblLogin = new JLabel("Start Game");
		lblLogin.setHorizontalTextPosition(SwingConstants.LEFT);
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Nirmala UI", Font.BOLD, 55));
		lblLogin.setBounds(185, 126, 373, 74);
		panel.add(lblLogin);
		
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(HomePage.class.getResource("/res/home.jpg")));
		lbl_main_Picture.setBounds(0, 0, 1307, 754);
		panel.add(lbl_main_Picture);
		setLocationRelativeTo(null);
		
		
	}
}
