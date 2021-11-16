package model;

public class KalTicketServiceImpl implements TicketService{
	public void kalTicketing() {
		System.out.println("대한항공 티켓팅하다");
	}

	@Override
	public void ticketing() {
		kalTicketing();
	}
}
