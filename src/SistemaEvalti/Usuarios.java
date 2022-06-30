package SistemaEvalti;

import java.sql.Date;

public class Usuarios {

	private int usuario_id;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private String correo_electronico;
	private String fecha;
	private int rol_id;
	private int activo;
	private boolean isActivo;
	private String contrasenia;
	private String rol;

	public Usuarios(int usuario_id, String nombre, String apellido, int telefono, String direccion,
			String correo_electronico, String fecha, int rol_id, int activo, String contrasenia) {

		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo_electronico = correo_electronico;
		this.fecha = fecha;
		this.rol_id = rol_id;
		this.activo = activo;
		this.contrasenia = contrasenia;
	
	}

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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

	public int getTelefono() {
		return telefono;
	}
	

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getRol() {
		if(rol == null) {
			return "Usuario";
		}
		
		
		return rol.toUpperCase();
		
	}
	

	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public int getActivo() {
		
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	public boolean getisActivo() {
		return isActivo;
	}
	
	public void setisActivo(boolean isActivo) {
		this.isActivo = isActivo;
	}

	@Override
	public String toString() {
		return "Usuarios [usuario_id=" + usuario_id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", direccion=" + direccion + ", correo_electronico=" + correo_electronico + ", fecha="
				+ fecha + ", rol_id=" + rol_id + ", activo=" + activo + ", contrasenia=" + contrasenia + "]";
	}

}
