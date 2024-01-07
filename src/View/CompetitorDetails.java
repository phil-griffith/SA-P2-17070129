package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompetitorDetails extends JPanel {

    // Table for competitor data
    private JTable competitorTable;
    // table column
    private String[] competitorTableColumn = {"FIRST NAME", "MIDDLE NAME", "LAST NAME", "COUNTRY", "AGE", "EMAIL", "COMPETITOR NUMBER", "SCORES", "CATEGORY", "LEVEL"};

    // back button
    private JButton backButton;

    public CompetitorDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        competitorTable = new JTable();
        // scroll bar for table
        JScrollPane competitorTableScroll = new JScrollPane(competitorTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(competitorTableScroll);

    }

    // gets competitors from database and loads to table
    public void getCompetitors(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) competitorTable.getModel();
        defaultTableModel.setColumnIdentifiers(competitorTableColumn);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(";");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
