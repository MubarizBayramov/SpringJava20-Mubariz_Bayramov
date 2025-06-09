package az.devolopia.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.devolopia.tourist.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BookingEntity b " +
           "WHERE b.object.id = :objectId AND " +
           "(:startDate <= b.endDate AND :endDate >= b.startDate)")
    boolean existsByObjectIdAndDateRange(@Param("objectId") Integer objectId,
                                         @Param("startDate") java.time.LocalDate startDate,
                                         @Param("endDate") java.time.LocalDate endDate);
}
