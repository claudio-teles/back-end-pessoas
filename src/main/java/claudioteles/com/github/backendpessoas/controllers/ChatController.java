package claudioteles.com.github.backendpessoas.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import claudioteles.com.github.backendpessoas.models.Chat;
import claudioteles.com.github.backendpessoas.services.ChatService;
import io.swagger.annotations.ApiOperation;

@RestController
@SessionScope
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@PostMapping("/chat")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva um chat no HSQLDB")
	public Chat criarChat(@RequestBody Map<String, String> chatJson) {
		return chatService.criarChatService(chatJson);
	}
	
	@GetMapping("/chat")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Pesquisa um chat no HSQLDB")
	public Chat obterChatId(@RequestParam("id") Long id, @RequestParam("idChat") Long idChat, @RequestParam("rem") Long rem, @RequestParam("dest") Long dest) {
		return chatService.obterChatService(id, idChat, rem, dest);
	}
	
	@GetMapping("/chats")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Lista todos os chats no HSQLDB")
	public List<Chat> listarChats(@RequestParam("id") Long id) {
		return chatService.listarChatService(id);
	}
	
	@DeleteMapping("/chat")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Deleta um chat no HSQLDB")
	public Map<String, Boolean> deletarChat(@RequestParam("id") Long id, @RequestParam("idChat") Long idChat) {
		return chatService.deletarChatService(id, idChat);
	}

}
