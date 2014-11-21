package com.modelosredes.examenfinal.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.modelosredes.examenfinal.AplicationUtils;


/**
 * Clase con utilidades sobre el SERVER
 * 
 * @author jordycuan
 */
public class ServerUtils {

	/**
	 * ENUM - Empleado para definir las acciones del servidor
	 */
	public enum ACCION_SERVIDOR {
		ALTA_USER, INICIAR_SESION, ENVIAR_MENSAJE
	};

	/**
	 * Longitud del mensaje aleatorio solicitada por el profesor
	 */
	public static final int LONGITUD_MA_4096 = 4096;

	/**
	 * Generación de Mensaje Aleatorio
	 */
	public static String getRandomString(int length) {

		// Comentar esta linea si se quiere usar otra longitud
		length = LONGITUD_MA_4096;

		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	/**
	 * Lista donde se guardará la llave de Fibonacci
	 */
	private static List<Integer> KEY_Fibonacci = new ArrayList<Integer>();

	public static final int PASSWORD_LENGHT_MAXIMO = 18;

	/**
	 * Generación de la LLave de Fibonacci
	 */
	public static void init_Fibonacci(/* int n */) {
		int n = PASSWORD_LENGHT_MAXIMO;
		KEY_Fibonacci = new ArrayList<Integer>();
		fib(n);
	}

	/**
	 * Método que crea la serie de fib. Hace el llenado de nuestra lista/key
	 * fibonacci
	 */
	private static void fib(int n) {
		if (n <= 1) {
			KEY_Fibonacci.add(1); // Le añadimos un uno y ahí muere
			return;
		}

		// Un poquito de seguridad (algo sucio)
		if (n > 18)
			n = 18;

		for (int i = 1; i <= n; i++) {
			KEY_Fibonacci.add(fib_aux(i)); // añadimos toda la suceción debida
		}
	}

	/**
	 * Método que genera el valor de fibonacci respectivo a la posición n dada
	 * como parametro
	 * 
	 * @param i Posición en la serie de fibonacci a buscar
	 * @return int Valor que se tiene al evaluar Fibonacci(i)
	 */
	private static int fib_aux(int i) {
		double y = (1 + Math.sqrt(5)) / 2.0;
		double z = Math.pow(y, i) * (1.0 / Math.sqrt(5));

		/** DEBUG */
		if (AplicationUtils.DEBUG) {
			System.out.println("#" + i + " - " + z + " - " + Math.round(z));
		}
		

		return (int) Math.round(z);
	}

	/**
	 * Función que devuelve la llave de los valores de fibonacci que serán
	 * utilizados dentro del mensaje aleatorio
	 * 
	 * @return int[] = 1,1,2,3,5,8,13 ... fib(n)
	 * @throws LlaveDeFobinacciNoEstablecidaException
	 */
	public static List<Integer> getKeyFibonacci()
			throws LlaveDeFobinacciNoEstablecidaException {
		if (KEY_Fibonacci.size() == 0) {
			/**
			 * Esta excepción es mandada porque queremos que el
			 * usuario/programador verifique el campo de la serie a producir y
			 * su longitud. Si ya se diera todo por hecho (que la longitud
			 * siempre será 18), bastaría con mandar a llamar aquí la función
			 * init en lugar de lanzar la Exception.
			 */
			throw new LlaveDeFobinacciNoEstablecidaException(
					"LlaveDeFobinacciNoEstablecidaException: "
							+ "Debes settear la llave primero");
		}

		
		
		
		/*
		// FUCK THAT!!! >_<
		// http://stackoverflow.com/questions/9572795/convert-list-to-array-in-java
		Integer[] array = new Integer[KEY_Fibonacci.size()];
		for (int i = 0; i < KEY_Fibonacci.size(); i++) {
			array[i] = KEY_Fibonacci.get(i);
		}

		return array;
		*/
		
		
		// Mejor usemos una lista dinámica. Usemos tipos no primitivos
		return KEY_Fibonacci;
	}

	/**
	 * Clase interna para llevar un mejor control con los números
	 * 
	 * @author jordycuan
	 */
	public static class LlaveDeFobinacciNoEstablecidaException extends Exception {
		public LlaveDeFobinacciNoEstablecidaException() {
			super();
		}

		public LlaveDeFobinacciNoEstablecidaException(String message) {
			super(message);
		}

		public LlaveDeFobinacciNoEstablecidaException(String message,
				Throwable cause) {
			super(message, cause);
		}

		public LlaveDeFobinacciNoEstablecidaException(Throwable cause) {
			super(cause);
		}
	}
}
