package pl.migibud.isolations.nonrepetableread;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("RunMeNonRepeatableRead")
@RequiredArgsConstructor
class RunMe {

    private final TicketService ticketService;

//    @EventListener(ApplicationReadyEvent.class)
    public void get() throws InterruptedException {
        ticketService.update();
        ticketService.show();
    }
}
