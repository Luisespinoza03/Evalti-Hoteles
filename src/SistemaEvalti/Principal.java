package SistemaEvalti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Table;

import conectorBD.MySQLConexion;

public class Principal {

	Menu menu = new Menu();
	// public static ArrayList<Usuarios> listaprod;

	// login
	public Usuarios obtenerUser(Usuarios usu) {
		Usuarios usuarios = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = MySQLConexion.getConexion();
			String sql = "select * from usuarios where correo_electronico = ? and contrasenia = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getCorreo_electronico());
			pst.setString(2, usu.getContrasenia());
			rs = pst.executeQuery();

			while (rs.next()) {
				usuarios = new Usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en obtener usuario");
		}
		return usuarios;
	}

	public static ArrayList<Usuarios> listarUsuarios() {

		Usuarios usuarios = null;

		Connection con;

		ResultSet rs = null;
		MySQLConexion acceso = new MySQLConexion();
		PreparedStatement pst = null;
		ArrayList<Usuarios> listaprod = null;
		try {

			String sql = "SELECT * FROM usuarios " + " LEFT JOIN roles ON usuarios.rol_id = roles.rol_id ";

			pst = acceso.getConexion().prepareStatement(sql);
			listaprod = new ArrayList<>();
			rs = pst.executeQuery();

			while (rs.next()) {
				Usuarios p = new Usuarios();
				p.setUsuario_id(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				p.setTelefono(rs.getInt(4));
				p.setDireccion(rs.getString(5));
				p.setCorreo_electronico(rs.getString(6));
				p.setFecha(rs.getString(7));
				p.setRol_id(rs.getInt(8));
				p.setActivo(rs.getInt(9));
				p.setContrasenia(rs.getString(10));
				p.setRol(rs.getString(12));
				listaprod.add(p);

			}

		} catch (Exception e) {
			// TODO: handle exception

			// System.out.println(e);
			System.out.println("Error en obtener usuario");
		}
		return listaprod;

	}

	public static void agregar(Usuarios usuarios) {
		Connection con;
		MySQLConexion mysqlConexion = new MySQLConexion();
		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO usuarios(nombre,apellido,telefono,direccion,correo_electronico,fecha_nacimiento,activo,contrasenia)VALUES"
				+ "(?,?,?,?,?,?,?,?)";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
     
     
        
		try {
			con = mysqlConexion.getConexion();
			preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, usuarios.getNombre());
			preparedStatement.setString(2,usuarios.getApellido());
			preparedStatement.setInt(3, usuarios.getTelefono());
			preparedStatement.setString(4, usuarios.getDireccion());
			preparedStatement.setString(5, usuarios.getCorreo_electronico());
			preparedStatement.setDate(6, new java.sql.Date(format.parse(usuarios.getFecha()).getTime()));
		
			
			
			int activo = 0;
			if(usuarios.getisActivo() ) {
				activo = 1;
			}
		
			preparedStatement.setInt(7, activo);
			preparedStatement.setString(8, usuarios.getContrasenia());
			preparedStatement.execute();

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);
		}
	}
	
	
	public static void eliminar(int  id){
		Connection con;
		MySQLConexion mysqlConexion = new MySQLConexion();
		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM usuarios WHERE usuario_id=?";
		
		try {
			con = mysqlConexion.getConexion();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}
