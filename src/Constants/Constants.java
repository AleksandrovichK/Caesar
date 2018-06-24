package Constants;

import java.awt.*;

public interface Constants {
    String PERMUTATIONS_SLOT = "Permutations";
    String SUBSTITUTIONS_SLOT = "Substitutions";
    String FRIEDMAN_INDEX_SLOT = "The Friedman Index";
    String FUNCTIONS_SLOT = "Functions";
    String FREQUENCY_SLOT = "Frequency";
    Color MAIN_COLOR = new Color(32, 32, 32);
    Color MAIN_TEXTPANEL_COLOR = new Color(48, 48, 48);
    Color SLOT_UP_COLOR = new Color(16, 112, 214);
    Color SLOT_DOWN_COLOR = new Color(16, 123, 214);
    Color GISTOGRAMM_COLOR = new Color(255, 58, 69);

    Font SLOT_FONT = new Font("Arial", Font.BOLD, 12);

    interface Sizes {
        int MAINFRAME_INDENT_X = 25 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
        int MAINFRAME_INDENT_Y = 5 * Toolkit.getDefaultToolkit().getScreenSize().height / 100;
        int MAINFRAME_SIZE_X = 50 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
        int MAINFRAME_SIZE_Y = 50 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;

        Rectangle MAINTEXTPANEL_BOUNDS = new Rectangle(MAINFRAME_SIZE_X / 50, MAINFRAME_SIZE_Y / 50, 94 * MAINFRAME_SIZE_X / 100, MAINFRAME_SIZE_Y / 4);
        Rectangle SLOTS_BOUNDS = new Rectangle(MAINFRAME_SIZE_X / 50, 2 * MAINFRAME_SIZE_Y / 50 + MAINFRAME_SIZE_Y / 4, MAINFRAME_SIZE_X / 6, MAINFRAME_SIZE_Y - 5 * MAINTEXTPANEL_BOUNDS.y - MAINTEXTPANEL_BOUNDS.height);
        Rectangle OPERATIONPANEL_BOUNDS = new Rectangle(2 * SLOTS_BOUNDS.x + SLOTS_BOUNDS.width, SLOTS_BOUNDS.y, MAINTEXTPANEL_BOUNDS.width - SLOTS_BOUNDS.width - SLOTS_BOUNDS.x, SLOTS_BOUNDS.height);

        Rectangle STATISTICS_BUTTON_BOUNDS = new Rectangle(MAINFRAME_SIZE_X/2 - SLOTS_BOUNDS.width - 80,10,200,60);
        Rectangle GISTOGRAMM_BOUNDS = new Rectangle(SLOTS_BOUNDS.x/2, 4*STATISTICS_BUTTON_BOUNDS.y+STATISTICS_BUTTON_BOUNDS.height, OPERATIONPANEL_BOUNDS.width-SLOTS_BOUNDS.x,SLOTS_BOUNDS.height - 10*STATISTICS_BUTTON_BOUNDS.y);
    }

    interface Buttons {
        String BUTTON_UPPER_CASE = "To upper case";
        String BUTTON_LOWER_CASE = "To lower case";
        String BUTTON_DELETE_WORD = "Delete word";
        String BUTTON_DIVIDE_INTO_COLUMNS = "Divide into columns";
        String BUTTON_TRANSPOSITION = "Transpose";
        String BUTTON_STATISTICS = "Statistics";
    }
}
