package gui;

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

/**
 * The ScoreBoardGui class represents the graphical user interface for the Leader Board.
 * It displays the top scores of players in a table format.
 * Users can navigate back to the game from this interface.
 */
public class ScoreBoardGui extends JFrame {
	
	// Label to display the username
	public JLabel lbl_username;
	
	// Panel to hold GUI components
	private JPanel contentPane;
	
	// Table to display the scores
	private JTable table;
	
	// Flag to track if the score button is clicked
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
     * Creates the Leader Board GUI frame.
     */
	public ScoreBoardGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ScoreBoardGui.class.getResource("/res/SignUpPage.jpg")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		setLocationRelativeTo(null);
		
		// Create the main panel
		JPanel panel = new JPanel();
		panel.setIgnoreRepaint(true);
		panel.setBorder(null);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Label to display the username
		lbl_username = new JLabel("");
		lbl_username.setVisible(false);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lbl_username.setForeground(new Color(255, 255, 255));
		lbl_username.setBounds(946, 45, 180, 47);
		panel.add(lbl_username);
		
		// Copyright label
		JLabel lbl_copy_right = new JLabel("Copyright@Robotz game");
		lbl_copy_right.setForeground(Color.WHITE);
		lbl_copy_right.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
		lbl_copy_right.setBounds(10, 712, 177, 32);
		panel.add(lbl_copy_right);
		
		// Button to navigate back to the game
		JButton btn_back = new JButton("Click");
		btn_back.addActionListener(new ActionListener() {
			// Open the HomeGui and pass the username
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
		btn_back.setBounds(579, 604, 131, 32);
		panel.add(btn_back);
		
		// Exit label
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Show confirmation dialog before exiting
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
		
		JLabel lbl_signup = new JLabel("Back to the game?");
		lbl_signup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_signup.setForeground(Color.WHITE);
		lbl_signup.setFont(new Font("Nirmala UI", Font.BOLD, 22));
		lbl_signup.setBounds(535, 558, 210, 37);
		panel.add(lbl_signup);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setFont(new Font("Nirmala UI", Font.BOLD, 30));
		scrollPane.setBounds(454, 238, 366, 294);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSize(new Dimension(1, 1));
		
		table.setBackground(new Color(0, 0, 102));
		table.setForeground(Color.WHITE);
		table.setGridColor(new Color(0, 0, 0));
		table.setSelectionForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setOpaque(false);
		table.setSelectionBackground(new Color(255, 0, 0));
		table.setRowMargin(0);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setRowHeight(30);
		table.setFont(new Font("Nirmala UI", Font.BOLD, 17));
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
        
        /**
         * Sets the data model for a JTable with default rendering and editing behavior.
         * The table is initialized with an empty data array and column headers.
         *
         * @param table The JTable for which the data model is being set.
         * @param columnHeaders An array of column header names for the table.
         * @see javax.swing.JTable
         * @see javax.swing.table.DefaultTableModel
         */
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Player", "Score"}
			) {
			
			/**
		     * Returns whether a cell at the specified position is editable.
		     *
		     * @param row The row index of the cell.
		     * @param column The column index of the cell.
		     * @return {@code false} to make all cells non-editable.
		     */
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false; // Make all cells non-editable
	            }
		
		});	
		
		// Main picture label
		JLabel lbl_main_Picture = new JLabel("");
		lbl_main_Picture.setIcon(new ImageIcon(ScoreBoardGui.class.getResource("/res/GAME OVER (5).jpg")));
		lbl_main_Picture.setBounds(0, 0, 1307, 754);
		panel.add(lbl_main_Picture);
	}
	
	/**
	 * Loads and displays the score table in a JTable component. The scores are retrieved
	 * from the database, and only one instance of loading is allowed by tracking whether
	 * the score button has been clicked.
	 *
	 * <p>
	 * This method fetches the player names and scores from the database, ranks them based on
	 * the highest score for each game, and displays the result in the JTable.
	 * </p>
	 *
	 * @throws Exception If an error occurs while querying the database or updating the table.
	 * @see java.sql.Connection
	 * @see java.sql.Statement
	 * @see java.sql.ResultSet
	 * @see javax.swing.JTable
	 * @see javax.swing.table.DefaultTableModel
	 */
	public void loadScoreTable() {
	    if (!isScoreButtonClicked) {
	        try {
	        	// Establish a database connection
	            Connection con = DatabaseConnection.createConnection();
	            Statement stm = con.createStatement();
	            // SQL query to rank scores and select the top scores for each game
	            String sql = "WITH RankedScores AS ( SELECT  game_id, score, ROW_NUMBER() OVER (PARTITION BY game_id ORDER BY score DESC) AS rn FROM score_table ) SELECT game_id, score FROM RankedScores WHERE rn = 1 ORDER BY score DESC;";
	            ResultSet rs = stm.executeQuery(sql);
	            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	            DefaultTableModel model = (DefaultTableModel) table.getModel();

	            // Set column headers based on the database metadata
	            int cols = rsmd.getColumnCount();
	            String[] colName = new String[cols];
	            for (int i = 0; i < cols; i++)
	                colName[i] = rsmd.getColumnName(i + 1);
	            model.setColumnIdentifiers(colName);
	            
	            // Populate the table with player names and scores
	            String player_name, score;
	            while (rs.next()) {
	                player_name = rs.getString(1);
	                score = rs.getString(2);
	                String[] row = { player_name, score };
	                model.addRow(row);
	            }
	            isScoreButtonClicked = true; // score button only click one time
	        } catch (Exception e1) {
	            System.out.println(e1.getMessage());
	        }
	    }
	}

	/**
	 * Table name set to Upper Case
	 * @author Avishka Dulanjana
	 *
	 */
	
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