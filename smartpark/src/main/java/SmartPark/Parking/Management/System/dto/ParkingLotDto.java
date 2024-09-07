package SmartPark.Parking.Management.System.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ParkingLotDto {

    @NotEmpty(message = "Location can not be a null or empty")
    private String location;

    @Positive(message = "Total number of parking spaces shoud be greater than zero")
    private int capacity;

    @NotNull(message = "Occupied spaces can not be a null")
    private int occupiedSpaces;

}
