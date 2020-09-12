package fr.warzou.sorting.visualizer.frame.sorting;

import fr.warzou.sorting.sort.Sort;
import fr.warzou.sorting.visualizer.frame.Frame;

import javax.swing.*;
import java.awt.*;

public class SortingVisualizerPanel extends JPanel {

    private Sort sort;

    public SortingVisualizerPanel(Sort sort) {
        this.sort = sort;
    }

    public JPanel create() {
        return this;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        int windowsWidth = Frame.width;
        int windowsHeight = Frame.height;
        if (this.sort.isEnd())
            return;
        repaint();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, windowsWidth, windowsHeight);
        for (int i = 0; i < Sort.VALUES_LENGTH; i++) {
            graphics.setColor(Color.WHITE);
            if (i == this.sort.getSelected())
                graphics.setColor(Color.RED);
            if (this.sort.getSortingValues().contains(i))
                graphics.setColor(Color.GREEN);
            int value = this.sort.getValues().get(i);
            int width = (int) (windowsWidth - ((windowsWidth / (Sort.VALUES_LENGTH + 0.0f)) * i));
            int height = (int) ((windowsHeight) * (value / (Sort.VALUES_LENGTH + 0.0)));
            if (i == this.sort.getSelected())
                height = windowsHeight;
            graphics.fillRect(windowsWidth - width, windowsHeight - height, (windowsWidth / Sort.VALUES_LENGTH), height);
        }
    }
}
