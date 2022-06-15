package com.app.nsoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="ReadingTab")
public class Reading {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="rd_currentUnit_col")
	private Long currentUnit;
	
	@Column(name="rd_lastUnit_col")
	private Long lastUnit;
	
	@Column(name="rd_usedUnit_col")
	private Long usedUnit;	
	
	private Double  unitPrice ;
 
	
}
