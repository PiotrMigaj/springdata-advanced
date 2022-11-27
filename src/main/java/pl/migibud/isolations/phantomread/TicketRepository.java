package pl.migibud.isolations.phantomread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TicketRepositoryTicketServicePhantomRead")
interface TicketRepository extends JpaRepository<Ticket,Long> {
}
