package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Component;

public class EndGameGui extends JFrame {

	/**
	 * This a Frame to show that game is over when the player loose the game
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lbl_username;
	public JLabel lbl_score;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndGameGui frame = new EndGameGui();
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
	public EndGameGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EndGameGui.class.getResource("/res/SignUpPage.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 768);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_play_again = new JButton("PLAY AGAIN");
		btn_play_again.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_play_again.setDisplayedMnemonicIndex(0);
		btn_play_again.setBorder(null);
		btn_play_again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeGui home = new HomeGui();
				home.lbl_username.setText(lbl_username.getText());
				home.setVisible(true);
				dispose();
			}
		});
		
		lbl_score = new JLabel("");
		lbl_score.setForeground(new Color(255, 255, 255));
		lbl_score.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_score.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 79));
		lbl_score.setBounds(10, 440, 1301, 76);
		contentPane.add(lbl_score);
		
		lbl_username = new JLabel("");
		lbl_username.setBounds(1109, 692, 184, 45);
		contentPane.add(lbl_username);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(1230, 10, 81, 68);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,  "Exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION)==0) {
					EndGameGui.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.white);
			}
		});
		
		
		btn_play_again.setBackground(new Color(255, 128, 64));
		btn_play_again.setForeground(new Color(255, 255, 255));
		btn_play_again.setFont(new Font("Nirmala UI", Font.BOLD, 28));
		btn_play_again.setBounds(514, 627, 245, 68);
		contentPane.add(btn_play_again);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(EndGameGui.class.getResource("/res/gameover.jpg")));
		lblNewLabel.setBounds(10, 10, 1301, 748);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
