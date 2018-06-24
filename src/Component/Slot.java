package Component;

import Constants.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Slot extends JPanel {
    private String name;
    private JPanel panel;

    Slot(String name, JPanel pane) {
        this.name = name;
        this.panel = pane;
        this.panel.setVisible(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setPaint(new GradientPaint(0, 0, Constants.SLOT_UP_COLOR, 0, this.getHeight() / 2, Constants.SLOT_DOWN_COLOR));
        gg.fillRect(0, 0, this.getWidth(), this.getHeight() / 2);
        gg.setPaint(new GradientPaint(0, this.getHeight() / 2, Constants.SLOT_DOWN_COLOR, 0, this.getHeight(), Constants.SLOT_UP_COLOR));
        gg.fillRect(0, this.getHeight() / 2, this.getWidth(), this.getHeight());

        gg.setPaint(Constants.MAIN_COLOR);
        gg.drawLine(0, this.getHeight() - 1, this.getWidth(), this.getHeight() - 1);

        gg.setPaint(Color.WHITE);
        gg.setFont(Constants.SLOT_FONT);
        gg.drawString(name, (this.getWidth() - gg.getFontMetrics().stringWidth(name)) / 2, this.getHeight()-10);

        try {
            gg.drawImage(ImageIO.read(new File("src/Component/images/"+name+".png")), this.getWidth()/4, this.getHeight()/10, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isPanelVisible() {
        return panel.isVisible();
    }

    void setPanelVisible(boolean visible) {
        panel.setVisible(visible);
    }
}
