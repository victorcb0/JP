package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ex2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex2 frame = new Ex2();
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
	public Ex2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("sa");
		JList list = new JList(listModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(list, BorderLayout.CENTER);
		
		textList = new JTextField();
		textList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(textList.getText());
			}
		});
		textList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textList, BorderLayout.NORTH);
		textList.setColumns(10);
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] n = list.getSelectedIndices();
				for(int i = n.length - 1; i >= 0; i--)
				{
					listModel.removeElementAt(n[i]);
				}
				//listModel.clear();
			}
		});
		btnSterge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnSterge, BorderLayout.SOUTH);		
		
	}
}
