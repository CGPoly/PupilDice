
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIWrite1 extends JFrame implements ActionListener
{    
    private GUIWrite2 writer2;

    private JButton bFinished;

    private JLabel lklasse;
    private JLabel lAnzahlW;
    private JLabel lAnzahlM;

    private JTextField tklasse;
    private JTextField tAnzahlW;
    private JTextField tAnzahlM;

    public GUIWrite1 ()
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

        lAnzahlW = new JLabel("Anzahl Mädchen"); 
        lAnzahlW.setBounds(10,70,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lAnzahlW);
        lAnzahlW.validate();
        lAnzahlW.repaint();

        lAnzahlW = new JLabel("Anzahl Jungen"); 
        lAnzahlW.setBounds(110,70,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lAnzahlW);
        lAnzahlW.validate();
        lAnzahlW.repaint();

        tklasse = new JTextField();
        tklasse.setBounds(10,40,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tklasse);
        tklasse.validate();
        tklasse.repaint();

        tAnzahlW = new JTextField();
        tAnzahlW.setBounds(10,100,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tAnzahlW);
        tAnzahlW.validate();
        tAnzahlW.repaint();

        tAnzahlM = new JTextField();
        tAnzahlM.setBounds(110,100,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tAnzahlM);
        tAnzahlM.validate();
        tAnzahlM.repaint();
    }

    public void actionPerformed (ActionEvent ev) {
        Object quelle = ev.getSource();
        if (quelle == bFinished){
            if (tklasse.getText() != null)
            {
                if (tAnzahlW.getText() != null)
                {
                    if (tAnzahlM.getText() != null)
                    {
                        writer2 = new GUIWrite2(tklasse.getText(), Integer.parseInt(tAnzahlW.getText()), Integer.parseInt(tAnzahlM.getText()));
                        dispose();
                    }
                }
            }
            else 
            {
                System.out.println("Sie müssen alle Felder füllen");
            }
        }
    }
}
