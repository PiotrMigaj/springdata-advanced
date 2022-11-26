package pl.migibud.isolations.dirtyread;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("TicketServiceDirtyRead")
@Transactional(rollbackFor = SQLException.class)
@RequiredArgsConstructor
class TicketService {

    private final TicketRepository ticketRepository;

    @Async
    public void update() throws SQLException, InterruptedException {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepository.save(ticketToNorway);
        Thread.sleep(3000);
        throw new SQLException("hehe");
    }

    @Async
    public void show() throws InterruptedException{
        System.out.println(ticketRepository.findAll());
    }

}
