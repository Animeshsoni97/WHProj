package com.wh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class WhUserType {

	@Id
	@GeneratedValue(generator = "WHUserGen")
	@SequenceGenerator(name = "WHUserGen", allocationSize = 1,
	                   initialValue = 1,sequenceName = "whUser_seq"    )
	private Integer whUId;
	private String whUType;
	private String whUCode;
	private String whUFor;
	private String whUEmail;
	private String whUContact;
	private String whUIDType;
	private String whUIDTypeOther;
	private String whUIDNumber;
	
	
}
