package pl.migibud.isolations.nonrepetableread;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("TicketServiceNonRepeatableRead")

class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        save();
    }

    public void save(){
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepository.save(ticketToNorway);

        Ticket ticketToFrance = new Ticket();
        ticketToFrance.setTicketName("to France");
        ticketRepository.save(ticketToFrance);
    }

    @Async
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void update() throws InterruptedException {
        Ticket ticketById = ticketRepository.findById(1L).get();
        ticketById.setTicketName("to USA");
        Thread.sleep(2000);
        ticketRepository.save(ticketById);
        Ticket newTicketValue = ticketRepository.findById(1L).get();
        log.info("AFTER UPDATE T2: {}",newTicketValue);
    }

    @Async
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void show() throws InterruptedException{
        Ticket ticketById = ticketRepository.findById(1L).get();
        log.info("AFTER READING T1: {}",ticketById);
        Thread.sleep(5000);
        Ticket ticketById2 = ticketRepository.findById(1L).get();
        log.info("AFTER UPDATE T1: {}",ticketById2);
    }

}
