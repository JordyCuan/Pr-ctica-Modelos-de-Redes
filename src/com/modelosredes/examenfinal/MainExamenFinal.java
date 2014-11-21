package com.modelosredes.examenfinal;

import java.util.Arrays;

import com.modelosredes.examenfinal.ServerUtils.LlaveDeFobinacciNoEstablecidaException;
import com.modelosredes.examenfinal.encriptacion.AplicacionUtiles;

public class MainExamenFinal {
	/**
	 * Clase de Pruebas MAIN
	 * @throws LlaveDeFobinacciNoEstablecidaException 
	 */
	public static void main(String[] args) throws LlaveDeFobinacciNoEstablecidaException {
		String strConvetir = "Jordy Joaquin Cuan Robledo";
		System.out.println("La String a convertir es: " + strConvetir);
		String n = AplicacionUtiles.encrypt(strConvetir);
		System.out.println("La String encriptada es: " + n);
		System.out.println("La String desencriptada es: "
				+ AplicacionUtiles.decrypt(n));
		System.out.println();

		System.out.println("Convertida a MD5: "
				+ AplicacionUtiles.md5(strConvetir) + "\n");

		System.out.println("Mensaje Aleatorio:\n"
				+ ServerUtils.getRandomString(1) + "\n\n");

		ServerUtils.init_Fibonacci();
		System.out.println("\n\n***Serie de fibonacci a usar en el programa (18)"
				+ "(" + ServerUtils.getKeyFibonacci().length + "):" + "\n" + 
				Arrays.asList(ServerUtils.getKeyFibonacci()));
	}
}
