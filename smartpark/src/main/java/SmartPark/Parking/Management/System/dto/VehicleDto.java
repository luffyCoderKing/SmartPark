package SmartPark.Parking.Management.System.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class VehicleDto {

    @NotEmpty(message = "License Plate can not be a null or empty")
    @Pattern(regexp="([A-Za-z0-9\\-_]+)",message = "License Plate should only contain letters, numbers and dashes")
    private String licensePlate;

    @NotEmpty(message = "Type can not be a null or empty")
    private String type;

    @NotEmpty(message = "Owner name can not be a null or empty")
    private String ownerName;

    private String status;

    private String lotId;

}
