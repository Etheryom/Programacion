package Tema16Clases;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HandleEventWithInternalClass extends JFrame {
	
	private JButton ok;
	private JButton cancel;
	private JTextField field;
	
	public HandleEventWithInternalClass (){
		
		setLayout(new BorderLayout());
		JPanel panel = new JPanel( new GridLayout(1, 2));
		
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		field = new JTextField("PEPE");
		
		panel.add(ok);
		panel.add(cancel);
		
		add(panel,BorderLayout.CENTER);
		add(field,BorderLayout.NORTH);
		
		//Instancio la clase Interna
		ChangeFieldText modificador_JTextField = new ChangeFieldText();
		
		//Añado los listener
		ok.addActionListener(modificador_JTextField);
		cancel.addActionListener(modificador_JTextField);
	}
	
	//INTERNAL CLASS QUE RECIBE EL MANEJA EL EVENTO
	 private class ChangeFieldText implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			//Obtengo el objeto que ha provocado el evento
			Object myObject = e.getSource();
			
			//Dependiendo del objeto que lo llamara realizara una opcion
			if(myObject == ok)
				field.setText("LE HE DADO AL BOTON OK");
			else if(myObject == cancel)
				field.setText("LE HE DADO AL BOTON CANCEL");
		}
		
	}
}
