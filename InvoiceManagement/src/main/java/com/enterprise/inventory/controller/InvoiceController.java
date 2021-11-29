package com.enterprise.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.inventory.domain.InvoiceDetail;
import com.enterprise.inventory.repository.InvoiceRepository;

@RestController
@RequestMapping("/enterprise-app/invoice")
public class InvoiceController {
	
	@Autowired
	InvoiceRepository invoiceRepo;
	
	@PostMapping("")
	InvoiceDetail createInvoice(@RequestBody InvoiceDetail invoiceDetail)
	{
		invoiceDetail=invoiceRepo.save(invoiceDetail);
		return invoiceDetail;
	}
	
	@GetMapping("/all")
	List<InvoiceDetail> retrieveInvoices()
	{
		Iterable<InvoiceDetail> invoiceDetailIter=invoiceRepo.findAll();
		List<InvoiceDetail> invoiceDetails=new ArrayList<InvoiceDetail>();
		invoiceDetailIter.forEach(e -> invoiceDetails.add(e));
		return invoiceDetails;
	}
	
	@GetMapping("")
	InvoiceDetail retrieveInvoice(Long id)
	{
		return invoiceRepo.findById(id).get();
	}
	
	@PostMapping("/update")
	InvoiceDetail updateInvoice(@RequestBody InvoiceDetail invoiceDetail)
	{
		invoiceDetail=invoiceRepo.save(invoiceDetail);
		return invoiceDetail;
	}
	
	@DeleteMapping
	String deleteInvoice(InvoiceDetail invoiceDetail)
	{
		invoiceRepo.delete(invoiceDetail);
		return "OK";
	}

}
