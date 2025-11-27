package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Bus;
import co.edu.unimagdalena.brasiliant.domain.enums.BusStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {
    Optional<Bus> findByPlate(String plate);
    List<Bus> findByStatus(BusStatus status);
    List<Bus> findByCapacityGreaterThanEqual(Integer minCapacity);

    @Query(value = """
        SELECT B.* FROM buses B
        JOIN bus_amenities BA ON BA.bus_id = B.bus_id
        JOIN amenities A ON A.amenity_id = BA.amenity_id
        WHERE A.name IN (:amenities)
        GROUP BY B.bus_id HAVING COUNT(DISTINCT A.name) = :requiredCant
    """, nativeQuery = true)
    List<Bus> findByAmenitiesNameIn(@Param("amenities") Collection<String> amenities, @Param("requiredCant") Integer requiredCant);

    @Query(value = """
        SELECT * FROM buses B
        JOIN bus_amenities BA ON BA.bus_id = B.bus_id
        JOIN amenities A on BA.amenity_id = A.amenity_id
        WHERE B.bus_id = :id
    """, nativeQuery = true)
    Optional<Bus> findByIdWithAmenities(@Param("id") Long id);
}
