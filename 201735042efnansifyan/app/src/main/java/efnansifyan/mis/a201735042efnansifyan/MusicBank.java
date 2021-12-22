package efnansifyan.mis.a201735042efnansifyan;

import java.util.ArrayList;
import java.util.List;

public class MusicBank {
//Müzik listeleri tanımlama
    private static List<String> WindSounds() {
        List<String> soundsNames = new ArrayList<>();

        soundsNames.add("saxaphone");
        soundsNames.add("hermonica");
        soundsNames.add("duduk");
        soundsNames.add("flut");
        soundsNames.add("clairnet");

        return soundsNames;

    }

    private static List<String> KeyedSounds() {
        List<String> soundsNames = new ArrayList<>();

        soundsNames.add("churchorg");
        soundsNames.add("melodica");
        soundsNames.add("piano");
        soundsNames.add("acordion");
        soundsNames.add("klavsen");

        return soundsNames;

    }

    private static List<String> StringedSounds() {
        List<String> soundsNames = new ArrayList<>();

        soundsNames.add("cello");
        soundsNames.add("guitar");
        soundsNames.add("bouzouki");
        soundsNames.add("violin");
        soundsNames.add("ud");

        return soundsNames;
    }

    private static List<String> PercussionSounds() {
        List<String> soundsNames = new ArrayList<>();

        soundsNames.add("darbuka");
        soundsNames.add("tef");
        soundsNames.add("marimba");
        soundsNames.add("trump");
        soundsNames.add("davul");

        return soundsNames;
    }
    //seçilen quize göre müzik listesini yönlendirme.

    public static List<String> getSounds(String selectedTopicName) {
        switch (selectedTopicName) {
            case "wind":
                return WindSounds();
            case "keyed":
                return KeyedSounds();
            case "stringed":
                return StringedSounds();
            default:
                return PercussionSounds();
        }
    }
}