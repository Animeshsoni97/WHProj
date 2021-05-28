package com.wh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class ShipmentType {
	@Id
	@GeneratedValue(generator = "shipType")
	@SequenceGenerator(name = "shipType", initialValue = 1, 
	         allocationSize =1,sequenceName = "shipType_seq" )
private Integer shipTId;
private String shipTMode;
private String shipTCode;
private String enableShipT;
private String shipTGrade;
private String shipTDesc;
	
}
