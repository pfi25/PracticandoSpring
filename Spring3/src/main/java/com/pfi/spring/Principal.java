package com.pfi.spring;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pfi.bean.AppConfig;
import com.pfi.bean.Factor;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JLabel lblSuma;
	
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtSuma;
	
	private int num1;
	private int num2;
	private int suma;
	
	private JButton btnCalcular; 

	public Principal() {
		
		this.setTitle("Suma en Spring");
		this.setBounds(300,300,400,300);
		this.setLayout(new FlowLayout());
		
		lblNum1 = new JLabel("Sumando 1: "); 
		txtNum1 = new JTextField(20);
		
		this.add(lblNum1);
		this.add(txtNum1);
		
		lblNum2 = new JLabel("Sumando 2: ");
		txtNum2 = new JTextField(20);
		
		this.add(lblNum2);
		this.add(txtNum2);
		
		lblSuma = new JLabel("Suma total: ");
		txtSuma = new JTextField(20);
		
		this.add(lblSuma);
		this.add(txtSuma);
		
		btnCalcular = new JButton("Sumar");
		this.add(btnCalcular);
		btnCalcular.addActionListener(new Oyente());
	}

	public static void main(String[] args) { 

		Principal ventana = new Principal();
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class Oyente implements ActionListener{

		private AnnotationConfigApplicationContext contexto;
		
		public void actionPerformed(ActionEvent e) {
			
			contexto = new AnnotationConfigApplicationContext();
			contexto.register(AppConfig.class);
			contexto.refresh(); 
				
			Factor obj1 = contexto.getBean(Factor.class);
			obj1.setSumando(Integer.parseInt(txtNum1.getText().trim()));
			num1 = obj1.getSumando();
			
			Factor obj2 = contexto.getBean(Factor.class);
			obj2.setSumando(Integer.parseInt(txtNum2.getText().trim()));
			num2 = obj2.getSumando();
			
			suma = num1 + num2;
			txtSuma.setText(String.valueOf(suma));
		}
		
	}
}
