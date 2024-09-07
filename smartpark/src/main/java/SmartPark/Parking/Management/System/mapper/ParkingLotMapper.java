package SmartPark.Parking.Management.System.mapper;

import SmartPark.Parking.Management.System.dto.ParkingLotDto;
import SmartPark.Parking.Management.System.dto.VehicleDto;
import SmartPark.Parking.Management.System.entity.ParkingLot;
import SmartPark.Parking.Management.System.entity.Vehicle;

public class ParkingLotMapper {

    public static ParkingLotDto mapToParkingLotDto(ParkingLot parkingLot, ParkingLotDto parkingLotDto){
        parkingLotDto.setLocation(parkingLot.getLocation());
        parkingLotDto.setCapacity(parkingLot.getCapacity());
        parkingLotDto.setOccupiedSpaces(parkingLot.getOccupiedSpaces());
        return parkingLotDto;
    }

    public static ParkingLot mapToParkingLot(ParkingLotDto parkingLotDto, ParkingLot parkingLot){
        parkingLot.setLocation(parkingLotDto.getLocation());
        parkingLot.setCapacity(parkingLotDto.getCapacity());
        parkingLot.setOccupiedSpaces(parkingLotDto.getOccupiedSpaces());
        return parkingLot;
    }

}
