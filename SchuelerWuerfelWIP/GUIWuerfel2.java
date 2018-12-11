import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIWuerfel2 extends JFrame implements ActionListener
{
    private Wuerfel wuerfel;

    private JButton bWuefel;
    private JButton bNaechster;

    private JLabel lMinJungen;
    private JLabel lMinMädchen;
    private JLabel lAnzahl;

    private JTextField tMinJungen;
    private JTextField tMinMädchen;
    private JTextField tAnzahl;
    private JTextField tAntwort;

    private int aktuelerSchueler = 0;
    String[] ergebnis;

    public GUIWuerfel2 (String klasse)
    {
        super("2. Daten aufnahme"); 
        setSize(300,200); 
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        wuerfel = new Wuerfel(klasse);

        bWuefel = new JButton("Würfeln");
        bWuefel.setBounds(10,125,200,30); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bWuefel.addActionListener(this);
        add(bWuefel);
        bWuefel.validate();
        bWuefel.repaint();
        bNaechster = new JButton("nächster Name");
        bNaechster.setBounds(110,100,150,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bNaechster.addActionListener(this);
        add(bNaechster);
        bNaechster.validate();
        bNaechster.repaint();

        lMinJungen = new JLabel("Min Jungen"); 
        lMinJungen.setBounds(10,10,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lMinJungen);
        lMinJungen.validate();
        lMinJungen.repaint();
        lMinMädchen = new JLabel("Min Mädchen"); 
        lMinMädchen.setBounds(10,40,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lMinMädchen);
        lMinMädchen.validate();
        lMinMädchen.repaint();
        lAnzahl = new JLabel("Anzahl"); 
        lAnzahl.setBounds(10,70,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lAnzahl);
        lAnzahl.validate();
        lAnzahl.repaint();

        tMinJungen = new JTextField("0");
        tMinJungen.setBounds(100,10,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tMinJungen);
        tMinJungen.validate();
        tMinJungen.repaint();
        tMinMädchen = new JTextField("0");
        tMinMädchen.setBounds(100,40,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tMinMädchen);
        tMinMädchen.validate();
        tMinMädchen.repaint();
        tAnzahl = new JTextField();
        tAnzahl.setBounds(100,70,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tAnzahl);
        tAnzahl.validate();
        tAnzahl.repaint();
        tAntwort = new JTextField("0");
        tAntwort.setBounds(10,100,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tAntwort);
        tAntwort.validate();
        tAntwort.repaint();
    }

    public void actionPerformed (ActionEvent ev) {
        Object quelle = ev.getSource();
        if (quelle == bWuefel)
        {
            ergebnis = wuerfel.wuerfeln(Integer.parseInt(tAnzahl.getText()),Integer.parseInt(tMinJungen.getText()),Integer.parseInt(tMinMädchen.getText()));
            tAntwort.setText(ergebnis[0]);
            aktuelerSchueler = 1;
        }
        else if (ergebnis != null)
        {
            if (quelle == bNaechster)
            {
                if (aktuelerSchueler < Integer.parseInt(tAnzahl.getText()))
                {
                    tAntwort.setText(ergebnis[aktuelerSchueler]);
                    aktuelerSchueler++;
                }
                else{
                    tAntwort.setText("das Waren schon alle");
                }
            }
        }
    }
}

