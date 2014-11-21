package com.modelosredes.examenfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.modelosredes.examenfinal.server.ServerUtils;
import com.modelosredes.examenfinal.server.ServerUtils.LlaveDeFobinacciNoEstablecidaException;

public class AplicationUtils {
	
	/**
	 * TRUE - para mostrar mensajes del estado del programa en consola
	 * FALSE - para lo contrario XD
	 */
	public static final boolean DEBUG = true;
	
	
	/**
	 * UnionPasswordAndRandomMessage
	 * 
	 * Esta función **DEBE** ser llamada cuando **Y SOLO CUANDO** se hace un
	 * **LOGIN** ADEMAS se debe haber hecho la VALIDACIÓN PREVIA de la PASSWORD
	 */
	public static String UnionPasswordAndRandomMessage(String password,
			String ma) {
		if (password.equals("")  ||  password.length() > ServerUtils.PASSWORD_LENGHT_MAXIMO) 
			return "";
		

		// Convertimos el MA (String) a una Lista<String> para facilitar su
		// manipulación
		List<Character> lma = new ArrayList<>();
		for (int i = 0; i < ma.length(); i++) {
			lma.add(ma.charAt(i));
		}

		/** DEBUG */
		if (DEBUG) {
			System.out.print(lma.toString());
		}
		

		// Lo mismo para la password
		List<Character> lpass = new ArrayList<>();
		for (int i = 0; i < password.length(); i++) {
			lpass.add(password.charAt(i));
		}

		try {
			if (ServerUtils.getKeyFibonacci().size() == 0)
				ServerUtils.init_Fibonacci();
			List<Integer> keyfib = ServerUtils.getKeyFibonacci();

			int i = 0;
			for (Integer fibPos : keyfib) {

				// @param1 - Insertamos en la posición de fibonacci establecida
				// @param2 - Se inserta la letra de la password correspondiente
				lma.add(fibPos.intValue(), lpass.get(i));

				if (i == lpass.size() - 1) // Si estamos en el último caracter
											// de la contraseña
					break;

				i++;
			}
		} catch (LlaveDeFobinacciNoEstablecidaException e) {
			e.printStackTrace();
		}

		
		String resultado = getStringRepresentation(lma);
		
		/** DEBUG */
		if (DEBUG) {
			System.out.println(resultado);
		}
		
		return resultado;
	}

	
	/** Función auxiliar para conseguir de List<Character> => String */
	private static String getStringRepresentation(List<Character> list) {
		StringBuilder builder = new StringBuilder(list.size());
		for (Character ch : list) {
			builder.append(ch);
		}
		return builder.toString();
	}
}
