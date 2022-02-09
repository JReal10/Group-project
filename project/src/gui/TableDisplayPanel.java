package gui;

import data.DataRepo;
import linear_regression.Estimator;
import linear_regression.Model;
import linear_regression.OrdLeastSquares;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class TableDisplayPanel extends JPanel {
    TableDisplayPanel(DataRepo data) {
        GridLayout layout = new GridLayout(1, 1);
        setLayout(layout);
        String[] columnNames = {"Day", "Cases"};
        String[][] tableData = new String[7][];
        double[] dates = data.getDateOffsets();
        double[] cases = data.getCases();
        Estimator estimator = new OrdLeastSquares();
        Model model = estimator.getModel(dates, cases);
        DecimalFormat df = new DecimalFormat("###,###");
        df.setMaximumIntegerDigits(15);
        for (int i = 0; i < 7; i++) {
            double day = dates[0] + i;
            double predicted = model.predict(day + 1);
            tableData[i] = new String[2];
            tableData[i][0] = "+" + Integer.toString(i + 1) + " days";
            tableData[i][1] = df.format(predicted);
        }
        JTable table = new JTable(tableData, columnNames);
        table.setFillsViewportHeight(true);
        add(table);
    }
}
