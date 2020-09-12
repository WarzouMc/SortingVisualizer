package fr.warzou.sorting.visualizer.frame;

import fr.warzou.sorting.sort.Sort;
import fr.warzou.sorting.visualizer.frame.select.sortingtype.PanelSortingTypeSelector;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public static int width = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 1.2);
    public static int height = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height / 1.2);

    private Sort sort;

    public Frame(Sort sort) {
        this.sort = sort;
    }

    public void openFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new PanelSortingTypeSelector(this, this.sort).create());
        setVisible(true);
    }

}
