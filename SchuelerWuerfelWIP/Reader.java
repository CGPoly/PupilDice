import java.io.*;

public class Reader
{
    String inhalt = "";
    String[] inhaltSplited;
    public Reader(String klasse)
    {
        main(klasse);
    }

    public void main(String klasse)
    {
        String fname = System.getProperty("user.dir") + klasse + ".txt";

        String line = null;
        try
        {
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                inhalt = line;
            }

            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file named '" + fname + "'");
        }
    }

    public String[] interpret()
    {
        inhaltSplited = inhalt.split(";");
        String[] a = new String[inhaltSplited.length-1];
        for (int i = 0; i<a.length; i++)
        {
            a[i] = inhaltSplited[i];
        }
        inhaltSplited = a;
        return inhaltSplited;
    }
}



