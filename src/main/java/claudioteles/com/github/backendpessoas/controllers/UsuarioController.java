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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import claudioteles.com.github.backendpessoas.models.Usuario;
import claudioteles.com.github.backendpessoas.services.UsuarioService;
import io.swagger.annotations.ApiOperation;

@RestController
@SessionScope
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva um usuário no HSQLDB")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.criarUsuarioService(usuario);
	}
	
	@GetMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Consulta um usuário no HSQLDB")
	public Usuario consultarUsuarioPeloId(@PathVariable("id") Long id) {
		return usuarioService.consultaUsuarioIdService(id);
	}
	
	@PostMapping("/usuario/cpf")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Consulta um usuário pelo CPF no HSQLDB")
	public Usuario consultarUsuarioPeloCpf(@RequestBody Map<String, String> usuarioJson) {
		return usuarioService.consultarUsuarioCpfService(usuarioJson);
	}
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Consulta todos os usuários no HSQLDB")
	public List<Usuario> mostarTodosUsuarios(@RequestParam("id") Long id) {
		return usuarioService.mostrarUsuarioIdService(id);
	}
	
	@PutMapping("/usuario")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Atualiza um suário no HSQLDB")
	public Usuario atualizarUsuario(@RequestBody Usuario usuarioAtualizado) {
		return usuarioService.atualizarUsuarioIdService(usuarioAtualizado);
	}
	
	@DeleteMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Deleta um usuário no HSQLDB")
	public Map<String, Boolean> deletarUsuario(@PathVariable("id") Long id) {
		return usuarioService.deletarUsuarioIdService(id);
	}
	
}
