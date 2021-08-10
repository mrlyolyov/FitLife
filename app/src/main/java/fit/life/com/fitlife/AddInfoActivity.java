package fit.life.com.fitlife;

import android.app.*;
import android.content.*;
import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.*;
import android.util.*;
import android.widget.*;

public class AddInfoActivity extends AppCompatActivity {
    private SharedPreferences sharedPref;
    private Context context;
    private int height, weight;
    private String sex;
    private String[] sexes = {"мъж", "жена"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_add_info);
        sharedPref = this.getSharedPreferences(getString(R.string.shared_file_name), Context.MODE_PRIVATE);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Изберете пол.");

        builder.setSingleChoiceItems(sexes, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sex=sexes[which];
                    }
                });



        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Изберете височина.");

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
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Изберете тегло.");

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
                                writeSharedPreferences();
                                Intent startMain = new Intent(context, MainActivity.class);
                                startActivity(startMain);
                            }
                        });
                        builder.show();
                    }

                });
                builder.show();
            }
        });
        builder.show();
    }


    private void writeSharedPreferences() {

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("weight", weight);
        editor.putInt("height", height);
        editor.putString("sex", sex);
        editor.apply();
    }
}
