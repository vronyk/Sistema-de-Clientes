package cl.veronica.sistemaDeClientes.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cl.veronica.sistemaDeClientes.modelo.CategoriaEnum;
import cl.veronica.sistemaDeClientes.modelo.Cliente;


public class ClienteServicio {
	static Scanner sc1 = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	
	 List<Cliente> listaClientes; 
   
   //CONSTRUCTOR CON PARAMETROS
   public ClienteServicio(List<Cliente> listaClientes) {
		
		this.listaClientes = listaClientes;
	}
   //CONSTRUCTOR VACIO
   public ClienteServicio() {
		
		listaClientes= new ArrayList<Cliente>();
	}
   //GETTERS Y SETTERS DE LOS ARRAYLIST
   public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
   
   
   
	///////////////////////////////////////////METODO PARA LISTAR CLIENTES
	public  List<Cliente>  listarCliente() {
		if(!listaClientes.isEmpty()) {
			for (Cliente clienteTemp : listaClientes) {
				System.out.println("------DATOS CLIENTE------");
				System.out.println("Nombre del Cliente: "+clienteTemp.getNombreCliente());
				System.out.println("Apellido del Cliente: "+clienteTemp.getApellidoCliente());
				System.out.println("Run del Cliente: "+clienteTemp.getRunCliente());
				System.out.println("Años como Cliente: "+clienteTemp.getAniosCliente());
				System.out.println("Estado del Cliente: "+clienteTemp.getNombreCategoria());
				System.out.println("--------------------------");
			}
			
		}else {
			System.out.println("No existen Clientes registrados");
			System.out.println("Si desea agregar un Cliente seleccione la opcion 2");
			
		}
		return listaClientes;
		
	}
	
