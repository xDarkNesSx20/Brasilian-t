package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Parcel;
import co.edu.unimagdalena.brasiliant.domain.enums.ParcelStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    Optional<Parcel> findByCode(String code);
    Optional<Parcel> findByDeliveryOTP(String deliveryOTP);
    Page<Parcel> findByStatus(ParcelStatus status, Pageable pageable);
    List<Parcel> findBySender_IdAndStatus(Long senderId, ParcelStatus status);
    List<Parcel> findByReceiver_IdAndStatus(Long receiverId, ParcelStatus status);
    List<Parcel> findBySender_IdAndReceiver_IdAndStatus(Long senderId, Long receiverId, ParcelStatus status);
    List<Parcel> findByFromStop_IdAndStatus(Long fromStopId, ParcelStatus status);
    List<Parcel> findByToStop_IdAndStatus(Long toStopId, ParcelStatus status);
    List<Parcel> findByFromStop_IdAndToStop_IdAndStatus(Long fromStopId, Long toStopId, ParcelStatus status);

}
