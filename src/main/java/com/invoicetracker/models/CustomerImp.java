package com.invoicetracker.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customerImpId")
public class CustomerImp extends Customer {
	
	/************************ Field Values ****************/
	
	@ManyToMany
	private Collection<Contractor> contractors;
	
	@ManyToOne
	private Agency agency;
	
	@ManyToMany
	private Collection<InvoiceImp> invoices;
	
	/************************ Getters and Setters ****************/

	public Collection<Contractor> getContractors() {
		return contractors;
	}

	public Agency getAgency() {
		return agency;
	}	
		
}