	///////////////////////////////////////////////METODO PARA AGREGAR CLIENTES
	public void agregarCliente(Cliente nuevoCliente) {
		
		
		if (listaClientes != null) {
			listaClientes.add(nuevoCliente);
		} else {
			listaClientes = new ArrayList<Cliente>();
			listaClientes.add(nuevoCliente);
		}
		
		System.out.println("******Cliente agregado*******");
		
	}
	////////////////////////////////////////////METODO PARA EDITAR CLIENTES
	public List<Cliente>  editarCliente(List<Cliente> listaClientes) {
		String op ="";
		String rut_aux="";
		while(!op.equals("3")) {
			System.out.println("------EDITAR CLIENTE------");
			System.out.println("Seleccione que desea hacer: ");
			System.out.println("1. Cambiar Estado del Cliente");
			System.out.println("2. Editar datos del Cliente");
			System.out.println("3. Volver al menu principal");
			System.out.println("Ingrese una opcion");
			op=sc1.next();
			switch(op) {
			case "1"://CAMBIAR ESTADO DEL CLIENTE
				System.out.println("Ingrese el RUN del Cliente para cambiar su estado");
				rut_aux=sc2.next();
				for (Cliente clienteTemp1 : listaClientes) {
					if(clienteTemp1.getRunCliente().equals(rut_aux)) {
						System.out.println("------ACTUALIZANDO ESTADO DEL CLIENTE------");
						System.out.println("Estado actual del Cliente: "+ clienteTemp1.getNombreCategoria());
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.-Si desea mantener el estado del cliente Activo");
						System.out.println("Ingrese una opcion");
						System.out.println("-------------------------------------------");
						String opcion=sc1.next();
						switch(opcion) {
						case "1":
							
							clienteTemp1.setNombreCategoria(CategoriaEnum.INACTIVO);
							System.out.println("------ACTUALIZANDO DATOS DEL CLIENTE-----");
							System.out.println("Nombre: "+clienteTemp1.getNombreCliente());
							System.out.println("Apellido: "+ clienteTemp1.getApellidoCliente());
							System.out.println("Run del Cliente: "+clienteTemp1.getRunCliente());
							System.out.println("Años como Cliente de nuestro Local: "+clienteTemp1.getAniosCliente());
							System.out.println("Estado: " + CategoriaEnum.INACTIVO);
							System.out.println("-------------------------------");
							
							break;
						case "2":
							//SE MANTIENE EL ESTADO DEL CLIENTE 
							
							break;
						default:
							System.out.println("No se reconoce la opcion ingresada");
							editarCliente(listaClientes);//LO DEVUELVE AL INICIO DEL METODO EDITAR
						
						}
						System.out.println("Estado del cliente modificado exitosamente!!");
						System.out.println("------ESTADO DEL CLIENTE MODIFICADO-----");
						System.out.println("Nombre: "+clienteTemp1.getNombreCliente());
						System.out.println("Apellido: "+ clienteTemp1.getApellidoCliente());
						System.out.println("Run del Cliente: "+clienteTemp1.getRunCliente());
						System.out.println("Años como Cliente de nuestro Local: "+clienteTemp1.getAniosCliente());
						System.out.println("Estado: " + clienteTemp1.getNombreCategoria());
						System.out.println("-------------------------------");
					}else {
						System.out.println("El RUN ingresado no se encuentra registrado");
					}
					
				}
				break;
			case "2"://EDITAR DATOS DEL CLIENTE
				System.out.println("Ingrese el RUN del Cliente para editar sus datos");
				rut_aux=sc2.next();
				String nuevoDato;
				for (Cliente clienteTemp2 : listaClientes) {
					if(clienteTemp2.getRunCliente().equals(rut_aux)) {
						System.out.println("------CLIENTE ACTUAL------");
						System.out.println("1. Nombre Del Cliente: "+ clienteTemp2.getNombreCliente());
						System.out.println("2. Apellido del Cliente: "+clienteTemp2.getApellidoCliente());
						System.out.println("3. Run del Cliente: "+clienteTemp2.getRunCliente());
						System.out.println("4. Años como cliente de nuestro Local: "+clienteTemp2.getAniosCliente());
						System.out.println("---------------------------");
						System.out.println("Ingrese que atributo desea modificar");
						String cambio= sc2.next();
						switch(cambio) {
						case "1":
							System.out.println("Ingrese el nuevo Nombre del Cliente");
							nuevoDato=sc2.next();
							clienteTemp2.setNombreCliente(nuevoDato);
							break;
						case "2":
							System.out.println("Ingrese el nuevo Apellido del Cliente");
							nuevoDato=sc2.next();
							clienteTemp2.setApellidoCliente(nuevoDato);
							break;
						case "3":
							System.out.println("Ingrese el nuevo Run del Cliente");
							nuevoDato=sc2.next();
							clienteTemp2.setRunCliente(nuevoDato);
							break;
						case "4":
							System.out.println("Edite los años como cliente de nuestro Local");
							nuevoDato=sc2.next();
							clienteTemp2.setAniosCliente(nuevoDato);
							break;
						default :
							System.out.println("No se reconoce la opcion ingresada");
							break;
						}
						System.out.println("Datos del cliente editados exitosamente!!");
						System.out.println("------CLIENTE EDITADO------");
						System.out.println("1. Nombre Del Cliente: "+ clienteTemp2.getNombreCliente());
						System.out.println("2. Apellido del Cliente: "+clienteTemp2.getApellidoCliente());
						System.out.println("3. Run del Cliente: "+clienteTemp2.getRunCliente());
						System.out.println("4. Años como clinet de nuestro Local: "+clienteTemp2.getAniosCliente());
						System.out.println("4. Estado como Cliente: "+clienteTemp2.getNombreCategoria());
						System.out.println("----------------------------");
					}
				}
				break;
			default:
				break;
			}
		}
		
		if(op.equals("3")){
			editarCliente(listaClientes);
			
		}
		
		return listaClientes;
		
		
	}
	
	
	//METODO PARA SALIR
	public void  terminarPrograma() {
		System.exit(0);
	}


}
