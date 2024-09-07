package SmartPark.Parking.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "parking_lot")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private int capacity;

    private int occupiedSpaces;

}
