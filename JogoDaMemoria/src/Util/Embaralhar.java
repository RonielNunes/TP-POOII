package Util;

import java.util.Random;
/*
 * @author Roniel Nunes
 */
public class Embaralhar {
        //remover dps, colletions é melhor
	public static void embaralhando(Object[] objetoEntrada){
		Random numero = new Random();
		for(int i = objetoEntrada.length - 1; i > 0; i--){
			int numeroAleatorio = numero.nextInt(i + 1);
			inverter(objetoEntrada, i, numeroAleatorio);
		}
	}
	private static void inverter(Object[] objetoEntrada, int i, int j){
		Object temporario = objetoEntrada[i];
		objetoEntrada[i] = objetoEntrada[j];
		objetoEntrada[j] = temporario;
	}

}
