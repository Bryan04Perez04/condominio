package condominio.core.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pago_condomino database table.
 * 
 */
@Entity
@Table(name="pago_condomino")
@NamedQuery(name="PagoCondomino.findAll", query="SELECT p FROM PagoCondomino p")
public class PagoCondomino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAGO_CONDOMINO_IDPAGOC_GENERATOR", sequenceName="SEQ_PAGO_CONDOMINO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAGO_CONDOMINO_IDPAGOC_GENERATOR")
	private long idpagoc;

	@Temporal(TemporalType.DATE)
	private Date fechatransaccion;

	private Boolean valido;

	private BigDecimal valor;

	//bi-directional many-to-one association to TipoPago
	@ManyToOne
	@JoinColumn(name="idpago")
	private TipoPago tipoPago;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public PagoCondomino() {
	}

	public long getIdpagoc() {
		return this.idpagoc;
	}

	public void setIdpagoc(long idpagoc) {
		this.idpagoc = idpagoc;
	}

	public Date getFechatransaccion() {
		return this.fechatransaccion;
	}

	public void setFechatransaccion(Date fechatransaccion) {
		this.fechatransaccion = fechatransaccion;
	}

	public Boolean getValido() {
		return this.valido;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}