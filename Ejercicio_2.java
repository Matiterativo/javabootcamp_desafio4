package com.javabootcamp_desafio4;

import java.util.Scanner;

public class Ejercicio_2 {
	
	public static void main(String[] args) {
	
		final String MENSAJE_INICIO ="CONTADOR DE CARACTER DE MAYOR FRECUENCIA" +
									"\n------------------------------------------" +
									"\nNota: ante frecuencias repetidas se muestra " +
									"\nel primer caracter según tabla UNICODE UTF-16.\n";
		final String MENSAJE_INGRESO_ORACION = "Indique la oración a evaluar (no puede ser vacía): ";
		final String MENSAJE_RESULTADO = "El caracter [%c] se repite %d veces";
		final int maxCharValue = 65535;		
		char caracterMaximo=0;
		int repeticionesMaximas=0;
		String oracion="";
		int[] repeticiones = new int[maxCharValue];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(MENSAJE_INICIO);

		do {		
			
			System.out.println(MENSAJE_INGRESO_ORACION);
			oracion = scanner.nextLine();
			oracion = oracion.trim().replace(" ","");
			
		} while (oracion.length() == 0);
		
		for (int i=0; i< oracion.length();i++) {
			repeticiones[oracion.charAt(i)]++;
		}
		
		for (int i=0; i < repeticiones.length; i++) {			
			if (repeticiones[i] > repeticionesMaximas) {
				caracterMaximo = (char)i;
				repeticionesMaximas= repeticiones[i];
			}
		}
		
		System.out.print(String.format(MENSAJE_RESULTADO, caracterMaximo, repeticionesMaximas));		
		scanner.close();
	}

}
