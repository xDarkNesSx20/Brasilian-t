package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Config;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, String> {
    Optional<Config> findByKeyIgnoreCase(String key);
    void deleteByKeyIgnoreCase(String key);
}
