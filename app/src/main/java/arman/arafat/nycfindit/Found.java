package arman.arafat.nycfindit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Found extends AppCompatActivity {

    ImageView pic;
    private static final int CAM_REQUEST = 1313;
    EditText caption_text;
    EditText loc_found_text;
    EditText loc_dropped_text;
    Spinner s_tags;
    String tag_selected;
    Spinner boros;
    String boro_selected;
    Button submit;

    public static ArrayList<Item> items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);

        pic = (ImageView)findViewById(R.id.imageViewPic);

        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam, CAM_REQUEST);

        s_tags = (Spinner)findViewById(R.id.tags);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tags_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_tags.setAdapter(adapter);

        boros = (Spinner)findViewById(R.id.boros);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.boro_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boros.setAdapter(adapter2);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                caption_text = (EditText)findViewById(R.id.caption);
                loc_found_text = (EditText)findViewById(R.id.loc_found);
                loc_dropped_text = (EditText)findViewById(R.id.loc_dropped);
                tag_selected = s_tags.getSelectedItem().toString();
                boro_selected = boros.getSelectedItem().toString();
                Item temp = new Item(pic, caption_text.getText().toString(), loc_found_text.getText().toString(), loc_dropped_text.getText().toString(), tag_selected, boro_selected);
                items.add(temp);
                /*
                Log.d("",temp.getDesc());
                Log.d("",temp.getDrop());
                Log.d("",temp.getLoc());
                Log.d("",temp.getTag());
                */
                Intent goToStart = new Intent(Found.this, Start.class);
                startActivity(goToStart);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == CAM_REQUEST && resultCode == Found.RESULT_OK)
        {
            Bitmap photo = (Bitmap)data.getExtras().get("data");
            pic.setImageBitmap(photo);

        }
    }
}
