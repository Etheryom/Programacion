package PelotaConTimer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame {
	
	private JPanel panel;
	private JPanel botones;
	private VistaPelota vistaPelota;
	private JButton mover;
	
	public Vista(VistaPelota vistaPelota){
		setLayout(new BorderLayout());

		panel = new JPanel(new BorderLayout());
		botones = new JPanel(new GridLayout(1,1));
		
		mover = new JButton("Mover");
		
		botones.add(mover);
		
		this.vistaPelota = vistaPelota;
		
		panel.add(vistaPelota);
		panel.setBackground(Color.green);
	
		add(panel,BorderLayout.CENTER);
		add(botones,BorderLayout.SOUTH);
	}
	
	public void arrancar(){
		setSize(1300,700);
		setTitle("Pelota");
		setVisible(true);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	public VistaPelota getVistaPelota(){
		return vistaPelota;
	}
	
	public JButton getMover(){
		return mover;
	}

}