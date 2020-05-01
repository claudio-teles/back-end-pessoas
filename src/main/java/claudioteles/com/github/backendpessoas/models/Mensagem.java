package claudioteles.com.github.backendpessoas.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mensagem")
public class Mensagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3277162417529633744L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id_mensagem", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id_mensagem", sequenceName = "sequencia_mensagem", initialValue = 30, allocationSize = 1)
	@Column(name = "id_mensagem", nullable = false)
	private Long idMensagem;
	@OneToOne(targetEntity = Usuario.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "uma_mensagem_tem_um_remetente"), nullable = false)
	private Usuario remetente;
	@OneToOne(targetEntity = Usuario.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "uma_mensagem_tem_um_destinatario"), nullable = false)
	private Usuario destinatario;
	@Column(length = 1000, nullable = false)
	private String mensagem;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_de_envio", nullable = false)
	private Date dataDeEnvio;
	
	public Mensagem() {
		super();
	}

	public Mensagem(Usuario remetente, Usuario destinatario, String mensagem, Date dataDeEnvio) {
		super();
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.mensagem = mensagem;
		this.dataDeEnvio = dataDeEnvio;
	}
	
	public Long getIdMensagem() {
		return idMensagem;
	}
	
	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}
	
	public Usuario getRemetente() {
		return remetente;
	}
	
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	
	public Usuario getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Date getDataDeEnvio() {
		return dataDeEnvio;
	}
	
	public void setDataDeEnvio(Date dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}

}
