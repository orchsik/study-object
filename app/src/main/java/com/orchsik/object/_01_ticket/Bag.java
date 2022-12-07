package com.orchsik.object._01_ticket;

public class Bag {
  private Long amount;
  private Invitation invitation;
  private Ticket ticket;

  public Bag(long amount) {
    this(amount, null);
  }

  public Bag(long amount, Invitation invitation) {
    this.invitation = invitation;
    this.amount = amount;
  }

  public Long hold(Ticket ticket) {
    if (hasInvitation()) {
      setTicket(ticket);
      return 0L;
    } else {
      setTicket(ticket);
      minusAmount(ticket.getFee());
      return ticket.getFee();
    }
  }

  public boolean hasTicket() {
    return ticket != null;
  }

  private void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  private boolean hasInvitation() {
    return invitation != null;
  }

  private void minusAmount(Long amount) {
    this.amount -= amount;
  }

  private void plusAmount(Long amount) {
    this.amount += amount;
  }

}
