import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIWuerfel1 extends JFrame implements ActionListener
{    
    private GUIWuerfel2 wuerfel2;

    private JButton bFinished;

    private JLabel lklasse;

    private JTextField tklasse;

    public GUIWuerfel1 ()
    {
        super("1. Daten aufnahme"); 
        setSize(300,200);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bFinished = new JButton("Daten Übernehmen");
        bFinished.setBounds(10,125,200,30); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bFinished.addActionListener(this);
        add(bFinished);
        bFinished.validate();
        bFinished.repaint();

        lklasse = new JLabel("klasse"); 
        lklasse.setBounds(10,10,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lklasse);
        lklasse.validate();
        lklasse.repaint();

        tklasse = new JTextField();
        tklasse.setBounds(10,40,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tklasse);
        tklasse.validate();
        tklasse.repaint();
    }

    public void actionPerformed (ActionEvent ev) {
        Object quelle = ev.getSource();
        if (quelle == bFinished){
            if (tklasse.getText() != null)
            {
                wuerfel2 = new GUIWuerfel2(tklasse.getText());
                dispose();
            }
            else 
            {
                System.out.println("Sie müssen alle Felder füllen");
            }
        }
    }
}
