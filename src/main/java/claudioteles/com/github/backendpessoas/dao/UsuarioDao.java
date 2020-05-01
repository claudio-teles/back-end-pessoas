package claudioteles.com.github.backendpessoas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.backendpessoas.models.Usuario;
import claudioteles.com.github.backendpessoas.repositories.UsuarioRepository;

@Repository
public class UsuarioDao {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario encontrarUmUsuarioPeloId(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public Usuario encontrarUmUsuarioPeloCpf(String cpf) {
		return usuarioRepository.findByCpf(cpf).get();
	}
	
	public Usuario encontrarUsuarioPeloEmail(String email) {
		return usuarioRepository.findByEmail(email).get();
	}
	
	public Boolean existeCpf(String cpf) {
		return usuarioRepository.existsByCpf(cpf);
	}
	
	public Boolean existeEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public List<Usuario> verTodosOsUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario atualizarUsuarios(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void deletarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

}
