package prueba.repuestos.storage;

import prueba.repuestos.cliente.Cliente;

public interface Storage {
	
	Cliente obtCliente(String tipoDoc, String norDoc, String password);
	

}
