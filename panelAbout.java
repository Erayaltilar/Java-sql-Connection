import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class panelAbout extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelAbout() {
		setBackground(Color.CYAN);
		setBounds(0,0,646,603);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eray Alt\u0131lar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(193, 205, 136, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("YabanciDilKursu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_3.setBounds(60, 49, 302, 93);
		add(lblNewLabel_3);
		
		JLabel lblMertAygn = new JLabel("Mert Ayg\u00FCn");
		lblMertAygn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMertAygn.setBounds(193, 243, 136, 27);
		add(lblMertAygn);
		
		JLabel lblNewLabel_2 = new JLabel("Haz\u0131rlayanlar :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(48, 203, 156, 27);
		add(lblNewLabel_2);
		
		JLabel lblAybkeBtn = new JLabel("Ayb\u00FCke B\u00FCt\u00FCn");
		lblAybkeBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAybkeBtn.setBounds(193, 292, 136, 27);
		add(lblAybkeBtn);
		
		JLabel lblMertAygn_1 = new JLabel("201613172029");
		lblMertAygn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMertAygn_1.setBounds(358, 205, 136, 27);
		add(lblMertAygn_1);
		
		JLabel lblMertAygn_2 = new JLabel("201613172039");
		lblMertAygn_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMertAygn_2.setBounds(358, 250, 136, 27);
		add(lblMertAygn_2);
		
		JLabel lblMertAygn_3 = new JLabel("201613172056");
		lblMertAygn_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMertAygn_3.setBounds(358, 299, 136, 27);
		add(lblMertAygn_3);
		
		JLabel lblNewLabel_1 = new JLabel("Veri taban\u0131 y\u00F6netim sistemleri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(60, 420, 551, 64);
		add(lblNewLabel_1);
	}
}
