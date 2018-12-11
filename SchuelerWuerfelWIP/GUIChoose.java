
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIChoose extends JFrame implements ActionListener
{
    GUIWrite1 writer;
    GUIWuerfel1 wuerfel;
    
    private JButton bWrite;
    private JButton bWuerfel;

    public GUIChoose ()
    {
        super("Auswahl"); 
        setSize(300,200); 
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bWrite = new JButton("Neue Klasse erstellen");
        bWrite.setBounds(10,10,200,30); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bWrite.addActionListener(this);
        add(bWrite);
        bWrite.validate();
        bWrite.repaint();

        bWuerfel = new JButton("Zufallswürfel nutzen");
        bWuerfel.setBounds(10,70,200,30); // x-Koordinate, y-Koordinate, Breite, Höhe
        bWuerfel.addActionListener(this);
        add(bWuerfel);
        bWuerfel.validate();
        bWuerfel.repaint();
    }

    public void actionPerformed (ActionEvent ev) {
        Object quelle = ev.getSource();
        if (quelle == bWrite){
            writer = new GUIWrite1();
            dispose();
        }
        else if (quelle == bWuerfel){
            wuerfel = new GUIWuerfel1();
            dispose();
        }
    }
}
