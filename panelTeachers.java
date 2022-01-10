import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class panelTeachers extends JPanel {
	private JTextField ogrtNoText;
	private JTextField ogrtAdText;
	private JTextField ogrtSoyText;
	private JTextField dilText;
	private JTable table;

	DefaultTableModel myModel = new DefaultTableModel();
	Object[] columns = {"Ogretmen No","Ogretmen adi","Ogretmen Soyadi","Ogretmen Dili"};
	Object[] rows = new Object[4];
	
	String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
	String user = "sqlserveray";
	String password = "nomad344";
	
	/**
	 * Create the panel.
	 */
	public panelTeachers() {
		setBackground(new Color(153, 204, 102));
		setBounds(0,0,646,603);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ogretmen No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(29, 70, 86, 14);
		add(lblNewLabel);
		
		JLabel lblOgretmenAdi = new JLabel("Ogretmen Ad\u0131");
		lblOgretmenAdi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOgretmenAdi.setBounds(165, 70, 86, 14);
		add(lblOgretmenAdi);
		
		JLabel lblOgretmenSoyad = new JLabel("\u00D6gretmen Soyad\u0131");
		lblOgretmenSoyad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOgretmenSoyad.setBounds(310, 70, 103, 14);
		add(lblOgretmenSoyad);
		
		JLabel lblCinsiyat = new JLabel("Dil");
		lblCinsiyat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCinsiyat.setBounds(452, 70, 70, 14);
		add(lblCinsiyat);
		
		ogrtNoText = new JTextField();
		ogrtNoText.setBounds(29, 110, 86, 20);
		add(ogrtNoText);
		ogrtNoText.setColumns(10);
		
		ogrtAdText = new JTextField();
		ogrtAdText.setColumns(10);
		ogrtAdText.setBounds(165, 110, 86, 20);
		add(ogrtAdText);
		
		ogrtSoyText = new JTextField();
		ogrtSoyText.setColumns(10);
		ogrtSoyText.setBounds(310, 110, 86, 20);
		add(ogrtSoyText);
		
		dilText = new JTextField();
		dilText.setColumns(10);
		dilText.setBounds(452, 110, 86, 20);
		add(dilText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 286, 466, 306);
		add(scrollPane);
		
		table = new JTable();
		myModel.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listele\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.setRowCount(0);
				ResultSet myRs = baglantiOgretmen.yap();
				try {
					while(myRs.next()) {
						rows[0]=myRs.getInt("ogrt_no");
						rows[1]=myRs.getString("ogrt_adi");
						rows[2]=myRs.getString("ogrt_soyadi");
						rows[3]=myRs.getString("ogrt_dil");
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
		btnNewButton.setBounds(505, 301, 89, 23);
		add(btnNewButton);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						statement.executeUpdate("INSERT INTO ogretmenler VALUES(" + ogrtNoText.getText() + ",'" + ogrtAdText.getText() + "','" + ogrtSoyText.getText() + "','"+ dilText.getText() + "'" + ")");
						JOptionPane.showMessageDialog(null, "Listeye eklendi !");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Öðretmen mevcut deðil veya ders zaten mevcut !");
						e1.printStackTrace();
					}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKaydet.setBounds(26, 252, 89, 23);
		add(btnKaydet);
		
		JButton btnYenile = new JButton("Yenile");
		btnYenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						  statement.execute("UPDATE ogretmenler SET ogrt_adi='" + ogrtAdText.getText() + "', ogrt_soyadi='" + ogrtSoyText.getText() + "', ogrt_dil = '" + dilText.getText()+ "' WHERE ogrt_no=" + ogrtNoText.getText() + ""); 
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
		btnYenile.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnYenile.setBounds(165, 252, 89, 23);
		add(btnYenile);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					statement.executeUpdate("DELETE FROM ogretmenler WHERE ogrt_no =" + ogrtNoText.getText());
					JOptionPane.showMessageDialog(null, "Veri silindi !");
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSil.setBounds(307, 252, 89, 23);
		add(btnSil);
	}
}
