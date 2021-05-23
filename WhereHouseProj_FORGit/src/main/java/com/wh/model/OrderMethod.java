package com.wh.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="orderM_method_tab")
public class OrderMethod {
    @Id
    @GeneratedValue(generator = "orderM")
	@SequenceGenerator(name = "orderM",sequenceName = "orderM_seq")
    @Column(name="orderM_id_col")
	private Integer orderMId;
    
    @Column(name="orderM_mode_col")
	private String orderMMode;
    
    @Column(name="orderM_code_col")
	private String orderMCode;
    
    @Column(name="orderM_type_col")
	private String orderMType;
    
    @Column(name="orderM_desc_col")
	private String orderMDesc;
	
	@ElementCollection //mandatory for creating new table
	@CollectionTable(name="orderM_accept_tab" ,joinColumns = @JoinColumn(name="orderM_id_col"))
	@Column(name="orderM_accept_col")
	private List<String> orderMAccept;
}
