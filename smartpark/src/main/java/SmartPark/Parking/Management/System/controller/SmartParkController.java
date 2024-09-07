package SmartPark.Parking.Management.System.controller;

import SmartPark.Parking.Management.System.constants.Constants;
import SmartPark.Parking.Management.System.dto.ParkingLotDto;
import SmartPark.Parking.Management.System.dto.ParkingVehicleDto;
import SmartPark.Parking.Management.System.dto.ResponseDto;
import SmartPark.Parking.Management.System.dto.VehicleDto;
import SmartPark.Parking.Management.System.entity.ParkingLot;
import SmartPark.Parking.Management.System.entity.Vehicle;
import SmartPark.Parking.Management.System.exception.ResourceNotFoundException;
import SmartPark.Parking.Management.System.service.IParkingLotService;
import SmartPark.Parking.Management.System.service.IVehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class SmartParkController {

    private IParkingLotService iParkingLotService;
    private IVehicleService iVehicleService;

    @PostMapping("/create-parking-lot")
    public ResponseEntity<ResponseDto> createParkingLot(@Valid @RequestBody ParkingLotDto parkingLotDto){
        iParkingLotService.createParkingLot(parkingLotDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(Constants.STATUS_201, Constants.MESSAGE_201));
    }

    @PostMapping("/create-vehicle")
    public ResponseEntity<ResponseDto> createVehicle(@Valid @RequestBody VehicleDto vehicleDto){
        iVehicleService.createVehicle(vehicleDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(Constants.STATUS_201, Constants.MESSAGE_201));
    }

    @PutMapping("/check-in-vehicle")
    public ResponseEntity<ResponseDto> registerVehicleToParkingLot(@Valid @RequestBody ParkingVehicleDto parkingVehicleDto){

        iVehicleService.registerVehicleToParkingLot(parkingVehicleDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(Constants.STATUS_201, Constants.MESSAGE_201));
    }

    @PutMapping("/check-out-vehicle")
    public ResponseEntity<ResponseDto> unregisterVehicleToParkingLot(@Valid @RequestBody ParkingVehicleDto parkingVehicleDto){

        iVehicleService.unregisterVehicleToParkingLot(parkingVehicleDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(Constants.STATUS_417, "Vehicle has been unregistered to the parking lot successfully"));
    }

    @GetMapping("/parking-lot")
    public ResponseEntity<ParkingLotDto> fetchParkingLot(Long lotId){

        ParkingLotDto parkingLotDto = iParkingLotService.findLotId(lotId);
        return ResponseEntity.status(HttpStatus.OK).body(parkingLotDto);
    }

    @GetMapping("/parked-vehicles")
    public List<Vehicle> fetchParkedVehicles(String lotId){
        List<Vehicle> vehicles = iVehicleService.findParkedVehicles(lotId);
        if(vehicles.isEmpty()){
            throw new RuntimeException("No parked vehicles in parking lot: " + lotId);
        }
        return vehicles;
    }

    @GetMapping("/all-parked-vehicles")
    public List<Vehicle> fetchAllParkedVehicles(){
        List<Vehicle> vehicles = iVehicleService.findAllParkedVehicles(Constants.UNAVAILABLE);
        if(vehicles.isEmpty()){
            throw new RuntimeException("No parked vehicles to display");
        }
        return vehicles;
    }

}
