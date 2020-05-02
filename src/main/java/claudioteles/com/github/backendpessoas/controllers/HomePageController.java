package claudioteles.com.github.backendpessoas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import io.swagger.annotations.ApiOperation;

@RestController
@SessionScope
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomePageController {
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Página Inicial")
	public String irHomePage() {
		return "{\n" + 
				"	\"home_page\":\"Bem Vindo!\"\n" + 
				"}";
	}

}
