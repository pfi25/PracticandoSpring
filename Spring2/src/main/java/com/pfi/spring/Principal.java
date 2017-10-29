package com.pfi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfi.bean.Factores;

public class Principal {

	public static void main(String[] args) { 

		ApplicationContext contexto = new ClassPathXmlApplicationContext("com/pfi/xml/beans.xml");
		Factores f1 = (Factores)contexto.getBean("a");
		Factores f2 = (Factores)contexto.getBean("b");
		
		System.out.println("suma = " + (f1.getA() + f2.getB()));
		System.out.println("resta = " + (f1.getA() - f2.getB()));
		System.out.println("division = " + (f1.getA() / f2.getB()));
		System.out.println("multiplicacion = " + (f1.getA() * f2.getB()));
		
		((ConfigurableApplicationContext)contexto).close();
	}

}
