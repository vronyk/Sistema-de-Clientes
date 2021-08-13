package cl.veronica.sistemaDeClientes.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidad {
	public void limpiarPantalla() {
		int saltos=5;
		for (int i = 0; i < saltos; i++) {
			System.out.println();
		}
		
	}
	 public void tiempoEspera() {
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	 }
	 
	 public static Boolean validaRut(String rut) {
			rut = rut.replace(".", "");
			Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
			Matcher matcher = pattern.matcher(rut);
			if (matcher.matches() == false)
				return false;
			String[] stringRut = rut.split("-");
			return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
		}

	 public static String dv(String rut) {
			Integer M = 0, S = 1, T = Integer.parseInt(rut);
			for (; T != 0; T = (int) Math.floor(T /= 10))
				S = (S + T % 10 * (9 - M++ % 6)) % 11;
			return (S > 0) ? String.valueOf(S - 1) : "k";
		
		}
}
