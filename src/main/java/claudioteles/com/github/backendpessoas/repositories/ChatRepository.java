package claudioteles.com.github.backendpessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.backendpessoas.models.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	
}
