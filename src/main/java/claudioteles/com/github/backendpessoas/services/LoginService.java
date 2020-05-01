package claudioteles.com.github.backendpessoas.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.backendpessoas.dao.LoginDao;
import claudioteles.com.github.backendpessoas.models.Usuario;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;

	public Usuario logarService(Map<String, String> loginJson) {
		Usuario usuario = new Usuario();
		usuario = loginDao.fazerLogin(loginJson.get("nome"), loginJson.get("senha"));
		if (usuario != null) {
			return usuario;
		}
		return null;
	}

	public Map<String, Boolean> desLogar(Long idUsuario) {
		Boolean resultadoDeletar = loginDao.fazerLogout(idUsuario);
		Map<String, Boolean> resposta = new HashMap<>();
		if (resultadoDeletar == true) {
			resposta.put("deslogado", true);
			return resposta;
		} else {
			resposta.put("deslogado", false);
			return resposta;
		}
	}

}
