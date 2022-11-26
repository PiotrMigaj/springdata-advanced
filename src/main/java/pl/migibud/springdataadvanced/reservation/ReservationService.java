package pl.migibud.springdataadvanced.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.springdataadvanced.passenger.Passenger;
import pl.migibud.springdataadvanced.passenger.PassengerRepository;
import pl.migibud.springdataadvanced.ticket.Ticket;
import pl.migibud.springdataadvanced.ticket.TicketRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final BigDecimal TICKET_PRICE = BigDecimal.valueOf(150);
    private final ReservationServiceCopy reservationServiceCopy;

    @Transactional
    public void reserveTicket() {
        Passenger passenger = new Passenger();
        passenger.setName("Adam");
        passenger.setAccountBalance(BigDecimal.valueOf(100));
        passengerRepository.save(passenger);
        try {
            reservationServiceCopy.reserveTicket2();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
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
