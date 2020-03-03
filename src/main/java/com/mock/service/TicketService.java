package com.mock.service;

import java.util.List;

import com.mock.model.Ticket;

public interface TicketService {

	Long getUserId(String userName);
	
	List<Ticket> findAlltickets();

}
