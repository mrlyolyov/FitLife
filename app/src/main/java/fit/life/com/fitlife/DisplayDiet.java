package fit.life.com.fitlife;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class DisplayDiet extends AppCompatActivity {


    private String sex;
    private int weight, height;
    private SharedPreferences sharedPref;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = this.getSharedPreferences(getString(R.string.shared_file_name), Context.MODE_PRIVATE);
        setContentView(R.layout.activity_display_diet);
        text=(TextView)findViewById(R.id.dietText);
        sex = sharedPref.getString("sex","sex");
        weight=sharedPref.getInt("weight",0);
        height = sharedPref.getInt("height",0);
        if(sex.equals("мъж")){
            if(height/2<weight)
            text.setText(underMan);
        else if(height/2>=weight)
            text.setText(overMan);

        }
        else{
            if(height/2<weight)
                text.setText(overWoman);
            else if(height/2>=weight)
                text.setText(underWoman);
        }


    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    private String overWoman = "Кисело мляко - 318 гр.\n" +
            "\n" +
            "Пилешко месо – 112 гр.\n" +
            "\n" +
            "Сьомга – 120 гр.\n" +
            "\n" +
            "Моркови – 113 гр.\n" +
            "\n" +
            "Зеле – 221 гр.\n" +
            "\n" +
            "Вишни – 150 гр.\n" +
            "\n" +
            "Портокали – 125 гр.\n";

    private String underWoman= "Многозърнест хляб – 220 гр.\n" +
            "\n" +
            "Краве сирене – 150 гр.\n" +
            "\n" +
            "Кашкавал - 120 гр.\n" +
            "\n" +
            "Свинско месо – 330 гр.\n" +
            "\n" +
            "Орехи – 153 гр.\n" +
            "\n" +
            "Домати – 250 гр.\n" +
            "\n" +
            "Мед – 53 гр.\n" +
            "\n" +
            "Банани – 256 гр.\n";

    private String underMan = "Ръжен хляб – 254 гр.\n" +
            "\n" +
            "Многозърнест хляб – 268 гр.\n" +
            "\n" +
            "Прясно мляко – 235 гр.\n" +
            "\n" +
            "Краве сирене – 164 гр.\n" +
            "\n" +
            "Кашкавал – 134 гр.\n" +
            "\n" +
            "Свинско месо – 173 гр.\n" +
            "\n" +
            "Телешко месо – 138 гр.\n" +
            "\n" +
            "Мед – 72 гр.\n" +
            "\n" +
            "Зрял боб – 305 гр.\n" +
            "\n" +
            "Зехтин – 30 гр.\n";


    private String overMan = "Кисело мляко 3,6% - 342 гр.\n" +
            "\n" +
            "Пилешко месо – 125 гр.\n" +
            "\n" +
            "Сьомга – 142 гр.\n" +
            "\n" +
            "Моркови – 135 гр.\n" +
            "\n" +
            "Зеле – 237 гр.\n" +
            "\n" +
            "Вишни – 205 гр.\n" +
            "\n" +
            "Портокали – 142 гр.\n";

}
