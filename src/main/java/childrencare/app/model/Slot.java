package childrencare.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "Slot")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot {
    @Id
    @Column(name = "slot_id")
    private int id;
    
    @Column(name = "start_time")
    private double start;
    @Column(name = "end_time")
    private double end;

    @OneToMany(mappedBy = "slot")
    private List<ReservationServiceModel> reservationServices;
}
