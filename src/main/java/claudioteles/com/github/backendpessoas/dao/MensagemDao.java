package claudioteles.com.github.backendpessoas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.backendpessoas.models.Mensagem;
import claudioteles.com.github.backendpessoas.models.Usuario;
import claudioteles.com.github.backendpessoas.repositories.MensagemRepository;

@Repository
public class MensagemDao {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Mensagem criarUmaMensagem(Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}
	
	public Mensagem encontrarUmaMensagemPeloId(Long id) {
		return mensagemRepository.findById(id).get();
	}
	
	public List<Mensagem> listarTodasMensagens() {
		return mensagemRepository.findAll();
	}
	
	public List<Mensagem> listarMensagensPeloRemetenteEDestinatario(Usuario remetente, Usuario destinatario, Usuario _remetente, Usuario _destinatario) {
		return mensagemRepository.findByRemetenteAndDestinatarioOrDestinatarioAndRemetente(remetente, destinatario, _remetente, _destinatario);
	}
	
	public Boolean deletarMensagem(Long id) {
		Mensagem mensagem = new Mensagem();
		mensagem = mensagemRepository.findById(id).get();
		if (mensagem != null) {
			mensagemRepository.delete(mensagem);
			return true;
		}
		return false;
	}

}
