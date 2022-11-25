package pl.migibud.springdataadvanced.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.springdataadvanced.ticket.Ticket;
import pl.migibud.springdataadvanced.ticket.TicketRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final TicketRepository ticketRepository;

    @Transactional
    public void save(){
        Ticket ticket = new Ticket();
        ticket.setName("To Canada");
        ticketRepository.save(ticket);
        System.out.println(10/0);
    }

}
