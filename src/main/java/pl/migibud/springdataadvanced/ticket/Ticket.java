package pl.migibud.springdataadvanced.ticket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
