package app.codeconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG="SpalshActivity";
    private static final int TIME_OUT=3000;
    TextView tv;
    private Typeface balooDa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        balooDa= Typeface.createFromAsset(getApplicationContext().getAssets(),"BalooDaRegular.ttf");
        tv=(TextView)findViewById(R.id.splash_textview);
        tv.setTypeface(balooDa);

        Thread thd=new Thread()
        {

            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    // Intent can be created in this manner also.
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        thd.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
