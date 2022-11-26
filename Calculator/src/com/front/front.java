package com.front;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
public class front extends JFrame{
	
	JPanel mainPanel; 
	JPanel buttomsPanel; 
	JTextField box; 
	
	public front() {
		//title
		setTitle("Calculadora JDT");
		
		//sise
		setSize(300,300); 
		
		//Location
		setLocationRelativeTo(null); 
		
		//outside
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		//ICON
		//setIconImage(new ImageIcon(getClass().getResource("URL image")).getImage());
		
		//Interface
		inter(); 
		
		//Visible
		setVisible(true); 
	}
	
	private void inter() {
		//Interface y functions 
		
		//Main Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//North text box
		box = new JTextField();
		mainPanel.add("North", box);
		
		//Center bottoms panel 
		buttomsPanel = new JPanel(); 
		buttomsPanel.setLayout(new GridLayout(5,4,8,8)); 
		mainPanel.add("Center", buttomsPanel);
		
		//Se agrega todo el contenido del panel principal apl panel del formulario
		getContentPane().add(mainPanel);
		
		//Metodo de Botones
		//bottonsAdd();
	}
}
