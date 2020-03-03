package com.mock.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mock.model.Ticket;
import com.mock.service.TicketService;

/**
 * @author hemalakshumi.v
 *
 */
@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	private static final Logger logger = LogManager.getLogger(TicketController.class);

	@GetMapping("/view-tickets")
	public ModelAndView showUserTicket() {
		List<Ticket> ticketList = new ArrayList<>();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Long userId = ticketService.getUserId(userName);
		if (userId != null) {
			ticketList = ticketService.findAlltickets().stream().filter(x -> x.getUser().getUserId() == userId)
					.collect(Collectors.toList());
		}
		return new ModelAndView("userticketlist", "ticketList", ticketList);
	}
}
