package claudioteles.com.github.backendpessoas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.backendpessoas.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Boolean existsByNome(String nome);
	Boolean existsBySenha(String senha);
	Boolean existsByEmail(String email);
	
	Boolean existsByCpf(String cpf);
	
	Optional<Usuario> findByNome(String nome);
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);
	
}
