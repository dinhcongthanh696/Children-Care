package childrencare.app.repository;

import childrencare.app.model.ReservationModel;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {


    // AKV - ReservationComplete
    @Modifying
    @Query(value = "UPDATE ReservationModel rm set rm.status = 'true' where rm.reservationId = ?1",
    nativeQuery = true)
    void changeStatus(int reservationId);

    @Modifying
    @Query(value = "insert into reservation_service(reservation_id, service_id, slot_id, staff_id, booked_date, price) " +
            "values (?1, ?2, ?3, ?4, ?5, ?6)",nativeQuery = true)
    void createSchedule(int reservationId,int serviceId, int slot_id,
                        int staff_id, Date date, double price);

    @Modifying
    @Query(value = "Delete reservation_service " +
            " where slot_id = ?1 and staff_id = ?2 and booked_date = ?3",nativeQuery = true)
    void deleteSchedule(int slot_id, int staff_id, Date date);




    @Query(value = "select top 1 * from reservation\r\n"
    		+ "inner join reservation_service\r\n"
    		+ "on reservation.reservation_id = reservation_service.reservation_id\r\n"
    		+ "inner join customer on reservation.customer_id = customer.customer_id\n"
    		+ "where customer_email = ?1 and service_id = ?2 " , nativeQuery = true)
    public ReservationModel getReservationByEmailAndServiceId(String email , Integer serviceId);

    
    @Query(value = "SELECT COUNT(*) FROM reservation WHERE status = ?1",nativeQuery = true)
    int countReservationByStatus(int status);
    
    @Query(value = "SELECT COUNT(*) FROM reservation WHERE status = ?1 AND DATEPART(month,date) = DATEPART(MONTH,?2)\r\n"
    		+ "AND DATEPART(YEAR,date) = DATEPART(YEAR,?2) AND DATEPART(DAY,date) = DATEPART(day,?2)",nativeQuery = true)
    int countReservationByStatusAndDate(int status,Date date);


    @Query(value = "select r.reservation_id,r.date,slot.start_time as TimeToCheckUp, r.total_reservation_price,r.status,r.fullname,r.gender,r.phone,r.email,r.address,r.notes\n" +
            "from reservation r\n" +
            "inner join reservation_service rc on rc.reservation_id = r.reservation_id\n" +
            "inner join slot on slot.slot_id = rc.slot_id\n" +
            "inner join [service] serv on serv.service_id= rc.service_id\n" +
            "where r.reservation_id = ?1 \n" +
            "group by r.reservation_id,r.date,slot.start_time, r.total_reservation_price,r.status,r.fullname,r.gender,r.phone,r.email,r.address,r.notes",nativeQuery = true)
    public ReservationModel getReservationModelByReservationId(int reserID);
}
