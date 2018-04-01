package sample;

import java.util.*;

public class Dictionary {
    private Map<String,Integer> dict ;
    Dictionary()
    {
        dict=new HashMap<String, Integer>();
    }
    boolean addWord(String newWord)
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
        //System.out.println("NEW: "+newWord);
        return false;
    }
    void printValues()
    {
        /*ValueComparator bvc = new ValueComparator(dict);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(dict);*/

        Set entrySet = dict.entrySet();
        Iterator i = entrySet.iterator();

        while(i.hasNext())
        {
            Map.Entry curr = (Map.Entry)i.next();
            System.out.println(curr.getKey()+"\t"+curr.getValue());
        }
    }

    /*class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with
        // equals.
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }*/
}
