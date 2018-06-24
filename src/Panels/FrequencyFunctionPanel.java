package Panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Buttons.JBlackButton;
import Component.GistogrammPanel;
import Constants.Constants;

public class FrequencyFunctionPanel extends JPanel {
    private JTextArea mainText;
    private JScrollPane gistogrammPane;

    public FrequencyFunctionPanel(JTextArea textArea) {
        this.setLayout(null);

        mainText = textArea;
        setBackground(Constants.Colors.MAIN_COLOR);

        JBlackButton countButton = new JBlackButton(Constants.Buttons.BUTTON_STATISTICS);
        countButton.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        countButton.setForeground(Color.WHITE);
        countButton.setFont(Constants.Fonts.BUTTONS_FONT);
        add(countButton).setBounds(Constants.Sizes.BUTTON_STATISTICS_BOUNDS);
        countButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toBuildFrequencyGistogrammPane();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void toBuildFrequencyGistogrammPane() {
        String text = mainText.getText();
        if (mainText.getText().isEmpty()) return;

        text = text.replaceAll(" ", "_");

        Integer value;
        Map<Character, Integer> Frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++){
            Frequency.put(text.charAt(i), 0);
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '\n') {
                value = Frequency.get(text.charAt(i));
                Frequency.put(text.charAt(i), ++value);
            }
        }

        String[][] data;
        if (Frequency.size() < 30) {
            data = new String[30][3];
        } else {
            data = new String[Frequency.size()][3];
        }


        int j = 0;
        for (Map.Entry entry : Frequency.entrySet()) {
            data[j][1] = entry.getValue().toString();
            data[j][0] = entry.getKey().toString();
            data[j][2] = String.valueOf(Double.valueOf(entry.getValue().toString()) / (double) text.length());
            j++;
        }

        String[] tmp;
        for (int i = 0; i < Frequency.size() - 1; i++)
            for (int k = i; k < Frequency.size(); k++)
                if (Integer.parseInt(data[i][1]) < Integer.parseInt(data[k][1])) {
                    tmp = data[i];
                    data[i] = data[k];
                    data[k] = tmp;
                }

        if (this.gistogrammPane != null) {
            this.remove(gistogrammPane);
            repaint();
        }

        updateUI();

        String s[] = new String[Frequency.size()];
        String d[] = new String[Frequency.size()];
        for (int i = 0; i < Frequency.size(); i++) {
            s[i] = data[i][0];
            d[i] = data[i][2];
        }

        gistogrammPane = new JScrollPane(new GistogrammPanel(s, d));
        gistogrammPane.setBorder(null);
        gistogrammPane.setFocusable(false);
        add(gistogrammPane).setBounds(Constants.Sizes.GISTOGRAMM_BOUNDS);
    }
}
