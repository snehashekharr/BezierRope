package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BezierPanel extends JPanel {

    // -----------------------
    // CONTROL POINTS
    // -----------------------
    Point P0 = new Point(100, 300);
    Point P3 = new Point(800, 300);

    // dynamic points
    Point P1 = new Point(300, 150);
    Point P2 = new Point(600, 450);

    // physics variables
    Point targetP1 = new Point(P1);
    Point targetP2 = new Point(P2);

    double vx1 = 0, vy1 = 0; // velocity for P1
    double vx2 = 0, vy2 = 0; // velocity for P2

    double k = 0.05;        // spring constant
    double damping = 0.85;  // damping factor

    public BezierPanel() {

        // ---------- MOUSE MOVEMENT CONTROLS ----------
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();

                // targets for P1 and P2 relative to mouse
                targetP1.x = mx;
                targetP1.y = my - 150;

                targetP2.x = mx;
                targetP2.y = my + 150;
            }
        });

        // Timer updates physics & repaint
        Timer timer = new Timer(16, e -> updatePhysics());
        timer.start();
    }

    // -----------------------
    // UPDATE PHYSICS
    // -----------------------
    private void updatePhysics() {
        // P1 physics
        double ax1 = -k * (P1.x - targetP1.x);
        double ay1 = -k * (P1.y - targetP1.y);

        vx1 = (vx1 + ax1) * damping;
        vy1 = (vy1 + ay1) * damping;

        P1.x += vx1;
        P1.y += vy1;

        // P2 physics
        double ax2 = -k * (P2.x - targetP2.x);
        double ay2 = -k * (P2.y - targetP2.y);

        vx2 = (vx2 + ax2) * damping;
        vy2 = (vy2 + ay2) * damping;

        P2.x += vx2;
        P2.y += vy2;

        repaint();
    }

    // -----------------------
    // MAIN DRAWING FUNCTION
    // -----------------------
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(3));

        // Draw control points
        g2.setColor(Color.RED);
        drawPoint(g2, P0);
        drawPoint(g2, P1);
        drawPoint(g2, P2);
        drawPoint(g2, P3);

        // Draw Bezier curve
        drawBezierCurve(g2);
    }

    // -----------------------
    // DRAW ONE POINT
    // -----------------------
    private void drawPoint(Graphics2D g, Point p) {
        g.fillOval(p.x - 5, p.y - 5, 10, 10);
    }

    // -----------------------
    // BEZIER MATH
    // -----------------------
    private Point bezier(double t, Point P0, Point P1, Point P2, Point P3) {
        double u = 1 - t;

        int x = (int) (
                u*u*u * P0.x +
                        3*u*u*t * P1.x +
                        3*u*t*t * P2.x +
                        t*t*t * P3.x
        );

        int y = (int) (
                u*u*u * P0.y +
                        3*u*u*t * P1.y +
                        3*u*t*t * P2.y +
                        t*t*t * P3.y
        );

        return new Point(x, y);
    }

    // -----------------------
    // DRAW BEZIER CURVE
    // -----------------------
    private void drawBezierCurve(Graphics2D g) {
        g.setColor(Color.BLUE);

        Point prev = P0;

        for (double t = 0; t <= 1; t += 0.01) {
            Point next = bezier(t, P0, P1, P2, P3);
            g.drawLine(prev.x, prev.y, next.x, next.y);
            prev = next;
        }
    }
}