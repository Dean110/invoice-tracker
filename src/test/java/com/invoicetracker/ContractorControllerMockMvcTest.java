package com.invoicetracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.invoicetracker.Controllers.ContractorController;
import com.invoicetracker.Repositories.ContractorRepository;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@WebMvcTest(ContractorController.class)
public class ContractorControllerMockMvcTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContractorRepository contractorRepo;
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToCreateInvoice() throws Exception {
		this.mockMvc.perform(get("/contractor/create-invoice")).andExpect(status().isOk());
	}
	
	

}
