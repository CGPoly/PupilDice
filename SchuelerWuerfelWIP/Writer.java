import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer
{
    public int aktuelleSchuelerZahlW = 0;
    public int aktuelleSchuelerZahlM = 0;
    public String[] schuelerW;
    public String[] schuelerM;
    private File fileW;
    private File fileM;
    public Writer(String klasse, int schuelerZahlW, int schuelerZahlM)
    {
        fileW = new File(System.getProperty("user.dir") + klasse + "W.txt");
        fileM = new File(System.getProperty("user.dir") + klasse + "M.txt");
        schuelerW = new String[schuelerZahlW];
        schuelerM = new String[schuelerZahlM];
    }

    public void writeW(String name)
    {
        schuelerW[aktuelleSchuelerZahlW] = name + "; ";
        aktuelleSchuelerZahlW++;
    }
    public void writeM(String name)
    {
        schuelerM[aktuelleSchuelerZahlM] = name + "; ";
        aktuelleSchuelerZahlM++;
    }

    public void end(){
        try{
            FileWriter writerW = new FileWriter(fileW);
            for (int i = 0; i < schuelerW.length; i++)
            {
                writerW.write(schuelerW[i]);
            }
            writerW.close();
            
            FileWriter writerM = new FileWriter(fileM);
            for (int i = 0; i < schuelerM.length; i++)
            {
                writerM.write(schuelerM[i]);
            }
            writerM.close();
        }catch(IOException ioe){}
    }
}