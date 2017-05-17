package prueba.repuestos.storage;

import java.util.ArrayList;
import java.util.List;

import prueba.repuestos.cliente.Cliente;

public class DummyStorage implements Storage {
	//declaracion vector que contendra los clientes
	private List<Cliente> clientes;
	
	public DummyStorage (){
		//iniciacion del vector como un Array list
		clientes=new ArrayList<>();
		
		//contador para generar identificadores unicos
		long id=0;
		
		
		//crea el primer cliente
		Cliente c=new Cliente();
		c.setTipoDoc("CI");
		c.setNroDoc("999999");
		c.setPassword("123");
		c.setNombre("Ale Villnueva");
		//aumento del contador, antes 0 ahora 1
		c.setId(++id);
		
		//agregar el cliente al vector
		clientes.add(c);
		
		//crear segundo cliente
		Cliente c2=new Cliente();
		c2.setTipoDoc("CI");
		c2.setNroDoc("888888");
		c2.setPassword("789");
		c2.setNombre("Otro cliente");
		//vuelve a aumentar el contador, antes 1 ahora 2
		c2.setId(++id);
		
		//agregar segundo cliente
		clientes.add(c2);
	
	}
	
	@Override
	public Cliente obtCliente(String tipoDoc, String norDoc, String password) {
		//Recorro el vector, asignado cada miembre a la variable "c"
		
		for(Cliente c: clientes){
			//Comparo los tres valores con los recibidos por párametros, si coincden, retorno el cliente
			//el método equals compara dos String, el operador &&  signific and 
			if(c.getTipoDoc().equals(tipoDoc) && c.getNroDoc().equals(norDoc) && c.getPassword().equals(password)){
				return c;
			}
		}
		//si no se encontraron coincidencia se retorna null
		return null;
	}
	
	//prueba de la clase
	public static void main(String[] ards){
	
		//creo una instaci de la clase DummyStorage
		Storage s=new DummyStorage();
		//Obtengo el primer cliente
		Cliente c=s.obtCliente("CI", "999999", "123");
		//imprimo en consola si es null (no encontro cliente)
		System.out.println("Es null: " + (c==null));
		//Imprimio el nombre del cliente si no es null
		if(c!=null) System.out.println("Nombre del cliente: " + c.getNombre());
		else System.out.println("No se encontro el cliente");
	
		//otro cliente
		//Obtengo el segundo cliente
				Cliente c2=s.obtCliente("CI", "888888", "789");
				//imprimo en consola si es null (no encontro cliente)
				System.out.println("Es null: " + (c2==null));
				//Imprimio el nombre del cliente si no es null
				if(c2!=null) System.out.println("Nombre del cliente: " + c2.getNombre());
				else System.out.println("No se encontro el cliente");
		
				//ahora un cliente que no exista
				
				//Obtengo el primer cliente
				Cliente c3=s.obtCliente("CI", "111111", "123");
				//imprimo en consola si es null (no encontro cliente)
				System.out.println("Es null: " + (c3==null));
				//Imprimio el nombre del cliente si no es null
				if(c3!=null) System.out.println("Nombre del cliente: " + c3.getNombre());
				else System.out.println("No se encontro el cliente");
	}

}