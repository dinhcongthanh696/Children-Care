package childrencare.app.model;

import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackModel {
	@Id
	@Column(name = "feedback_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int feedbackId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	@MapsId("service_id")
	@JsonIgnore
	private ServiceModel service;
	
	@Column(name = "rated_star")
	private double ratedStar;
	
	private String comment;
	
	@Column(name = "feedback_image")
	private byte[] image;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Transient
	private String base64ImageEncode;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerModel customer;
	
	public void setBase64ImageEncode(byte[] image) {
		if(image != null) {
			this.base64ImageEncode = Base64.getEncoder().encodeToString(image);
		}
	}
	
}
