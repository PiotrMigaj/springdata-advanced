package pl.migibud.isolations.phantomread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("TicketServicePhantomRead")

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
        ticketToFrance.setTicketName("to Canada");
        ticketRepository.save(ticketToFrance);
    }

    @Async

    public void saveNewElement() throws InterruptedException{
        Ticket ticketToFrance = new Ticket();
        ticketToFrance.setTicketName("to France");
        Thread.sleep(2000);
        ticketRepository.save(ticketToFrance);
    }

    @Async
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void show() throws InterruptedException {
        List<Ticket> all = ticketRepository.findAll();
        log.info("AFTER READING T2: {}",all);
        Thread.sleep(4000);
        List<Ticket> all2 = ticketRepository.findAll();
        log.info("AFTER READING T2: {}",all2);
    }

}
