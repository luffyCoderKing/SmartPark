package SmartPark.Parking.Management.System.service;

import SmartPark.Parking.Management.System.dto.ParkingVehicleDto;
import SmartPark.Parking.Management.System.dto.VehicleDto;
import SmartPark.Parking.Management.System.entity.Vehicle;

import java.util.List;

public interface IVehicleService {

    Vehicle findLicensePlate(String licensePlate);

    void createVehicle(VehicleDto vehicleDto);

    void registerVehicleToParkingLot(ParkingVehicleDto parkingVehicleDto);

    void unregisterVehicleToParkingLot(ParkingVehicleDto parkingVehicleDto);

    List<Vehicle> findAllParkedVehicles(String status);

    List<Vehicle> findParkedVehicles(String lotId);
}
