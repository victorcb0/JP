package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ex_laborator extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNume;
	private JTextField textVarsta;
	private JTextField textCautare;
    private ResultSet rs;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex_laborator frame = new Ex_laborator();
					frame.setVisible(true);
					frame.set(); 
					frame.Setare(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//con.close();
		//sql.close();
		//rs.close();
	}
	
	public void set()
	{
		String url = "jdbc:mysql://localhost:3306/test";
		Statement sql;
		Connection con;
		try {
			con = DriverManager.getConnection (url, "root", "root");
			sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = sql.executeQuery("select * from persoane");
			rs.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Setare() {
		try {
			textID.setText(rs.getString("id"));
			textNume.setText( rs.getString("nume"));
			textVarsta.setText(rs.getString("varsta"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Ex_laborator() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnMoveFirst = new JButton("");
		btnMoveFirst.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/MoveFirst.png")));
		toolBar.add(btnMoveFirst);
		btnMoveFirst.setEnabled(false);
		
		JButton btnMovePrevious = new JButton("");
		btnMovePrevious.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/MovePrevious.png")));
		toolBar.add(btnMovePrevious);
		btnMovePrevious.setEnabled(false);
		
		textCautare = new JTextField();
		textCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					do
					{
						if (textCautare.getText().equals(rs.getString("id")))
						{
							Setare();
							break;
						}
					} while(rs.next());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(textCautare);
		textCautare.setColumns(10);
		
		JButton btnMoveNext = new JButton("");
		btnMoveNext.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/MoveNext.png")));
		toolBar.add(btnMoveNext);
		
		JButton btnMoveLast = new JButton("");
		btnMoveLast.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/MoveLast.png")));
		toolBar.add(btnMoveLast);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.moveToInsertRow();
					rs.updateInt("id", Integer.parseInt(textID.getText()));
					rs.updateString("nume", textNume.getText());
					rs.updateInt("varsta", Integer.parseInt(textVarsta.getText()));
					rs.insertRow();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAdd.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/Add.png")));
		toolBar.add(btnAdd);
		
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					do
					{
						if (textCautare.getText().equals(rs.getString("id")))
						{
							Setare();
							break;
						}
					} while(rs.next());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/Edit.png")));
		toolBar.add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					do
					{
						if (textCautare.getText().equals(rs.getString("id")))
						{
							rs.deleteRow();
							break;
						}
					} while(rs.next());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/Delete.png")));
		toolBar.add(btnDelete);
		
		JButton btnFind = new JButton("");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					do
					{
						if (textCautare.getText().equals(rs.getString("id")))
						{
							Setare();
							break;
						}
					} while(rs.next());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFind.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/find.JPG")));
		toolBar.add(btnFind);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/save.JPG")));
		toolBar.add(btnSave);
		
		JButton btnUndo = new JButton("");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUndo.setIcon(new ImageIcon(Ex_laborator.class.getResource("/Imagini/undo.JPG")));
		toolBar.add(btnUndo);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel ldNume = new JLabel("ID");
		panel_1.add(ldNume);
		
		Component verticalStrut = Box.createVerticalStrut(25);
		panel_1.add(verticalStrut);
		
		JLabel lblNume = new JLabel("Nume");
		panel_1.add(lblNume);
		
		Component verticalStrut_1 = Box.createVerticalStrut(25);
		panel_1.add(verticalStrut_1);
		
		JLabel lblVarsta = new JLabel("Varsta");
		panel_1.add(lblVarsta);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		textID = new JTextField();
		panel_2.add(textID);
		textID.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_2);
		
		textNume = new JTextField();
		panel_2.add(textNume);
		textNume.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_3);
		
		textVarsta = new JTextField();
		panel_2.add(textVarsta);
		textVarsta.setColumns(10);
		
		class Action implements ActionListener
		{
			private String str;
			public Action(String str)
			{
				this.str = str;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(str) 
				{
				case "F":
					try {
						if(rs.first())
						{
							Setare();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					break;
				case "P":
					try {
						if(rs.previous())
							Setare();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case "N":
					try {
						if(rs.next())
							Setare();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case "L":
					try {
						if(rs.last())
							Setare();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				}		
				try {
					if (rs.isFirst())
					{
						btnMoveFirst.setEnabled(false);
						btnMovePrevious.setEnabled(false);
					}
					else
					{
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
					}
					if (rs.isLast())
					{
						btnMoveLast.setEnabled(false);
						btnMoveNext.setEnabled(false);
					}
					else
					{
						btnMoveLast.setEnabled(true);
						btnMoveNext.setEnabled(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					textCautare.setText(rs.getRow() + "");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		btnMoveFirst.addActionListener(new Action("F"));
		btnMovePrevious.addActionListener(new Action("P"));
		btnMoveNext.addActionListener(new Action("N"));
		btnMoveLast.addActionListener(new Action("L"));
		JTextField myText = new JTextField("dszd");
		//JOptionPane.showInputDialog();
	}
}
