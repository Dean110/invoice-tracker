package com.invoicetracker.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
//the jar file for this import is on the desktop 
// source of file is found https://stackoverflow.com/questions/8997598/importing-json-into-an-eclipse-project
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoicetracker.models.Customer;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.models.ServiceItem;
import com.invoicetracker.repositories.CustomerRepository;
import com.invoicetracker.repositories.InvoiceRepository;
import com.invoicetracker.repositories.ServiceItemRepository;

@CrossOrigin
@Controller
public class InvoiceController {

	@Resource
	private InvoiceRepository invoiceRepo;
	
	@Resource
	private ServiceItemRepository serviceItemRepo;
	
	@Resource
	private CustomerRepository customerRepo;
	
//	@RequestMapping("submit-invoice")
//	private void createNewInvoice(@RequestBody String body) throws JSONException {
//		JSONObject newInvoice = new JSONObject(body);
//		String dateOfInvoice = newInvoice.getString("invoiceDate");
//		LocalDate localDate = LocalDate.parse(dateOfInvoice);
//		invoiceRepo.save(new Invoice(localDate));
//	}
	
	@RequestMapping("submit-invoice")
	private void createNewInvoice(@RequestBody String body) throws JSONException {
		JSONObject newInvoice = new JSONObject(body);
		
		String dateOfInvoice = newInvoice.getJSONObject("invoiceNumbersJson").getString("invoiceDate");
		LocalDate localDate = LocalDate.parse(dateOfInvoice);
		Invoice invoice = new Invoice(localDate);
		invoiceRepo.save(invoice);	
		
		JSONArray serviceItems = newInvoice.getJSONArray("invoiceArray");

		for (int i=0; i < serviceItems.length(); i++) {
			String serviceName = serviceItems.getJSONObject(1).getString("clientName");
			Customer customer = new Customer(serviceName);
			System.out.println(serviceName + " Hey You guuuuuuuuaaaaaaiiiiiiiiiiiiiissss!!!!!!!!!!!!!!!!!!!!!");
			String serviceDate = serviceItems.getJSONObject(1).getString("serviceDate");
			LocalDate localServiceDate = LocalDate.parse(serviceDate);
			ServiceItem serviceItem = new ServiceItem(localServiceDate);
			serviceItem.setCustomer(customer);
			customerRepo.save(customer);
			serviceItemRepo.save(serviceItem);
			invoice.addServiceItem(serviceItem);
			invoiceRepo.save(invoice);
		}
		
	
		
		int invoiceNumber = newInvoice.getJSONObject("invoiceNumbersJson").getInt("invoiceNumber");
		invoice.setInvoiceNumber(invoiceNumber);
		
		
		invoiceRepo.save(invoice);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
