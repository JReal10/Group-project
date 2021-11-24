package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuOptions extends JPanel {
    MainGUI appFrame;
    JButton reloadBtn = new JButton("Reload Data");

    public MenuOptions(MainGUI appFrame){
        this.appFrame=appFrame;
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
        setLayout( layout );
        add(reloadBtn, BorderLayout.SOUTH);
        reloadBtn.addActionListener(new ReloadHandler());
        add( new JButton("EXPORT TO PDF"), BorderLayout.SOUTH );
        add( new JButton("GRAPH"), BorderLayout.SOUTH );
        add( new JButton("RAW DATA"), BorderLayout.SOUTH );
    }

    private class ReloadHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for(;;) {
                try {
                    appFrame.refreshData();
                    JOptionPane.showMessageDialog(appFrame, "Successfully downloaded new data", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    int result = JOptionPane.showConfirmDialog(appFrame, "Failed to update data, try again?\nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    if(result==0) continue;
                    else break;
                }
            }
        }
    }
}
