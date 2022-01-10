import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class panelLectures extends JPanel {
	private JTextField dersNoText;
	private JTextField ogrtNoText;
	private JTextField dersAdiText;
	private JTable table;

	DefaultTableModel myModel = new DefaultTableModel();
	Object[] columns = {"Ders No","Ogretmen No","Ders Adi"};
	Object[] rows = new Object[3];
	
	String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
	String user = "sqlserveray";
	String password = "nomad344";
	
	/**
	 * Create the panel.
	 */
	public panelLectures() {
		setBackground(new Color(135, 206, 235));
		setBounds(0,0,646,603);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ders No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 80, 14);
		add(lblNewLabel);
		
		JLabel lblOgretmenNo = new JLabel("Ogretmen No");
		lblOgretmenNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOgretmenNo.setBounds(10, 65, 80, 14);
		add(lblOgretmenNo);
		
		JLabel lblDersAdi = new JLabel("Ders adi");
		lblDersAdi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDersAdi.setBounds(10, 123, 80, 14);
		add(lblDersAdi);
		
		dersNoText = new JTextField();
		dersNoText.setBounds(100, 8, 86, 20);
		add(dersNoText);
		dersNoText.setColumns(10);
		
		ogrtNoText = new JTextField();
		ogrtNoText.setColumns(10);
		ogrtNoText.setBounds(100, 62, 86, 20);
		add(ogrtNoText);
		
		dersAdiText = new JTextField();
		dersAdiText.setColumns(10);
		dersAdiText.setBounds(100, 120, 86, 20);
		add(dersAdiText);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						statement.executeUpdate("INSERT INTO dersler VALUES(" + dersNoText.getText() + "," + ogrtNoText.getText() + ",'" + dersAdiText.getText() + "'" + ")");
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 175, 89, 23);
		add(btnNewButton);
		
		JButton btnYenile = new JButton("Yenile");
		btnYenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					try {
						  statement.execute("UPDATE dersler SET ogrt_no=" + ogrtNoText.getText() + ",ders_adi='" + dersAdiText.getText() + "' WHERE ders_no=" + dersNoText.getText() + ""); 
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
		btnYenile.setBounds(10, 230, 89, 23);
		add(btnYenile);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					Statement statement = connection.createStatement();
					statement.executeUpdate("DELETE FROM dersler WHERE ders_no =" + dersNoText.getText());
					JOptionPane.showMessageDialog(null, "Veri silindi !");
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSil.setBounds(10, 288, 89, 23);
		add(btnSil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 11, 381, 581);
		add(scrollPane);
		
		table = new JTable();
		myModel.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Listele");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.setRowCount(0);
				ResultSet myRs = baglantiDersler.yap();
				try {
					while(myRs.next()) {
						rows[0]=myRs.getInt("ders_no");
						rows[1]=myRs.getInt("ogrt_no");
						rows[2]=myRs.getString("ders_adi");
						myModel.addRow(rows);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(myModel);
				
			}
		});
		btnNewButton_1.setBounds(156, 175, 89, 23);
		add(btnNewButton_1);
	}

}
