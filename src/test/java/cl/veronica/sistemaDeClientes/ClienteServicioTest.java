package cl.veronica.sistemaDeClientes;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import cl.veronica.sistemaDeClientes.modelo.CategoriaEnum;
import cl.veronica.sistemaDeClientes.modelo.Cliente;
import cl.veronica.sistemaDeClientes.servicios.ClienteServicio;

public class ClienteServicioTest {
	private static ClienteServicio nuevoServicio;
	private static Cliente nuevoCliente;
	
	@Before
	public void setUp() {
		nuevoServicio= new ClienteServicio();
	}
	
	@Test
	public void agregarClienteTest() {
		
		String runCliente ="11.111.111-1";
		String nombreCliente ="Edutecno";
		String apellidoCliente="Capacitacion";
		String aniosCliente="3";
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		
		nuevoCliente =new Cliente(runCliente,nombreCliente,apellidoCliente,aniosCliente,nombreCategoria);
		nuevoServicio.agregarCliente(nuevoCliente);
		assertEquals(nuevoServicio.getListaClientes().get(0).getNombreCliente(), "Edutecno");
		assertNull(nuevoServicio.getListaClientes().get(0).getNombreCliente(),null);
	}
	

}
