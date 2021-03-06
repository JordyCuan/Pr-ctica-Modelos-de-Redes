package com.modelosredes.examenfinal.encriptacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;

import org.apache.commons.codec.binary.Base64;

/**
 * Clase con utilidades sobre la encriptaci�n
 * 
 * @author jordycuan
 */
public class EncriptationUtiles {
	
	/**
	 * Definimos un array de Keys que usar� nuestro algoritmo de encriptaci�n
	 */
	private static byte[] key = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41,
			0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79 };

	/**
	 * M�todo de encriptaci�n de una String utilizando AES
	 * 
	 * @param strToEncrypt
	 * @return String encriptada del texto proporcionado
	 */
	public static String AES_encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			final String encryptedString = Base64.encodeBase64String(cipher
					.doFinal(strToEncrypt.getBytes()));
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * M�todo de desencriptaci�n de una String utilizando AES
	 * 
	 * NOTA: Este m�todo desencripta strings que hayan sido encriptadas con un
	 * algoritmo de 'AES'
	 * 
	 * @param strToDecrypt
	 * @return String desencriptada del texto proporcionado
	 */
	public static String AES_decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			final String decryptedString = new String(cipher.doFinal(Base64
					.decodeBase64(strToDecrypt)));
			return decryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	/****
	 * Algoritmo MD5
	 * 
	 * @param clear Cadena a convertir a MD5
	 * @return String en formato MD5
	 */
	public static String md5(String clear) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] b = md.digest(clear.getBytes());

			int size = b.length;
			StringBuffer h = new StringBuffer(size);
			for (int i = 0; i < size; i++) {
				int u = b[i] & 255;
				if (u < 16) {
					h.append("0" + Integer.toHexString(u));
				} else {
					h.append(Integer.toHexString(u));
				}
			}
			return h.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	
	
	/****
	 * Encuentra el numero primo proximo mayor o igual al numero dado (2147483124)
	 */
	public static long primo(long num) {

		while (true) {
			int contador = 2;
			boolean esPrimo = true;

			while ((esPrimo) && (contador <= num / 2)) {
				if (num % contador == 0)
					esPrimo = false;
				contador++;
			}
			if (esPrimo)
				return num;
			num++;
		}
	}
}