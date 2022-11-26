package pl.migibud.springdataadvanced.passenger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal accountBalance;
}
