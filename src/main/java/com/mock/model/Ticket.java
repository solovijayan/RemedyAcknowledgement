package com.mock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tikcetId;
	private Enum<TicketType> ticketType;
	@NotEmpty(message = "Description field should not be empty")
	private String ticketDescription;
	private Enum<TicketStatus> ticketStatus;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getTikcetId() {
		return tikcetId;
	}

	public void setTikcetId(Long tikcetId) {
		this.tikcetId = tikcetId;
	}

	public Enum<TicketType> getTicketType() {
		return ticketType;
	}

	public void setTicketType(Enum<TicketType> ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public Enum<TicketStatus> getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Enum<TicketStatus> ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ticket() {
		super();
	}

}
