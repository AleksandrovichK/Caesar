package Component;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Slots extends JPanel {
    public Slots(JPanel frequencyFunctionPanel, JPanel editPanel) {
        String[] names = { Constants.FREQUENCY_SLOT, Constants.FUNCTIONS_SLOT, Constants.FRIEDMAN_INDEX_SLOT, Constants.SUBSTITUTIONS_SLOT, Constants.PERMUTATIONS_SLOT };
        Slot[] slots = new Slot[names.length];

        slots[0] = new Slot(names[0], frequencyFunctionPanel);
        this.add(slots[0]);

        slots[1] = new Slot(names[1], editPanel);
        this.add(slots[1]);

        this.setLayout(new GridLayout(names.length, 1));
    }
}
