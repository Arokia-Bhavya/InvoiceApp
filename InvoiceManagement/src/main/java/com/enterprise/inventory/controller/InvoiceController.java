package com.enterprise.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.inventory.domain.InvoiceDetail;
import com.enterprise.inventory.repository.InvoiceRepository;

@CrossOrigin(origins = "http://localhost:8081")
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
	
	@GetMapping("{id}")
	InvoiceDetail retrieveInvoice(@RequestParam Long id)
	{
		return invoiceRepo.findById(id).get();
	}
	
	@PutMapping("{id}")
	InvoiceDetail updateInvoice(@RequestBody InvoiceDetail invoiceDetail,@RequestParam Long id)
	{
		invoiceDetail=invoiceRepo.save(invoiceDetail);
		return invoiceDetail;
	}
	
	@DeleteMapping("{id}")
	String deleteInvoice(@RequestParam Long id)
	{
		invoiceRepo.deleteById(id);
		return "OK";
	}
	
	@DeleteMapping("")
	String deleteInvoices()
	{
		invoiceRepo.deleteAll();
		return "OK";
	}

}
