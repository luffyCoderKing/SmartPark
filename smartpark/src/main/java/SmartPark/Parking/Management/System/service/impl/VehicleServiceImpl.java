package SmartPark.Parking.Management.System.service.impl;

import SmartPark.Parking.Management.System.constants.Constants;
import SmartPark.Parking.Management.System.dto.ParkingVehicleDto;
import SmartPark.Parking.Management.System.dto.VehicleDto;
import SmartPark.Parking.Management.System.entity.ParkingLot;
import SmartPark.Parking.Management.System.entity.Vehicle;
import SmartPark.Parking.Management.System.exception.ResourceNotFoundException;
import SmartPark.Parking.Management.System.exception.VehicleAlreadyExistsException;
import SmartPark.Parking.Management.System.mapper.VehicleMapper;
import SmartPark.Parking.Management.System.repository.ParkingLotRepository;
import SmartPark.Parking.Management.System.repository.VehicleRepository;
import SmartPark.Parking.Management.System.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;


    @Override
    public void createVehicle(VehicleDto vehicleDto) {
        String vehicleType = vehicleDto.getType();
        if(!vehicleType.equals("Car") && !vehicleType.equals("Motorcycle") && !vehicleType.equals("Truck")){
            throw new RuntimeException("Vehicle Type should be [Car,Motorcycle,Truck] only");
        }
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto, new Vehicle());
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByLicensePlate(vehicle.getLicensePlate());
        if(optionalVehicle.isPresent()){
            throw new VehicleAlreadyExistsException("Vehicle already registered with a license plate: " + vehicle.getLicensePlate());
        }
        vehicle.setStatus(Constants.AVAILABLE);
        vehicleRepository.save(vehicle);
    }



    @Override
    public Vehicle findLicensePlate(String licensePlate) {

        return vehicleRepository.findByLicensePlate(licensePlate).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "licensePlate", licensePlate)
        );

    }

    @Override
    public void registerVehicleToParkingLot(ParkingVehicleDto parkingVehicleDto) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(parkingVehicleDto.getLicensePlate()).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "vehicle", parkingVehicleDto.getLicensePlate())
        );

        ParkingLot parkingLot = parkingLotRepository.findById(parkingVehicleDto.getLotId()).orElseThrow(
                () -> new ResourceNotFoundException("ParkingLot","lotId", String.valueOf(parkingVehicleDto.getLotId()))
        );

        boolean isVehicleAvailable = vehicle.getStatus().equals(Constants.AVAILABLE);
        int spotsLeft = parkingLot.getCapacity() - parkingLot.getOccupiedSpaces();


        if(isVehicleAvailable && (spotsLeft > 0)) {
            vehicle.setStatus(Constants.UNAVAILABLE);
            vehicle.setLotId(String.valueOf(parkingVehicleDto.getLotId()));

            parkingLot.setOccupiedSpaces(parkingLot.getOccupiedSpaces()+1);
            vehicleRepository.save(vehicle);
        }else{
            throw new RuntimeException("Cannot registered the vehicle into the parking lot " + parkingVehicleDto);
        }
    }

    @Override
    public void unregisterVehicleToParkingLot(ParkingVehicleDto parkingVehicleDto) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(parkingVehicleDto.getLicensePlate()).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle", "vehicle", parkingVehicleDto.getLicensePlate())
        );

        ParkingLot parkingLot = parkingLotRepository.findById(parkingVehicleDto.getLotId()).orElseThrow(
                () -> new ResourceNotFoundException("ParkingLot","lotId", String.valueOf(parkingVehicleDto.getLotId()))
        );

        vehicle.setStatus(Constants.AVAILABLE);
        vehicle.setLotId(null);

        if(parkingLot.getOccupiedSpaces()>0) {
            parkingLot.setOccupiedSpaces(parkingLot.getOccupiedSpaces() - 1);
        }

        vehicleRepository.save(vehicle);
        parkingLotRepository.save(parkingLot);
    }

    @Override
    public List<Vehicle> findAllParkedVehicles(String status) {
        return vehicleRepository.findAllByStatus(status);
    }

    @Override
    public List<Vehicle> findParkedVehicles(String lotId) {
        return vehicleRepository.findAllByLotId(lotId);
    }

}
