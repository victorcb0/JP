package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.awt.event.ActionEvent;
import javax.swing.JTree;

public class Ex extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File file_selected;
					Ex frame = new Ex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void rec (Node elt, File file_selected){
		NodeList aux;
		NamedNodeMap map;
		if (elt.hasAttributes())
		{
			System.out.println("Atributele tagului " + elt.getNodeName() + " sunt: ");
			map = elt.getAttributes();
			for(int i = 0; i < map.getLength(); i++)
				System.out.println("\t" + map.item(i).getNodeName() + "=\""+
						map.item(i).getNodeValue() + "\"");
		}
		if (elt.hasChildNodes())
		{
			aux=elt.getChildNodes();
			for (int i = 0; i < aux.getLength(); i++)
				rec(aux.item(i), file_selected);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Ex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(366, 22, 60, 16);
		contentPane.add(lblDate);
		
		JButton btnOpen_XML = new JButton("Open XML");
		btnOpen_XML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser open = new JFileChooser();
				 FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Documents (*.xml)", "xml");
				 open.setAcceptAllFileFilterUsed(false);
				 open.setFileFilter(filter);
				 File project_directory = new File(System.getProperty("user.dir"));
				 open.setCurrentDirectory(project_directory);
				 int val = open.showOpenDialog(null);
				 if (val == JFileChooser.APPROVE_OPTION) 
				 {
					 File file_selected = open.getSelectedFile();
					 System.out.println(file_selected.getAbsolutePath());
					 try
					 {
						 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						 DocumentBuilder builder = factory.newDocumentBuilder();
						 Document document = builder.parse(file_selected);
						 Element elt = document.getDocumentElement();
						 rec(elt, file_selected);
					 }
					 catch(Exception e1){
						 System.out.println(e1.toString());
					 }
				 }
			}
		});
		btnOpen_XML.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOpen_XML.setBounds(10, 21, 99, 25);
		contentPane.add(btnOpen_XML);
		
		JTree tree = new JTree();
		tree.setBounds(10, 56, 416, 197);
		contentPane.add(tree);
		tree.scrollRowToVisible(ERROR);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  Calendar time = Calendar.getInstance();
				  String s;
				  s = String.format("%02d:%02d:%02d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.SECOND));
				  lblDate.setText(s);
			  }
			}, 1, 1000);
	}
}
