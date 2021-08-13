package cl.veronica.sistemaDeClientes.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import cl.veronica.sistemaDeClientes.modelo.CategoriaEnum;
import cl.veronica.sistemaDeClientes.modelo.Cliente;

public class CargarDatos {
	public void importarDatos(String ruta) {
		
	File archivo = new File("C:/Users/hp/Desktop/"+ruta);
	ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();//SE GURDAN LOS DATOS DEL ARCHIVO CSV
	
	try {
		
		FileReader fileReader= new FileReader(archivo);
		BufferedReader bfReader = new BufferedReader(fileReader);
		
		String data= bfReader.readLine();//SE COMIENZA A LEER LA PRIMERA LINEA
		
		while(data!=null) {
			ArrayList <String> cargaData= new ArrayList<String>(Arrays.asList(data.split(",")));
			Cliente nuevoCliente =new Cliente(cargaData.get(0),cargaData.get(1),cargaData.get(2),cargaData.get(3),CategoriaEnum.valueOf(cargaData.get(4).toUpperCase()));
		listaClientes.add(nuevoCliente);	
		data= bfReader.readLine();
		}
		bfReader.close();
		fileReader.close();
		
	}catch(IOException e){
		
		e.printStackTrace();
	}
	
	for (Cliente clienteTemp : listaClientes) {
		System.out.println(clienteTemp.getRunCliente());
		System.out.println(clienteTemp.getNombreCliente());
		System.out.println(clienteTemp.getApellidoCliente());
		System.out.println(clienteTemp.getAniosCliente());
		System.out.println(clienteTemp.getNombreCategoria());
		System.out.println("\n");
	}
	System.out.println("Datos cargados correctamente en la lista");
	
	
}


}
