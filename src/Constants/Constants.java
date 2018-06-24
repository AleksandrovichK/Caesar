package Constants;

import java.awt.*;

public interface Constants {
    interface Colors {
        Color MAIN_COLOR = new Color(32, 32, 32);
        Color MAIN_TEXTPANEL_COLOR = new Color(48, 48, 48);
        Color SLOT_UP_COLOR = new Color(16, 112, 214);
        Color SLOT_DOWN_COLOR = new Color(16, 123, 214);
        Color GISTOGRAMM_COLOR = new Color(255, 58, 69);
    }

    interface Fonts {
        Font SLOT_FONT = new Font("Arial", Font.BOLD, 12);
        Font BUTTONS_FONT = new Font("Arial", Font.BOLD, 18);
        Font FIELD_FONT = new Font("Arial", Font.BOLD, 18);
    }

    interface Slots {
        String PERMUTATIONS_SLOT = "Permutations";
        String SUBSTITUTIONS_SLOT = "Substitutions";
        String FRIEDMAN_INDEX_SLOT = "The Friedman Index";
        String FUNCTIONS_SLOT = "Functions";
        String FREQUENCY_SLOT = "Frequency";
    }

    interface Sizes {
        int MAINFRAME_INDENT_X = 25 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
        int MAINFRAME_INDENT_Y = 5 * Toolkit.getDefaultToolkit().getScreenSize().height / 100;
        int MAINFRAME_SIZE_X = 50 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;
        int MAINFRAME_SIZE_Y = 50 * Toolkit.getDefaultToolkit().getScreenSize().width / 100;

        Rectangle PANEL_MAINTEXT_BOUNDS = new Rectangle(MAINFRAME_SIZE_X / 50, MAINFRAME_SIZE_Y / 50, 94 * MAINFRAME_SIZE_X / 100, MAINFRAME_SIZE_Y / 4);
        Rectangle PANEL_SLOTS_BOUNDS = new Rectangle(MAINFRAME_SIZE_X / 50, 2 * MAINFRAME_SIZE_Y / 50 + MAINFRAME_SIZE_Y / 4, MAINFRAME_SIZE_X / 6, MAINFRAME_SIZE_Y - 5 * PANEL_MAINTEXT_BOUNDS.y - PANEL_MAINTEXT_BOUNDS.height);
        Rectangle PANEL_OPERATIONAL_BOUNDS = new Rectangle(2 * PANEL_SLOTS_BOUNDS.x + PANEL_SLOTS_BOUNDS.width, PANEL_SLOTS_BOUNDS.y, PANEL_MAINTEXT_BOUNDS.width - PANEL_SLOTS_BOUNDS.width - PANEL_SLOTS_BOUNDS.x, PANEL_SLOTS_BOUNDS.height);

        Rectangle BUTTON_STATISTICS_BOUNDS = new Rectangle(MAINFRAME_SIZE_X / 2 - PANEL_SLOTS_BOUNDS.width - 80, 10, 200, 60);
        Rectangle GISTOGRAMM_BOUNDS = new Rectangle(PANEL_SLOTS_BOUNDS.x / 2, 4 * BUTTON_STATISTICS_BOUNDS.y + BUTTON_STATISTICS_BOUNDS.height, PANEL_OPERATIONAL_BOUNDS.width - PANEL_SLOTS_BOUNDS.x, PANEL_SLOTS_BOUNDS.height - 10 * BUTTON_STATISTICS_BOUNDS.y);

        Rectangle BUTTON_UPCASE_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, 30, 500, 50);
        Rectangle BUTTON_DOWNCASE_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, BUTTON_UPCASE_BOUNDS.y + BUTTON_UPCASE_BOUNDS.height + 30, 500, 50);
        Rectangle BUTTON_DIVIDECOLUMN_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, BUTTON_DOWNCASE_BOUNDS.y + BUTTON_DOWNCASE_BOUNDS.height + 30, 440, 50);
        Rectangle TEXTFIELD_DIVIDECOLUMN_BOUNDS = new Rectangle(BUTTON_DIVIDECOLUMN_BOUNDS.x+BUTTON_DIVIDECOLUMN_BOUNDS.width+10, BUTTON_DOWNCASE_BOUNDS.y + BUTTON_DOWNCASE_BOUNDS.height + 30, 50, 50);
    }

    interface Buttons {
        String BUTTON_UPPER_CASE = "To upper case";
        String BUTTON_LOWER_CASE = "To lower case";
        String BUTTON_DIVIDE_INTO_COLUMNS = "Divide into columns";
        String BUTTON_STATISTICS = "Statistics";
    }
}
