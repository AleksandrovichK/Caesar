package Panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import Constants.Constants;
import JBlack.JBlackButton;

public class FreedmanPanel extends JPanel {
    private JTextArea mainText;
    private JTextArea textMutualCoincidence;
    private JLabel coincidenceValue;
    private JLabel mutualCoincidenceValue;

    public FreedmanPanel(JTextArea mainText) {
        this.setLayout(null);

        this.mainText = mainText;
        setBackground(Constants.Colors.MAIN_COLOR);

        textMutualCoincidence = new JTextArea();
        textMutualCoincidence.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        textMutualCoincidence.setForeground(Color.WHITE);
        textMutualCoincidence.setFont(Constants.Fonts.TEXTAREA_FONT);

        JScrollPane textPane = new JScrollPane(textMutualCoincidence);
        textPane.setBorder(null);
        textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(textPane).setBounds(Constants.Sizes.TEXTPANEL_MUTUALFRIEDMAN_BOUNDS);

        coincidenceValue = new JLabel(Constants.Buttons.BUTTON_FREEDMAN + ": ");
        coincidenceValue.setForeground(Color.WHITE);
        coincidenceValue.setFont(Constants.Fonts.FIELD_FONT);
        add(coincidenceValue).setBounds(Constants.Sizes.VALUE_COINCIDENCE_BOUNDS);

        mutualCoincidenceValue = new JLabel(Constants.Buttons.BUTTON_MUTUAL_FRIEDMAN + " with text: ");
        mutualCoincidenceValue.setForeground(Color.WHITE);
        mutualCoincidenceValue.setFont(Constants.Fonts.FIELD_FONT);
        add(mutualCoincidenceValue).setBounds(Constants.Sizes.VALUE_MUTUAL_COINCIDENCE_BOUNDS);

        JBlackButton coincidenceButton = new JBlackButton(Constants.Buttons.BUTTON_FREEDMAN);
        coincidenceButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toCountFreedman(FreedmanPanel.this.mainText.getText());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(coincidenceButton).setBounds(Constants.Sizes.BUTTON_COINCIDENCE_BOUNDS);

        JBlackButton mutualCoincidenceButton = new JBlackButton(Constants.Buttons.BUTTON_MUTUAL_FRIEDMAN);
        mutualCoincidenceButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!textMutualCoincidence.getText().equals("")) {
                    toCountMutFreedman(textMutualCoincidence.getText());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(mutualCoincidenceButton).setBounds(Constants.Sizes.BUTTON_MUTUAL_COINCIDENCE_BOUNDS);

        JLabel allLanguagesIndex = new JLabel(Constants.Buttons.BUTTON_FREEDMAN + " for languages:");
        allLanguagesIndex.setForeground(Color.WHITE);
        add(allLanguagesIndex).setBounds(Constants.Sizes.LABEL_FRIEDMAN_BOUNDS);

        JLabel rusMutualIndex = new JLabel(Constants.Buttons.BUTTON_MUTUAL_FRIEDMAN + " for Russian:");
        rusMutualIndex.setForeground(Color.WHITE);
        add(rusMutualIndex).setBounds(Constants.Sizes.LABEL_RUS_MUTUAL_FRIEDMAN_BOUNDS);

        JLabel engMutualIndex = new JLabel(Constants.Buttons.BUTTON_MUTUAL_FRIEDMAN + " for English:");
        engMutualIndex.setForeground(Color.WHITE);
        add(engMutualIndex).setBounds(Constants.Sizes.LABEL_ENG_MUTUAL_FRIEDMAN_BOUNDS);

        toPrintFreedmanTable();
        toPrintRusTable();
        toPrintEngTable();
        this.updateUI();
    }

