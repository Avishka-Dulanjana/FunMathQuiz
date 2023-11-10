package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import repo.DatabaseConnection;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class ScoreBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoard frame = new ScoreBoard();
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
	public ScoreBoard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ScoreBoard.class.getResource("/res/SignUpPage.jpg")));
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
		
		JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
		lbl_email_1_1_1.setForeground(Color.WHITE);
		lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_email_1_1_1.setBounds(10, 712, 177, 32);
		panel.add(lbl_email_1_1_1);
		
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(ScoreBoard.class.getResource("/res/LeaderBoard_image.jpg")));
		lbl_main_Picture.setBounds(0, 0, 896, 754);
		panel.add(lbl_main_Picture);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			/**
			 * Action Performed to Signup Page
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				dispose();
			}
		});
		btn_back.setBackground(new Color(240, 240, 240));
		btn_back.setBorder(null);
		btn_back.setForeground(new Color(0, 0, 0));
		btn_back.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btn_back.setBounds(1111, 696, 131, 32);
		panel.add(btn_back);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,  "Exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION)==0) {
					ScoreBoard.this.dispose();
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
		lbl_exit.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exit.setForeground(new Color(255, 255, 255));
		lbl_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_exit.setBounds(1262, 0, 45, 47);
		panel.add(lbl_exit);
		
		JLabel lblLogin = new JLabel("Leader Board");
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Nirmala UI", Font.BOLD, 50));
		lblLogin.setBounds(928, 127, 314, 63);
		panel.add(lblLogin);
		
		JLabel lblChanger = new JLabel("Welcome Master");
		lblChanger.setHorizontalTextPosition(SwingConstants.LEFT);
		lblChanger.setHorizontalAlignment(SwingConstants.LEFT);
		lblChanger.setForeground(Color.WHITE);
		lblChanger.setFont(new Font("Nirmala UI", Font.PLAIN, 30));
		lblChanger.setBounds(938, 196, 238, 39);
		panel.add(lblChanger);
		
		JLabel lbl_signup = new JLabel("Back to the game?");
		lbl_signup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_signup.setForeground(Color.WHITE);
		lbl_signup.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lbl_signup.setBounds(947, 699, 154, 25);
		panel.add(lbl_signup);
		setLocationRelativeTo(null);
		
		
	}
}