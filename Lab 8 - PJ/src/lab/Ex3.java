package lab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Ex3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFilm;
	private JTextField textActori;
	private JSpinner spinnerAn;
	private JCheckBox chckbxComedie;
	private JCheckBox chckbxIstoric;
	private JCheckBox chckbxRomantic;
	private JCheckBox chckbxActiune;
	private JTable table;
	private JCheckBox chckbxDrama;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex3 frame = new Ex3();
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
	public Ex3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(78, 31, 61, 17);
		lblFilm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblFilm);
		
		JLabel lblActori = new JLabel("Actori");
		lblActori.setBounds(78, 59, 61, 17);
		lblActori.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblActori);
		
		textFilm = new JTextField();
		textFilm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFilm.setBounds(147, 32, 183, 19);
		contentPane.add(textFilm);
		textFilm.setColumns(10);
		
		textActori = new JTextField();
		textActori.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textActori.setBounds(147, 60, 183, 19);
		textActori.setColumns(10);
		contentPane.add(textActori);
		
		JLabel lblAnLansare = new JLabel("An lansare");
		lblAnLansare.setBounds(78, 111, 74, 17);
		lblAnLansare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblAnLansare);
		
		SpinnerModel model = new SpinnerNumberModel(2015, 2015, 2020, 1);  
		spinnerAn = new JSpinner(model);
		spinnerAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerAn.setBounds(206, 113, 61, 17);
		contentPane.add(spinnerAn);
		
		chckbxComedie = new JCheckBox("comedie");
		chckbxComedie.setBounds(32, 175, 93, 21);
		chckbxComedie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(chckbxComedie);
		
		chckbxDrama = new JCheckBox("drama");
		chckbxDrama.setBounds(128, 177, 93, 21);
		chckbxDrama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(chckbxDrama);
		
		chckbxIstoric = new JCheckBox("istoric");
		chckbxIstoric.setBounds(223, 175, 93, 21);
		chckbxIstoric.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(chckbxIstoric);
		
		chckbxRomantic = new JCheckBox("romantic");
		chckbxRomantic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxRomantic.setBounds(318, 177, 79, 21);
		contentPane.add(chckbxRomantic);
		
		chckbxActiune = new JCheckBox("actiune");
		chckbxActiune.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxActiune.setBounds(167, 200, 93, 21);
		contentPane.add(chckbxActiune);
		
		DefaultTableModel table1 = new DefaultTableModel();
		String[] column = { "Film", "Actori", "An lansare", "Genuri" };
		table1.setColumnIdentifiers(column);
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] row = new String[4];
				row[0] = textFilm.getText();
				row[1] = textActori.getText();
				row[2] = String.valueOf(spinnerAn.getValue());
				row[3] = "";
				if (chckbxComedie.isSelected())
					row[3] += "comedie, ";
				if (chckbxDrama.isSelected())
					row[3] += "drama, ";
				if (chckbxIstoric.isSelected())
					row[3] += "istoric, ";
				if (chckbxRomantic.isSelected())
					row[3] += "romantic, ";
				if (chckbxActiune.isSelected())
					row[3] += "actiune, ";
				if (!(row[3].equals("")))
					row[3] = row[3].substring(0, row[3].length() - 2);
				table1.addRow(row);
			}
		});
		btnAdauga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdauga.setBounds(32, 256, 120, 25);
		contentPane.add(btnAdauga);
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] n = table.getSelectedRows();
				for (int i = n.length - 1; i >= 0; i--)
					table1.removeRow(n[i]);
			}
		});
		btnSterge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSterge.setBounds(273, 256, 120, 25);
		contentPane.add(btnSterge);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(21, 159, 391, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Genuri"));
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(27, 291, 370, 211);
		contentPane.add(scrollPane);
		table = new JTable(table1);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

	}
}
