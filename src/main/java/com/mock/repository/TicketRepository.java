package com.mock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mock.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
