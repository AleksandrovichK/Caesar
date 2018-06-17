package Component;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Slots extends JPanel {
    public Slots() {
        String[] names = { Constants.FREQUENCY_SLOT, Constants.FUNCTIONS_SLOT, Constants.FRIEDMAN_INDEX_SLOT, Constants.SUBSTITUTIONS_SLOT, Constants.PERMUTATIONS_SLOT };
        Slot[] slots = new Slot[names.length];

        for (int i = 0; i < names.length; i++) {
            slots[i] = new Slot(names[i]);
            this.add(slots[i]);
        }
        this.setLayout(new GridLayout(names.length, 1));
    }
}
