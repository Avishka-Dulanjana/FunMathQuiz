package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import repo.DatabaseConnection;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class ScoreBoardGui extends JFrame {
	
	public JLabel lbl_username;
	private JPanel contentPane;
	private JTable table;
	private boolean isScoreButtonClicked = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoardGui frame = new ScoreBoardGui();
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
	public ScoreBoardGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ScoreBoardGui.class.getResource("/res/SignUpPage.jpg")));
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
		panel.setIgnoreRepaint(true);
		panel.setBorder(null);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl_username = new JLabel("");
		lbl_username.setVisible(false);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lbl_username.setForeground(new Color(255, 255, 255));
		lbl_username.setBounds(946, 45, 180, 47);
		panel.add(lbl_username);
		
		JLabel lbl_copy_right = new JLabel("Copyright@Robotz game");
		lbl_copy_right.setForeground(Color.WHITE);
		lbl_copy_right.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_copy_right.setBounds(10, 712, 177, 32);
		panel.add(lbl_copy_right);
		
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(ScoreBoardGui.class.getResource("/res/LeaderBoard_image.jpg")));
		lbl_main_Picture.setBounds(0, 0, 896, 754);
		panel.add(lbl_main_Picture);
		
		JButton btn_back = new JButton("Click");
		btn_back.addActionListener(new ActionListener() {
			/**
			 * Action Performed to Signup Page
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				HomeGui home = new HomeGui();
				home.setVisible(true);
				home.lbl_username.setText(lbl_username.getText());
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
					ScoreBoardGui.this.dispose();
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
		lblLogin.setBounds(936, 108, 314, 63);
		panel.add(lblLogin);
		
		JLabel lblChanger = new JLabel("Welcome Master");
		lblChanger.setHorizontalTextPosition(SwingConstants.LEFT);
		lblChanger.setHorizontalAlignment(SwingConstants.LEFT);
		lblChanger.setForeground(Color.WHITE);
		lblChanger.setFont(new Font("Nirmala UI", Font.PLAIN, 30));
		lblChanger.setBounds(936, 167, 238, 39);
		panel.add(lblChanger);
		
		JLabel lbl_signup = new JLabel("Back to the game?");
		lbl_signup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_signup.setForeground(Color.WHITE);
		lbl_signup.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lbl_signup.setBounds(947, 699, 154, 25);
		panel.add(lbl_signup);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Nirmala UI", Font.BOLD, 30));
		scrollPane.setBounds(938, 232, 332, 309);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSize(new Dimension(1, 1));
		//table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setGridColor(new Color(0, 0, 0));
		table.setSelectionForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setOpaque(false);
		table.setSelectionBackground(new Color(255, 0, 0));
		table.setRowMargin(0);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setRowHeight(30);
		table.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		//table.setGridColor(new Color(0, 0, 0));
		table.setShowGrid(true);
		table.setGridColor(new Color(0, 0, 0));
		
		// Center-align cell content
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
		
        // Score table header
		JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Nirmala UI", Font.BOLD, 20));
        header.setBackground(new Color(200, 200, 200));
        header.setDefaultRenderer(new UppercaseHeaderRenderer()); // Score table header uppercase
        
        
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {}
			) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // Make all cells non-editable
	            }
		
		});
		
		JButton btn_score = new JButton("Score");
		btn_score.setBackground(new Color(255, 128, 64));
		btn_score.setForeground(new Color(255, 255, 255));
		btn_score.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btn_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_score.setBackground(new Color(255, 255, 123));
				btn_score.setForeground(Color.black);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_score.setBackground(new Color(255, 128, 64));
				btn_score.setForeground(Color.white);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_score.setBackground(new Color(255, 128, 64));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_score.setBackground(new Color(255, 128, 64));
			}
		});
		
		btn_score.addActionListener(new ActionListener() {
			/*
			 * Score data retrive
			 * */
			
			public void actionPerformed(ActionEvent e) {
				if(!isScoreButtonClicked) {
					try {
						Connection con= DatabaseConnection.createConnection();
						Statement stm =con.createStatement();
						String sql = "WITH RankedScores AS ( SELECT game_id, score, ROW_NUMBER() OVER (PARTITION BY game_id ORDER BY score DESC) AS rn FROM score_table ) SELECT game_id, score FROM RankedScores WHERE rn = 1 ORDER BY score DESC LIMIT 15";
						ResultSet rs = stm.executeQuery(sql);
						ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						int cols = rsmd.getColumnCount();
						String[] colName = new String[cols];
						for(int i=0; i<cols; i++) 
							colName[i] = rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String player_name, marks;
						while(rs.next()){
							player_name = rs.getString(1);
							marks = rs.getString(2);
							String[] row = {player_name,marks};
							model.addRow(row);
						}
						isScoreButtonClicked = true; // score button only click one time
					}catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				
			}
		});
		btn_score.setBounds(938, 561, 188, 56);
		panel.add(btn_score);
		setLocationRelativeTo(null);	
	}

	// TABEL NAMES SET UPPER CASE
	
	
	private static class UppercaseHeaderRenderer implements TableCellRenderer {
        private final JLabel label;

        public UppercaseHeaderRenderer() {
            label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Nirmala UI", Font.BOLD, 20));
            label.setBackground(new Color(200, 200, 200));
            label.setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            label.setText(value.toString().toUpperCase());
            return label;
        }
    }
}