package Constants;

import java.awt.*;

public interface Constants {
    String PERMUTATIONS_SLOT = "Permutations";
    String SUBSTITUTIONS_SLOT = "Substitutions";
    String FRIEDMAN_INDEX_SLOT = "The Friedman Index";
    String FUNCTIONS_SLOT = "Functions";
    String FREQUENCY_SLOT = "Frequency";
    Color MAIN_COLOR = new Color(32, 32, 32);
    Color SLOT_UP_COLOR = new Color(3, 0, 37);
    Color SLOT_DOWN_COLOR =  new Color(3, 7, 35);

    interface Sizes {
        int MAINFRAME_INDENT_X = 25 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
        int MAINFRAME_INDENT_Y = 5  * Toolkit.getDefaultToolkit().getScreenSize().height / 100;
        int MAINFRAME_SIZE_X = 50 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
        int MAINFRAME_SIZE_Y = 50 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
    }
    interface Buttons {
        String BUTTON_UPPER_CASE = "To upper case";
        String BUTTON_LOWER_CASE = "To lower case";
        String BUTTON_DELETE_WORD = "Delete word";
        String BUTTON_DIVIDE_INTO_COLUMNS = "Divide into columns";
        String BUTTON_TRANSPOSITION = "Transpose";
    }
}
