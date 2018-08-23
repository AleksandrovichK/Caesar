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

class MainFrame extends JFrame {
    private JTextArea textArea;
    private JPanel frequencyFunctionPanel;
    private JPanel editPanel;
    private JPanel freedmanPanel;
    private JPanel substitutionPanel;
    private JPanel permutationPanel;

    MainFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Caesar 2.1");
        this.setBounds(Constants.Sizes.MAINFRAME_INDENT_X, Constants.Sizes.MAINFRAME_INDENT_Y, Constants.Sizes.MAINFRAME_SIZE_X, Constants.Sizes.MAINFRAME_SIZE_Y);
        this.setLayout(null);

        getContentPane().setBackground(Constants.Colors.MAIN_COLOR);

        textArea = new JTextArea();
        this.textArea.setFont(Constants.Fonts.TEXTAREA_FONT);
        this.textArea.setBackground(Constants.Colors.MAIN_TEXTPANEL_COLOR);
        this.textArea.setForeground(Color.WHITE);

        JScrollPane textPane = new JScrollPane(textArea);
        textPane.setBorder(null);
        textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(textPane).setBounds(Constants.Sizes.PANEL_MAINTEXT_BOUNDS);

        frequencyFunctionPanel = new FrequencyFunctionPanel(this.getFullTextArea());
        editPanel = new EditPanel(this.getFullTextArea());
        freedmanPanel = new FreedmanPanel(this.getFullTextArea());
        substitutionPanel = new SubstitutionPanel(this.getFullTextArea());
        permutationPanel = new PermutationPanel(this.getFullTextArea());

        this.add(frequencyFunctionPanel).setBounds(Constants.Sizes.PANEL_OPERATIONAL_BOUNDS);
        this.add(editPanel).setBounds(Constants.Sizes.PANEL_OPERATIONAL_BOUNDS);
        this.add(freedmanPanel).setBounds(Constants.Sizes.PANEL_OPERATIONAL_BOUNDS);
        this.add(substitutionPanel).setBounds(Constants.Sizes.PANEL_OPERATIONAL_BOUNDS);
        this.add(permutationPanel).setBounds(Constants.Sizes.PANEL_OPERATIONAL_BOUNDS);

        toDevisibleAll();

        Slots slots = new Slots(frequencyFunctionPanel, editPanel, freedmanPanel, substitutionPanel, permutationPanel);
        this.add(slots).setBounds(Constants.Sizes.PANEL_SLOTS_BOUNDS);
    }

    private JTextArea getFullTextArea() {
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
