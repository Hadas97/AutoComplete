package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TBL_NAMES")
@Data
public class NameEntity {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	String name;

}
