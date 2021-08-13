package cl.veronica.sistemaDeClientes.servicios;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cl.veronica.sistemaDeClientes.modelo.Cliente;

public class ExportadorCsv extends Exportar{
	String nombreArchivo="";
	Scanner sc = new Scanner(System.in);
	@Override
	public void exportarDatos( List<Cliente> listaClientes) {
		System.out.println("Ingrese nombre del archivo csv a crear");
		nombreArchivo=sc.nextLine();
		
		//ESCRIBIR ARCHIVO Y PASAR PARAMETROS
		try {
			
			File archivo = new File("C:/Users/hp/Desktop/"+nombreArchivo+".csv");//CREAMOS EL OBJETO FILE CON LA RUTA
			FileWriter fileWriter= new FileWriter(archivo); //ARCHIVO DE TIPO FW
			BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);//OBJETO A ESCRIBIR EN LA CLASE BW
			if(!archivo.exists()) {
				archivo.createNewFile();
			}else {
				for (Cliente clienteTemp : listaClientes) {
					bufferedWriter.write("Descripcion del Cliente: \n");
					bufferedWriter.write("Run: "+clienteTemp.getRunCliente()+"\n");
					bufferedWriter.write("Nombre: "+clienteTemp.getRunCliente()+"\n");
					bufferedWriter.write("Apellido: "+clienteTemp.getRunCliente()+"\n");
					bufferedWriter.write("Años como cliente: "+clienteTemp.getRunCliente()+"\n");
					bufferedWriter.write("Estado: "+clienteTemp.getRunCliente()+"\n");
					bufferedWriter.write("Estado: "+clienteTemp.getRunCliente()+"\n");
					
					bufferedWriter.newLine();
					
				}
				
			}
			
			bufferedWriter.close();
			fileWriter.close();
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("HA SUCEDIDO UN ERROR EN LA CREACION O LECTUTRA DEL FICHERO");
		}
		//METODO DE LECTURA DEL ARCHIVO POR CONSOLA
		/*try {
			File archivo= new File("C:/Users/hp/Desktop/"+nombreArchivo+".csv");
			FileReader fileReader= new FileReader(archivo);
			BufferedReader bfReader = new BufferedReader(fileReader);
			
			String data= bfReader.readLine();
			while(data!=null) {
				System.out.println(data);
				data= bfReader.readLine();
			}
			bfReader.close();
			fileReader.close();
			
		}catch(IOException e){
			
			e.printStackTrace();
		}*/
		
		System.out.println("Archivo de Registro de Clientes en formato CSV creado exitosamente!!\n");
		
	}
	

}
