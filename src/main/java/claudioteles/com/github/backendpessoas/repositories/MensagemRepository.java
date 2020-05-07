package claudioteles.com.github.backendpessoas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.backendpessoas.models.Mensagem;
import claudioteles.com.github.backendpessoas.models.Usuario;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	List<Mensagem> findByRemetenteAndDestinatarioOrDestinatarioAndRemetente(Usuario remetente, Usuario destinatario, Usuario _remetente, Usuario _destinatario);
}
