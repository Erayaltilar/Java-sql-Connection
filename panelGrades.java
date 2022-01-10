import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class panelGrades extends JPanel {
	
	String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
	String user = "sqlserveray";
	String password = "nomad344";
	
	private JTextField ogrNoText;
	private JTextField dersNoText;
	private JTextField vizeNotuText;
	private JTextField finalNotuText;
	
	DefaultTableModel myModel = new DefaultTableModel();
	Object[] columns = {"Ogrenci No","Ders No","Vize Notu","Final notu"};
	Object[] rows = new Object[4];
	private JTable table;
	/**
	 * Create the panel.
	 */
	public panelGrades() {
		setBackground(new Color(221, 160, 221));
		setBounds(0,0,646,603);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00D6\u011Frenci No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 60, 75, 14);
		add(lblNewLabel);
		
		ogrNoText = new JTextField();
		ogrNoText.setBounds(10, 85, 86, 20);
		add(ogrNoText);
		ogrNoText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ders No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(109, 60, 75, 14);
		add(lblNewLabel_1);
		
		dersNoText = new JTextField();
		dersNoText.setBounds(109, 85, 86, 20);
		add(dersNoText);
		dersNoText.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vize Notu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(215, 60, 75, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Final Notu");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(322, 60, 75, 14);
		add(lblNewLabel_1_2);
		
		vizeNotuText = new JTextField();
		vizeNotuText.setColumns(10);
		vizeNotuText.setBounds(215, 85, 86, 20);
		add(vizeNotuText);
		
		finalNotuText = new JTextField();
		finalNotuText.setColumns(10);
		finalNotuText.setBounds(311, 85, 86, 20);
		add(finalNotuText);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(Color.ORANGE));
		scrollPane.setBounds(10, 310, 626, 282);
		add(scrollPane);
		
		table = new JTable();
		myModel.setColumnIdentifiers(columns);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setBounds(332, 310, 304, 282);

		JButton btnNewButton = new JButton("Listele");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.setRowCount(0);
				ResultSet myRs = baglantiNotlar.yap();
				try {
					while(myRs.next()) {
						rows[0]=myRs.getInt("ogr_no");
						rows[1]=myRs.getInt("ders_no");
						rows[2]=myRs.getInt("vize_not");
						rows[3]=myRs.getInt("final_not");
						myModel.addRow(rows);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(myModel);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(475, 266, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					statement.executeUpdate("INSERT INTO notlar VALUES(" + ogrNoText.getText() + "," + dersNoText.getText() + "," + vizeNotuText.getText() + ","  + finalNotuText.getText() + ")");
					JOptionPane.showMessageDialog(null, "Veri Girildi !");
					}
					catch(Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Bir sorun oluþtu !");
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(7, 130, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Yenile");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						  statement.execute("UPDATE notlar SET ders_no=" + dersNoText.getText() + ",vize_not=" + vizeNotuText.getText() + " , final_not= " + finalNotuText.getText() + " WHERE ogr_no=" + ogrNoText.getText() + ""); 
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
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(106, 130, 89, 23);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Sil");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					statement.executeUpdate("DELETE FROM notlar WHERE ogr_no =" + ogrNoText.getText());
					JOptionPane.showMessageDialog(null, "Veri silindi!");
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_2.setBounds(215, 130, 89, 23);
		add(btnNewButton_1_2);


	}
}
