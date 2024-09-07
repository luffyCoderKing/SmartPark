# SmartPark
 Smart Parking Management System
 
 Postman Collection: use to test the API
 SmartPark.postman_collection
 
@PostMapping("/create-parking-lot")
 Create a parking lot

@PostMapping("/create-vehicle"):
Create a vehicle record

@PutMapping("/check-in-vehicle")
Register a vehicle in a parking lot

@PutMapping("/check-out-vehicle")
Unregistering a vehicle in a parking lot

@GetMapping("/parking-lot")
Display the current occupancy and vacancies in a parking lot

@GetMapping("/parked-vehicles")
Display the parked vehicles in a certain parking lot

@GetMapping("/all-parked-vehicles")
Display all the parked vehicles along with there dedicated parking lot

