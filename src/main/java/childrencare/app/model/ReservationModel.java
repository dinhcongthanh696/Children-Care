package childrencare.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationModel {
	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int reservationId;
	private String date;
	@Column(name = "total_reservation_price")
	private double totalReservationPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerModel customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_reservation_id")
	private StatusModel statusReservation;


	private String notes;

	
	@OneToMany(mappedBy = "reservation")
	private List<ReservationServiceModel> reservationServices;

	
	@OneToMany(mappedBy = "reservation")
	private List<ReservationServiceDrugModel> reservationServiceDrugs;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	private Payment payment;
}
