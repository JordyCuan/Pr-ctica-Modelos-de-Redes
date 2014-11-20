package com.modelosredes.examenfinal;

import com.modelosredes.examenfinal.encriptacion.AplicacionUtiles;

public class MainExamenFinal {
	/**
	 * Clase de Pruebas MAIN
	 */
	public static void main(String[] args) {
		String strConvetir = "Jordy Joaquin Cuan Robledo";
		System.out.println("La String a convertir es: " + strConvetir);
		String n = AplicacionUtiles.encrypt(strConvetir);
		System.out.println("La String encriptada es: " + n);
		System.out.println("La String desencriptada es: " + AplicacionUtiles.decrypt(n));
		System.out.println();
		
		System.out.println("Convertida a MD5: " + AplicacionUtiles.md5(strConvetir));
		
		System.out.println("Mensaje Aleatorio:\n" + AplicacionUtiles.getRandomString(1));
	}
}
