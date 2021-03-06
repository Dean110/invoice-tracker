package com.invoicetracker;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.invoicetracker.controllers.InvoiceController;
import com.invoicetracker.models.Invoice;
import com.invoicetracker.repositories.InvoiceRepository;

public class InvoiceControllerTest {

	@InjectMocks
	private InvoiceController underTest;
	
	@Mock
	private Invoice invoice;
	
	@Mock
	private InvoiceRepository invoiceRepo;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addInvoiceToModel() {
		//arrange
		long arbitraryCourseId = 1;
		//act
		when(invoiceRepo.save(invoice))
		
		//assert
	}
}























