package claudioteles.com.github.backendpessoas.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6062392036647008332L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id_chat", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id_chat", sequenceName = "sequencia_chat", initialValue = 30, allocationSize = 1)
	@Column(name = "id_chat", nullable = false)
	private Long idChat;
	@OneToOne(targetEntity = Usuario.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "um_chat_tem_um_remetente"), nullable = false)
	private Usuario remetente;
	@OneToOne(targetEntity = Usuario.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "um_chat_tem_um_destinatario"), nullable = false)
	private Usuario destinatario;
	@OneToMany(targetEntity = Mensagem.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "uma_chat_tem_muitas_mensagens"))
	private List<Mensagem> mensagems;
	
	public Chat() {
		super();
	}

	public Chat(List<Mensagem> mensagems) {
		super();
		this.mensagems = mensagems;
	}

	public Long getIdChat() {
		return idChat;
	}

	public void setIdChat(Long idChat) {
		this.idChat = idChat;
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

	public List<Mensagem> getMensagems() {
		return mensagems;
	}

	public void setMensagems(List<Mensagem> mensagems) {
		this.mensagems = mensagems;
	}

}
