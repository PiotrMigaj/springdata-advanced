package pl.migibud.isolations.dirtyread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TicketRepositoryTicketServiceDirtyRead")
interface TicketRepository extends JpaRepository<Ticket,Long> {
}
