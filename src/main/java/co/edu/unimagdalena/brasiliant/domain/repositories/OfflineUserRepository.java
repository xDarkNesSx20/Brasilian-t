package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.OfflineUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfflineUserRepository extends JpaRepository<OfflineUser,Long> {
    List<OfflineUser> findByFullNameContainingIgnoreCase(String name);
    int countOfflineUsers();
    Optional<OfflineUser> findByIdNumber(String idNumber);
}
