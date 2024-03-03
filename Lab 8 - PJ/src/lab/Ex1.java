package lab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ex1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOperand1;
	private JTextField textOperand2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex1 frame = new Ex1();
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
	public Ex1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOperand1 = new JLabel("Operand 1");
		lblOperand1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOperand1.setBounds(52, 33, 77, 22);
		contentPane.add(lblOperand1);
		
		JLabel lblOperand2 = new JLabel("Operand 2");
		lblOperand2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOperand2.setBounds(52, 65, 77, 22);
		contentPane.add(lblOperand2);
		
		textOperand1 = new JTextField();
		textOperand1.setBounds(139, 37, 118, 19);
		contentPane.add(textOperand1);
		textOperand1.setColumns(10);
		
		textOperand2 = new JTextField();
		textOperand2.setBounds(139, 69, 118, 19);
		contentPane.add(textOperand2);
		textOperand2.setColumns(10);
		
		JLabel lblRezultat = new JLabel("Rezultat");
		lblRezultat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRezultat.setBackground(Color.WHITE);
		lblRezultat.setBounds(52, 191, 235, 22);
		lblRezultat.setOpaque(true);
		contentPane.add(lblRezultat);	

		class Calcule implements ActionListener
		{
			private char operand;
			public Calcule(char operand)
			{
				this.operand = operand;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					int nr1 = Integer.parseInt(textOperand1.getText());
					int nr2 = Integer.parseInt(textOperand2.getText());
					switch(operand)
					{
					case '+':
						lblRezultat.setText(String.valueOf(nr1 + nr2));
						break;
					case '-':
						lblRezultat.setText(String.valueOf(nr1 - nr2));
						break;
					case '*':
						lblRezultat.setText(String.valueOf(nr1 * nr2));
						break;
					case '/':
						lblRezultat.setText(String.valueOf(nr1 / nr2));
						break;
					case 'c':
						lblRezultat.setText("Rezultat");
						break;
					}
				}
				catch (NumberFormatException e1)
				{
					lblRezultat.setText("Valoare necorespunzatoare");
					if (textOperand1.getText().isBlank())
						lblRezultat.setText("Valoare lipsa");
				}
				catch(ArithmeticException q)
				{
					lblRezultat.setText("Impartire la 0");
				}
			}
		}
		
		JButton btnAdunare = new JButton("Adunare");
		btnAdunare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdunare.addActionListener(new Calcule('+'));
		btnAdunare.setBounds(52, 109, 97, 27);
		contentPane.add(btnAdunare);
		
		JButton btnScadere = new JButton("Scadere");
		btnScadere.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnScadere.addActionListener(new Calcule('-'));
		btnScadere.setBounds(190, 112, 97, 27);
		contentPane.add(btnScadere);
		
		JButton btnInmultire = new JButton("Inmultire");
		btnInmultire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInmultire.addActionListener(new Calcule('*'));
		btnInmultire.setBounds(52, 146, 97, 27);
		contentPane.add(btnInmultire);
		
		JButton btnImpartire = new JButton("Impartire");
		btnImpartire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImpartire.addActionListener(new Calcule('/'));
		btnImpartire.setBounds(190, 149, 97, 27);
		contentPane.add(btnImpartire);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.addActionListener(new Calcule('c'));
		btnClear.setBounds(125, 225, 89, 28);
		contentPane.add(btnClear);
		
	}
}
