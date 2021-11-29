package com.enterprise.inventory.domain;
import java.util.stream.Stream;


public enum InvoiceStatus { 
	NEW(1), APPROVED(2), CLOSED(3);
	public Integer invoiceStatus;

	private InvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public int getInvoiceStatus() {
		return invoiceStatus;
	}
	
	 public static InvoiceStatus decode(final Integer code) {
	        return Stream.of(InvoiceStatus.values()).filter(targetEnum -> targetEnum.invoiceStatus.equals(code)).findFirst().orElse(null);
	  }
}
