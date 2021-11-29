package com.enterprise.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.enterprise.inventory.domain.InvoiceDetail;

public interface InvoiceRepository extends CrudRepository<InvoiceDetail,Long>{

}
