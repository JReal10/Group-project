package gui;

import data.DataRepo;
import linear_regression.Estimator;
import linear_regression.Model;
import linear_regression.OrdLeastSquares;

import javax.swing.*;
import java.text.DecimalFormat;

public class TableDisplayPanel extends JPanel {
    TableDisplayPanel(DataRepo data) {
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
            tableData[i][0] = Integer.toString(i + 1);
            tableData[i][1] = df.format(predicted);
            System.out.println("dates[0]:" + dates[0] + " i:" + i + " predicted:" + df.format(predicted));
        }
        JTable table = new JTable(tableData, columnNames);
        add(table);
    }
}
