package com.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.model.Ticket;
import com.mock.model.User;
import com.mock.repository.TicketRepository;
import com.mock.repository.UserRepository;

@Service
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

}