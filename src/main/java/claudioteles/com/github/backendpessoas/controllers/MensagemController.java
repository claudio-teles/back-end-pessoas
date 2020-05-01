package claudioteles.com.github.backendpessoas.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import claudioteles.com.github.backendpessoas.models.Mensagem;
import claudioteles.com.github.backendpessoas.services.MensagemService;
import io.swagger.annotations.ApiOperation;

@RestController
@SessionScope
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MensagemController {
	
	@Autowired
	private MensagemService mensagemService;
	
	@PostMapping("/mensagem")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva uma mensagem no HSQLDB")
	public Mensagem enviarMensagem(@RequestBody Map<String, String> enviarJsons) {
		return mensagemService.enviarMensagemService(enviarJsons);
	}
	
	@GetMapping("/mensagem/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Pesquisa uma mensagem no HSQLDB")
	public Mensagem encontrarMensagem(@PathVariable("id") Long id) {
		return mensagemService.encontrarMensagemIdService(id);
	}
	
	@GetMapping("/mensagens")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Encontra todas as mensagens no HSQLDB")
	public List<Mensagem> listarMensagens(@RequestParam("id") Long id) {
		return mensagemService.listaMensagensService(id);
	}
	
	@GetMapping("/mensagens/conversa")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Lista todas as conversas salvas no chat no HSQLDB")
	public List<Mensagem> listarMensagensConversa(@RequestParam("remetente") Long remetente, @RequestParam("remetente") Long destinatario) {
		return mensagemService.listaMensagensConversaService(remetente, destinatario);
	}
	
	@DeleteMapping("/mensagem")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Excluir uma mensagem no HSQLDB")
	public Map<String, Boolean> deletarMensagem(@RequestParam("id") Long id, @RequestParam("idMensagem") Long idMensagem) {
		return mensagemService.deletarMensagemService(id, idMensagem);
	}

}
