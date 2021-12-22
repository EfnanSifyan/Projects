package efnansifyan.mis.a201735042efnansifyan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
 private ImageView playButton;
 private ImageView backBtn;
 private TextView questionCount;
 private TextView selectedQuizName;
 private TextView question;
 private AppCompatButton option1,option2,option3,option4;
 private AppCompatButton nextBtn;
 private  List<QuestionsList> questionsLists;
 private int currentQuestionPosition = 0;
 private String selectedOptionByUser ="";
 private MediaPlayer mediaPlayer;
 private int soundId;
 private String actualSound;
 private List<String>soundsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Intent yakalanarak seçilen quiz adı alındı.
        final String getSelectedQuizName = getIntent().getStringExtra("selectedTopic");

        init(getSelectedQuizName);

        selectedQuizName.setText(getSelectedQuizName);

        //Seçilen quize göre müzik ve soru listesi getirildi.

        questionsLists = QuestionsBank.getQuestions(getSelectedQuizName);
        soundsList = MusicBank.getSounds(getSelectedQuizName);

        //Manuel olarak ilk soru ve cevapların yazdırıldığı fonksiyon çağırıldı.
        getQuestionsAndOptions();


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Kullanıcının seçtiği şık değişkene atandı.
                selectedOptionByUser = option1.getText().toString();

                // Seçim yapılmamışsa mesaj yazdırıldı.
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    // Seçilen şık öncelikle kırmızıya boyandı.
                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);

                    // Daha sonra doğru şıkkı yeşile boyayan metot çağırıldı.
                    revealAnswer();

                    // Sonrasında hesaplama yapılabilmesi için listeye kullanıcının seçtiği şık atanıyor.
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOptionByUser = option2.getText().toString();
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {

                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOptionByUser = option3.getText().toString();
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOptionByUser = option4.getText().toString();
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();

                } else {
                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Şık işaretlenmeden sonraki soruya geçilmesi engelleniyor.
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {

                    //Çalan müzik durduruluyor.
                    mediaPlayer.stop();

                    //sonraki soru çağrılıyor.
                    changeNextQuestion();
                }
            }
        });

        //Kullanıcı Quizden çıkarılarak ana menüye gönderiliyor.
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();

            }
        });

        //Müzik başlatılıyor.
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

    }

    private void init(String selectedQuestionName){
        backBtn = findViewById(R.id.backBtn);
        selectedQuizName = findViewById(R.id.QuizName);
        playButton = findViewById(R.id.playButton);
        question = findViewById(R.id.question);
        questionCount = findViewById(R.id.questionCount);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);


        //Seçilen quize göre ilk müziğin adı belirleniyor.
        switch (selectedQuestionName) {
            case "wind":
                actualSound = "saxaphone";
                break;
            case "keyed":
                actualSound = "churchorg";
                break;
            case "stringed":
                actualSound = "cello";
                break;
            default:
                actualSound = "darbuka";
        }

        //Seçilen müziğe ait dosyanın id değeri atanarak mediaPlayer nesnesiyle eşleştiriliyor.
        Resources res = getResources();

        soundId = res.getIdentifier(actualSound, "raw", getPackageName());

        //R.raw."fileName" -> fileId
        mediaPlayer = MediaPlayer.create(getApplicationContext(), soundId);
    }

    //İlk soru ve cevaplar
    private void getQuestionsAndOptions(){
        questionCount.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

    }

    private void changeNextQuestion(){
        // Şuanki soru sayısı için değer bir arttırdı
        currentQuestionPosition++;

        // Eğer şuanki soru listedeki son soru ise tamamlama butonu aktifleştirildi.
        if ((currentQuestionPosition+1)== questionsLists.size()){
            nextBtn.setText("Submit Quiz");
        }

        // Eğer son soru değil ise ..
        if(currentQuestionPosition < questionsLists.size()){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option2.setTextColor(Color.parseColor("#1F6BBB"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option3.setTextColor(Color.parseColor("#1F6BBB"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option4.setTextColor(Color.parseColor("#1F6BBB"));

            // Soru sayısı yazdırıldı
            questionCount.setText((currentQuestionPosition+1)+"/"+questionsLists.size());

            // Şuanki soru değerine göre listeden soru ve şıklar getirildi
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());

            // Şuanki soru değerine göre soruya ait müziğin adı getiriliyor.
            String name = soundsList.get(currentQuestionPosition);

            // Müzik dosyasının Id değeri bulunarak mediaPlayer nesnesine atanıyor
            Resources res=getResources();
            int id = res.getIdentifier(name, "raw", getPackageName());
            mediaPlayer = MediaPlayer.create(getApplicationContext(),id);
        }
        // Quiz tamamlandıysa Yeni intent oluşturularak QuizResult Activity'sine yönlendiriliyor.
        else {
            Intent intent = new Intent(QuizActivity.this,QuizResults.class);

            // Doğru ve yanlış sayısı gönderiliyor.
            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("incorrect",getInCorrectAnswers());
            startActivity(intent);

            finish();
        }
    }

    private int getCorrectAnswers(){

        int correctAnswers =0;
        String getUserSelectedAnswer ="";
        String getAnswer ="";

        // for döngüsüyle soruya ait kullanıcının seçimleri ve doğru cevaplar alındı.
        for(int i=0;i<questionsLists.size();i++){
              getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
              getAnswer = questionsLists.get(i).getAnswer();

              //Kullanıcının seçimi cevapla aynıysa doğru cevap sayısı bir arttırıldı.
            if (getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;

    }

    private int getInCorrectAnswers(){

        int IncorrectAnswers =0;
       String getUserSelectedAnswer="";
       String getAnswer ="";

        for(int i=0;i<questionsLists.size();i++){
             getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
             getAnswer = questionsLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)){
                IncorrectAnswers++;
            }
        }

        return IncorrectAnswers;

    }

    //Quizden çıkarak Ana menuye yönlendiriliyor.
    @Override
    public void onBackPressed() {

        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();
    }

    private void revealAnswer(){

        // İlgili şık seçildiğinde o soruya ait doğru cevap değişkene atandı
       String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

       //Şıkkın metni cevap ile eş ise şık yeşile boyandı.
        if (option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }

        else if (option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }

    }
}