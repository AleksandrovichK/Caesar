package Component;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Slots extends JPanel {
    private Slot[] slots;

    public Slots(JPanel frequencyFunctionPanel, JPanel editPanel, JPanel freedmanPanel, JPanel substitutionPanel, JPanel permutationPanel) {
        String[] names = { Constants.FREQUENCY_SLOT, Constants.FUNCTIONS_SLOT, Constants.FRIEDMAN_INDEX_SLOT, Constants.SUBSTITUTIONS_SLOT, Constants.PERMUTATIONS_SLOT };
        this.slots = new Slot[names.length];

        slots[0] = new Slot(names[0], frequencyFunctionPanel);
        slots[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toInvisibleOthers(0);
                slots[0].setPanelVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(slots[0]);

        slots[1] = new Slot(names[1], editPanel);
        slots[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toInvisibleOthers(1);
                slots[1].setPanelVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(slots[1]);

        slots[2] = new Slot(names[2], freedmanPanel);
        slots[2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toInvisibleOthers(2);
                slots[2].setPanelVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(slots[2]);

        slots[3] = new Slot(names[3], substitutionPanel);
        slots[3].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toInvisibleOthers(3);
                slots[3].setPanelVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(slots[3]);

        slots[4] = new Slot(names[4], permutationPanel);
        slots[4].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                toInvisibleOthers(4);
                slots[4].setPanelVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add(slots[4]);

        this.setLayout(new GridLayout(names.length, 1));
    }

    private void toInvisibleOthers(int excluding){
        for (int i = 0; i < slots.length; i++) {
            if (i != excluding)
                slots[i].setPanelVisible(false);
        }
    }
}
