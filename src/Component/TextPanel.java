package Component;

import java.awt.TextArea;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

public class TextPanel extends JPanel {
	private TextArea MainText = new TextArea();
	
	public TextArea getMainText() {
		return MainText;
	}
	public void setMainText(TextArea mainText) {
		MainText = mainText;
	}
	public TextPanel() {
		this.setLayout(null);
		this.addComponentListener(new Listener());
		this.add(MainText);
	}
	public class Listener implements ComponentListener{

		@Override
		public void componentResized(ComponentEvent e) {
			// TODO Auto-generated method stub
			MainText.setBounds(0, 0, getWidth(), getHeight());
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentShown(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
