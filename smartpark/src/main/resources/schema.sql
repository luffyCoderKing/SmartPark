 CREATE TABLE IF NOT EXISTS `parking_lot` (
   `id` int AUTO_INCREMENT PRIMARY KEY,
   `location` varchar(200) NOT NULL,
   `capacity` int NOT NULL,
   `occupied_spaces` int NOT NULL
 );

 CREATE TABLE IF NOT EXISTS `vehicle` (
   `id` int AUTO_INCREMENT PRIMARY KEY,
   `license_plate` varchar(100) NOT NULL,
   `type` varchar(100) NOT NULL,
   `owner_name` varchar(200) NOT NULL,
   `status` varchar(200) NOT NULL,
   `lot_id` int NULL
 );