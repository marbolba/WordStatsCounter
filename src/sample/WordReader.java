package sample;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

public class WordReader
{
    protected ArrayList<String> words;

    public WordReader(String source)        //konstruktor domyslny
    {
        words = new ArrayList<String>();
        readDoc(source);
    }
    public String removeSigns(String text)
    {
        String cleanText="";
        String[] letters = text.split("");      //convert to array
        for(int i=0;i<letters.length;i++)
        {
            if(!letters[i].equals(",")&&!letters[i].equals(".")&&!letters[i].equals("?")&&!letters[i].equals("!")&&!letters[i].equals("\"")&&
               !letters[i].equals(":")&&!letters[i].equals("*")&&!letters[i].equals("#")&&!letters[i].equals("$")&&!letters[i].equals("(")&&
               !letters[i].equals(")")&&!letters[i].equals("-"))        //illegal signs
                cleanText+=letters[i];
        }
        return cleanText;
    }
    public void readDoc(String source)
    {
        BufferedReader br = null;
        String line;
        Charset ch = Charset.forName("UTF-8");      //include national signs
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(source),ch));

            while ((line= br.readLine()) != null)
            {
                String[] withSplit;
                line=removeSigns(line.toLowerCase());           //change to lower case to standardize all strings
                withSplit = line.split(" ");
                for(String w:withSplit)
                    words.add(w);

            }
        } catch (IOException e) {e.printStackTrace();}
    }
    public ArrayList<String> getWords(){
        return words;
    }
}
