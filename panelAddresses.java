import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class panelAddresses extends JPanel {
	private JTextField ogrNoText;
	private JTextField adresNoText;
	private JTextField adresNoText_1;
	private JTextField adresDetayText;
	private JTable table;

	DefaultTableModel myModel = new DefaultTableModel();
	Object[] columns = {"Oðrenci No","Adres No"};
	Object[] rows = new Object[2];
	
	DefaultTableModel myModel1 = new DefaultTableModel();
	Object[] columns1 = {"Adres No","Adres Detay"};
	Object[] rows1 = new Object[2];
	
	String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
	String user = "sqlserveray";
	String password = "nomad344";
	private JTable table_1;
	
	/**
	 * Create the panel.
	 */
	public panelAddresses() {
		setBackground(new Color(255, 228, 181));
		setBounds(0,0,646,603);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O\u011Frenci no");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 56, 80, 14);
		add(lblNewLabel);
		
		JLabel lblAdresNo = new JLabel("Adres no");
		lblAdresNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresNo.setBounds(10, 114, 80, 14);
		add(lblAdresNo);
		
		JLabel lblAdresNo_1 = new JLabel("Adres no");
		lblAdresNo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresNo_1.setBounds(10, 324, 80, 14);
		add(lblAdresNo_1);
		
		JLabel lblAdresDetay = new JLabel("Adres detay");
		lblAdresDetay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresDetay.setBounds(10, 380, 80, 14);
		add(lblAdresDetay);
		
		ogrNoText = new JTextField();
		ogrNoText.setBounds(100, 53, 86, 20);
		add(ogrNoText);
		ogrNoText.setColumns(10);
		
		adresNoText = new JTextField();
		adresNoText.setColumns(10);
		adresNoText.setBounds(100, 111, 86, 20);
		add(adresNoText);
		
		adresNoText_1 = new JTextField();
		adresNoText_1.setColumns(10);
		adresNoText_1.setBounds(100, 321, 86, 20);
		add(adresNoText_1);
		
		adresDetayText = new JTextField();
		adresDetayText.setColumns(10);
		adresDetayText.setBounds(10, 416, 300, 40);
		add(adresDetayText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 11, 282, 270);
		add(scrollPane);
		
		table = new JTable();
		myModel.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(354, 336, 282, 256);
		add(scrollPane_1);
		
		table_1 = new JTable();
		myModel1.setColumnIdentifiers(columns1);
		scrollPane_1.setViewportView(table_1);
		
		JButton Adres_btn = new JButton("Listele");
		Adres_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel1.setRowCount(0);
				ResultSet myRs = baglantiAdres.yap();
				try {
					while(myRs.next()) {
						rows1[0]=myRs.getInt("adres_no");
						rows1[1]=myRs.getString("adres_detay");
						myModel1.addRow(rows1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_1.setModel(myModel1);
			}
		});
		
		Adres_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Adres_btn.setBounds(255, 380, 89, 23);
		add(Adres_btn);
		
		JButton Ogr_adres_btn = new JButton("Listele");
		Ogr_adres_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.setRowCount(0);
				ResultSet myRs = baglantiOgrenciAdres.yap();
				try {
					while(myRs.next()) {
						rows[0]=myRs.getInt("ogr_no");
						rows[1]=myRs.getInt("adres_no");
						myModel.addRow(rows);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(myModel);
				
			}
		});
		Ogr_adres_btn.setFont(new Font("Tahoma", Font.BOLD, 11));
		Ogr_adres_btn.setBounds(255, 52, 89, 23);
		add(Ogr_adres_btn);
		
		JButton insertBtn = new JButton("Kaydet");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						statement.executeUpdate("INSERT INTO ogrenciAdres VALUES(" + ogrNoText.getText() + "," + adresNoText.getText() + ")");
						JOptionPane.showMessageDialog(null, "Listeye eklendi !");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Öðrenci veya adres mevcut deðil !");
						e1.printStackTrace();
					}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		insertBtn.setBounds(10, 159, 89, 23);
		add(insertBtn);
		
		JButton updateBtn = new JButton("Yenile\r\n");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						  statement.execute("UPDATE ogrenciAdres SET adres_no=" + adresNoText.getText() + " WHERE ogr_no=" + ogrNoText.getText() + ""); 
						JOptionPane.showMessageDialog(null, "Veri yenilendi !");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Yanlýþ veya eksik bilgi girdiniz !");
						e1.printStackTrace();
					}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		updateBtn.setBounds(109, 159, 89, 23);
		add(updateBtn);
		
		JButton deleteBtn = new JButton("Sil");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					statement.executeUpdate("DELETE FROM OgrenciAdres WHERE ogr_no =" + ogrNoText.getText());
					statement.executeUpdate("DELETE FROM OgrenciAdres WHERE adres_no ="+ adresNoText.getText());
					JOptionPane.showMessageDialog(null, "Veri silindi !");
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteBtn.setBounds(208, 159, 89, 23);
		add(deleteBtn);
		
		JButton insertBtn2 = new JButton("Kaydet");
		insertBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						statement.executeUpdate("INSERT INTO adres VALUES(" + adresNoText_1.getText() + ",'" + adresDetayText.getText() + "'" + ")");
						JOptionPane.showMessageDialog(null, "Listeye eklendi !");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Eksik veya hatalý bilgi girdiniz !");
						e1.printStackTrace();
					}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		insertBtn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		insertBtn2.setBounds(10, 495, 89, 23);
		add(insertBtn2);
		
		JButton updateBtn2 = new JButton("Yenile\r\n");
		updateBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						  statement.execute("UPDATE adres SET adres_detay = '" + adresDetayText.getText() + "' WHERE adres_no= " + adresNoText_1.getText() + ""); 
						JOptionPane.showMessageDialog(null, "Veri yenilendi !");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Yanlýþ veya eksik bilgi girdiniz !");
						e1.printStackTrace();
					}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		updateBtn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		updateBtn2.setBounds(109, 495, 89, 23);
		add(updateBtn2);
		
		JButton deleteBtn2 = new JButton("Sil");
		deleteBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					statement.executeUpdate("DELETE FROM adres WHERE adres_no = " + adresNoText_1.getText());
					JOptionPane.showMessageDialog(null, "Veri silindi !");
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		deleteBtn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteBtn2.setBounds(208, 495, 89, 23);
		add(deleteBtn2);
	}
}
