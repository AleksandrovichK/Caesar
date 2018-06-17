package Panels;

import Component.GistogrammPanel;
import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class FrequencyFunctionPanel extends JPanel {
    private JTextArea mainText;
    private GistogrammPanel gistogramm = null;
    private int q = 0;

    public FrequencyFunctionPanel(JTextArea textArea) {
        mainText = textArea;
        setBackground(Constants.MAIN_COLOR);

        JButton toCount = new JButton("To count");
        toCount.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(toCount);
        toCount.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toCountFrequency(mainText);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void toCountFrequency(JTextArea MText) {
        String text = MText.getText();
        if (MText.getText().isEmpty()) return;

        Map<Character, Integer> Frequency = new HashMap<>();

        //text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++)
            Frequency.put(text.charAt(i), 0);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '\n') {
                Integer value = Frequency.get(text.charAt(i));
                value = value + 1;
                Frequency.put(text.charAt(i), value);
            }
        }

        String[][] data;
        if (Frequency.size() < 30) {
            data = new String[30][3];
        } else {
            data = new String[Frequency.size()][3];
        }

        Double[] quantity = new Double[Frequency.size()];
        for (int i = 0; i < Frequency.size(); i++)
            quantity[i] = Double.valueOf(0.0);
        Double length = new Double(Double.valueOf(text.length()));

        int j = 0;
        for (Map.Entry entry : Frequency.entrySet()) {
            data[j][1] = entry.getValue().toString();
            String temp = entry.getValue().toString();
            quantity[j] = Double.valueOf(temp);
            data[j][0] = entry.getKey().toString();

            Double res = Double.valueOf(quantity[j] / length);
            data[j][2] = String.valueOf(res);
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

        if (q == 1) {
            remove(gistogramm);
        } else {
            q = 1;
        }
        updateUI();

        String s[] = new String[Frequency.size()];
        String d[] = new String[Frequency.size()];
        for (int i = 0; i < Frequency.size(); i++) {
            s[i] = data[i][0];
            System.out.print(s[i]);
            System.out.print(" = ");
            d[i] = data[i][2];
            System.out.print(d[i]);
            System.out.println();
        }

        gistogramm = new GistogrammPanel(s, d);

        gistogramm.setPreferredSize(new Dimension(585, 330));
        JScrollPane qwer2 = new JScrollPane(gistogramm);
        add(qwer2);
    }
}
