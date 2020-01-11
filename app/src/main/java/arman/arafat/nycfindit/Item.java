package arman.arafat.nycfindit;

import android.widget.ImageView;

public class Item {
    private ImageView image;
    private String desc;
    private String loc;
    private String dropOff;
    private String tag;
    private String boro;

    public Item(ImageView i, String d, String l, String drop, String t, String b)
    {
        image=i;
        desc=d;
        loc=l;
        dropOff=drop;
        tag=t;
        boro=b;
    }

    //accessor methods
    public ImageView getImg()
    {
        return image;
    }
    public String getDesc()
    {
        return desc;
    }
    public String getLoc()
    {
        return loc;
    }
    public String getDrop()
    {
        return dropOff;
    }
    public String getTag()
    {
        return tag;
    }
    public String getBoro()
    {
        return boro;
    }
}
