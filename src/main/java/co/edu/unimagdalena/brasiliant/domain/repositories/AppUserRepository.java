package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.AppUser;
import co.edu.unimagdalena.brasiliant.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByFullNameContainingIgnoreCase(String name);
    int countAppUsers();

    Optional<AppUser> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);

    List<AppUser> findByActive(Boolean active);

    @Query(value = """
        SELECT DISTINCT U.* FROM app_users U
        JOIN user_roles R ON R.user_id = U.user_id
        WHERE R.role IN :roles
    """, nativeQuery = true)
    List<AppUser> findByHavingRoles(@Param("roles") Collection<Role> roles);
}
