package hiber.model;

import lombok.*;
import javax.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @Override
    public String toString() {
        return "а/м " + model + " серии " + series;
    }
}
