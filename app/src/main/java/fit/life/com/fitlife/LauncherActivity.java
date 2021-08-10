package fit.life.com.fitlife;

import android.content.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;

import java.io.*;

public class LauncherActivity extends AppCompatActivity {
    private Context context;
    private SharedPreferences sharedPref;
    private String sex;
    private final int WAIT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_launcher);
        sharedPref =this.getSharedPreferences(getString(R.string.shared_file_name),Context.MODE_PRIVATE);
        sex = sharedPref.getString("sex","nope");
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //access shared prefs
                if(!sex.equals("nope")){
                    Intent continueToMain = new Intent(context, MainActivity.class);
                    startActivity(continueToMain);
                    finish();
                }
                else{
                    Intent addInfo = new Intent(context, AddInfoActivity.class);
                    startActivity(addInfo);
                    finish();
                }
            }
        },WAIT);

    }
}