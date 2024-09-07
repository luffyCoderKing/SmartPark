package SmartPark.Parking.Management.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParkingLotAlreadyExistsException extends RuntimeException{

    public ParkingLotAlreadyExistsException(String message){
        super(message);
    }
}
