package SmartPark.Parking.Management.System.mapper;

import SmartPark.Parking.Management.System.dto.VehicleDto;
import SmartPark.Parking.Management.System.entity.Vehicle;

public class VehicleMapper {

    public static VehicleDto mapToVehicleDto(Vehicle vehicle, VehicleDto vehicleDto){
        vehicleDto.setLicensePlate(vehicle.getLicensePlate());
        vehicleDto.setType(vehicle.getType());
        vehicleDto.setOwnerName(vehicle.getOwnerName());
        vehicleDto.setStatus(vehicle.getStatus());
        vehicleDto.setLotId(vehicle.getLotId());
        return vehicleDto;
    }

    public static Vehicle mapToVehicle(VehicleDto vehicleDto, Vehicle vehicle){
        vehicle.setLicensePlate(vehicleDto.getLicensePlate());
        vehicle.setType(vehicleDto.getType());
        vehicle.setOwnerName(vehicleDto.getOwnerName());
        vehicle.setStatus(vehicleDto.getStatus());
        vehicle.setLotId(vehicleDto.getLotId());
        return vehicle;
    }
}
