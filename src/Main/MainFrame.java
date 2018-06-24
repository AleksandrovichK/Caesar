package Main;

import java.awt.*;

import javax.swing.*;

import Component.Slots;
import Constants.Constants;
import Panels.EditPanel;
import Panels.FreedmanPanel;
import Panels.FrequencyFunctionPanel;
import Panels.PermutationPanel;
import Panels.SubstitutionPanel;

public class MainFrame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JPanel frequencyFunctionPanel = new FrequencyFunctionPanel(getFullTextArea());
    private JPanel editPanel = new EditPanel(this);
    private JPanel freedmanPanel = new FreedmanPanel(this.getFullTextArea());
    private JPanel substitutionPanel = new SubstitutionPanel(this);
    private JPanel permutationPanel = new PermutationPanel(this);

    MainFrame() {
        setting();

        this.textArea.setFont(new Font("Arial", Font.BOLD, 12));
        this.textArea.setBackground(Constants.MAIN_TEXTPANEL_COLOR);
        this.textArea.setForeground(Color.WHITE);

        JScrollPane textPane = new JScrollPane(textArea);
        textPane.setBorder(null);
        textPane.setBounds(Constants.Sizes.MAINTEXTPANEL_BOUNDS);
        textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(textPane);
    }

    private void setting() {
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

        frequencyFunctionPanel.setBounds(Constants.Sizes.OPERATIONPANEL_BOUNDS);
        editPanel.setBounds(Constants.Sizes.OPERATIONPANEL_BOUNDS);
        freedmanPanel.setBounds(Constants.Sizes.OPERATIONPANEL_BOUNDS);
        substitutionPanel.setBounds(Constants.Sizes.OPERATIONPANEL_BOUNDS);
        permutationPanel.setBounds(Constants.Sizes.OPERATIONPANEL_BOUNDS);

        Slots slots = new Slots(frequencyFunctionPanel, editPanel, freedmanPanel, substitutionPanel, permutationPanel);
        slots.setBounds(Constants.Sizes.SLOTS_BOUNDS);
        this.add(slots);
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
