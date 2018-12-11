import java.util.Random;

public class Wuerfel
{
    String[] schueler;
    private Random zufallsgenerator = new Random();
    int jungenEnde;
    Reader readerW;
    Reader readerM;
    public Wuerfel(String klasse)
    {
        readerW = new Reader(klasse+"W");
        String[] schuelerW = readerW.interpret();
        readerM = new Reader(klasse+"M");
        String[] schuelerM = readerM.interpret();
        
        jungenEnde = schuelerM.length;
        schueler = new String[schuelerM.length + schuelerW.length];
        for (int i = 0; i < schuelerM.length; i++)
        {
            schueler[i] = schuelerM[i];
        }
        for (int i = 0; i < schuelerW.length; i++)
        {
            schueler[i+jungenEnde] = schuelerW[i];
        }
    }
    
    public String[] wuerfeln(int anzahlAnWuerfen, int minJungen, int minMaedchen)
    {
        String[] schuelerDieSchonWaren = new String[anzahlAnWuerfen];
        if(minJungen+minMaedchen > anzahlAnWuerfen)
        {
            System.out.println("Sie können nicht mehr Mindest Personen nehmen als Würfe.");
        }
        
        else if (anzahlAnWuerfen > schueler.length)
        {
            System.out.println("Du können nicht mehr Schüler auswürfeln, alls sie haben.");
        }
       
        /*else if (minJungen == anzahlAnWuerfen) //nur Jungen
        {
            for (int i = 0; i < anzahlAnWuerfen; i++)
            {
                int x = zufallsgenerator.nextInt(schueler.length-jungenEnde);
                boolean schuelerNichtDoppelt = true;
                int u = 0;
                while (u < anzahlAnWuerfen && schuelerNichtDoppelt)
                {
                    if (schuelerDieSchonWaren[u] != schueler[x] && schuelerNichtDoppelt)
                    {
                        schuelerNichtDoppelt = true;
                    }
                    else 
                    {
                        schuelerNichtDoppelt = false;
                    }
                    u++;
                }
                if (schuelerNichtDoppelt)
                {
                    schuelerDieSchonWaren[i] = schueler[x];
                }
                else 
                {
                    i--;
                }
            }
        }
        
        else if (minMaedchen == 0 && minJungen == 0) //kompleter Zufall
        {
            for (int i = 0; i < anzahlAnWuerfen; i++)
            {
                int x = zufallsgenerator.nextInt(schueler.length);
                boolean schuelerNichtDoppelt = true;
                int u = 0;
                while (u < anzahlAnWuerfen && schuelerNichtDoppelt)
                {
                    if (schuelerDieSchonWaren[u] != schueler[x] && schuelerNichtDoppelt)
                    {
                        schuelerNichtDoppelt = true;
                    }
                    else 
                    {
                        schuelerNichtDoppelt = false;
                    }
                    u++;
                }
                if (schuelerNichtDoppelt)
                {
                    schuelerDieSchonWaren[i] = schueler[x];
                }
                else 
                {
                    i--;
                }
            }
        }
        
        else if (minMaedchen == anzahlAnWuerfen) //nur Maedchen 
        {
            for (int i = 0; i < anzahlAnWuerfen; i++)
            {
                int x = zufallsgenerator.nextInt(schueler.length-jungenEnde) + jungenEnde;
                boolean schuelerNichtDoppelt = true;
                int u = 0;
                while (u < anzahlAnWuerfen && schuelerNichtDoppelt)
                {
                    if (schuelerDieSchonWaren[u] != schueler[x] && schuelerNichtDoppelt)
                    {
                        schuelerNichtDoppelt = true;
                    }
                    else 
                    {
                        schuelerNichtDoppelt = false;
                    }
                    u++;
                }
                if (schuelerNichtDoppelt)
                {
                    schuelerDieSchonWaren[i] = schueler[x];
                }
                else 
                {
                    i--;
                }
            }
        }
        */
        else //Beides
        {
            for (int i = 0; i < anzahlAnWuerfen - (minJungen + minMaedchen); i++)
            {
                int x = zufallsgenerator.nextInt(schueler.length);
                boolean schuelerNichtDoppelt = true;
                int u = 0;
                while (u < anzahlAnWuerfen && schuelerNichtDoppelt)
                {
                    if (schuelerDieSchonWaren[u] != schueler[x] && schuelerNichtDoppelt)
                    {
                        schuelerNichtDoppelt = true;
                    }
                    else 
                    {
                        schuelerNichtDoppelt = false;
                    }
                    u++;
                }
                if (schuelerNichtDoppelt)
                { 
                    schuelerDieSchonWaren[i] = schueler[x];
                }
                else 
                {
                    i--;
                }
            }
            
            for (int i = 0; i < minMaedchen; i++)
            {
                int x = zufallsgenerator.nextInt(schueler.length-jungenEnde) + jungenEnde;
                boolean schuelerNichtDoppelt = true;
                int u = 0;
                while (u < anzahlAnWuerfen && schuelerNichtDoppelt)
                {
                    if (schuelerDieSchonWaren[u] != schueler[x] && schuelerNichtDoppelt)
                    {
                        schuelerNichtDoppelt = true;
                    }
                    else 
                    {
                        schuelerNichtDoppelt = false;
                    }
                    u++;
                }
                if (schuelerNichtDoppelt)
                {
                    schuelerDieSchonWaren[i+anzahlAnWuerfen-minJungen-minMaedchen] = schueler[x];
                }
                else 
                {
                    i--;
                }
            }
            
            for (int i = 0; i < minJungen; i++) 
            {
                int x = zufallsgenerator.nextInt(schueler.length-jungenEnde);
                boolean schuelerNichtDoppelt = true;
                int u = 0;
                while (u < anzahlAnWuerfen && schuelerNichtDoppelt)
                {
                    if (schuelerDieSchonWaren[u] != schueler[x] && schuelerNichtDoppelt)
                    {
                        schuelerNichtDoppelt = true;
                    }
                    else 
                    {
                        schuelerNichtDoppelt = false;
                    }
                    u++;
                }
                if (schuelerNichtDoppelt)
                {
                    schuelerDieSchonWaren[i+anzahlAnWuerfen-minJungen] = schueler[x];
                }
                else 
                {
                    i--;
                }
            }
        }
        return schuelerDieSchonWaren;
    }
}