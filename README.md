Vehicle Dealership Management System
This project is a vehicle dealership management system that maintains an inventory of various types of vehicles available for sale. Each vehicle has unique attributes and behaviors, categorized by land, water, and air vehicles. The system supports adding, updating, and managing these vehicles, as well as handling actions like test drives and purchases, with multi-threading and concurrency handling.

Vehicle Types and Attributes
Vehicles are categorized into three main types:

Land Vehicles: Have wheels, can move on different surfaces (paved or unpaved), and store the number of wheels.
Water Vehicles: Can sail with or against the wind, and have a flag representing their country.
Air Vehicles: Used for military or civilian purposes.
Vehicles can also be Motorized or Non-Motorized:

Motorized: Store fuel consumption and engine lifetime.
Non-Motorized: Have an energy source and an energy rating (A, B, C).
Some vehicles are Commercial and require a license type: MINI, LIMITED, or UNLIMITED.

Example Vehicle Implementations
Jeep: A motorized land vehicle for commercial use with four wheels, used off-road, licensed as MINI.
Frigate: A motorized water vehicle under the Israeli flag with specific fuel consumption and engine lifetime.
Spy Glider: A non-motorized air vehicle for military use with a single seat and energy rating C.
Toy Glider: A non-motorized air vehicle for civilian use with an energy rating A and manual power source.
Amphibious Vehicle: Both a land and water vehicle, motorized, used on paved roads.
Electric Bicycle: A motorized land vehicle with two wheels and specific fuel consumption.
Hybrid Aircraft: A motorized air, land, and water vehicle used for military purposes.
Key Design Patterns Implemented
Singleton: Used in MainMenu and VehicleData to ensure a single instance of the main menu and vehicle data management.
Abstract Factory: Used to add vehicles by category (land, water, air) and their respective specific factories.
Decorator: Adds dynamic functionality such as color and state to vehicles at runtime.
Iterator: Allows traversal over the vehicle collection to retrieve specific vehicle data.
Thread Pool: Manages up to seven concurrent test drives, ensuring smooth multi-threading.
Memento: Saves and restores vehicle states while limiting the number of saved states to avoid redundancy.
Observer: Notifies dependent objects when vehicle data changes, ensuring data consistency across modules.
Key System Features
Adding Vehicles: The user can add various types of vehicles by selecting the category and inputting the required data.
Test Drive: Users can take vehicles for test drives by entering the vehicle details and the desired distance.
Reset Mileage: Resets the mileage of all vehicles in the inventory.
Change Flag: Updates the flag of all water vehicles to a user-specified country.
View Inventory: Displays all available vehicles, with hover-based details and dynamic updates reflecting changes in the system.
Concurrency Support: Multiple operations, like test drives and purchases, can happen simultaneously without blocking other processes.
Multi-Threading and Synchronization
Each GUI window runs in its own thread, allowing simultaneous actions.
Test Drives are delayed based on distance.
Purchases involve a random delay, followed by confirmation from the user.
Database Updates after vehicle modifications or purchases include a delay and progress indicator.
Thread Synchronization Rules
Only one test drive can occur per vehicle type (land, water, air) at a time.
Vehicles cannot be purchased while they are on a test drive.
The system ensures all test drives and purchases complete before the program can exit.
This system is designed to manage vehicles efficiently while providing a user-friendly interface and handling concurrent operations. The design patterns ensure maintainability, flexibility, and scalability.
