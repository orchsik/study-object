package com.orchsik.object._01_ticket;

public class Theather {
  private TicketSeller ticketSeller;

  public Theather(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience) {
    ticketSeller.sellTo(audience);
  }

}
