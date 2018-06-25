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
        Font TABLE_FONT = new Font("Arial", Font.BOLD, 9);
        Font SLOT_FONT = new Font("Arial", Font.BOLD, 12);
        Font TEXTAREA_FONT = new Font("Arial", Font.BOLD, 12);
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

        Rectangle BUTTON_CLEAN_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, 30, 500, 50);
        Rectangle BUTTON_UPCASE_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, BUTTON_CLEAN_BOUNDS.y + BUTTON_CLEAN_BOUNDS.height + 30, 500, 50);
        Rectangle BUTTON_DOWNCASE_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, BUTTON_UPCASE_BOUNDS.y + BUTTON_UPCASE_BOUNDS.height + 30, 500, 50);
        Rectangle BUTTON_DIVIDECOLUMN_BOUNDS = new Rectangle(PANEL_OPERATIONAL_BOUNDS.width/2- 250, BUTTON_DOWNCASE_BOUNDS.y + BUTTON_DOWNCASE_BOUNDS.height + 30, 440, 50);
        Rectangle TEXTFIELD_DIVIDECOLUMN_BOUNDS = new Rectangle(BUTTON_DIVIDECOLUMN_BOUNDS.x+BUTTON_DIVIDECOLUMN_BOUNDS.width+10, BUTTON_DOWNCASE_BOUNDS.y + BUTTON_DOWNCASE_BOUNDS.height + 30, 50, 50);

        Rectangle BUTTON_COINCIDENCE_BOUNDS = new Rectangle(BUTTON_UPCASE_BOUNDS.x, 0, BUTTON_UPCASE_BOUNDS.width, 50);
        Rectangle VALUE_COINCIDENCE_BOUNDS = new Rectangle(0, BUTTON_COINCIDENCE_BOUNDS.y+BUTTON_COINCIDENCE_BOUNDS.height+15, 600, 20);

        Rectangle BUTTON_MUTUAL_COINCIDENCE_BOUNDS = new Rectangle(BUTTON_UPCASE_BOUNDS.x, VALUE_COINCIDENCE_BOUNDS.y + VALUE_COINCIDENCE_BOUNDS.height+15, BUTTON_COINCIDENCE_BOUNDS.width, BUTTON_COINCIDENCE_BOUNDS.height);
        Rectangle VALUE_MUTUAL_COINCIDENCE_BOUNDS = new Rectangle(VALUE_COINCIDENCE_BOUNDS.x, BUTTON_MUTUAL_COINCIDENCE_BOUNDS.y+BUTTON_MUTUAL_COINCIDENCE_BOUNDS.height+15, VALUE_COINCIDENCE_BOUNDS.width, VALUE_COINCIDENCE_BOUNDS.height);

        Rectangle TEXTPANEL_MUTUALFRIEDMAN_BOUNDS = new Rectangle(0, VALUE_MUTUAL_COINCIDENCE_BOUNDS.y+VALUE_MUTUAL_COINCIDENCE_BOUNDS.height + 15, PANEL_OPERATIONAL_BOUNDS.width, 100);

        Rectangle TABLE_FRIEDMAN = new Rectangle(TEXTPANEL_MUTUALFRIEDMAN_BOUNDS.x, TEXTPANEL_MUTUALFRIEDMAN_BOUNDS.y+TEXTPANEL_MUTUALFRIEDMAN_BOUNDS.height+45, TEXTPANEL_MUTUALFRIEDMAN_BOUNDS.width, 30);
        Rectangle TABLE_RUS_MUTUAL_FRIEDMAN = new Rectangle(TABLE_FRIEDMAN.x, TABLE_FRIEDMAN.y+TABLE_FRIEDMAN.height+40, TABLE_FRIEDMAN.width, TABLE_FRIEDMAN.height);
        Rectangle TABLE_ENG_MUTUAL_FRIEDMAN = new Rectangle(TABLE_RUS_MUTUAL_FRIEDMAN.x, TABLE_RUS_MUTUAL_FRIEDMAN.y + TABLE_RUS_MUTUAL_FRIEDMAN.height+40, TABLE_RUS_MUTUAL_FRIEDMAN.width, TABLE_RUS_MUTUAL_FRIEDMAN.height);

        Rectangle LABEL_FRIEDMAN = new Rectangle(TABLE_FRIEDMAN.x, TABLE_FRIEDMAN.y - TABLE_FRIEDMAN.height, TABLE_FRIEDMAN.width, TABLE_FRIEDMAN.height);
        Rectangle LABEL_RUS_MUTUAL_FRIEDMAN = new Rectangle(TABLE_RUS_MUTUAL_FRIEDMAN.x, TABLE_RUS_MUTUAL_FRIEDMAN.y - TABLE_RUS_MUTUAL_FRIEDMAN.height, TABLE_RUS_MUTUAL_FRIEDMAN.width, TABLE_RUS_MUTUAL_FRIEDMAN.height);
        Rectangle LABEL_ENG_MUTUAL_FRIEDMAN =  new Rectangle(TABLE_ENG_MUTUAL_FRIEDMAN.x, TABLE_ENG_MUTUAL_FRIEDMAN.y - TABLE_ENG_MUTUAL_FRIEDMAN.height, TABLE_ENG_MUTUAL_FRIEDMAN.width, TABLE_ENG_MUTUAL_FRIEDMAN.height);
    }

    interface Buttons {
        String BUTTON_UPPER_CASE = "To upper case";
        String BUTTON_LOWER_CASE = "To lower case";
        String BUTTON_DIVIDE_INTO_COLUMNS = "Divide into columns";
        String BUTTON_STATISTICS = "Statistics";
        String BUTTON_FREEDMAN = "Index of coincidence";
        String BUTTON_MUTUAL_FRIEDMAN = "Index of mutual coincidence";
        String BUTTON_CLEAN = "Clear text from symbols";
    }
}
