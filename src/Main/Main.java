package Main;

import javax.swing.JPanel;

import Frames.MainFrame;
import Panels.EditPanel;
import Panels.FreedmanPanel;
import Panels.FrequencyFunctionFrame;
import Panels.PermutationPanel;
import Panels.substitutionPanel;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] s = { "Частота", "Функции", "Индекс Фридмана","Подстановка", "Перестановка" };
		JPanel frames[] = new JPanel[s.length];
		MainFrame mainFrame = new MainFrame(s, frames);
		
		frames[0] = new FrequencyFunctionFrame(mainFrame);
		frames[1] = new EditPanel(mainFrame);
		frames[2] = new FreedmanPanel(mainFrame);
		frames[3] = new substitutionPanel(mainFrame);
		frames[4] = new PermutationPanel(mainFrame);
		for(int i=0; i<frames.length; i++){
			mainFrame.getPanel().add(i+"",frames[i]);
			frames[i].setVisible(false);
		}


		mainFrame.setVisible(true);
	}
	
}
