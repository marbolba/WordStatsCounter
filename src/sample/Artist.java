package sample;

public class Artist
{
    private String name="";
    //dummy class to make types diffrent, workaround
    Artist(String name)
    {
        this.name=name.toLowerCase();
    }
    public String getName()
    {
        return name;
    }
}
