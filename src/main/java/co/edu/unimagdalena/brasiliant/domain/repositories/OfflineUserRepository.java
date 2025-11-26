package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.OfflineUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfflineUserRepository extends JpaRepository<OfflineUser,Long> {
}
