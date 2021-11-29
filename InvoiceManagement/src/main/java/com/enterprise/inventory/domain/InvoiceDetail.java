package com.enterprise.inventory.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enterprise.inventory.converter.StatusAttributeConverter;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="invoice_details")
public class InvoiceDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoiceId")
	private Long id;
	
	@Column(name="vendorName")
	private String vendorName;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="pdfName")
	private String pdfName;
	
	@Column(name="status",columnDefinition = "smallint")
	@Convert(converter = StatusAttributeConverter.class)
	private InvoiceStatus status;
}
