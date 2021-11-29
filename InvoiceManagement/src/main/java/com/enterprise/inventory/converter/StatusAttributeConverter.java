package com.enterprise.inventory.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.enterprise.inventory.domain.InvoiceStatus;

@Converter(autoApply = true)
public class StatusAttributeConverter implements AttributeConverter<InvoiceStatus,Integer>{

	@Override
	public Integer convertToDatabaseColumn(InvoiceStatus attribute) {		
		return attribute.getInvoiceStatus();
	}

	@Override
	public InvoiceStatus convertToEntityAttribute(Integer dbData) {
		return InvoiceStatus.decode(dbData);
	}

}
