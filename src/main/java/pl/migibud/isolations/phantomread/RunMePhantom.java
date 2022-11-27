package pl.migibud.isolations.phantomread;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("RunMePhantomRead")
@RequiredArgsConstructor
class RunMePhantom {

    private final TicketService ticketService;

//    @EventListener(ApplicationReadyEvent.class)
    public void get() throws InterruptedException {
        ticketService.saveNewElement();
        ticketService.show();
    }
}
