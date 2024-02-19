package school.sptech.jogadoresfutebol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.jogadoresfutebol.model.JogadorModel;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorModel, Long> {

    JogadorModel findById(int id);

}
