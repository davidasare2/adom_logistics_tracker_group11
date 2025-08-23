# Adom Logistics Fleet Management System

## Overview
Adom Logistics is a regional freight transport company based in Tema. This console-based Java application manages vehicle operations, driver assignments, maintenance schedules, and deliveries using custom data structures and file handling. The system is fully offline and simulates dispatcher decisions.

## Features
- **Vehicle Database:** Add, remove, search trucks/vans. Organized by type or mileage using trees or hash tables.
- **Driver Assignment:** Manage available drivers with stack/queue. Assign based on proximity or experience. Track activity, delays, infractions.
- **Delivery Tracking:** Simulate deliveries with a queue or linked list. Support route updates and rerouting.
- **Maintenance Scheduler:** Use a min-heap/priority queue to flag vehicles for service. Record parts replaced and costs.
- **Fuel Efficiency Reports:** Calculate average fuel use, flag outliers, filter and sort vehicles by performance.
- **File Storage:** All data is saved in `vehicles.txt`, `drivers.txt`, `deliveries.txt`, `maintenance.txt`.
- **Search & Sort:** Binary search on registration numbers. Insertion/merge/quick sort for vehicles/drivers.

## Project Structure
```
adom_logistics_tracker_group11/
├── vehicles.txt
├── deliveries.txt
├── drivers.txt
├── maintenance.txt
├── README.md
├── docs/
│   └── report.md
└── src/
	├── main/
	│   ├── java/
	│   │   └── com/adomlogistics/
	│   │       ├── App.java
	│   │       ├── cli/Menu.java
	│   │       ├── model/
	│   │       │   ├── Vehicle.java
	│   │       │   ├── Driver.java
	│   │       │   ├── Delivery.java
	│   │       │   └── MaintenanceRecord.java
	│   │       ├── ds/
	│   │       │   ├── MyList.java
	│   │       │   ├── MyQueue.java
	│   │       │   ├── MyStack.java
	│   │       │   ├── MyTree.java
	│   │       │   ├── MyHashTable.java
	│   │       │   └── MyMinHeap.java
	│   │       ├── service/
	│   │       │   ├── VehicleService.java
	│   │       │   ├── DriverService.java
	│   │       │   ├── DeliveryService.java
	│   │       │   └── MaintenanceService.java
	│   │       └── util/
	│   │           ├── FileManager.java
	│   │           ├── Sorter.java
	│   │           └── Searcher.java
	│   └── resources/
	└── test/
```

## Getting Started
1. Clone the repository or download the source code.
2. Open in your preferred Java IDE (e.g., IntelliJ, Eclipse, VS Code).
3. Compile and run `App.java` to start the CLI.
4. All data is stored in the root `.txt` files.

## Documentation
- See `docs/report.md` for algorithmic choices, complexity analysis, and modeling decisions.

## Requirements
- Java 8 or higher
- No external libraries or APIs (manual data structure implementation)

## Authors
- Group 11, Adom Logistics