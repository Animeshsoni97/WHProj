package com.wh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator = "poGen")
	@SequenceGenerator(name = "poGen", allocationSize = 1,
	initialValue = 1,sequenceName = "po_Seq")
	private Integer poId ;
	private String poCode;


	@ManyToOne
	@JoinColumn(name = "ship_code_fk")	
	private  ShipmentType poShipCode;
	@ManyToOne
	@JoinColumn(name="whUser_code_fk")	
	private  WhUserType poVendor;

	private  String poRefNo;
	private  String poQltCheck;
	private  String poStatus;
	private  String poDesc;

}
