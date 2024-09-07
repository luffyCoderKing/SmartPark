package SmartPark.Parking.Management.System.service;

import SmartPark.Parking.Management.System.dto.ParkingLotDto;

public interface IParkingLotService {

    ParkingLotDto findLotId(Long id);
    void createParkingLot(ParkingLotDto parkingLotDto);
}
