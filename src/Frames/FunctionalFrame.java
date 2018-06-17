package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Component.Slot;

public class FunctionalFrame extends JFrame {
        private String[] names;
        private Slot[] slots;
        private JPanel[] frames;


        public FunctionalFrame(String[] s, JPanel[] frames) {
            this.frames = frames;
            names = s;
            slots = new Slot[names.length];
            this.setLayout(new GridLayout(names.length, 1));
            for (int i = 0; i < names.length; i++) {
                slots[i] = new Slot(names[i]);
                slots[i].addMouseListener(new Listener());
                this.add(slots[i]);
            }
        }

        private void setting() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 1 * Toolkit.getDefaultToolkit().getScreenSize().height / 100, 300, 300);
        this.setLayout(null);
        this.addMouseListener(new Listener());
        this.getContentPane().setBackground(Color.WHITE);
        this.setUndecorated(true);
    }
        public class Listener implements MouseListener {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            @Override
            public void mousePressed(MouseEvent e) {
                Slot s = (Slot) e.getSource();
                for (int i = 0; i < names.length; i++) {
                    if (s == slots[i]) {

                        for (int j = 0; j < frames.length; j++) {
                            frames[i].setVisible(false);
                        }
                        frames[i].setVisible(true);
                        frames[i].repaint();
                    }
                }

            }
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        }


}

