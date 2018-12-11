import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIWrite2 extends JFrame implements ActionListener
{
    private Writer writer;

    private JButton bFinished;
    private JButton bnameW;
    private JButton bnameM;

    private JLabel lnameW;
    private JLabel lnameM;

    private JTextField tnameW;
    private JTextField tnameM;

    public GUIWrite2 (String klasse, int anzahlW, int anzahlM)
    {
        super("2. Daten aufnahme"); 
        setSize(300,200); 
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        writer = new Writer(klasse, anzahlW, anzahlM);

        bFinished = new JButton("Daten Übernehmen");
        bFinished.setBounds(10,130,250,30); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bFinished.addActionListener(this);
        add(bFinished);
        bFinished.validate();
        bFinished.repaint();
        
        bnameW = new JButton("name Eintragen");
        bnameW.setBounds(110,40,150,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bnameW.addActionListener(this);
        add(bnameW);
        bnameW.validate();
        bnameW.repaint();
        
        bnameM = new JButton("name Eintragen");
        bnameM.setBounds(110,100,150,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        bnameM.addActionListener(this);
        add(bnameM);
        bnameM.validate();
        bnameM.repaint();

        lnameW = new JLabel("name Mädchen"); 
        lnameW.setBounds(10,10,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lnameW);
        lnameW.validate();
        lnameW.repaint();

        tnameW = new JTextField();
        tnameW.setBounds(10,40,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tnameW);
        tnameW.validate();
        tnameW.repaint();
        
        lnameM = new JLabel("name Junge"); 
        lnameM.setBounds(10,70,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe 
        add(lnameM);
        lnameM.validate();
        lnameM.repaint();

        tnameM = new JTextField();
        tnameM.setBounds(10,100,100,20); // x-Koordinate, y-Koordinate, Breite, Höhe
        add(tnameM);
        tnameM.validate();
        tnameM.repaint();
    }

    public void actionPerformed (ActionEvent ev) {
        Object quelle = ev.getSource();
        if (quelle == bnameW){
            {
                if (tnameW.getText() != null)
                {
                    writer.writeW(tnameW.getText());
                    tnameW.setText("");
                }
                else 
                {
                    System.out.println("Sie müssen alle Felder füllen");
                }
            }
        }
        else if (quelle == bnameM){
            {
                if (tnameM.getText() != null)
                {
                    writer.writeM(tnameM.getText());
                    tnameM.setText("");
                }
                else 
                {
                    System.out.println("Sie müssen alle Felder füllen");
                }
            }
        }
        else if (quelle == bFinished)
        {
            writer.end();
            dispose();
        }
        
        if (writer.schuelerW.length == writer.aktuelleSchuelerZahlW)
        {
            tnameW.setText("Alle Eingetragen");
        }
        
        if (writer.schuelerM.length == writer.aktuelleSchuelerZahlM)
        {
            tnameM.setText("Alle Eingetragen");
        }
    }
}
