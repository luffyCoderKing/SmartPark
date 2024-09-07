package SmartPark.Parking.Management.System.repository;

import SmartPark.Parking.Management.System.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> findAllByStatus(String status);

    List<Vehicle> findAllByLotId(String lotId);
}
