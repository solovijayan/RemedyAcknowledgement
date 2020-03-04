package com.mock.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mock.model.Ticket;
import com.mock.service.TicketService;

/**
 * @author sabarinathan.r
 *
 */
@RestController
public class AdminController {
	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets")
	public ModelAndView inventoryList(Map<String, Object> map, Model model) {
		map.put("ticketlist", new Ticket());
		List<Ticket> ticket = ticketService.getTicketList();
		model.addAttribute("ticketlist", ticket);
		return new ModelAndView("ticketlist");
	}

	@GetMapping(value = "/editticket")
	public ModelAndView editTicket(@RequestParam("getId") Long ticketId, Model model) {
		System.out.println(ticketId);
		Ticket ticket = ticketService.getTicket(ticketId);
		model.addAttribute("ticket", ticket);
		return new ModelAndView("editstatus");

	}

	@PostMapping(value = "/updateticket")
	public ModelAndView updateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticketService.updateTicket(ticket);
		return new ModelAndView("redirect:/tickets");

	}

}
