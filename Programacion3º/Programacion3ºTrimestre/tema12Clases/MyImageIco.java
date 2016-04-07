package tema12Clases;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyImageIco extends JFrame {
	
	public MyImageIco(){	
	
		//He puesto la ruta absoluta, ya que no encuentro el directorio del proyecto git
		JPanel panel = new JPanel(new GridLayout(1,4,5,5));
		panel.add(new JLabel(new ImageIcon("C:\\Users\\R aul\\Desktop\\images\\wifi.png")));
		panel.add(new JLabel(new ImageIcon("C:\\Users\\R aul\\Desktop\\images\\internet.png")));
		panel.add(new JLabel(new ImageIcon("C:\\Users\\R aul\\Desktop\\images\\twitter.png")));
		panel.add(new JLabel(new ImageIcon("C:\\Users\\R aul\\Desktop\\images\\instagram.png")));
		
		add(panel);
	}

}
