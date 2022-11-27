package pl.migibud.isolations.nonrepetableread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TicketRepositoryTicketServiceNonRepeatableRead")
interface TicketRepository extends JpaRepository<Ticket,Long> {
}
