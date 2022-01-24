package childrencare.app.repository;

import childrencare.app.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {

    @Query(value = "insert into reservation_service (reservation_id,service_id,total_person)" +
            "values (?1, ?2, ?3)",nativeQuery = true)
    void insertReservation_Service(int rId,int sId, int total);

    @Query(value = "select max(reservation_id) from reservation",nativeQuery = true)
    int idIdentity();

}
