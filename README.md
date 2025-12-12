Video Drive Link : https://drive.google.com/drive/folders/13wfXfqN-fsOeJXVv7kQ9I31LH6yA7jxg?usp=sharing
# Bezier Rope Simulation (Java Swing)

## Overview
This project demonstrates a **Bezier curve rope simulation** using Java Swing.  
It visually represents a rope or curve defined by **four control points** (P0, P1, P2, P3) and shows how a cubic Bezier curve is drawn in real-time.  

The simulation updates at ~60 FPS and displays both the control points and the curve dynamically. This project was created as part of a placement assignment for FlamApp.

---

## Features
- Draws **control points** for the curve.
- Renders a **smooth cubic Bezier curve** connecting the points.
- **Real-time visualization** with continuous repaint (~60 FPS).
- Fully implemented in **Java Swing**.

---

## File Structure
BezierRope/
│
├─ src/main/java/org/example/
│ ├─ Main.java # Entry point, creates JFrame and adds BezierPanel
│ └─ BezierPanel.java # Draws control points and Bezier curve
│
├─ pom.xml # Maven project file
├─ .gitignore # Git ignore for IDE and build files
└─ README.md # Project overview and instructions

---

## How to Run

### Requirements
- Java JDK 20+ installed
- IntelliJ IDEA (or any Java IDE)
- Maven installed (optional, for building project)

### Steps
1. **Clone the repository**  
   ```bash
   git clone https://github.com/<your-username>/BezierRope.git
   cd BezierRope
How it Works

Control Points: P0, P1, P2, P3 define the curve.

Bezier Math: Uses the cubic Bezier formula:

B(t) = (1-t)^3 * P0 + 3*(1-t)^2 * t * P1 + 3*(1-t) * t^2 * P2 + t^3 * P3


Rendering: Draws small circles for control points (red) and lines connecting points on the curve (blue).
