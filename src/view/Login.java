package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.ModelDatabase;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_email;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
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
		
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(Login.class.getResource("/res/login.jpg")));
		lbl_main_Picture.setBounds(0, 0, 896, 754);
		panel.add(lbl_main_Picture);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lbl_email.setForeground(new Color(255, 255, 255));
		lbl_email.setBounds(938, 251, 158, 25);
		panel.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_email.getText().equals("Enter Your Email Address")) {
					txt_email.setText("");
				}else {
					txt_email.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txt_email.getText().equals("")) {
					txt_email.setText("Enter Your Email Address");
				}
			}
		});
		txt_email.setDisabledTextColor(new Color(255, 255, 255));
		txt_email.setBorder(null);
		txt_email.setCaretColor(new Color(64, 128, 128));
		txt_email.setBackground(new Color(255, 155, 80));
		txt_email.setForeground(new Color(255, 255, 255));
		txt_email.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		txt_email.setText("Enter Your Email Address");
		txt_email.setBounds(938, 286, 340, 39);
		panel.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lbl_password.setBounds(938, 335, 124, 25);
		panel.add(lbl_password);
		
		txt_password = new JPasswordField();
		txt_password.setText("Password");
		txt_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(txt_password.getText().equals("Password")) {
					txt_password.setEchoChar('●');
					txt_password.setText("");
				}else {
					txt_password.selectAll();
				}
			}
			public void focusLost(FocusEvent e) {
				if(txt_password.getText().equals("")) {
					txt_password.setText("Password");
					txt_password.setEchoChar((char)0);
				}
			}
		});
		txt_password.setBorder(null);
		txt_password.setForeground(new Color(255, 255, 255));
		txt_password.setBackground(new Color(255, 155, 80));
		txt_password.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		txt_password.setBounds(938, 370, 340, 39);
		panel.add(txt_password);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("hg");
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setActionCommand("");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(938, 423, 26, 32);
		panel.add(chckbxNewCheckBox);
		
		JLabel lbl_email_1 = new JLabel("Remember me");
		lbl_email_1.setForeground(Color.WHITE);
		lbl_email_1.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		lbl_email_1.setBounds(970, 426, 148, 25);
		panel.add(lbl_email_1);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.setForeground(new Color(255, 255, 255));
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
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Retrieve data from the signup table and matching with the details user entered.
				 */
								try {
									
									Connection con= ModelDatabase.createConnection();
									Statement stm =con.createStatement();
									String sql="select * from signup where sname='"+txt_email.getText()+"'and spassword='"+txt_password.getText()+"';";
									ResultSet rs=stm.executeQuery(sql);
									
									if (rs.next()) {
										dispose();
										new HomePage().setVisible(true);
									}
									else {
										JOptionPane.showMessageDialog(Login.this,"Username or Password Error..!");
										txt_password.setText("");
									}
																
								}catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
			}
		});

		btn_login.setBackground(new Color(198, 61, 47));
		btn_login.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		btn_login.setBorder(null);
		btn_login.setBounds(938, 463, 340, 56);
		panel.add(btn_login);
		
		JLabel lbl_signup = new JLabel("Don't have an account?");
		lbl_signup.setForeground(Color.WHITE);
		lbl_signup.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lbl_signup.setBounds(1014, 549, 190, 25);
		panel.add(lbl_signup);
		
		JButton btn_signup = new JButton("Sign Up");
		btn_signup.addActionListener(new ActionListener() {
			/**
			 * Action Performed to Signup Page
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				new SignUp().setVisible(true);
				dispose();
			}
		});
		btn_signup.setBackground(new Color(240, 240, 240));
		btn_signup.setBorder(null);
		btn_signup.setForeground(new Color(0, 0, 0));
		btn_signup.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btn_signup.setBounds(1037, 584, 148, 32);
		panel.add(btn_signup);
		
		JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
		lbl_email_1_1_1.setForeground(Color.WHITE);
		lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_email_1_1_1.setBounds(1031, 722, 177, 32);
		panel.add(lbl_email_1_1_1);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,  "Exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION)==0) {
					Login.this.dispose();
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
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Nirmala UI", Font.BOLD, 50));
		lblLogin.setBounds(938, 119, 136, 63);
		panel.add(lblLogin);
		
		JLabel lblChanger = new JLabel("be the game changer");
		lblChanger.setHorizontalTextPosition(SwingConstants.LEFT);
		lblChanger.setHorizontalAlignment(SwingConstants.LEFT);
		lblChanger.setForeground(Color.WHITE);
		lblChanger.setFont(new Font("Nirmala UI", Font.PLAIN, 30));
		lblChanger.setBounds(938, 185, 286, 39);
		panel.add(lblChanger);
		setLocationRelativeTo(null);
		
		
	}
}
