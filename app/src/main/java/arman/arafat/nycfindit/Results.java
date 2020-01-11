package arman.arafat.nycfindit;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Results extends ListActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String> descriptions = new ArrayList<String>();
    ListView listview;
    public static int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        listview = (ListView)findViewById(android.R.id.list);

        if(!descriptions.isEmpty())
            descriptions.clear();

        for(Item i : Lost.matched_items)
        {
            descriptions.add(i.getDesc());
        }

        if(descriptions.isEmpty())
            descriptions.add("No Results Found");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,descriptions);
        setListAdapter(adapter);

        /*
        for(Item i : Lost.matched_items)
        {
            ImageView temp = i.getImg();

        }
        */
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        pos = position;
        Intent goToDetail = new Intent(Results.this, Detail.class);
        startActivity(goToDetail);
    }


}
