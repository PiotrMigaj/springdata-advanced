package pl.migibud.isolations.dirtyread;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("RunDirtyRead")
@RequiredArgsConstructor
class RunMeDirty {

    private final TicketService ticketService;

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws SQLException, InterruptedException {
        ticketService.update();
        ticketService.show();

    }
}
