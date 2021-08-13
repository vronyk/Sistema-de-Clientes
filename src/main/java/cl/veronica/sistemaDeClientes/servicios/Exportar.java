package cl.veronica.sistemaDeClientes.servicios;


import java.util.List;

import cl.veronica.sistemaDeClientes.modelo.Cliente;

public abstract class Exportar {
	public abstract void exportarDatos( List<Cliente>listaClientes);

}
