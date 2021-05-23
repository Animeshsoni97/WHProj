package com.wh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
@Entity
@Data

public class Uom {
	@Id
	@GeneratedValue(generator = "uom")
	@SequenceGenerator(name = "uom",sequenceName = "uom_seq")
	private Integer uomId;
	private String uomType;
	private String uomModel;
	private String uomDesc;

}
