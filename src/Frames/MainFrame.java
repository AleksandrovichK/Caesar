package Frames;

import Component.Slots;
import Constants.Constants;
import Panels.EditPanel;
import Panels.FreedmanPanel;
import Panels.FrequencyFunctionPanel;
import Panels.PermutationPanel;
import Panels.SubstitutionPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JPanel frequencyFunctionPanel = new FrequencyFunctionPanel(getFullTextArea());
    private JPanel editPanel = new EditPanel(this);
    private JPanel freedmanPanel = new FreedmanPanel(this.getFullTextArea());
    private JPanel substitutionPanel = new SubstitutionPanel(this);
    private JPanel permutationPanel = new PermutationPanel(this);

    public MainFrame() {
        setting();

        this.textArea.setBounds(this.getBounds().width / 50, this.getBounds().height / 50, 94 * this.getBounds().width / 100, this.getBounds().height / 4);
        this.add(textArea);
    }

    private void setting() {
        this.setFont(new Font("Consolas", Font.BOLD, 18));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(Constants.Sizes.MAINFRAME_INDENT_X, Constants.Sizes.MAINFRAME_INDENT_Y, Constants.Sizes.MAINFRAME_SIZE_X, Constants.Sizes.MAINFRAME_SIZE_Y);
        this.setLayout(null);

        getContentPane().setBackground(Constants.MAIN_COLOR);

        this.add(frequencyFunctionPanel);
        this.add(editPanel);
        this.add(freedmanPanel);
        this.add(substitutionPanel);
        this.add(permutationPanel);

        toDevisibleAll();

        frequencyFunctionPanel.setBounds(110, 290, 850, 505);
        editPanel.setBounds(110, 290, 850, 505);

        frequencyFunctionPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toDevisibleAll();
                showPanel(1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        editPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toDevisibleAll();
                showPanel(2);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Slots slots = new Slots(frequencyFunctionPanel, editPanel);
        slots.setBounds(5, 290, 100, 405);
        this.add(slots);
    }

    private void showPanel(int number) {
        switch (number){
            case 1: {
                frequencyFunctionPanel.setVisible(true);
                frequencyFunctionPanel.repaint();
                break;
            }
            case 2: {
                editPanel.setVisible(true);
                editPanel.repaint();
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            default: throw new NullPointerException("Wrong panel number!");
        }
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea(String text) {
        this.textArea.setText(text);
    }

    public JTextArea getFullTextArea() {
        return textArea;
    }

    private void toDevisibleAll() {
        frequencyFunctionPanel.setVisible(false);
        editPanel.setVisible(false);
        freedmanPanel.setVisible(false);
        substitutionPanel.setVisible(false);
        permutationPanel.setVisible(false);
    }
}
