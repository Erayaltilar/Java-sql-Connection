import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.BorderLayout;

import java.awt.event.MouseAdapter;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.w3c.dom.events.MouseEvent;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class FrameDashboard extends JFrame {


	private JPanel contentPane;
	
	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("res/Logo.png")).getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
	private Image img_home = new ImageIcon(FrameLogin.class.getResource("res/Home.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_students = new ImageIcon(FrameLogin.class.getResource("res/Students.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_grades = new ImageIcon(FrameLogin.class.getResource("res/Grades.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_lectures = new ImageIcon(FrameLogin.class.getResource("res/Lectures.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_faculties = new ImageIcon(FrameLogin.class.getResource("res/Faculties.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_teachers = new ImageIcon(FrameLogin.class.getResource("res/Teachers.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_about = new ImageIcon(FrameLogin.class.getResource("res/About.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	

	private panelHome panelHome;
	private panelStudents panelStudents;
	private panelGrades panelGrades;
	private panelLectures panelLectures;
	private panelAddresses panelFaculties;
	private panelTeachers panelTeachers;
	private panelAbout panelAbout;
	
	
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://DESKTOP-IB35G0J\\MSSQLSERVER;databaseName=YabanciDilKursu";
		String user = "sqlserveray";
		String password = "nomad344";
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					System.out.println("SQL baðlantýsý kuruldu !");
					//Statement statement = connection.createStatement();
					
					
					FrameDashboard frame = new FrameDashboard();
					frame.setVisible(true);
					
				} catch (Exception e) {
					System.out.println("Baðlantý kurulamadý !");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDashboard() {
		setBackground(new Color(102, 153, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 625);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setForeground(new Color(51, 102, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHome = new panelHome();
		panelStudents = new panelStudents();
		panelGrades = new panelGrades();
		panelLectures = new panelLectures();
		panelFaculties = new panelAddresses();
		panelTeachers = new panelTeachers();
		panelAbout = new panelAbout();
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(Color.WHITE);
		paneMenu.setBounds(10, 11, 318, 603);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 298, 192);
		paneMenu.add(lblIconLogo);
		
		JPanel paneHome = new JPanel();
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelHome);
			}
		});
		paneHome.setBorder(new LineBorder(Color.WHITE));
		paneHome.setBackground(Color.WHITE);
		paneHome.setForeground(Color.WHITE);
		paneHome.setBounds(0, 220, 308, 40);
		paneMenu.add(paneHome);
		paneHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ANA SAYFA");
		lblNewLabel.setForeground(new Color(221, 160, 221));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 12, 308, 14);
		paneHome.add(lblNewLabel);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setIcon(new ImageIcon(img_home));
		lblIconHome.setBounds(40, 0, 46, 40);
		paneHome.add(lblIconHome);
		
		JPanel paneStudents = new JPanel();
		paneStudents.addMouseListener(new PanelButtonMouseAdapter(paneStudents) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelStudents);
			}
		});
		paneStudents.setBorder(new LineBorder(Color.WHITE));
		paneStudents.setBackground(Color.WHITE);
		paneStudents.setForeground(Color.WHITE);
		paneStudents.setBounds(0, 260, 308, 40);
		paneMenu.add(paneStudents);
		paneStudents.setLayout(null);
		
		JLabel lblStudents = new JLabel("   OGRENCILER");
		lblStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudents.setForeground(new Color(221, 160, 221));
		lblStudents.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblStudents.setBounds(0, 11, 308, 14);
		paneStudents.add(lblStudents);
		
		JLabel lblIconStudents = new JLabel("");
		lblIconStudents.setIcon(new ImageIcon(img_students));
		lblIconStudents.setBounds(39, 0, 46, 40);
		paneStudents.add(lblIconStudents);
		
		JPanel paneGrades = new JPanel();
		paneGrades.addMouseListener(new PanelButtonMouseAdapter(paneGrades) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelGrades);
			}
		});
		paneGrades.setBorder(new LineBorder(Color.WHITE));
		paneGrades.setBackground(Color.WHITE);
		paneGrades.setForeground(Color.WHITE);
		paneGrades.setBounds(0, 300, 308, 40);
		paneMenu.add(paneGrades);
		paneGrades.setLayout(null);
		
		JLabel lblGrades = new JLabel("NOTLAR");
		lblGrades.setBounds(0, 11, 308, 18);
		lblGrades.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrades.setForeground(new Color(221, 160, 221));
		lblGrades.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		paneGrades.add(lblGrades);
		
		JLabel lblIconGrades = new JLabel("");
		lblIconGrades.setIcon(new ImageIcon(img_grades));
		lblIconGrades.setBounds(39, 0, 46, 40);
		paneGrades.add(lblIconGrades);
		
		JPanel paneLectures = new JPanel();
		paneLectures.addMouseListener(new PanelButtonMouseAdapter(paneLectures) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelLectures);
			}
		});
		paneLectures.setBorder(new LineBorder(Color.WHITE));
		paneLectures.setBackground(Color.WHITE);
		paneLectures.setForeground(Color.WHITE);
		paneLectures.setBounds(0, 340, 308, 40);
		paneMenu.add(paneLectures);
		paneLectures.setLayout(null);
		
		JLabel lblLecture = new JLabel("  DERSLER");
		lblLecture.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture.setForeground(new Color(221, 160, 221));
		lblLecture.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblLecture.setBounds(0, 11, 308, 14);
		paneLectures.add(lblLecture);
		
		JLabel lblIconLectures = new JLabel("");
		lblIconLectures.setIcon(new ImageIcon(img_lectures));
		lblIconLectures.setBounds(37, 0, 46, 40);
		paneLectures.add(lblIconLectures);
		
		JPanel paneFaculties = new JPanel();
		paneFaculties.addMouseListener(new PanelButtonMouseAdapter(paneFaculties) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelFaculties);
			}
		});
		paneFaculties.setBorder(new LineBorder(Color.WHITE));
		paneFaculties.setBackground(Color.WHITE);
		paneFaculties.setForeground(Color.WHITE);
		paneFaculties.setBounds(0, 380, 308, 40);
		paneMenu.add(paneFaculties);
		paneFaculties.setLayout(null);
		
		JLabel lblFacultes = new JLabel("ADRESLER");
		lblFacultes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacultes.setForeground(new Color(221, 160, 221));
		lblFacultes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblFacultes.setBounds(10, 11, 308, 14);
		paneFaculties.add(lblFacultes);
		
		JLabel lblIconFaculties = new JLabel("");
		lblIconFaculties.setIcon(new ImageIcon(img_faculties));
		lblIconFaculties.setBounds(35, 0, 46, 40);
		paneFaculties.add(lblIconFaculties);
		
		JPanel paneTeachers = new JPanel();
		paneTeachers.addMouseListener(new PanelButtonMouseAdapter(paneTeachers) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelTeachers);
			}
		});
		paneTeachers.setBorder(new LineBorder(Color.WHITE));
		paneTeachers.setBackground(Color.WHITE);
		paneTeachers.setForeground(Color.WHITE);
		paneTeachers.setBounds(0, 420, 308, 40);
		paneMenu.add(paneTeachers);
		paneTeachers.setLayout(null);
		
		JLabel lblTeachers = new JLabel(" OGRETMENLER ");
		lblTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeachers.setForeground(new Color(221, 160, 221));
		lblTeachers.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblTeachers.setBounds(0, 11, 308, 14);
		paneTeachers.add(lblTeachers);
		
		JLabel lblIconTeachers = new JLabel("");
		lblIconTeachers.setIcon(new ImageIcon(img_teachers));
		lblIconTeachers.setBounds(35, 0, 46, 40);
		paneTeachers.add(lblIconTeachers);
		
		JPanel paneAbout = new JPanel();
		paneAbout.addMouseListener(new PanelButtonMouseAdapter(paneAbout) {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				menuClicked(panelAbout);
			}
		});
		paneAbout.setBorder(new LineBorder(Color.WHITE));
		paneAbout.setBackground(Color.WHITE);
		paneAbout.setForeground(Color.WHITE);
		paneAbout.setBounds(0, 460, 308, 40);
		paneMenu.add(paneAbout);
		paneAbout.setLayout(null);
		
		JLabel lblAbout = new JLabel("  KURUM HAKKINDA");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setForeground(new Color(221, 160, 221));
		lblAbout.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblAbout.setBounds(0, 11, 308, 14);
		paneAbout.add(lblAbout);
		
		JLabel lblIconAbout = new JLabel("");
		lblIconAbout.setIcon(new ImageIcon(img_about));
		lblIconAbout.setBounds(35, 0, 46, 40);
		paneAbout.add(lblIconAbout);
		
		JPanel paneExit = new JPanel();
		//paneExit.addMouseListener(new PanelButtonMouseAdapter(paneExit));
		paneExit.setBorder(new LineBorder(Color.WHITE));
		paneExit.setBackground(Color.WHITE);
		paneExit.setForeground(Color.WHITE);
		paneExit.setBounds(0, 500, 308, 80);
		paneMenu.add(paneExit);
		paneExit.setLayout(null);
		
		JLabel lblExit = new JLabel("EXIT");
		lblExit.setBackground(Color.WHITE);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				
				if(JOptionPane.showConfirmDialog(null,"Çýkýþ yapmak istediðinizden emin misiniz ?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION)== 0) {
					FrameDashboard.this.dispose();
				}
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent arg0) {
				lblExit.setBackground(new Color(47, 79 ,79));
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				lblExit.setBackground(Color.WHITE);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(new Color(221, 160, 221));
		lblExit.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblExit.setBounds(10, 0, 298, 80);
		paneExit.add(lblExit);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(338, 11, 646, 603);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		panelMainContent.add(panelHome);
		panelMainContent.add(panelStudents);
		panelMainContent.add(panelGrades);
		panelMainContent.add(panelLectures);
		panelMainContent.add(panelFaculties);
		panelMainContent.add(panelTeachers);
		panelMainContent.add(panelAbout);
		
		menuClicked(panelHome);
	}
	
	public void menuClicked(JPanel panel) {
		panelHome.setVisible(false);
		panelStudents.setVisible(false);
		panelGrades.setVisible(false);
		panelLectures.setVisible(false);
		panelFaculties.setVisible(false);
		panelTeachers.setVisible(false);
		panelAbout.setVisible(false);
		
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			panel.setBackground(new Color(47, 79 ,79));
		}
		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			panel.setBackground(Color.WHITE);
		}
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			panel.setBackground(new Color(112,128 ,144 ));
		}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			panel.setBackground(new Color(112,128 ,144 ));	
		}
	}
}
