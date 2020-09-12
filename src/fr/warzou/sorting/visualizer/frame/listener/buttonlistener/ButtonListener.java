package fr.warzou.sorting.visualizer.frame.listener.buttonlistener;

import fr.warzou.sorting.sort.Sort;
import fr.warzou.sorting.visualizer.frame.sorting.SortingVisualizerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JFrame jFrame;
    private Sort sort;

    public ButtonListener(JFrame jFrame, Sort sort) {
        this.jFrame = jFrame;
        this.sort = sort;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton jButton = (JButton) event.getSource();
        if (jButton.getName().equals("sorting.type.0")) {
            this.jFrame.getContentPane().remove(0);
            jFrame.setVisible(false);
            sort.sort();
            this.jFrame.getContentPane().add(new SortingVisualizerPanel(sort).create());
            jFrame.setVisible(true);
        }
    }
}
