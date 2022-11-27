package pl.migibud.isolations.dirtyread;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("TicketServiceDirtyRead")
@RequiredArgsConstructor
class TicketService {

    private final TicketRepository ticketRepository;

    @Async
    @Transactional
    public void update() throws InterruptedException {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepository.save(ticketToNorway);
        Thread.sleep(3000);
        throw new RuntimeException("hehe");
    }

    @Async
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void show() throws InterruptedException{
        Thread.sleep(1000);
        log.info("Ticked read from db: {}",ticketRepository.findAll());
    }

}
