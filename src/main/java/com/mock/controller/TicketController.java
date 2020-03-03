package com.mock.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mock.model.Ticket;
import com.mock.model.User;
import com.mock.service.TicketService;
import com.mock.service.UserService;

/**
 * @author hemalakshumi.v
 *
 */
@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@Autowired
	UserService userService;


	private static final Logger logger = LogManager.getLogger(TicketController.class);
	
	
	@GetMapping(value = "ticket")
	public ModelAndView ticketForm(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("TicketForm");
		mav.addObject("ticket", new Ticket());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(auth.getName());
		logger.info(userService.getUserId(auth.getName()));
		session.setAttribute("user", userService.getUserId(auth.getName()));
		return mav;
	}

	@PostMapping(value = "ticket")
	public ModelAndView createTicket(@ModelAttribute("ticket") @Validated Ticket ticket, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mav.setViewName("TicketForm");
			return mav;
		} else {
			logger.info("In save ticket: "+session.getAttribute("user"));
			ticket.setUser((User)session.getAttribute("user"));
			ticketService.createTicket(ticket);
			mav.addObject("message", "Ticket created Successfully!");
		}
		return new ModelAndView("redirect:/home");
	}
	
	//added this in usercontroller
	/*@GetMapping("/view-tickets")
	public ModelAndView showUserTicket() {
		List<Ticket> ticketList = new ArrayList<>();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Long userId = ticketService.getUserId(userName);
		if (userId != null) {
			ticketList = ticketService.findAlltickets().stream().filter(x -> x.getUser().getUserId() == userId)
					.collect(Collectors.toList());
		}
		return new ModelAndView("userhome", "ticketList", ticketList);
	}*/
	
	

}
