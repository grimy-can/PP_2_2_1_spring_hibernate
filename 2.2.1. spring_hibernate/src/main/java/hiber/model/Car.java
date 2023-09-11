package hiber.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model")
    String model;

    @Column(name = "series")
    int series;



    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "а/м " + model + " серии " + series;
    }
}
