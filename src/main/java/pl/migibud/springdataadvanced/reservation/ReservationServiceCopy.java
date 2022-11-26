package pl.migibud.springdataadvanced.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.springdataadvanced.passenger.PassengerRepository;
import pl.migibud.springdataadvanced.ticket.Ticket;
import pl.migibud.springdataadvanced.ticket.TicketRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReservationServiceCopy {

    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final BigDecimal TICKET_PRICE = BigDecimal.valueOf(150);


    @Transactional
    public void reserveTicket2(){

        Ticket ticket = new Ticket();
        ticket.setName("To Canada");
        ticketRepository.save(ticket);
        throw new RuntimeException();
    }

//    private boolean validateCreditLimit(BigDecimal accountBalance) {
//        if (accountBalance.compareTo(TICKET_PRICE)<0){
//            throw new CreditLimitException("There is not enough money in the account.");
//        }
//        return true;
//    }
//
//    public static class CreditLimitException extends RuntimeException{
//        public CreditLimitException(String message) {
//            super(message);
//        }
//    }

}
