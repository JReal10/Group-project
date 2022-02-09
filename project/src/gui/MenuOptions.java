package gui;

import data.DataRepo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuOptions extends JPanel {
    MainGUI app;
    DataRepo data;

    public MenuOptions(MainGUI app, DataRepo data) {
        this.data = data;
        this.app = app;
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        setLayout(layout);
        JButton reloadBtn = new JButton("Reload Data");
        add(reloadBtn, BorderLayout.SOUTH);
        reloadBtn.addActionListener(new ReloadHandler());
        add(new JButton("EXPORT TO PDF"), BorderLayout.SOUTH);
        JButton dataBtn = new JButton("View Table");
        add(dataBtn, BorderLayout.SOUTH);
        dataBtn.addActionListener(new TableHandler());
    }

    private class TableHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableFrame frame = new TableFrame();
        }
    }

    private class ReloadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for (; ; ) {
                try {
                    data.refresh();
                    JOptionPane.showMessageDialog(app, "Successfully downloaded new data", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    int result = JOptionPane.showConfirmDialog(app, "Failed to update data, try again?\nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    if (result == 0) continue;
                    else break;
                }
            }
        }
    }
}
