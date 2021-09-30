
public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String cp;
	
	public Cliente(String dni, String nombre, String apellido, String cp) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cp = cp;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

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

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
	
	
	
	
}
