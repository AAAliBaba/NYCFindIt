package arman.arafat.nycfindit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    Item result;
    ImageView pic;
    TextView cap;
    TextView l_f;
    TextView l_d;
    TextView t;
    TextView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        result = Lost.matched_items.get(Results.pos);
        pic = (ImageView)findViewById(R.id.pic);

        cap = (TextView)findViewById(R.id.caption);
        cap.setText("Caption:\n"+result.getDesc());

        l_f = (TextView)findViewById(R.id.loc_found);
        l_f.setText("Location Found:\n"+result.getLoc());

        l_d = (TextView)findViewById(R.id.loc_dropped);
        l_d.setText("Location Dropped Off:\n"+result.getDrop());

        t = (TextView)findViewById(R.id.tag);
        t.setText("Tag:\n"+result.getTag());

        b = (TextView)findViewById(R.id.boro);
        b.setText("Borough:\n"+result.getBoro());
    }
}
