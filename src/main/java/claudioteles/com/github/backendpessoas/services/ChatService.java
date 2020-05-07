package claudioteles.com.github.backendpessoas.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.backendpessoas.dao.ChatDao;
import claudioteles.com.github.backendpessoas.dao.MensagemDao;
import claudioteles.com.github.backendpessoas.dao.UsuarioDao;
import claudioteles.com.github.backendpessoas.models.Chat;
import claudioteles.com.github.backendpessoas.models.Mensagem;
import claudioteles.com.github.backendpessoas.models.Usuario;

@Service
public class ChatService {
	
	@Autowired
	private ChatDao chatDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private MensagemDao mensagemDao;

	public Chat criarChatService(Map<String, String> chatJson) {
		Chat chat = new Chat();
		Usuario remetente = new Usuario();
		remetente = usuarioDao.encontrarUsuarioPeloEmail(chatJson.get("email_remetente"));
		Usuario destinatario = new Usuario();
		destinatario = usuarioDao.encontrarUsuarioPeloEmail(chatJson.get("email_destinatario"));
		List<Mensagem> conversas = new ArrayList<>();
		if ( remetente.isAtivo() || destinatario.isAtivo() ) {
			if ((usuarioDao.existeEmail(chatJson.get("email_remetente"))
					&& (usuarioDao.existeEmail(chatJson.get("email_destinatario"))))) {
				chat.setRemetente(remetente);
				chat.setDestinatario(destinatario);
				chat.setMensagems(conversas);
				chatDao.criarUmChat(chat);
				return chat;
			} 
		}
		return null;
	}

	public Chat obterChatService(Long id, Long idChat, Long rem, Long dest) {
		Chat chat = new Chat();
		Usuario usuario = new Usuario();
		Usuario remetente = new Usuario();
		remetente = usuarioDao.encontrarUmUsuarioPeloId(rem);
		Usuario destinatario = new Usuario();
		destinatario = usuarioDao.encontrarUmUsuarioPeloId(dest);
		List<Mensagem> mensagens = new ArrayList<>();
		mensagens.addAll(mensagemDao.listarMensagensPeloRemetenteEDestinatario(remetente, destinatario, destinatario, destinatario));
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			chat = chatDao.encontrarConversaPeloId(idChat);
			chatDao.atualizarChat(idChat, mensagens);
			return chat;
		}
		return null;
	}

	public List<Chat> listarChatService(Long id) {
		Usuario usuario = new Usuario();
		List<Chat> chats = new ArrayList<>();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			chats.addAll(chatDao.listarTodosOsChats());
			return chats;
		}
		return null;
	}

	public Map<String, Boolean> deletarChatService(Long id, Long idChat) {
		Usuario usuario = new Usuario();
		Map<String, Boolean> resposta = new HashMap<>();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			chatDao.deletarchat(idChat);
			resposta.put("chat_deletado", true);
			return resposta;
		} else {
			resposta.put("chat_deletado", false);
			return resposta;
		}
	}

}
