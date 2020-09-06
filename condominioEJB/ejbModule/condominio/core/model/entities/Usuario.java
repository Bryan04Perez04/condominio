package condominio.core.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_IDUSUARIO_GENERATOR", sequenceName="SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_IDUSUARIO_GENERATOR")
	private long idusuario;

	private String apellidos;

	private String contrasenia;

	private String email;

	private String nombres;

	//bi-directional many-to-one association to Gasto
	@OneToMany(mappedBy="usuario")
	private List<Gasto> gastos;

	//bi-directional many-to-one association to PagoCondomino
	@OneToMany(mappedBy="usuario")
	private List<PagoCondomino> pagoCondominos;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;

	public Usuario() {
	}

	public long getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Gasto> getGastos() {
		return this.gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public Gasto addGasto(Gasto gasto) {
		getGastos().add(gasto);
		gasto.setUsuario(this);

		return gasto;
	}

	public Gasto removeGasto(Gasto gasto) {
		getGastos().remove(gasto);
		gasto.setUsuario(null);

		return gasto;
	}

	public List<PagoCondomino> getPagoCondominos() {
		return this.pagoCondominos;
	}

	public void setPagoCondominos(List<PagoCondomino> pagoCondominos) {
		this.pagoCondominos = pagoCondominos;
	}

	public PagoCondomino addPagoCondomino(PagoCondomino pagoCondomino) {
		getPagoCondominos().add(pagoCondomino);
		pagoCondomino.setUsuario(this);

		return pagoCondomino;
	}

	public PagoCondomino removePagoCondomino(PagoCondomino pagoCondomino) {
		getPagoCondominos().remove(pagoCondomino);
		pagoCondomino.setUsuario(null);

		return pagoCondomino;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}