    private void toCountFreedman(String text) {
        Map<Character, Integer> Frequency = new HashMap<>();

        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Frequency.put(text.charAt(i), 0);
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Integer value = Frequency.get(text.charAt(i));
                Frequency.put(text.charAt(i), ++value);
            }
        }

        Double length = (double) text.length();
        Double Ic = 0.0;
        Double pi;

        for (Map.Entry entry : Frequency.entrySet()) {
            pi = Double.valueOf(entry.getValue().toString()) / length;
            Ic = Ic + Math.pow(pi, 2);
        }

        coincidenceValue.setText(Constants.Buttons.BUTTON_FREEDMAN + ": " + String.valueOf(Ic));
        repaint();
    }

    private void toCountMutFreedman(String text2) {
        if (mainText.getText().equals(""))
            return;

        String text = mainText.getText();

        Map<Character, Integer> Frequency = new HashMap<>();
        Map<Character, Integer> Frequency2 = new HashMap<>();

        text = text.toUpperCase();
        text2 = text2.toUpperCase();

           for (int i = 0; i < text.length(); i++)
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Frequency.put(text.charAt(i), 0);
            }
        for (int i = 0; i < text2.length(); i++)
            if ((int) text2.charAt(i) != 10 && (int) text2.charAt(i) != 13) {
                Frequency2.put(text2.charAt(i), 0);
            }
        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Integer value1 = Frequency.get(text.charAt(i));
                Frequency.put(text.charAt(i), ++value1);
            }
        }

        for (int i = 0; i < text2.length(); i++) {
            if ((int) text2.charAt(i) != 10 && (int) text2.charAt(i) != 13) {
                Integer value2 = Frequency2.get(text2.charAt(i));
                Frequency2.put(text2.charAt(i), ++value2);
            }
        }

        Double length = (double) text.length();
        Double length2 = (double) text2.length();

        Double MIc = 0.0;
        Double pi1;
        Double pi2 = 0.0;

        for (Map.Entry entry : Frequency.entrySet()) {
            pi1 = Double.valueOf(entry.getValue().toString()) / length;
            if (Frequency2.get(entry.getKey()) != null) {
                pi2 = Double.valueOf(Frequency2.get(entry.getKey())) / length2;
            }
            MIc = MIc + pi1 * pi2;
        }

        mutualCoincidenceValue.setText(Constants.Buttons.BUTTON_MUTUAL_FRIEDMAN + ": " + String.valueOf(MIc));
        repaint();
    }

    private void toPrintFreedmanTable() {
        Object[] columns = { "Russian", "English", "French", "German", "Italian", "Spanish" };
        Object[][] data = new String[2][6];

        data[0][0] = "Russian";
        data[0][1] = "English";
        data[0][2] = "French";
        data[0][3] = "German";
        data[0][4] = "Italian";
        data[0][5] = "Spanish";

        data[1][0] = "0.0553";
        data[1][1] = "0.0662";
        data[1][2] = "0.0778";
        data[1][3] = "0.0762";
        data[1][4] = "0.0738";
        data[1][5] = "0.0775";

        JTable table = new JTable(data, columns);
        table.setSelectionBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        table.setSelectionForeground(Color.WHITE);
        table.setBorder(new MatteBorder(1, 1, 1, 1, Constants.Colors.MAIN_TEXTPANEL_COLOR));
        table.setFont(Constants.Fonts.TEXTAREA_FONT);
        table.setForeground(Color.WHITE);
        table.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        this.add(table).setBounds(Constants.Sizes.TABLE_FRIEDMAN_BOUNDS);
    }

    private void toPrintRusTable() {
        String[] columns = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };
        String[][] data = new String[2][17];

        data[0][0] = "0";
        data[0][1] = "1";
        data[0][2] = "2";
        data[0][3] = "3";
        data[0][4] = "4";
        data[0][5] = "5";
        data[0][6] = "6";
        data[0][7] = "7";
        data[0][8] = "8";
        data[0][9] = "9";
        data[0][10] = "10";
        data[0][11] = "11";
        data[0][12] = "12";
        data[0][13] = "13";
        data[0][14] = "14";
        data[0][15] = "15";
        data[0][16] = "16";

        data[1][0] = "0.0553";
        data[1][1] = "0.0366";
        data[1][2] = "0.0345";
        data[1][3] = "0.0400";
        data[1][4] = "0.0340";
        data[1][5] = "0.0360";
        data[1][6] = "0.0326";
        data[1][7] = "0.0241";
        data[1][8] = "0.0287";
        data[1][9] = "0.0317";
        data[1][10] = "0.0265";
        data[1][11] = "0.0251";
        data[1][12] = "0.0244";
        data[1][13] = "0.0291";
        data[1][14] = "0.0322";
        data[1][15] = "0.0244";
        data[1][16] = "0.0249";

        JTable table = new JTable(data, columns);
        table.setFont(Constants.Fonts.TABLE_FONT);
        table.setForeground(Color.WHITE);
        table.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        table.setSelectionForeground(Color.WHITE);
        table.setSelectionBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        table.setBorder(new MatteBorder(1, 1, 1, 1, Constants.Colors.MAIN_TEXTPANEL_COLOR));
        this.add(table).setBounds(Constants.Sizes.TABLE_RUS_MUTUAL_FRIEDMAN_BOUNDS);
    }

    private void toPrintEngTable() {
        String[] columns = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
        String[][] data = new String[2][14];

        data[0][0] = "0";
        data[1][0] = "0.0644";
        data[0][1] = "1";
        data[1][1] = "0.0394";
        data[0][2] = "2";
        data[1][2] = "0.0319";
        data[0][3] = "3";
        data[1][3] = "0.0345";
        data[0][4] = "4";
        data[1][4] = "0.0436";
        data[0][5] = "5";
        data[1][5] = "0.0332";
        data[0][6] = "6";
        data[1][6] = "0.0363";
        data[0][7] = "7";
        data[1][7] = "0.0389";
        data[0][8] = "8";
        data[1][8] = "0.0338";
        data[0][9] = "9";
        data[1][9] = "0.0342";
        data[0][10] = "10";
        data[1][10] = "0.0378";
        data[0][11] = "11";
        data[1][11] = "0.0440";
        data[0][12] = "12";
        data[1][12] = "0.0387";
        data[0][13] = "13";
        data[1][13] = "0.0428";

        JTable table = new JTable(data, columns);
        table.setFont(Constants.Fonts.TABLE_FONT);
        table.setForeground(Color.WHITE);
        table.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        table.setSelectionForeground(Color.WHITE);
        table.setSelectionBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        table.setBorder(new MatteBorder(1, 1, 1, 1, Constants.Colors.MAIN_TEXTPANEL_COLOR));
        this.add(table).setBounds(Constants.Sizes.TABLE_ENG_MUTUAL_FRIEDMAN_BOUNDS);
    }
}
