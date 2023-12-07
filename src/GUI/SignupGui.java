package gui;

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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import controller.SignupController;
import model.User;
import repo.DatabaseConnection;
import service.SignupService;


/**
 * SignupGui class represents the user sign-up interface.
 * Users can enter their information to create an account.
 */
public class SignupGui extends JFrame {
	
	private JPanel contentPane;
	private JTextField txt_full_name;
	private JPasswordField txt_password;
	private JTextField txt_game_name;
	private JTextField txt_email;
	
	// Email validation function using a simple regex
	private boolean isValidEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    return email.matches(emailRegex);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupGui frame = new SignupGui();
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
	public SignupGui() {
		
			setIconImage(Toolkit.getDefaultToolkit().getImage(SignupGui.class.getResource("/res/SignUp_Page.jpg")));
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
			
			// Close button
			JLabel lbl_exit = new JLabel("X");
			lbl_exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null,  "Exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION)==0) {
						SignupGui.this.dispose();
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
			
			// Main picture
			JLabel lbl_main_Picture = new JLabel("");
			lbl_main_Picture.setIcon(new ImageIcon(SignupGui.class.getResource("/res/SignUpPage.jpg")));
			lbl_main_Picture.setBounds(411, 0, 896, 754);
			panel.add(lbl_main_Picture);
			
			// Sign Up label
			JLabel lblNewLabel = new JLabel("Sign Up");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 45));
			lblNewLabel.setBounds(21, 51, 191, 63);
			panel.add(lblNewLabel);
			
			// Full Name label
			JLabel lbl_name = new JLabel("Full Name");
			lbl_name.setFont(new Font("Nirmala UI", Font.BOLD, 20));
			lbl_name.setForeground(new Color(255, 255, 255));
			lbl_name.setBounds(32, 167, 158, 25);
			panel.add(lbl_name);
			
			// Full Name text field
			txt_full_name = new JTextField();
			txt_full_name.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_full_name.getText().equals("Enter Your Name")) {
						txt_full_name.setText("");
					}else {
						txt_full_name.selectAll();
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txt_full_name.getText().equals("")) {
						txt_full_name.setText("Enter Your Name");
					}
				}
			});
			txt_full_name.setDisabledTextColor(new Color(255, 255, 255));
			txt_full_name.setBorder(null);
			txt_full_name.setCaretColor(new Color(64, 128, 128));
			txt_full_name.setBackground(new Color(255, 155, 80));
			txt_full_name.setForeground(new Color(255, 255, 255));
			txt_full_name.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			txt_full_name.setText("Enter Your Name");
			txt_full_name.setBounds(32, 202, 340, 39);
			panel.add(txt_full_name);
			txt_full_name.setColumns(10);
			
			// Password label
			JLabel lbl_password = new JLabel("Password");
			lbl_password.setForeground(Color.WHITE);
			lbl_password.setFont(new Font("Nirmala UI", Font.BOLD, 20));
			lbl_password.setBounds(32, 419, 124, 25);
			panel.add(lbl_password);
			
			// Password text field
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
			txt_password.setBounds(32, 454, 340, 39);
			panel.add(txt_password);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("hg");
			chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
			chckbxNewCheckBox.setActionCommand("");
			chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
			chckbxNewCheckBox.setBounds(32, 499, 26, 32);
			panel.add(chckbxNewCheckBox);
			
			JLabel lbl_email_1 = new JLabel("Remember me");
			lbl_email_1.setForeground(Color.WHITE);
			lbl_email_1.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
			lbl_email_1.setBounds(64, 502, 148, 25);
			panel.add(lbl_email_1);
			
			JButton btn_signup = new JButton("Sign Up");
			
			/**
			 * ActionListener for the sign-up button in the GUI. Handles user registration
			 * by validating input fields and sending registration data to a Spring Boot API.
			 */
			btn_signup.addActionListener(new ActionListener() {
				
				/**
			     * Invoked when the sign-up button is clicked.
			     *
			     * @param e The ActionEvent representing the button click.
			     */
				public void actionPerformed(ActionEvent e) {
					String fullName = txt_full_name.getText().trim();
			        String gameName = txt_game_name.getText().trim();
			        String email = txt_email.getText().trim();
			        String password = new String(txt_password.getPassword());
			        
			     // Validate user input
					if(fullName.isEmpty() ||fullName.equals("Enter Your Name"))
					{
						JOptionPane.showMessageDialog(null," User name cannot be blank");
					}
					else if(gameName.isEmpty() || gameName.equals("Enter Your Game Nickname"))
					{
						JOptionPane.showMessageDialog(null, "Gamer Id cannot be blank");
					}
					else if(email.isEmpty() || email.equals("Enter Your Email Address"))
					{
						JOptionPane.showMessageDialog(null, "Email cannot be blank");
					}
					else if (!isValidEmail(email)) {
			            JOptionPane.showMessageDialog(null, "Invalid email address");
			        } 
		 			
					else if(password.isEmpty() || password.equals("Password"))
					{
						JOptionPane.showMessageDialog(null, "Password cannot be blank");
					}else{
						
						// Attempt to connect to the Spring Boot API for user registration
	                    try {
	                        URL url = new URL("http://localhost:8890/api/v1/user/save");
	                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	                        // Set up the HTTP request for user registration
	                        connection.setRequestMethod("POST");
	                        connection.setRequestProperty("Content-Type", "application/json");
	                        connection.setDoOutput(true);

	                        // Create a JSON string representing the user data
	                        String userData = "{\"userName\":\"" + txt_full_name.getText() + "\","
	                                + "\"userGameName\":\"" + txt_game_name.getText() + "\","
	                                + "\"email\":\"" + txt_email.getText() + "\","
	                                + "\"userPassword\":\"" + new String(txt_password.getPassword()) + "\"}";

	                        // Write the JSON data to the request
	                        try (OutputStream os = connection.getOutputStream()) {
	                            byte[] input = userData.getBytes("utf-8");
	                            os.write(input, 0, input.length);
	                        }

	                        // Get the HTTP response code
	                        int responseCode = connection.getResponseCode();

	                        // Check if the request was successful (HTTP 201 Created)
	                        if (responseCode == HttpURLConnection.HTTP_CREATED) {
	                            JOptionPane.showMessageDialog(null, "Sign up Successful! Go back to Login.");
	                            
	                            // Clear the input fields after successful registration
	                            txt_full_name.setText("");
	                            txt_game_name.setText("");
	                            txt_email.setText("");
	                            txt_password.setText("");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Sign Up unsuccessful. Please try again.");
	                        }
	                        
	                        // Disconnect the connection
	                        connection.disconnect();
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
			    }
	
	        });
				
			        
	/////////////////////////////////////////////// NORMAL METHOD ///////////////////////////////////////////////////////////////////////////////////////////////////		        
			        
					// TODO Auto-generated method stub

//					if(fullName.isEmpty() ||fullName.equals("Enter Your Name"))
//					{
//						JOptionPane.showMessageDialog(null," User name cannot be blank");
//					}
//					else if(gameName.isEmpty() || gameName.equals("Enter Your Game Nickname"))
//					{
//						JOptionPane.showMessageDialog(null, "Nick Name cannot be blank");
//					}
//					else if(email.isEmpty() || email.equals("Enter Your Email Address"))
//					{
//						JOptionPane.showMessageDialog(null, "Email cannot be blank");
//					}
//					else if (!isValidEmail(email)) {
//			            JOptionPane.showMessageDialog(null, "Invalid email address");
//			        } 
//		 			
//					else if(password.isEmpty() || password.equals("Password"))
//					{
//						JOptionPane.showMessageDialog(null, "Password cannot be blank");
//					}
//					else {					
////						try {
////						    boolean signUpSuccessful = SignupController.signUpUser(
////						            txt_full_name.getText(),
////						            txt_game_name.getText(),
////						            txt_email.getText(),
////						            txt_password.getText()
////						    );
////
////						    if (signUpSuccessful) {
////						        JOptionPane.showMessageDialog(null, "Sign up Successful! Go back to Login.");
////						        txt_full_name.setText("");
////						        txt_game_name.setText("");
////						        txt_email.setText("");
////						        txt_password.setText("");
////						    } else {
////						        JOptionPane.showMessageDialog(null, "Sign Up unsuccessful. Please try again.");
////						    }
////						} catch (Exception ex) {
////						    ex.printStackTrace();
////						}					
//						
//					}
//					
//				}
//			});
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
			
			// Create a JButton for signing up with associated styling and event handling
			btn_signup.setForeground(new Color(255, 255, 255));
			btn_signup.addMouseListener(new MouseAdapter() {
				// Set button background and foreground colors on mouse hover, press, and release
				@Override
				public void mouseEntered(MouseEvent e) {
					btn_signup.setBackground(new Color(255, 255, 123));
					btn_signup.setForeground(Color.black);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btn_signup.setBackground(new Color(198, 61, 47));
					btn_signup.setForeground(Color.white);
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					btn_signup.setBackground(new Color(198, 61, 47));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btn_signup.setBackground(new Color(198, 61, 47));
				}
			});


			btn_signup.setBackground(new Color(198, 61, 47));
			btn_signup.setFont(new Font("Nirmala UI", Font.BOLD, 22));
			btn_signup.setBorder(null);
			btn_signup.setBounds(32, 537, 340, 56);
			panel.add(btn_signup);
			
			// Create a JLabel asking if the user has an account
			JLabel lbl_signup = new JLabel("Do have an account?");
			lbl_signup.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_signup.setForeground(Color.WHITE);
			lbl_signup.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
			lbl_signup.setBounds(112, 616, 190, 25);
			panel.add(lbl_signup);
			
			// Create a JButton for navigating to the login page
			JButton btn_login = new JButton("Login");
			btn_login.addActionListener(new ActionListener() {
				/**
				 * Action Performed to Login Page
				 * 
				 */
				public void actionPerformed(ActionEvent e) {
					new LoginGui().setVisible(true);
					dispose();
				}
			});
			btn_login.setBackground(new Color(240, 240, 240));
			btn_login.setBorder(null);
			btn_login.setForeground(new Color(0, 0, 0));
			btn_login.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			btn_login.setBounds(131, 658, 148, 32);
			panel.add(btn_login);
			
			// Create a JLabel for copyright information
			JLabel lbl_email_1_1_1 = new JLabel("Copyright@Robotz game");
			lbl_email_1_1_1.setForeground(Color.WHITE);
			lbl_email_1_1_1.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
			lbl_email_1_1_1.setBounds(125, 722, 177, 32);
			panel.add(lbl_email_1_1_1);
			
			// Create JLabels with motivational messages
			JLabel lblToUnleash = new JLabel("to unleash");
			lblToUnleash.setHorizontalTextPosition(SwingConstants.LEFT);
			lblToUnleash.setHorizontalAlignment(SwingConstants.LEFT);
			lblToUnleash.setForeground(Color.WHITE);
			lblToUnleash.setFont(new Font("Nirmala UI", Font.PLAIN, 30));
			lblToUnleash.setBounds(210, 57, 191, 63);
			panel.add(lblToUnleash);
			
			JLabel lblTheGamerWithin = new JLabel("the gamer within you!");
			lblTheGamerWithin.setHorizontalTextPosition(SwingConstants.LEFT);
			lblTheGamerWithin.setHorizontalAlignment(SwingConstants.LEFT);
			lblTheGamerWithin.setForeground(Color.WHITE);
			lblTheGamerWithin.setFont(new Font("Nirmala UI", Font.PLAIN, 30));
			lblTheGamerWithin.setBounds(31, 106, 330, 39);
			panel.add(lblTheGamerWithin);
			
			// Create JLabels and JTextFields for user information input
			JLabel lbl_gamer_id = new JLabel("Gamer Id");
			lbl_gamer_id.setForeground(Color.WHITE);
			lbl_gamer_id.setFont(new Font("Nirmala UI", Font.BOLD, 20));
			lbl_gamer_id.setBounds(32, 251, 158, 25);
			panel.add(lbl_gamer_id);
			
			// Create a JTextField for entering the game nickname
			txt_game_name = new JTextField();
			txt_game_name.setText("Enter Your Game Nickname");
			txt_game_name.setForeground(Color.WHITE);
			txt_game_name.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			txt_game_name.setDisabledTextColor(Color.WHITE);
			txt_game_name.setColumns(10);
			txt_game_name.setCaretColor(new Color(64, 128, 128));
			txt_game_name.setBorder(null);
			txt_game_name.setBackground(new Color(255, 155, 80));
			txt_game_name.setBounds(32, 286, 340, 39);
			panel.add(txt_game_name);
			// Add focus listeners to handle text field behavior on focus
			txt_game_name.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txt_game_name.getText().equals("Enter Your Game Nickname")) {
						txt_game_name.setText("");
					}else {
						txt_game_name.selectAll();
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txt_game_name.getText().equals("")) {
						txt_game_name.setText("Enter Your Game Nickname");
					}
				}
			});
			// Create JLabel for email information
			JLabel lbl_email = new JLabel("Email");
			lbl_email.setForeground(Color.WHITE);
			lbl_email.setFont(new Font("Nirmala UI", Font.BOLD, 20));
			lbl_email.setBounds(32, 335, 158, 25);
			panel.add(lbl_email);
			
			// Create a JTextField for entering the email address
			txt_email = new JTextField();
			txt_email.setText("Enter Your Email Address");
			txt_email.setForeground(Color.WHITE);
			txt_email.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			txt_email.setDisabledTextColor(Color.WHITE);
			txt_email.setColumns(10);
			txt_email.setCaretColor(new Color(64, 128, 128));
			txt_email.setBorder(null);
			txt_email.setBackground(new Color(255, 155, 80));
			txt_email.setBounds(32, 370, 340, 39);
			
			// Add focus listeners to handle text field behavior on focus
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
			
			panel.add(txt_email);
			setLocationRelativeTo(null); // Set the location of the frame to the center of the screen
			
		}
}
