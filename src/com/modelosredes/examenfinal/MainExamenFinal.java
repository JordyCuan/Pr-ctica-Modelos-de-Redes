package com.modelosredes.examenfinal;

import com.modelosredes.examenfinal.encriptacion.EncriptationUtiles;
import com.modelosredes.examenfinal.server.ServerUtils;
import com.modelosredes.examenfinal.server.ServerUtils.LlaveDeFobinacciNoEstablecidaException;

public class MainExamenFinal {
	/**
	 * Clase de Pruebas MAIN
	 * 
	 * @throws LlaveDeFobinacciNoEstablecidaException
	 */
	public static void main(String[] args)
			throws LlaveDeFobinacciNoEstablecidaException {
		String strConvetir = "Jordy Joaquin Cuan Robledo";
		System.out.println("La String a convertir es: " + strConvetir);
		String n = EncriptationUtiles.AES_encrypt(strConvetir);
		System.out.println("La String encriptada es: " + n);
		System.out.println("La String desencriptada es: "
				+ EncriptationUtiles.AES_decrypt(n));
		System.out.println();

		System.out.println("Convertida a MD5: "
				+ EncriptationUtiles.md5(strConvetir) + "\n");

		String menAle = ServerUtils.getRandomString(1);
		System.out.println("Mensaje Aleatorio:\n"
				+ menAle + "\n\n");

		ServerUtils.init_Fibonacci();
		/*
		 * System.out.println("\n\n***Serie de fibonacci a usar en el programa (18)"
		 * + "(" + ServerUtils.getKeyFibonacci().length + "):" + "\n" +
		 * Arrays.asList(ServerUtils.getKeyFibonacci()));
		 */
		System.out
				.println("\n\n***Serie de fibonacci a usar en el programa (18)"
						+ "(" + ServerUtils.getKeyFibonacci().size() + "):"
						+ "\n" + ServerUtils.getKeyFibonacci().toString());

		
		// Donde se vean asteriscos en el MA es donde se insertarían los caracteres
		System.out.println(AplicationUtils.UnionPasswordAndRandomMessage("***************",
				menAle));
	}
}
