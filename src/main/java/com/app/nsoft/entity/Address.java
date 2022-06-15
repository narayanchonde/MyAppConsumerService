package com.app.nsoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AddressTab")
public class Address {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;


	@Column(name="addr_line1_col")
	private String line1;

	@Column(name="addr_line2_col")
	private String line2;

	@Column(name="addr_city_col")
	private String city;

	@Column(name="addr_state_col")
	private String state;

	@Column(name="addr_country_col")
	private String country;


	@Column(name="addr_pincode_col")
	private Long pincode;
}
