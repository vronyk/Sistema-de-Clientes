package cl.veronica.sistemaDeClientes.servicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


import cl.veronica.sistemaDeClientes.modelo.Cliente;

public class ExportadorTxt extends Exportar{
	String nombreArchivo="";
	Scanner sc= new Scanner(System.in);
//////////////////////////////////////////////////////////////////////METODO PARA EXPORTAR DATOS
	@Override
	public void exportarDatos(List<Cliente> listaClientes) {
		System.out.println("Ingrese nombre del archivo txt a crear");
		nombreArchivo=sc.nextLine();
		//CREACION DEL ARCHIVO Y SU FORMATO CORRESPONDIENTE PARA EXPORTAR EN FORMATO TXT
		
	
				
				//ESCRIBIR ARCHIVO Y PASAR PARAMETROS
				try {
					
					File archivo = new File("C:/Users/hp/Desktop/"+nombreArchivo+".txt");//CREAMOS EL OBJETO FILE CON LA RUTA
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
				
				
				System.out.println("Archivo de Registro de Clientes en formato TXT creado exitosamente!!\n");
			
				
	}	
		
}
	
		
	

