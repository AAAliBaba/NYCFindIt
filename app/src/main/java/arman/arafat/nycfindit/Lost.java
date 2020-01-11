package arman.arafat.nycfindit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Lost extends AppCompatActivity {

    Spinner s_tags2;
    Spinner boros2;
    Button search;

    String targetTag;
    String targetBoro;

    public static ArrayList<Item> matched_items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        s_tags2 = (Spinner)findViewById(R.id.tags);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tags_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_tags2.setAdapter(adapter);

        boros2 = (Spinner)findViewById(R.id.boros);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.boro_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boros2.setAdapter(adapter2);

        search = (Button)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                targetTag = s_tags2.getSelectedItem().toString();
                targetBoro = boros2.getSelectedItem().toString();

                if(!matched_items.isEmpty())
                    matched_items.clear();

                for(Item i : Found.items)
                {
                    if(i.getTag()==targetTag && i.getBoro()==targetBoro)
                    {
                        matched_items.add(i);
                    }
                }

                Intent goToResults = new Intent(Lost.this, Results.class);
                startActivity(goToResults);
            }
        });
    }
}
