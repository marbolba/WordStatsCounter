package sample;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

public class WordReader
{
    protected ArrayList<String> words;

    WordReader()
    {
        words = new ArrayList<String>();
    }
    WordReader(String source)        //konstruktor domyslny
    {
        this();
        readDoc(source);
    }
    WordReader(Artist artist)
    {
        this();
        System.out.println("szukam dla artysty: "+artist.getName());
        //search
        File folderText=new File("./text/");
        File files[]=folderText.listFiles();
        int countFiles=0;
        for(File f:files)
        {
            if(f.getName().contains(artist.getName()+"-"))      //artist_name-title  - standarize
            {
                readDoc(f.getName());
                countFiles++;
            }
        }
        if(countFiles==0)
        {
            System.out.println("ERROR: there are no files of "+artist.getName());
            words=null;
        }
    }
    public void readDoc(String source)
    {
        BufferedReader br = null;
        String line;
        Charset ch = Charset.forName("UTF-8");      //include national signs
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("text/"+source),ch));

            while ((line= br.readLine()) != null)
            {
                String[] withSplit;
                line=line.replaceAll("[^a-żA-Ż ]","").toLowerCase();     //with polish signs, to lower case to standardize all strings
                //line=removeSigns(line.toLowerCase());
                withSplit = line.split(" ");
                for(String w:withSplit)
                {
                    if(w.length()>3)       //takes only words longer than 3 signs
                        words.add(w);
                }

            }
        } catch (IOException e) {e.printStackTrace();}
    }
    public ArrayList<String> getWords(){
        return words;
    }
}
