package com.app.nsoft.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name="PaymentHistoryTab")
public class PaymentHistory  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="pay_reciepdate_Col")
	private Date recieptDate;
	
	@Column(name="pay_paid_Col")
	private Double paid;
	

}
