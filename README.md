# 🧾 Sales & Commissions Management — Legacy Code Reengineering

This project involved the **reengineering and refactoring** of a legacy Java application code designed to manage sales data and calculate commissions for sales representatives of a clothing company. The goal was to improve the architecture, code quality and maintainability while preserving the original functionality and extending the system with new features.

## 🎯 Project Goals

- **Refactor** problematic code (code smells, poor structure, naming, deprecated APIs, etc.)
- **Improve** modularity, readability and extensibility
- **Implement** unit tests for use cases
- **Extend** the system with new features (HTML input/output support)

## 🧠 Original Functionality

The original application:
- Accepted **TXT** or **XML** input files with sales receipts
- Allowed users to **manually add receipts** via a GUI
- Calculated commissions for sales representatives
- Generated reports in **TXT** or **XML** format

## 🛠️ Refactoring Overview
- Removed **"lazy"** classes (Coat, Shirt, Skirt, Trouser) and replaced them with a clothingType field, handled through a `clothingFactory` class using the **Factory Method** design pattern.
- **Renamed** classes and fields with more meaningful and representative names for clarity and maintainability.
- Moved `ReceiptAppender` classes to the output package, reflecting their true responsibility in the application's architecture.
- **Merged primitive fields** into a `Receipt` class to reduce primitive obsession.
- Extracted common logic shared by similar classes into a **Template Method**, with class-specific variations implemented as concrete steps in subclasses.

## ➕ Extension Features
### 🌐 HTML support added:
- HTMLInput class to parse receipts from structured HTML files

- HTMLReportGenerator class to export sales commission reports in structured HTML format

### 📁 User-driven file selection: 
- Updated the GUI to allow the user to choose a specific directory and filename when saving reports, improving usability and flexibility

### Tests
- Respective unit tests added for the extra features

## 🧪 Testing
- Unit tests implemented for:
  - Input parsing (TXT, XML, HTML)
  - Receipt processing and commission calculation
  - Report generation (TXT, XML, HTML)

## 🧱 Technologies Used
- **Language**: Java
- **Frameworks**: Java and JUnit
- **IDE**: Eclipse
- **Design Patterns Used**:
  - Template Method
  - Factory Method

## 🚀 How to Run
Clone the repository

Open the project in Eclipse

Build and run the application


## 📘 Course Info
Course: Ανάπτυξη Λογισμικού II (Software Development II)

Team: This project was developed in collaboration with two fellow students.
