package SmartPark.Parking.Management.System.service.impl;

import SmartPark.Parking.Management.System.dto.ParkingLotDto;
import SmartPark.Parking.Management.System.entity.ParkingLot;
import SmartPark.Parking.Management.System.exception.ParkingLotAlreadyExistsException;
import SmartPark.Parking.Management.System.exception.ResourceNotFoundException;
import SmartPark.Parking.Management.System.mapper.ParkingLotMapper;
import SmartPark.Parking.Management.System.repository.ParkingLotRepository;
import SmartPark.Parking.Management.System.service.IParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingLotServiceImpl implements IParkingLotService {

    private ParkingLotRepository parkingLotRepository;

    @Override
    public void createParkingLot(ParkingLotDto parkingLotDto) {
        ParkingLot parkingLot = ParkingLotMapper.mapToParkingLot(parkingLotDto, new ParkingLot());
//        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(parkingLot.getId());
//        if(optionalParkingLot.isPresent()){
//            throw new ParkingLotAlreadyExistsException("Parking lot already registered");
//        }
        parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLotDto findLotId(Long id) {

        ParkingLot parkingLot = parkingLotRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Parking Lot", "Lot Id", String.valueOf(id))
        );

        return ParkingLotMapper.mapToParkingLotDto(parkingLot, new ParkingLotDto());

    }

}
