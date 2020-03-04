package com.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mock.model.Ticket;
import com.mock.model.User;
import com.mock.repository.TicketRepository;
import com.mock.repository.UserRepository;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public Long getUserId(String userName) {
		Long userId = null;
		try {
			User user = userRepository.findByUserName(userName);
			if (user != null) {
				userId = user.getUserId();
			}
		} catch (Exception e) {

		}
		return userId;
	}

	@Override
	public List<Ticket> findAlltickets() {
		return (List<Ticket>) ticketRepository.findAll();
	}
	
	@Override
	public void createTicket(Ticket ticket) {
		
		ticketRepository.save(ticket);
	}



	@Override
	public List<Ticket> getTicketList() {
		List<Ticket> ticketlist = (List<Ticket>) ticketRepository.getTickets();
		return ticketlist;

	}

	public Ticket getTicket(Long ticketId) {
		Ticket tickets = new Ticket();
		Ticket ticket = ticketRepository.findOne(ticketId);
		/*tickets.setTicketStatus(ticket.getTicketStatus());
		tickets.setTikcetId(ticketId);
		tickets.setUser(ticket.getUser());
		tickets.setTicketDescription(ticket.getTicketDescription());*/
		/*ticketRepository.save(tickets);*/
		return ticket;
	}

	@Override
	public void updateTicket(Ticket ticket) {
	
		ticketRepository.updateTicket(ticket.getTicketStatus(),ticket.getTicketId());
		
	}


}