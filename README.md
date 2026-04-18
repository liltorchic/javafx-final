# NASA Solar Event Tracker

A JavaFX desktop application that fetches and displays real-time solar flare event data from NASA's public REST API. Built as a final project for an Object-Oriented Programming course.

![Java](https://img.shields.io/badge/Java-21-orange) ![JavaFX](https://img.shields.io/badge/JavaFX-21-blue) ![Maven](https://img.shields.io/badge/build-Maven-red) ![License](https://img.shields.io/badge/license-GPL--3.0-green)

---

## Overview

This app queries NASA's [DONKI API](https://api.nasa.gov/) (Space Weather Database of Notifications, Knowledge, Information) to pull recent solar events — such as solar flares, coronal mass ejections, and geomagnetic storms — and presents them in a structured, readable desktop UI.

Key design goals:
- Clean separation of concerns using OOP: API calls, response parsing, and UI are handled by distinct classes
- JSON responses deserialized into typed Java model objects using Jackson
- JavaFX UI built with FXML and ControlsFX components
- Demonstrate understanding implementing third party dependencies

---

## Features

- Fetches live solar event data from the NASA DONKI REST API
- Parses JSON responses into strongly-typed Java model classes
- Displays event data in a clean JavaFX interface with time based charts
- Handles API responses and errors gracefully

---

## Tech stack

| Technology          | Version | Purpose |
|---------------------|---|---|
| Java                | 21 | Core language |
| JavaFX              | 21 | Desktop UI framework |
| Jackson Databind    | 2.13.4.2 | JSON deserialization |
| Jackson Core        | 2.21.1 | JSON deserialization |
| Jackson Annotations | 2.13.4 | JSON deserialization |
| ControlsFX          | 11.2.1 | Extended JavaFX UI components |
| Maven               | 3.x | Build and dependency management |

---

## Getting started

### Prerequisites

- Java 21 or higher
- Maven 3.6+

### Run the app

```bash
git clone https://github.com/liltorchic/javafx-final.git
cd javafx-final
mvn clean javafx:runmvn
```

---

## Project structure

```
src/main/java/com/koehn/javafinal/
├── FLRApplication.java      # App entry point
├── Data.java                # API url builder
├── FLR.java                 # API end point
└── controller/               # JavaFX controllers (UI logic)
```

```
src/main/resources/
├── sampleresponse.json      # local api response for testing
└── com/koehn/javafinal/     # JavaFX layouts (.fxml)
```


---

## API

This project uses NASA's free [DONKI API](https://api.nasa.gov/). No API key setup is required to run the app — NASA provides a `DEMO_KEY` for development use with standard rate limits.

To use your own key, sign up at [api.nasa.gov](https://api.nasa.gov/) and replace the key in `FLRApplication.java`

---

## What I learned

- Consuming and parsing a real-world REST API in Java
- Deserializing nested JSON into typed model classes with Jackson
- Structuring a multi-class OOP project with clear separation of concerns
- Building and running a desktop app with JavaFX and Maven

---

## License

GPL-3.0 — see [LICENSE](LICENSE) for details.
