package pl.migibud.springdataadvanced;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.migibud.springdataadvanced.reservation.ReservationService;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringdataAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataAdvancedApplication.class, args);
	}

	private final ReservationService reservationService;

	@EventListener(ApplicationReadyEvent.class)
	public void get(){
		reservationService.save();
	}
}
