package gui;

import javax.swing.*;
import java.awt.*;

public class MenuOptions extends JPanel {
    public MenuOptions(){
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER,10,10);
        setLayout( layout );
        add( new JButton("EXPORT TO PDF"), BorderLayout.SOUTH );
    }
}
