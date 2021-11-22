package model;

public class AsianaTicketServiceImpl implements TicketService{
	public void asianaTicketing() {
		System.out.println("아시아나 티켓팅하다");
	}

	@Override
	public void ticketing() {
		asianaTicketing();
	}
	
	
}
