package arman.arafat.nycfindit;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;

public class Start extends AppCompatActivity {

    //Used to load the 'native-lib' library on application startup.
    //static {
        //System.loadLibrary("native-lib");
    //}

    Button lost;
    Button found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        lost = (Button)findViewById(R.id.buttonL);
        found = (Button)findViewById(R.id.buttonF);

        lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLost = new Intent(Start.this,Lost.class);
                startActivity(goToLost);
            }

        });

        found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToFound = new Intent(Start.this,Found.class);
                startActivity(goToFound);
                //Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(cam,0);
            }
        });
    }


}
