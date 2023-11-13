

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import repo.DatabaseConnection;
import view.Login;

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
import javax.swing.JProgressBar;

public class StarterScreen extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lbl_percentage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		StarterScreen startScreen = new StarterScreen();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				startScreen.setVisible(true);
			}
		});
		Login login = new Login();
				try {
					for(int i=0; i<=100; i++) {
						Thread.sleep(40);
						startScreen.progressBar.setValue(i);
						startScreen.lbl_percentage.setText(Integer.toString(i)+"%");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				new StarterScreen().setVisible(false);
				login.setVisible(true);
				startScreen.dispose();
			
		
	}

	/**
	 * Create the frame.
	 */
	public StarterScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/res/SignUpPage.jpg")));
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
				
				lbl_percentage = new JLabel("0%");
				lbl_percentage.setForeground(new Color(255, 255, 255));
				lbl_percentage.setFont(new Font("Stencil", Font.PLAIN, 25));
				lbl_percentage.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_percentage.setBounds(617, 642, 129, 47);
				panel.add(lbl_percentage);
				
				progressBar = new JProgressBar();
				progressBar.setForeground(new Color(255, 0, 0));
				progressBar.setBounds(273, 621, 789, 11);
				panel.add(progressBar);
		
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(StarterScreen.class.getResource("/res/SplashScreen.jpg")));
		lbl_main_Picture.setBounds(0, 0, 1307, 754);
		panel.add(lbl_main_Picture);
		
		JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
		lbl_email_1_1_1.setForeground(Color.WHITE);
		lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_email_1_1_1.setBounds(1031, 722, 177, 32);
		panel.add(lbl_email_1_1_1);
		setLocationRelativeTo(null);
		
		
	}
}
