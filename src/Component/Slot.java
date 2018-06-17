package Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Slot extends JPanel {
    private Color up;
    private Color down;
    private String name;

    public Slot(String s) {
        name = s;
        up = new Color(3, 15, 60);
        down = new Color(3, 0, 37);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                down = new Color(0, 0, 0);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                down = new Color(3, 0, 120);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                down = new Color(3, 0, 37);
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setPaint(new GradientPaint(0, 0, up, 0, this.getHeight() / 2, down));
        gg.fillRect(0, 0, this.getWidth(), this.getHeight() / 2
        );
        gg.setPaint(new GradientPaint(0, this.getHeight() / 2, down, 0, this.getHeight(), up));
        gg.fillRect(0, this.getHeight() / 2, this.getWidth(), this.getHeight());

        gg.setPaint(Color.BLACK);
        gg.drawLine(this.getWidth() / 4, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);
        gg.setPaint(Color.WHITE);
        gg.drawLine(this.getWidth() / 4, 0, this.getWidth(), 0);

        gg.setPaint(Color.WHITE);
        gg.drawString(name, (this.getWidth() - gg.getFontMetrics().stringWidth(name)) / 2, this.getHeight() / 2);
        gg.setPaint(Color.BLACK);
        gg.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1, this.getHeight());
        gg.drawLine(0, 0, 0, this.getHeight());
    }
}
