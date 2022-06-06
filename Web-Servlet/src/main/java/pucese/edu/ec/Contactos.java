package pucese.edu.ec;

public class Contactos {
	
	private String nombre, apellido, telefono;

	public Contactos() {
		
	}
	
	public Contactos(String nombre, String apellido, String telefono) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
	}
	
	//getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//toString
	@Override
	public String toString() {
		return "Contactos [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
	}
	

	
	
	
}
