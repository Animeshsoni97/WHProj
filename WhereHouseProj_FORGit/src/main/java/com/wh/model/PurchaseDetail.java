package com.wh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;
import lombok.Data;
	
@Data 
@Entity   
@Table(name="purchase_dtl_tab")
public class PurchaseDetail {  
@Id
@GeneratedValue(generator = "pd")     
@SequenceGenerator(name = "pd", initialValue = 10, 
allocationSize =10,sequenceName = "purchase_dtl_seq" )
@Column(name="pd_id_col")
private Integer id;

@Transient 
private Integer slNo;

@ManyToOne
@JoinColumn(name="part_fk_col")
private Part part;

@ManyToOne
@JoinColumn(name="purchaseOrder_fk_col")
private PurchaseOrder purchaseOrder;

@Column(name="purchase_quantity_col")
private Integer quantity;


}//class
