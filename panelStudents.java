import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;






public class panelStudents extends JPanel {
	
	private JTextField ogrNoText;
	private JTextField ogrAdText;
	private JTextField ogrSoyText;
	private JTextField ogrTcnoText;

	String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
	String user = "sqlserveray";
	String password = "nomad344";
	
	
	DefaultTableModel myModel = new DefaultTableModel();
	Object[] columns = {"Ogrenci No","Ogrenci adi","Ogrenci Soyadi","Ogrenci Tcno"};
	Object[] rows = new Object[4];
	
	
	
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public panelStudents() {
		setBackground(new Color(100, 149, 237));
		setForeground(Color.BLACK);
		setBorder(new LineBorder(Color.RED, 3));
		setBounds(0,0,646,603);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00D6\u011Frenci ad\u0131");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(39, 109, 84, 22);
		add(lblNewLabel);
		
		JLabel lblrenciNo = new JLabel("\u00D6\u011Frenci No");
		lblrenciNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblrenciNo.setBounds(39, 76, 84, 22);
		add(lblrenciNo);
		
		JLabel lblrenciSoyad = new JLabel("\u00D6\u011Frenci soyad\u0131");
		lblrenciSoyad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblrenciSoyad.setBounds(39, 141, 84, 22);	
		add(lblrenciSoyad);
		
		ogrNoText = new JTextField();
		ogrNoText.setBounds(133, 77, 160, 20);
		add(ogrNoText);
		ogrNoText.setColumns(10);
		
		ogrAdText = new JTextField();
		ogrAdText.setBounds(133, 110, 160, 20);
		add(ogrAdText);
		ogrAdText.setColumns(10);
		
		ogrSoyText = new JTextField();
		ogrSoyText.setBounds(133, 142, 160, 20);
		add(ogrSoyText);
		ogrSoyText.setColumns(10);
		
		JLabel lblrenciTcno = new JLabel("\u00D6\u011Frenci tcno");
		lblrenciTcno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblrenciTcno.setBounds(39, 174, 84, 22);
		add(lblrenciTcno);
		
		ogrTcnoText = new JTextField();
		ogrTcnoText.setBounds(133, 175, 160, 20);
		add(ogrTcnoText);
		ogrTcnoText.setColumns(10);
		
		JButton InsertButton = new JButton("Kaydet");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		InsertButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();
				try {
					statement.executeUpdate("INSERT INTO ogrenci VALUES(" + ogrNoText.getText() + ",'" + ogrAdText.getText() + "','" + ogrSoyText.getText() + "',"  + ogrTcnoText.getText() + ")");
					JOptionPane.showMessageDialog(null, "Veri girildi !");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Bir sorun oluþtu !");
					e1.printStackTrace();
				}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		InsertButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		InsertButton.setBounds(39, 207, 89, 23);
		add(InsertButton);
		
		JButton UpdateButton = new JButton("Yenile");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						  statement.execute("UPDATE ogrenci SET ogr_adi='" + ogrAdText.getText() + "',ogr_soyadi='" + ogrSoyText.getText() + "' , ogr_tcno = '" + ogrTcnoText.getText() + "' WHERE ogr_no=" + ogrNoText.getText() + ""); 
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
		UpdateButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		UpdateButton.setBounds(143, 206, 89, 23);
		add(UpdateButton);
		
		JButton DeleteButton = new JButton("Sil");
		DeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();
				statement.executeUpdate("DELETE FROM ogrenci WHERE ogr_no =" + ogrNoText.getText());
				JOptionPane.showMessageDialog(null, "Veri silindi!");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Bir sorun oluþtu !");
					e1.printStackTrace();
				}
				
			}
		});
		DeleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		DeleteButton.setBounds(242, 207, 89, 23);
		add(DeleteButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 626, 342);
		add(scrollPane);
		
		table = new JTable();
		myModel.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.setRowCount(0);
				ResultSet myRs = baglantiOgrenci.yap();
				try {
					while(myRs.next()) {
						rows[0]=myRs.getInt("ogr_no");
						rows[1]=myRs.getString("ogr_adi");
						rows[2]=myRs.getString("ogr_soyadi");
						rows[3]=myRs.getString("ogr_tcno");
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
		btnNewButton.setBounds(470, 207, 89, 23);
		add(btnNewButton);
	}
	
	
}
