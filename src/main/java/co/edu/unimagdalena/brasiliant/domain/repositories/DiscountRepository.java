package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Discount;
import co.edu.unimagdalena.brasiliant.domain.enums.DiscountType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findByFareRule_Id(Long fareRuleId);
    Optional<Discount> findByFareRule_IdAndType(Long fareRuleId, DiscountType type);
    Page<Discount> findByType(DiscountType type, Pageable pageable);
}
