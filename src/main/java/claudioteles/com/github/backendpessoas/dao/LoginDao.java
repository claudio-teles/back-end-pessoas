package claudioteles.com.github.backendpessoas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.backendpessoas.models.Usuario;
import claudioteles.com.github.backendpessoas.repositories.UsuarioRepository;
import claudioteles.com.github.backendpessoas.services.CriptografiaService;

@Repository
public class LoginDao {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CriptografiaService criptografiaService;
	
	public Usuario fazerLogin(String nome, String senha) {
		Boolean temNome = usuarioRepository.existsByNome(nome);
		Usuario usuario = new Usuario();
		Boolean temSenha = usuarioRepository.existsBySenha(criptografiaService.gerarStringHash(senha));
		if (temNome && temSenha) {
			usuario = usuarioRepository.findByNome(nome).get();
			usuario.setAtivo(true);
			usuarioRepository.save(usuario);
			return usuario;
		}
		return usuario = null;
	}
	
	@SuppressWarnings("unused")
	public Boolean fazerLogout(Long idUsuario) {
		Usuario usuario = new Usuario();
		if (usuario != null) {
			usuario = usuarioRepository.findById(idUsuario).get();
			usuario.setAtivo(false);
			usuarioRepository.save(usuario);
			return true;
		} else {
			return false;
		}
	}

}
