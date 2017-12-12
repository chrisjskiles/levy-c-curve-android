package edu.niu.cs.skiles.levyc_curve;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int MIN_LEVEL = 1,
                     MAX_LEVEL = 15;

    private TextView levelTV;
    private Integer levelNum;
    private RelativeLayout relativeLayout;
    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //put toolbar on screen
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        relativeLayout = (RelativeLayout)findViewById(R.id.screen);
        levelTV = (TextView)findViewById(R.id.levelTextView);

        fractalView = new FractalView(this);
        relativeLayout.addView(fractalView, 0);

        levelNum = MIN_LEVEL;
    }//onCreate

    public void drawFractal(View v) {
        fractalView.setLevel(levelNum);
        fractalView.invalidate();
    }//drawFractal

    public void stepUp(View v) {
        if(levelNum < MAX_LEVEL) {
            levelNum++;
            levelTV.setText((levelNum).toString());
        }
    }//stepUp

    public void stepDown(View v) {
        if(levelNum > MIN_LEVEL) {
            levelNum--;
            levelTV.setText((levelNum).toString());
        }
    }//stepDown

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.draw_black) {
            fractalView.setFractalColor(Color.rgb(0, 0, 0));
            fractalView.invalidate();
            Toast.makeText(MainActivity.this, "Selected Black", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.draw_red) {
            fractalView.setFractalColor(Color.rgb(255, 0, 0));
            fractalView.invalidate();
            Toast.makeText(MainActivity.this, "Selected Red", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.draw_blue) {
            fractalView.setFractalColor(Color.rgb(0, 0, 255));
            fractalView.invalidate();
            Toast.makeText(MainActivity.this, "Selected Blue", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.draw_green) {
            fractalView.setFractalColor(Color.rgb(0, 255, 0));
            fractalView.invalidate();
            Toast.makeText(MainActivity.this, "Selected Green", Toast.LENGTH_SHORT).show();
            return true;
        }

        else {
            return super.onOptionsItemSelected(item);
        }
    }


}
