package claudioteles.com.github.backendpessoas.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.backendpessoas.dao.UsuarioDao;
import claudioteles.com.github.backendpessoas.models.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private CriptografiaService criptografiaService;

	public Usuario criarUsuarioService(Usuario usuario) {
		Usuario u = new Usuario();
		if (!usuarioDao.existeCpf(usuario.getCpf())) {// Somente salva o usuário se o cpf for único no banco de dados.
			u.setNome(usuario.getNome());
			u.setSenha(criptografiaService.gerarStringHash(usuario.getSenha()));
			u.setAtivo(usuario.isAtivo());
			u.setRegra(usuario.getRegra());
			u.setSexo(usuario.getSexo());
			u.setEmail(usuario.getEmail());
			u.setDataDeNascimento(usuario.getDataDeNascimento());
			u.setNaturalidade(usuario.getNome());
			u.setNacionalidade(usuario.getNacionalidade());
			u.setCpf(usuario.getCpf());
			u.setDataDeCadastro(new Date());
			u.setDataDeAtualizacao(new Date());
			return usuarioDao.criarUsuario(u);
		}
		return u;
	}

	public Usuario consultaUsuarioIdService(Long id) {
		Usuario usuario = new Usuario();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			return usuario;
		} else {
			return null;
		}
	}
	

	public Usuario consultarUsuarioCpfService(Map<String, String> usuarioJson) {
		Usuario usuario = new Usuario();
		usuario = usuarioDao.encontrarUmUsuarioPeloCpf(usuarioJson.get("cpf"));
		if (usuario.isAtivo()) {
			return usuario;
		} else {
			return null;
		}
	}

	public List<Usuario> mostrarUsuarioIdService(Long id) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			usuarios.addAll(usuarioDao.verTodosOsUsuarios());
			return usuarios;
		}
		return null;
	}
	
	public Usuario atualizarUsuarioIdService(Usuario usuarioAtualizado) {
		Usuario usuarioDesAtualizado = new Usuario();
		usuarioDesAtualizado = usuarioDao.encontrarUmUsuarioPeloId(usuarioAtualizado.getIdUsuario());
		if (usuarioDesAtualizado.isAtivo()) {
			usuarioDesAtualizado.setNome(usuarioAtualizado.getNome());
			usuarioDesAtualizado.setSenha(criptografiaService.gerarStringHash(usuarioAtualizado.getSenha()));
			usuarioDesAtualizado.setRegra(usuarioAtualizado.getRegra());
			usuarioDesAtualizado.setSexo(usuarioAtualizado.getSexo());
			usuarioDesAtualizado.setEmail(usuarioAtualizado.getEmail());
			usuarioDesAtualizado.setCpf(usuarioAtualizado.getCpf());
			return usuarioDao.atualizarUsuarios(usuarioDesAtualizado);
		}
		return null;
	}

	public Map<String, Boolean> deletarUsuarioIdService(Long id) {
		Map<String, Boolean> resposta = new HashMap<>();
		Usuario usuario = new Usuario();
		usuario = usuarioDao.encontrarUmUsuarioPeloId(id);
		if (usuario.isAtivo()) {
			usuarioDao.deletarUsuario(usuario);
			resposta.put("usuario_deletado", true);
			return resposta;
		} else {
			resposta.put("usuario_deletado", false);
			return resposta;
		}
	}
	
}
