import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class panelHome extends JPanel {

	
	
	private Image img_homepage = new ImageIcon(FrameLogin.class.getResource("res/Homelogo.png")).getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
	/**
	 * Create the panel.
	 */
	public panelHome() {
		
		
		
		setBackground(new Color(72, 61, 139));
		setBounds(0,0,646,603);
		setLayout(null);
		setVisible(true);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(img_homepage));
		lblIcon.setBackground(Color.WHITE);
		lblIcon.setForeground(new Color(0, 255, 255));
		lblIcon.setFont(new Font("Goudy Old Style", Font.BOLD, 26));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(10, 11, 626, 581);
		add(lblIcon);
	}
}
