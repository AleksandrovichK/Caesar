package Component;

import java.awt.*;

import javax.swing.*;

import Constants.Constants;
import JBlack.JBlackField;

public class Substitution extends JPanel {
    private JBlackField substitution;
    private JLabel letter;

    public Substitution(String inLetter, String inField) {
        setLayout(null);
        letter = new JLabel(inLetter);
        letter.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        setBackground(Constants.Colors.MAIN_COLOR);

        letter.setFont(Constants.Fonts.FIELD_FONT);
        letter.setForeground(Color.WHITE);
        add(letter).setBounds(Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS);

        if (inField != null) {
            substitution = new JBlackField(inField.charAt(0));
        } else {
            substitution = new JBlackField('*');
        }
        substitution.setBorder(null);
        substitution.setFont(Constants.Fonts.FIELD_FONT);
        substitution.setForeground(Color.WHITE);
        add(substitution).setBounds(0, Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS.height, Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS.width, Constants.Sizes.LABEL_LETTER_SUBST_BOUNDS.height);
    }

    public JBlackField getSubstitution() {
        return substitution;
    }

    public JLabel getLetter() {
        return letter;
    }
}