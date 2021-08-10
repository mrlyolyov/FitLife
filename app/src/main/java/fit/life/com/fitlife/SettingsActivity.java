package fit.life.com.fitlife;

import android.content.*;
import android.support.v7.app.*;
import android.os.Bundle;
import android.text.*;
import android.view.*;
import android.widget.*;

public class SettingsActivity extends AppCompatActivity {

    private TextView sexView, heightView, weightView;
    private Button sexChange, heightChange,weightChange;
    private String sex;
    private Context context;
    private int weight,height;
    private String[] sexes = {"мъж", "жена"};
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        context=this;
        sharedPref =this.getSharedPreferences(getString(R.string.shared_file_name),Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        sex = sharedPref.getString("sex","sex");
        weight=sharedPref.getInt("weight",0);
        height = sharedPref.getInt("height",0);
        loadGUI();
    }


    private void loadGUI(){
        sexView=(TextView)findViewById(R.id.sexText);
        String sexViewText =  "Пол: "+sex;
        sexView.setText(sexViewText);
        heightView=(TextView)findViewById(R.id.heightText);
        String heightViewText =  "Височина: "+ String.valueOf(height);
        heightView.setText(heightViewText);
        weightView=(TextView)findViewById(R.id.weightText);
        String weightViewText = "Тегло: "+String.valueOf(weight);
        weightView.setText(weightViewText);

        sexChange=(Button)findViewById(R.id.sexChange);
        sexChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Променете пол.");

                builder.setSingleChoiceItems(sexes, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sex=sexes[which];

                        editor.putString("sex", sex);
                        editor.apply();
                        String sexViewText =  "Пол: "+sex;
                        sexView.setText(sexViewText);
                        dialog.dismiss();

                    }
                });

                builder.show();

            }
        });

        weightChange=(Button)findViewById(R.id.weightChange);
        weightChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Променете тегло.");

                // Set up the input
                final EditText input = new EditText(context);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        weight = Integer.parseInt(input.getText().toString());

                        editor.putInt("weight", weight);
                        editor.apply();
                        String weightViewText = "Тегло: "+String.valueOf(weight);
                        weightView.setText(weightViewText);

                    }
                    });
                        builder.show();


                }

                });

        heightChange=(Button)findViewById(R.id.heightChange);
        heightChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Променете височина.");

                // Set up the input
                final EditText input = new EditText(context);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        height = Integer.parseInt(input.getText().toString());

                        editor.putInt("height", height);
                        editor.apply();
                        String heightViewText =  "Височина: "+ String.valueOf(height);
                        heightView.setText(heightViewText);

                    }
                });
                builder.show();


            }

        });









    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

        super.onBackPressed();
    }
}
