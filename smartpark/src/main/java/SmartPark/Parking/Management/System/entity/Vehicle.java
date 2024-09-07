package SmartPark.Parking.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "type")
    private String type;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "status")
    private String status;

    @Column(name = "lot_id")
    private String lotId;

}
