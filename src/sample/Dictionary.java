package sample;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Dictionary
{
    private Map<String,Integer> dict ;
    private String artist="";
    Dictionary(String artist)
    {
        this.artist=artist;
        dict=new HashMap<String, Integer>();
    }
    Dictionary(ArrayList<String> words,String artist)
    {
        this(artist);
        if(words!=null)
            for(String w:words)
                this.addWord(w);
        else
        {
            dict=null;
            System.out.println("Not enough data!");
        }

    }
    public boolean addWord(String newWord)
    {
        Set entrySet = dict.entrySet();
        Iterator i = entrySet.iterator();

        while(i.hasNext())
        {
            Map.Entry curr = (Map.Entry)i.next();
            if(curr.getKey().equals(newWord))
            {
                dict.put(curr.getKey().toString(), dict.get(curr.getKey()) + 1);
                //System.out.println("added to: "+curr.getKey());
                return true;
            }
        }
        //if there isn't such value
        dict.put(newWord,1);
        return false;
    }
    public void printValues()
    {
        if(dict==null)
        {
            System.out.println("Cannot print - enough data!");
            return;
        }


        CompareValues cmp=new CompareValues(dict);
        TreeMap<String,Integer> sortedDict=new TreeMap<>(cmp);
        sortedDict.putAll(dict);

        Set entrySet = sortedDict.entrySet();
        Iterator i = entrySet.iterator();

        try{
            PrintWriter out = new PrintWriter("./summary/"+artist+"-summary.txt");
            out.println("Diffrent words used: "+sortedDict.size());
            while(i.hasNext())
            {
                Map.Entry curr = (Map.Entry)i.next();

                    int len=curr.getKey().toString().length();
                    if(len<8)
                        out.println(curr.getKey()+"\t\t\t\t"+curr.getValue());
                    if(len>=8 && len<16)
                        out.println(curr.getKey()+"\t\t\t"+curr.getValue());
                    if(len>=16 && len <24)
                        out.println(curr.getKey()+"\t\t"+curr.getValue());
                    if(len>=24)
                        out.println(curr.getKey()+"\t"+curr.getValue());
            }
            out.close();
            System.out.println("summary created: "+artist+"-summary.txt");
            Desktop.getDesktop().edit(new File("./summary/"+artist+"-summary.txt"));        //open a file
        }catch (Exception e){}
    }
    public void saveToFile()
    {
        CompareValues cmp=new CompareValues(dict);
        TreeMap<String,Integer> sortedDict=new TreeMap<>(cmp);
        sortedDict.putAll(dict);

        Set entrySet = sortedDict.entrySet();
        Iterator i = entrySet.iterator();

        while(i.hasNext())
        {
            Map.Entry curr = (Map.Entry)i.next();
            System.out.println(curr.getKey()+"\t"+curr.getValue());
        }
    }
    class CompareValues implements Comparator<String>
    {
        Map<String,Integer> tmp;
        public CompareValues(Map<String,Integer> thisMap)
        {
            this.tmp=thisMap;
        }
        @Override
        public int compare(String a,String b)
        {
            if(tmp.get(a) >= tmp.get(b))
            {
                return -1;
            }
            else
                return 1;
        }
    }
}
