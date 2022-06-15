package com.app.nsoft.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ConsumerTab")
public class Consumer {
	@Id
	@Column(name="com_id_pk_col")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="con_fname_col")
	private String conFName;

	@Column(name="con_mName_col")
	private String conMName;

	@Column(name="con_lName_col")
	private String conlName;

	@Column(name="con_aadhar_col")
	private String conAadhar;

	@Column(name="con_pancard_col")
	private String conPanCard;

	@Column(name="con_occupation_col")
	private String conOccupation;

	@Column(name="con_cast_col")
	private String conCast;

	@Column(name="con_gender_col")
	private String conGender;

	@Column(name="con_email_col")
	private String conEmail;

	@Column(name="con_mobile_col")
	private String conMobile;

	@Column(name="con_supplytype_col")
	private String conSupplyType;

	@Column(name="con_image_col")
	private String conImage;

	//TODO Create Has-A Relation with Address and Reading table 


	@OneToMany(cascade =CascadeType.ALL)
	@JoinColumn(name="con_id_fk_col")
	private List<Address> address;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="con_fk_reading_col")
	private List<Reading> reading;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="con_fk_payhis_col")
	private List<PaymentHistory> paymentHistory;




}