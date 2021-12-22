package efnansifyan.mis.a201735042efnansifyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//değişken tanımlama
    private  String selectedTopicName ="";
    private LinearLayout wind;
    private LinearLayout keyed;
    private LinearLayout stringed;
    private LinearLayout percussion;
    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        init();

        // Quiz seçmek için renk atamaları yaptım.
        wind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName ="wind";
                wind.setBackgroundResource(R.drawable.round_back_white_stroke);
                keyed.setBackgroundResource(R.drawable.round_back_white);
                stringed.setBackgroundResource(R.drawable.round_back_white);
                percussion.setBackgroundResource(R.drawable.round_back_white);
            }
        });

        keyed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName ="keyed";

                keyed.setBackgroundResource(R.drawable.round_back_white_stroke);

                wind.setBackgroundResource(R.drawable.round_back_white);
                stringed.setBackgroundResource(R.drawable.round_back_white);
                percussion.setBackgroundResource(R.drawable.round_back_white);


            }
        });

        stringed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName ="stringed";

                stringed.setBackgroundResource(R.drawable.round_back_white_stroke);

                keyed.setBackgroundResource(R.drawable.round_back_white);
                wind.setBackgroundResource(R.drawable.round_back_white);
                percussion.setBackgroundResource(R.drawable.round_back_white);


            }
        });

        percussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName ="percussion";

                percussion.setBackgroundResource(R.drawable.round_back_white_stroke);

                keyed.setBackgroundResource(R.drawable.round_back_white);
                wind.setBackgroundResource(R.drawable.round_back_white);
                wind.setBackgroundResource(R.drawable.round_back_white);


            }
        });

        //Toast Bilgilendirme mesajı
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTopicName.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Select the Topic",Toast.LENGTH_SHORT).show();
                }

                else{
                    Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                    intent.putExtra("selectedTopic",selectedTopicName);
                    startActivity(intent);
                }
            }
        });

    }
//eşleştirme
    private void init(){
        wind = findViewById(R.id.windLayout);
        keyed = findViewById(R.id.keyedLayout);
        stringed = findViewById(R.id.stringedLayout);
        percussion = findViewById(R.id.percussionLayout);
        startBtn = findViewById(R.id.StartQuizBtn);
    }
}