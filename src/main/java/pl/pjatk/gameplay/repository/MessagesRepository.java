package pl.pjatk.gameplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.gameplay.model.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {
}
