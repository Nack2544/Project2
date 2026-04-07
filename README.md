# Road Traffic Data Analyzer

A Java application that reads, processes, and analyzes road traffic volume and speed data from CSV files, designed as part of a Data Structures & Algorithms course at the University of North Florida (UNF).

## Overview

This project demonstrates object-oriented programming principles in Java including class design, file I/O, CSV parsing, and data processing across multiple related data sets.

## Features

- Reads road volume and speed data from CSV input files
- Processes traffic data across multiple road sections
- Calculates total volume, average volume, and average speed per section
- Outputs processed results to a report file
- Handles invalid input with exception management

## How It Works

1. User provides paths to volume and speed CSV data files
2. Data is loaded into `RoadVolume` and `RoadSpeed` objects
3. `RoadSection` combines both data sets and computes traffic metrics
4. Results are written to an output file

## Usage

```bash
javac src/*.java
java -cp src Project2
# Enter Path and Name of Volume and Speed Data File: Volume_Data.csv Speed_Data.csv
```

## Technologies

- Java
- Object-Oriented Programming (OOP)
- CSV File Parsing
- Exception Handling

## Project Structure

```
src/
  Project2.java       - Main class and program entry point
  RoadSection.java    - Combines volume and speed data, computes metrics
  RoadVolume.java     - Models road volume sensor data
  RoadSpeed.java      - Models road speed sensor data
  FileHandler.java    - Handles CSV file reading and parsing
Flowchart.png         - Program flow diagram
```
