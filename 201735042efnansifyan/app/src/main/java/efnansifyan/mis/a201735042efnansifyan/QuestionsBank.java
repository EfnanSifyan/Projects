package efnansifyan.mis.a201735042efnansifyan;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
//Quiz konuları için QuestionList türünde liste oluşturuyoruz.

    private static List<QuestionsList> windQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Saxophone","Flute","Harmonica","Duduk","Saxophone","");
        final QuestionsList question2 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Saxophone","Flute","Harmonica","Duduk","Harmonica","");
        final QuestionsList question3 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Saxophone","Flute","Harmonica","Duduk","Duduk","");
        final QuestionsList question4 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Saxophone","Flute","Harmonica","Duduk","Flute","");
        final QuestionsList question5 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Clarinet","Flute","Harmonica","Duduk","Clarinet","");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);

        return questionsLists;

    }

    private static List<QuestionsList> KeyedQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Piano","Acordion","Melodica","Church Org","Church Org","");
        final QuestionsList question2 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Piano","Acordion","Melodica","Church Org","Melodica","");
        final QuestionsList question3 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Piano","Acordion","Melodica","Church Org","Piano","");
        final QuestionsList question4 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Piano","Acordion","Melodica","Church Org","Acordion","");
        final QuestionsList question5 = new QuestionsList("Which musical instrument does the sound you hear belong to?","Piano","Acordion","Melodica","Klavsen","Klavsen","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);

        return questionsLists;
    }

    private static List<QuestionsList> StringedQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Cello", "Acoustic-Guitar", "Bouzouki", "Ud", "Cello", "");
        final QuestionsList question2 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Violin", "Acoustic-Guitar", "Bouzouki", "Ud", "Acoustic-Guitar", "");
        final QuestionsList question3 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Violin", "Acoustic-Guitar", "Bouzouki", "Ud", "Bouzouki", "");
        final QuestionsList question4 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Violin", "Acoustic-Guitar", "Bouzouki", "Ud", "Violin", "");
        final QuestionsList question5 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Violin", "Acoustic-Guitar", "Bouzouki", "Ud", "Ud", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);

        return questionsLists;
    }

    private static List<QuestionsList> PercussionQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Darbuka", "Tef", "Drum", "Marimba", "Darbuka", "");
        final QuestionsList question2 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Darbuka", "Tef", "Drum", "Marimba", "Tef", "");
        final QuestionsList question3 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Darbuka", "Tef", "Drum", "Marimba", "Marimba", "");
        final QuestionsList question4 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Darbuka", "Tef", "Drum", "Marimba", "Drum", "");
        final QuestionsList question5 = new QuestionsList("Which musical instrument does the sound you hear belong to?", "Darbuka", "Davul", "Drum", "Marimba", "Davul", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);

        return questionsLists;

    }

    //Yönlendirme
    public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "wind":
                return windQuestions();
            case "keyed":
                return KeyedQuestions();
            case "stringed":
                return StringedQuestions();
            default:
                return PercussionQuestions();
        }
    }

    }
