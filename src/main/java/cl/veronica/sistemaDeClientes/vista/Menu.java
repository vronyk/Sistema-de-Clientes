package cl.veronica.sistemaDeClientes.vista;

import java.util.Scanner;

import cl.veronica.sistemaDeClientes.modelo.CategoriaEnum;
import cl.veronica.sistemaDeClientes.modelo.Cliente;
import cl.veronica.sistemaDeClientes.servicios.CargarDatos;
import cl.veronica.sistemaDeClientes.servicios.ClienteServicio;
import cl.veronica.sistemaDeClientes.servicios.ExportadorCsv;
import cl.veronica.sistemaDeClientes.servicios.ExportadorTxt;
import cl.veronica.sistemaDeClientes.utilidades.Utilidad;

public class Menu {
	
	private String fileName1 = "DBClientes.csv";
	
	Scanner sc=new Scanner(System.in);
	Scanner sc1=new Scanner(System.in);
	
	ClienteServicio nuevoServicio= new ClienteServicio();
	Utilidad nuevaUtilidad= new Utilidad();
	ExportadorTxt exportarTxt= new ExportadorTxt();
	ExportadorCsv exportarCsv= new ExportadorCsv();
	CargarDatos cargarDatos= new CargarDatos();
	
	public void menucliente() {
		
		
		String opcion="";
		while(!opcion.equals("6")) {
		System.out.println("***************");	
		System.out.println("  BON BON JOVI ");
		System.out.println("***************");
		System.out.println("1 Listar Cliente");
		System.out.println("2 Agregar Cliente");
		System.out.println("3 Editar Cliente");
		System.out.println("4 Cargar Datos");
		System.out.println("5 Exportar Datos");
		System.out.println("6 SALIR");
		System.out.println("Ingrese una opción");
		opcion=sc.next();
		
		switch(opcion) {
		case "1":
			nuevoServicio.listarCliente();
			nuevaUtilidad.limpiarPantalla();
			nuevaUtilidad.tiempoEspera();
			break;
			
		case "2":
			
			String runCliente="";
			while (!Utilidad.validaRut(runCliente)){
				
				System.out.println("Ingrese el RUN del cliente Ej 27011011-1");
				runCliente = sc1.nextLine();
				if (Utilidad.validaRut(runCliente)) {
					System.out.println("Run ingresado es correcto");
				} else {
					System.out.println("Run ingresado es incorrecto");
				}
				
			} ;
			
			System.out.println("------CREAR CLIENTE------");
			
			System.out.println("Ingresar Nombre del Cliente");
			String nombreCliente=sc1.next();
			System.out.println("Ingresar Apellido del Cliente");
			String apellidoCliente=sc1.next();
			System.out.println("Ingresar años como Cliente del Local");
			String aniosCliente=sc1.next();
			System.out.println("---------------------------");
			Cliente nuevoCliente =new Cliente(runCliente,nombreCliente,apellidoCliente,aniosCliente,CategoriaEnum.ACTIVO);
			nuevoServicio.agregarCliente(nuevoCliente);
			nuevaUtilidad.limpiarPantalla();
			
			break;
			
		case "3":
			nuevoServicio.editarCliente(nuevoServicio.getListaClientes());
			nuevaUtilidad.limpiarPantalla();
			
			break;
			
		case "4":
			
			cargarDatos.importarDatos(fileName1);
			nuevaUtilidad.limpiarPantalla();
			break;
		case "5":
			String op="";
			
			
			while(!opcion.equals("3")) {
				System.out.println("------FORMATO DE EXPORTACION------");
				System.out.println("Seleccione en que extension desea exportar el archivo: ");
				System.out.println("1. Exportar en formato txt");
				System.out.println("2. Exportar en formato csv");
				System.out.println("Ingrese una opcion");
				op=sc.next();
				switch(op) {
				case "1":
					
					exportarTxt.exportarDatos( nuevoServicio.getListaClientes());
					break;
				case "2":
					
					exportarCsv.exportarDatos(nuevoServicio.getListaClientes());
					break;
				
				default:
					System.out.println("No se reconoce la opcion ingresada");
					break;
				}
				
			}
			
			break;
			
		default:
			System.out.println("NO SE RECONOCE LA OPCION INGRESADA");
			break;
		}
		
		}
		if(opcion.equals("6")) {
			nuevoServicio.terminarPrograma();
		}
		sc.close();
	}
	

}
