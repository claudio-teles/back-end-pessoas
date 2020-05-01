package claudioteles.com.github.backendpessoas.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import claudioteles.com.github.backendpessoas.models.Usuario;
import claudioteles.com.github.backendpessoas.services.LoginService;
import io.swagger.annotations.ApiOperation;

@RestController
@SessionScope
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PutMapping("/login")
	@ApiOperation(value = "Faz um login no HSQLDB")
	@ResponseStatus(HttpStatus.OK)
	public Usuario logar(@RequestBody Map<String, String> loginJson) {
		return loginService.logarService(loginJson);
	}
	
	@GetMapping("/logout/{idUsuario}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Faz o logout no HSQLDB")
	public Map<String, Boolean> desLogar(@PathVariable("idUsuario") Long idUsuario) {
		return loginService.desLogar(idUsuario);
	}

}
