# Water Service

This repository is one of the three repositories ( Water, [Land](https://github.com/KDG-Muhammet/Land), and [Warehous](https://github.com/KDG-Muhammet/Warehous)) that together form the MineralFlow logistics platform. 
Each repository runs as a separate Spring Boot application with its own database schema and communicates with the others through REST APIs.

## Overview
The **Water Service** manages ship logistics such as docking, inspections, bunkering, and fulfilling Purchase Orders (POs).  
It communicates with the Warehouse service to update stock levels after shipments.

## Features
- Register ship arrivals and coordinate **Inspection Operations (IO)** and **Bunker Operations (BO)** (max 6 per day).
- Fulfill client POs using a **FIFO** inventory strategy.
- Update warehouse stock and calculate KdG commission.

## API Highlights
- `POST /dockoperation` – Register ship arrival and start IO/BO.
- `POST /bunkeroperation` – Schedule bunkering for a ship.
- `POST /fulfillPO` – Deduct warehouse stock and log commission.

## Tech Stack
- **Spring Boot** (Java)
- **PostgreSQL** – Schema: `water`
- **REST** communication with Warehouse service
- **OAuth2 / Keycloak** for security
