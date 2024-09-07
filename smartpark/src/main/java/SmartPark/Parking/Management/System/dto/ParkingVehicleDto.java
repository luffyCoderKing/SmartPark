package SmartPark.Parking.Management.System.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParkingVehicleDto {

    @NotNull(message = "lotId can not be a null or empty")
    private long lotId;

    @NotEmpty(message = "licensePlate can not be a null or empty")
    private String licensePlate;

}
