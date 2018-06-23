package Component;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Slot extends JPanel {
    private Color up = Constants.SLOT_UP_COLOR;
    private Color down = Constants.SLOT_DOWN_COLOR;
    private String name;

    private JPanel panel;

    Slot(String s, JPanel pane) {
        name = s;
        panel = pane;
        panel.setVisible(false);

        /*this.addMouseListener(new MouseListener() {
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
                isVisible = !isVisible;
                panel.setVisible(isVisible);
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
        });*/
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setPaint(new GradientPaint(0, 0, up, 0, this.getHeight() / 2, down));
        gg.fillRect(0, 0, this.getWidth(), this.getHeight() / 2);
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

    boolean isPanelVisible() {
        return panel.isVisible();
    }

    void setPanelVisible(boolean visible) {
        panel.setVisible(visible);
    }
}
