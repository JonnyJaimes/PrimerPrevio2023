package Entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Paciente  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
		 private Integer id;
	@Column
	 private String documento;
	
	
	@Column
		 private String nombre;
	@Column
		private String apellido;
	@Column
		 private String Email;
	@Column
		private String genero;
	@Column
		 private Date fechanacimiento;
	@Column
		 private String telefono;
	@Column
		  private String direccion;
	@Column
		 private  Double peso;
	@Column
		 private Double estatura ;
	
	public Paciente() {}
	
	public Paciente(Integer id,String documento, String nombre, String apellido, String Email, String genero, Date fechanacimiento,
			String telefono, String direccion, Double peso, Double estatura) {
		super();
		this.id = id;
		this.documento=documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.Email = Email;
		this.genero = genero;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String i) {
		this.documento = i;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	
	
	
}
