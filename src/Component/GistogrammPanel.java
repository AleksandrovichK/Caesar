package Component;

import java.awt.*;

import javax.swing.*;

import Constants.Constants;

public class GistogrammPanel extends JPanel {
    private String[] info;
    private String[] data;

    public GistogrammPanel(String[] s, String[] d) {
        info = s;
        data = d;
    }

    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        gg.setPaint(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        gg.fillRect(0, 0, this.getWidth(), this.getHeight());

        gg.setPaint(Color.GRAY);
        gg.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

        int n = info.length;
        double scale = 0.8 / Double.parseDouble(data[0]);
        for (int i = 0; i < n; i++) {
            gg.setPaint(Constants.Colors.GISTOGRAMM_COLOR);
            gg.fillRect(i * this.getWidth() / n + 1,
                    (int) (this.getHeight() - Double.parseDouble(data[i]) * scale * this.getHeight()) -3,
                    this.getWidth() / n - 3,
                    (int) (Double.parseDouble(data[i]) * scale * this.getHeight()));

            gg.setPaint(Color.BLACK);
            gg.drawRect(i * this.getWidth() / n + 1,
                    (int) (this.getHeight() - Double.parseDouble(data[i]) * scale * this.getHeight()) -3,
                    this.getWidth() / n - 3,
                    (int) (Double.parseDouble(data[i]) * scale * this.getHeight()));

            gg.setPaint(Color.WHITE);
            gg.drawString(info[i], this.getWidth() * (2 * i + 1) / (2 * n) - 4, this.getHeight() - 6);
        }
        gg.setPaint(Constants.Colors.MAIN_COLOR);
    }
}
