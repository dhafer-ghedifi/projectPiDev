package Pi.Spring.Repositury;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Pi.Spring.Entity.Emojis;

@Repository
public interface EmojisRepositury extends JpaRepository<Emojis, Long> {

}
