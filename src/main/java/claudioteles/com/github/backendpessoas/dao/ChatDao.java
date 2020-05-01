package claudioteles.com.github.backendpessoas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.backendpessoas.models.Chat;
import claudioteles.com.github.backendpessoas.models.Mensagem;
import claudioteles.com.github.backendpessoas.repositories.ChatRepository;

@Repository
public class ChatDao {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public Chat criarUmChat(Chat chat) {
		return chatRepository.save(chat);
	}
	
	public Chat encontrarConversaPeloId(Long id) {
		return chatRepository.findById(id).get();
	}
	
	public List<Chat> listarTodosOsChats() {
		return chatRepository.findAll();
	}
	
	public Chat atualizarChat(Long id, List<Mensagem> mensagens) {
		Chat chat = new Chat();
		chat = chatRepository.findById(id).get();
		chat.setMensagems(mensagens);
		return chatRepository.save(chat);
	}
	
	@SuppressWarnings("unused")
	public Boolean deletarchat(Long id) {
		Chat chat = new Chat();
		if (chat != null) {
			chat = encontrarConversaPeloId(id);
			chatRepository.delete(chat);
			return true;
		}
		return false;
	}

}
