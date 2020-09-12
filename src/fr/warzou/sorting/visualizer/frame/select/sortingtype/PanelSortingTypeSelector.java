package fr.warzou.sorting.visualizer.frame.select.sortingtype;

import fr.warzou.sorting.sort.Sort;
import fr.warzou.sorting.visualizer.frame.listener.buttonlistener.ButtonListener;
import fr.warzou.sorting.visualizer.sort.type.SortingType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelSortingTypeSelector extends JPanel {

    private List<JButton> buttonList = new ArrayList<>();

    private JFrame jFrame;
    private Sort sort;

    public PanelSortingTypeSelector(JFrame jFrame, Sort sort) {
        this.jFrame = jFrame;
        this.sort = sort;
    }

    public JPanel create() {
        for (int i = 0; i < 10; i++) {
            SortingType sortingType = SortingType.byID(i);
            JButton jButton = new JButton();
            jButton.addActionListener(new ButtonListener(this.jFrame, this.sort));
            if (sortingType == null) {
                jButton.setName("sorting.type." + i);
                jButton.setText("Any sort");
                add(jButton);
                buttonList.add(jButton);
                continue;
            }
            jButton.setName("sorting.type." + i);
            jButton.setText(sortingType.getName());
            add(jButton);
            buttonList.add(jButton);
        }
        return this;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        repaint();
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setBounds(10 + (i * 100), 10, 100, 25);
        }
    }
}
