import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;

// candle baby
// ref: https://www.pinterest.com/pin/584905070374334075/
public class Assignment2_65050427_65050242 extends JPanel implements Runnable {
    int frame = 1;
    int animate = 0;

    public static void main(String[] args) {
        Assignment2_65050427_65050242 m = new Assignment2_65050427_65050242();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("baby candle🕯️");
        f.setSize(600, 625);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        (new Thread(m)).start();
    }

    @Override
    public void run() {
        double lasttime = System.currentTimeMillis();
        double currentTime, elapsedTime;
        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lasttime;
            if (elapsedTime >= 100) {
                frame += 1;
                lasttime = currentTime;
                repaint();
                if (frame > 10 && frame <= 60) {
                    animate++;
                }
                if (frame > 60) {
                    animate = 50;
                }
                if (frame > 70) {
                    frame = 1;
                    animate = 0;
                }
            }

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.setColor(Color.white);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.black);
        int animation = (2 * animate);

        bodyCandle(g2, animation);
        TextCandle(g2);
        paintColor(buffer, animation);

        g.drawImage(buffer, 0, 0, null);
    }

    private void TextCandle(Graphics2D g2) {
        // C
        g2.setColor(Color.decode("#79DE79"));
        bezierCurve(g2, 63, 10, -17, -2, -9, 107, 64, 95, 4);
        bezierCurve(g2, 63, 10, 101, 15, 89, 49, 64, 44, 4);
        bezierCurve(g2, 64, 95, 102, 89, 92, 53, 64, 59, 4);
        bezierCurve(g2, 64, 59, 44, 56, 50, 42, 64, 44, 4);

        // A
        g2.setColor(Color.decode("#FDAA18"));
        bezierCurve(g2, 48, 164, 28, 215, -9, 171, 18, 127, 4);
        bezierCurve(g2, 48, 164, 44, 192, 112, 209, 79, 127, 4);
        bezierCurve(g2, 18, 127, 31, 83, 73, 98, 79, 127, 4);
        midpointCircle(g2, 48, 140, 8, 4);

        // N
        g2.setColor(Color.decode("#FB6962"));
        bezierCurve(g2, 48, 251, 49, 311, 4, 289, 10, 244, 4);
        bezierCurve(g2, 48, 251, 57, 328, 103, 290, 98, 251, 4);
        bezierCurve(g2, 10, 244, 7, 189, 59, 191, 61, 236, 4);
        bezierCurve(g2, 61, 236, 60, 188, 110, 196, 98, 251, 4);

        // D
        g2.setColor(Color.decode("#79DE79"));
        bezierCurve(g2, 46, 303, -4, 291, -4, 403, 47, 392, 4);
        bezierCurve(g2, 46, 303, 98, 298, 121, 388, 47, 392, 4);
        // midpointCircle(g2, 49, 349, 8, 4);
        midpointEllipse(g2, 49, 349, 8, 10, 4);

        // L
        g2.setColor(Color.decode("#FDAA18"));
        bezierCurve(g2, 62, 452, 94, 424, 115, 484, 61, 486, 4);
        bezierCurve(g2, 62, 452, 82, 394, 16, 374, 25, 452, 4);
        bezierCurve(g2, 25, 452, 23, 461, 33, 488, 61, 486, 4);

        // E
        g2.setColor(Color.decode("#FB6962"));
        bezierCurve(g2, 58, 502, 10, 494, 10, 592, 60, 586, 4);
        bezierCurve(g2, 58, 502, 109, 502, 103, 536, 61, 532, 4);
        bezierCurve(g2, 61, 532, 94, 540, 75, 555, 63, 558, 4);
        bezierCurve(g2, 63, 558, 90, 551, 119, 582, 60, 586, 4);
    }

    private void bodyCandle(Graphics2D g2, int animation) {
        // ตัวด้านซ้าย
        bresenhamLine(g2, 204, 300 + animation, 204, 494, 2);
        // ตัวด้านล่าง
        bresenhamLine(g2, 204, 494, 393, 494, 2);
        // ตัวด้านขวา
        bresenhamLine(g2, 393, 494, 393, 279 + animation, 2);

        // ขาด้านซ้าย
        bresenhamLine(g2, 246, 494, 246, 552, 2);
        bresenhamLine(g2, 273, 494, 273, 555, 2);
        midpointEllipse(g2, 250, 560, 30, 10, 2);

        // ขาด้านขวา
        bresenhamLine(g2, 350, 494, 350, 554, 2);
        bresenhamLine(g2, 323, 494, 323, 553, 2);
        midpointEllipse(g2, 330, 560, 30, 10, 2);

        // เทียนละลายซ้าย
        bezierCurve(g2, 212, 300 + animation, 181, 310 + animation, 154, 145 + animation, 241, 143 + animation, 2);

        // เทียนละลายบน
        bresenhamLine(g2, 241, 143 + animation, 360, 143 + animation, 2);

        // เทียนละลายขวา
        bezierCurve(g2, 360, 143 + animation, 441, 145 + animation, 430, 309 + animation, 377, 277 + animation, 2);

        // ตัวเทียนละลายล่างขวา
        bezierCurve(g2, 377, 277 + animation, 354, 265 + animation, 367, 168 + animation, 326, 211 + animation, 2);
        // ตัวเทียนละลายล่างกลาง
        bezierCurve(g2, 326, 211 + animation, 310, 268 + animation, 279, 233 + animation, 276, 211 + animation, 2);
        // ตัวเทียนละลายล่างซ้าย
        bezierCurve(g2, 276, 211 + animation, 230, 171 + animation, 261, 277 + animation, 212, 300 + animation, 2);

        // ก้านเทียน
        bresenhamLine(g2, 300, 140 + animation, 300, 113 + animation, 5);

        int angdeg = -30 + (animation / 2);
        // เปลวไฟ
        g2.rotate(Math.toRadians(angdeg), 300, 113 + animation);
        midpointEllipse(g2, 302, 75 + animation, 20, 40, 3);
        // midpointEllipse(g2, 302, 85 + animation, 10, 30, 2);

        g2.rotate(-Math.toRadians(angdeg), 300, 113 + animation);
        // ตา
        midpointCircle(g2, 255, 300 + animation, 15, 2);
        midpointCircle(g2, 340, 300 + animation, 15, 2);

        // ปาก
        midpointEllipse(g2, 300, 324 + animation, 30, 15, 2);
        bezierCurve(g2, 285, 335 + animation, 282, 323 + animation, 310, 316 + animation, 309, 337 + animation, 2);

        // แก้ม
        midpointEllipse(g2, 247, 330 + animation, 15, 10, 2);
        midpointEllipse(g2, 350, 330 + animation, 15, 10, 2);

        // แขนซ้าย
        bezierCurve(g2, 204, 334 + animation, 171, 333 + animation, 154, 375 + animation, 204, 381 + animation, 2);
        bezierCurve(g2, 204, 348 + animation, 193, 343 + animation, 175, 360 + animation, 204, 366 + animation, 2);

        // แขนขวา
        bezierCurve(g2, 393, 334 + animation, 418, 335 + animation, 451, 367 + animation, 393, 380 + animation, 2);
        bezierCurve(g2, 393, 348 + animation, 413, 347 + animation, 419, 361 + animation, 393, 366 + animation, 2);

        // ผ้า
        bezierCurve(g2, 204, 339 + animation, 237, 354 + animation, 371, 356 + animation, 393, 336 + animation, 2);
        bezierCurve(g2, 204, 381 + animation, 231, 391 + animation, 347, 398 + animation, 393, 381 + animation, 2);

        // ตารางผ้า
        bresenhamLine(g2, 233, 346 + animation, 233, 387 + animation, 2);
        bresenhamLine(g2, 260, 349 + animation, 260, 390 + animation, 2);
        bresenhamLine(g2, 292, 349 + 3 + animation, 292, 390 + 3 + animation, 2);
        bresenhamLine(g2, 322, 349 + 3 + animation, 322, 390 + 3 + animation, 2);
        bresenhamLine(g2, 355, 349 + animation, 355, 390 + animation, 2);

        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.drawString((100 - animation) + "%", 470, 200 + animation);

    }

    private void paintColor(BufferedImage buffer, int animation) {
        // สีเปลวไฟ
        floodfill(buffer, 300, 80 + animation, Color.white, Color.decode("#fb5c04"));

        // สีเทียนละลาย
        floodfill(buffer, 300, 160 + animation, Color.white,
                Color.decode("#fddcb4"));

        // สีตัวเทียน
        floodfill(buffer, 300, 300 + animation, Color.white,
                Color.decode("#fbe5ba"));
        floodfill(buffer, 380, 488, Color.white,
                Color.decode("#fbe5ba"));

        // สีตา
        floodfill(buffer, 255, 300 + animation, Color.white, Color.black);
        floodfill(buffer, 340, 300 + animation, Color.white, Color.black);

        // สีปาก
        floodfill(buffer, 310, 324 + animation, Color.white, Color.black);
        floodfill(buffer, 295, 326 + animation, Color.white, Color.decode("#e9a690"));

        // สีแก้ม
        floodfill(buffer, 247, 330 + animation, Color.white, Color.decode("#e9a690"));
        floodfill(buffer, 350, 330 + animation, Color.white, Color.decode("#e9a690"));

        // สีแขน
        floodfill(buffer, 190, 338 + animation, Color.white, Color.decode("#ffd6a4"));
        floodfill(buffer, 400, 340 + animation, Color.white, Color.decode("#ffd6a4"));

        // สีขา
        floodfill(buffer, 260, 500, Color.white, Color.decode("#ffd6a4"));
        floodfill(buffer, 340, 500, Color.white, Color.decode("#ffd6a4"));

        // สีรองเท้า
        floodfill(buffer, 250, 560, Color.white, Color.decode("#5d76cb"));
        floodfill(buffer, 330, 560, Color.white, Color.decode("#5d76cb"));

        // สีผ้า
        floodfill(buffer, 223, 356 + animation, Color.white, Color.decode("#79DE79"));
        floodfill(buffer, 253, 356 + animation, Color.white, Color.decode("#FCFC99"));
        floodfill(buffer, 253 + 30, 356 + animation, Color.white, Color.decode("#FB6962"));
        floodfill(buffer, 253 + 60, 356 + animation, Color.white, Color.decode("#79DE79"));
        floodfill(buffer, 253 + 90, 356 + animation, Color.white, Color.decode("#FCFC99"));
        floodfill(buffer, 253 + 120, 356 + animation, Color.white, Color.decode("#FB6962"));

    }

    private void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int size) {
        for (int i = 0; i <= 1000; i++) {

            double t = i / 1000.0;

            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * Math.pow(t, 2) * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * Math.pow(t, 2) * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, x, y, size);
        }
    }

    private void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2, int size) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;
        if (dy > dx) {
            double dd = dx;
            dx = dy;
            dy = dd;
            isSwap = true;
        }
        double D = 2 * dy - dx;
        double x = x1;
        double y = y1;
        for (int i = 1; i < dx; i++) {
            plot(g, (int) x, (int) y, size);
            if (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }
            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }
            D += 2 * dy;
        }
    }

    public BufferedImage floodfill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<Point>();

        if (m.getRGB(x, y) == targetColor.getRGB()) {
            g2.setColor(replacementColor);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));
        }
        while (!q.isEmpty()) {
            Point p = q.poll();

            // south
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }
        return m;

    }

    private void midpointCircle(Graphics g, int xc, int yc, int r, int size) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {
            plotSymmetricPointsCircle(g, xc, yc, x, y, size);

            x++;
            Dx += 2;
            D = D + Dx + 1;

            if (D >= 0) {
                y--;
                Dy -= 2;
                D = D - Dy;
            }
        }
    }

    private void midpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        /* REGION 1 */
        int x = 0;
        int y = b;
        int D = Math.round(b2 - a2 * b + a2 / 4);
        int Dx = 0;
        int Dy = twoA2 * y;

        while (Dx <= Dy) {

            plotSymmetricPointsEllipse(g, xc, yc, x, y, size);

            x++;
            Dx = Dx + twoB2;
            D = D + Dx + b2;

            if (D >= 0) {
                y--;
                Dy = Dy - twoA2;
                D = D - Dy;
            }
        }

        /* REGION 2 */
        x = a;
        y = 0;
        D = Math.round(a2 - b2 * a + b2 / 4);
        Dx = twoB2 * x;
        Dy = 0;

        while (Dx >= Dy) {

            plotSymmetricPointsEllipse(g, xc, yc, x, y, size);

            y++;
            Dy = Dy + twoA2;
            D = D + Dy + a2;

            if (D >= 0) {
                x--;
                Dx = Dx - twoB2;
                D = D - Dx;
            }
        }
    }

    private void plotSymmetricPointsCircle(Graphics g, int xc, int yc, int x, int y, int size) {
        plot(g, xc + x, yc + y, size); // Octant 1
        plot(g, xc + y, yc + x, size); // Octant 2
        plot(g, xc - x, yc + y, size); // Octant 3
        plot(g, xc - y, yc + x, size); // Octant 4
        plot(g, xc - x, yc - y, size); // Octant 5
        plot(g, xc - y, yc - x, size); // Octant 6
        plot(g, xc + x, yc - y, size); // Octant 7
        plot(g, xc + y, yc - x, size); // Octant 8
    }

    private void plotSymmetricPointsEllipse(Graphics g, int xc, int yc, int x, int y, int size) {
        plot(g, xc + x, yc + y, size); // Quadrant 1
        plot(g, xc - x, yc + y, size); // Quadrant 2
        plot(g, xc - x, yc - y, size); // Quadrant 3
        plot(g, xc + x, yc - y, size); // Quadrant 4
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

}
