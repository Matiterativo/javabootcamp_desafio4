package com.javabootcamp_desafio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1 {

	public static void main(String[] args) {
		
		final String MENSAJE_INICIO_PROGRAMA = "CALCULADOR DE SUMA TOTAL, MINIMO Y MAXIMO \n" +
							"-----------------------------------------\n";
		final String MENSAJE_INGRESO_USUARIO = "Escriba un numero entero (0 para finalizar): ";
		final String MENSAJE_ERROR_TIPO_INVALIDO = "Error: debe ingresar un número entero";
		final String MENSAJE_FINALIZACION = "\nLa suma total es: %d \nEl numero mayor es: %d \nEl numero menor es: %d";
		int enteroIngresado=-1, suma=0, minimo=0, maximo=0;
		boolean primerIngreso = true;
		Scanner scanner = new Scanner(System.in);	
		
		System.out.println(MENSAJE_INICIO_PROGRAMA);

		do {
			
			try {
			
				System.out.print(MENSAJE_INGRESO_USUARIO);
				enteroIngresado = scanner.nextInt();
				
				if (enteroIngresado == 0) {
					break;
				}
				
				suma += enteroIngresado;
				
				//Inicializa "minimo" y "maximo" con el primer ingreso válido (distinto a 0), evitando resultados incorrectos para series como: 5, 0.
				if (primerIngreso) {
					minimo = enteroIngresado;
					maximo = enteroIngresado;
					primerIngreso = false;
				}
				
				if (enteroIngresado > maximo)  {
					maximo = enteroIngresado;
				}
				
				if (enteroIngresado < minimo) {
					minimo = enteroIngresado;
				}
				
			} catch (InputMismatchException e) {
				System.out.println(MENSAJE_ERROR_TIPO_INVALIDO);
				scanner.next();
			}
		} while (enteroIngresado != 0);
		
		System.out.printf(String.format(MENSAJE_FINALIZACION, suma, maximo, minimo));
		
		scanner.close();

	}
}
