package efnansifyan.mis.a201735042efnansifyan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    private AppCompatButton startNewBtn;
    private TextView correctAnswer;
    private TextView incorrectAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        //Önceki intent yakalanarak doğru ve yanlış değerleri alındı.
        final int getCorrectAnswers = getIntent().getIntExtra("correct",0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect",0);


        startNewBtn = findViewById(R.id.startNewQuizBtn);
        correctAnswer = findViewById(R.id.correctAnswers);
        incorrectAnswers = findViewById(R.id.incorrectAnswers);

        //TextViewlara yakalanan değerler yazdırıldı.
        correctAnswer.setText(String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText(String.valueOf(getIncorrectAnswers));

        //Kullanıcı ana menuye yönlendirildi.
        startNewBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResults.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this,MainActivity.class));
        finish();
    }
}