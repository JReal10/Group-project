package gui;

import data.DataRepo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MenuOptions extends JPanel {
    JFrame parent;
    DataRepo data;

    public MenuOptions(JFrame parent, DataRepo data) {
        this.parent = parent;
        this.data = data;
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        setLayout(layout);
        JButton reloadBtn = new JButton("Reload Data");
        add(reloadBtn, BorderLayout.SOUTH);
        reloadBtn.addActionListener(new ReloadHandler());
        JButton exportBtn = new JButton("Export Pdf");
        add(exportBtn, BorderLayout.SOUTH);
        exportBtn.addActionListener(new ExportHandler());
        JButton dataBtn = new JButton("View Table");
        add(dataBtn, BorderLayout.SOUTH);
        dataBtn.addActionListener(new TableHandler());
    }

    private class TableHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableFrame frame = new TableFrame(data);
            frame.setLocationRelativeTo(parent);
        }
    }

    private class ReloadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for (; ; ) {
                try {
                    data.refresh();
                    JOptionPane.showMessageDialog(parent, "Successfully downloaded new data", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    int result = JOptionPane.showConfirmDialog(parent, "Failed to update data, try again?\nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    if (result == 0) continue;
                    else break;
                }
            }
        }
    }

    private class ExportHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                PDDocument export = new PDDocument();
                PDPage page1 = new PDPage();
                export.addPage(page1);
                PDPage page = export.getPage(0);
                PDImageXObject pdImage = PDImageXObject.createFromFile("./output.png", export);
                PDImageXObject pdImage2 = PDImageXObject.createFromFile("./output2.png", export);
                PDPageContentStream contentStream = new PDPageContentStream(export, page);
                contentStream.drawImage(pdImage, 50, 400);
                contentStream.drawImage(pdImage2, 50, 60);
                contentStream.close();
                String filename = "Results_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss")) + ".pdf";
                System.out.println(filename);
                export.save(filename);
                export.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
