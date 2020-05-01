package claudioteles.com.github.backendpessoas.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.backendpessoas.dao.MensagemDao;
import claudioteles.com.github.backendpessoas.dao.UsuarioDao;
import claudioteles.com.github.backendpessoas.models.Mensagem;
import claudioteles.com.github.backendpessoas.models.Usuario;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemDao mensagemDao;
	
	@Autowired
	private UsuarioDao usuarioDao;

	public Mensagem enviarMensagemService(Map<String, String> enviarJsons) {
		Usuario remetente = new Usuario();
		Usuario destinatario = new Usuario();
		Mensagem mensagem = new Mensagem();
		remetente = usuarioDao.encontrarUsuarioPeloEmail(enviarJsons.get("email_remetente"));
		destinatario = usuarioDao.encontrarUsuarioPeloEmail(enviarJsons.get("email_destinatario"));
		if (remetente.isAtivo()) {
			mensagem.setRemetente(remetente);
			mensagem.setDestinatario(destinatario);
			mensagem.setMensagem(enviarJsons.get("mensagem"));
			mensagem.setDataDeEnvio(new Date());
			return mensagemDao.criarUmaMensagem(mensagem);
		}
		return null;
	}

	public Mensagem encontrarMensagemIdService(Long id) {
		return mensagemDao.encontrarUmaMensagemPeloId(id);
	}

	public List<Mensagem> listaMensagensService(Long id) {
		Usuario usuario = new Usuario();
		List<Mensagem> mensagens = new ArrayList<>();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			mensagens.addAll(mensagemDao.listarTodasMensagens());
			return mensagens;
		}
		return null;
	}

	public List<Mensagem> listaMensagensConversaService(Long remetente, Long destinatario) {
		Usuario usuarioRemetente = new Usuario();
		usuarioRemetente = usuarioDao.encontrarUmUsuarioPeloId(remetente);
		Usuario usuarioDestinatario = new Usuario();
		usuarioDestinatario = usuarioDao.encontrarUmUsuarioPeloId(destinatario);
		List<Mensagem> mensagens = new ArrayList<>();
		if (usuarioRemetente.isAtivo()) {
			mensagens.addAll(mensagemDao.listarMensagensPeloRemetenteEDestinatario(usuarioRemetente, usuarioDestinatario));
			return mensagens;
		}
		return null;
	}

	public Map<String, Boolean> deletarMensagemService(Long id, Long idMensagem) {
		Map<String, Boolean> resposta = new HashMap<>();
		Usuario usuario = new Usuario();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			mensagemDao.deletarMensagem(idMensagem);
			resposta.put("mensagem_deletada", true);
			return resposta;
		} else {
			resposta.put("mensagem_deletada", false);
			return resposta;
		}
	}

}
