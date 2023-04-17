package Dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Paciente;

import Util.ConnectionGeneric;
import Util.QueryGeneric;

public class PacienteDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QueryGeneric<Paciente> query;

	public PacienteDao() {
	}

	public List<Paciente> list() {
		this.query = new QueryGeneric<Paciente>();
		this.query.setQuery("SELECT * FROM paciente");
		this.query.setList(new ArrayList<Paciente>());
		try {
			this.query.setPs(ConnectionGeneric.getC().prepareStatement(this.query.getQuery()));
			this.query.setRs(this.query.getPs().executeQuery());
			while (this.query.getRs().next()) {
				this.query.setEntity(new Paciente());
				this.query.getEntity().setId(this.query.getRs().getInt(1));
				this.query.getEntity().setDocumento(this.query.getRs().getString(2));
				this.query.getEntity().setNombre(this.query.getRs().getString(3));
				this.query.getEntity().setApellido(this.query.getRs().getString(4));
				this.query.getEntity().setEmail(this.query.getRs().getString(5));
				this.query.getEntity().setGenero(this.query.getRs().getString(6));
				this.query.getEntity().setFechanacimiento(this.query.getRs().getDate(7));
				this.query.getEntity().setTelefono(this.query.getRs().getString(8));
				this.query.getEntity().setDireccion(this.query.getRs().getString(9));
				this.query.getEntity().setPeso(this.query.getRs().getDouble(10));
				this.query.getEntity().setEstatura(this.query.getRs().getDouble(11));
				this.query.getList().add(this.query.getEntity());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// ConnectionGeneric.close();
		}
		return this.query.getList();
	}
	
	public List<Paciente> list(String id) {
		this.query = new QueryGeneric<Paciente>();
		this.query.setQuery("SELECT * FROM paciente WHERE id = "+id);
		this.query.setList(new ArrayList<Paciente>());
		try {
			this.query.setPs(ConnectionGeneric.getC().prepareStatement(this.query.getQuery()));
			this.query.setRs(this.query.getPs().executeQuery());
			while (this.query.getRs().next()) {
				this.query.setEntity(new Paciente());
				this.query.getEntity().setId(this.query.getRs().getInt(1));
				this.query.getEntity().setDocumento(this.query.getRs().getString(2));
				this.query.getEntity().setNombre(this.query.getRs().getString(3));
				this.query.getEntity().setApellido(this.query.getRs().getString(4));
				this.query.getEntity().setEmail(this.query.getRs().getString(5));
				this.query.getEntity().setGenero(this.query.getRs().getString(6));
				this.query.getEntity().setFechanacimiento(this.query.getRs().getDate(7));
				this.query.getEntity().setTelefono(this.query.getRs().getString(8));
				this.query.getEntity().setDireccion(this.query.getRs().getString(9));
				this.query.getEntity().setPeso(this.query.getRs().getDouble(10));
				this.query.getEntity().setEstatura(this.query.getRs().getDouble(11));
				this.query.getList().add(this.query.getEntity());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// ConnectionGeneric.close();
		}
		return this.query.getList();
	}
	
	public Paciente find(String id) {
		this.query = new QueryGeneric<Paciente>();
		this.query.setQuery("SELECT * FROM paciente WHERE id = "+id);
		try {
			this.query.setPs(ConnectionGeneric.getC().prepareStatement(this.query.getQuery()));
			this.query.setRs(this.query.getPs().executeQuery());
			while (this.query.getRs().next()) {
				this.query.setEntity(new Paciente());
				this.query.getEntity().setId(this.query.getRs().getInt(1));
				this.query.getEntity().setDocumento(this.query.getRs().getString(2));
				this.query.getEntity().setNombre(this.query.getRs().getString(3));
				this.query.getEntity().setApellido(this.query.getRs().getString(4));
				this.query.getEntity().setEmail(this.query.getRs().getString(5));
				this.query.getEntity().setGenero(this.query.getRs().getString(6));
				this.query.getEntity().setFechanacimiento(this.query.getRs().getDate(7));
				this.query.getEntity().setTelefono(this.query.getRs().getString(8));
				this.query.getEntity().setDireccion(this.query.getRs().getString(9));
				this.query.getEntity().setPeso(this.query.getRs().getDouble(10));
				this.query.getEntity().setEstatura(this.query.getRs().getDouble(11));
				
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// ConnectionGeneric.close();
		}
		return this.query.getEntity();
	}
	
	
	

	public void insert(Paciente t) {
		if (t != null) {
			this.query = new QueryGeneric<Paciente>();
			this.query.setQuery(
					"INSERT INTO paciente(id,documento,nombre,apellido,email,genero,fechanacimiento,telefono,direccion,peso,estatura) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			try {
				this.query.setPs(ConnectionGeneric.getC().prepareStatement(this.query.getQuery()));
				this.query.getPs().setInt(1, t.getId());
				this.query.getPs().setString(2, t.getDocumento());
				this.query.getPs().setString(3, t.getNombre());
				this.query.getPs().setString(4, t.getApellido());
				this.query.getPs().setString(5, t.getEmail());
				this.query.getPs().setString(6, t.getGenero());
				this.query.getPs().setDate(7, (Date) t.getFechanacimiento());
				this.query.getPs().setString(8, t.getTelefono());
				this.query.getPs().setString(9, t.getDireccion());
				this.query.getPs().setDouble(10, t.getPeso());
				this.query.getPs().setDouble(11, t.getEstatura());
								this.query.getPs().executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				// ConnectionGeneric.close();
			}
		}
	}

	public void update(Paciente t) {
		if (t != null) {
			this.query = new QueryGeneric<Paciente>();
			this.query.setQuery(
					"UPDATE candidato SET documento = ?, nombre = ?, apellido = ?, email = ?, genero = ?, fechanacimiento = ?, telefono = ?, direccion = ?, peso = ?, estatura = ?,  WHERE id = "
							+ t.getId() + "");
			try {
				this.query.setPs(ConnectionGeneric.getC().prepareStatement(this.query.getQuery()));
				this.query.getPs().setString(1, t.getDocumento());
				this.query.getPs().setString(2, t.getNombre());
				this.query.getPs().setString(3, t.getApellido());
				this.query.getPs().setString(4, t.getEmail());
				this.query.getPs().setString(5, t.getGenero());
				this.query.getPs().setDate(6, (Date) t.getFechanacimiento());
				this.query.getPs().setString(7, t.getTelefono());
				this.query.getPs().setString(8, t.getDireccion());
				this.query.getPs().setDouble(9, t.getPeso());
				this.query.getPs().setDouble(10, t.getEstatura());
				this.query.getPs().executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				// ConnectionGeneric.close();
			}
		}
	}

	public boolean delete(int id) {
		if (id > 0) {
			this.query = new QueryGeneric<Paciente>();
			query.setQuery("DELETE FROM paciente WHERE id = " + id + "");
			try {
				this.query.setPs(ConnectionGeneric.getC().prepareStatement(this.query.getQuery()));
				if (this.query.getPs().executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				ConnectionGeneric.close();
			}
		}
		return false;
	}

}
