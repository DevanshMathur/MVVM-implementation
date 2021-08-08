package com.devansh.myproject.repositories;

import androidx.lifecycle.MutableLiveData;

import com.devansh.myproject.model.Festival;

import java.util.ArrayList;

public class FestivalRepository {
    private static FestivalRepository instance;
    private ArrayList<Festival> data = new ArrayList<>();

    public static FestivalRepository getInstance() {
        if (instance == null) {
            instance = new FestivalRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Festival>> getFestivals() {
        setData();
        MutableLiveData<ArrayList<Festival>> data = new MutableLiveData<>();
        data.setValue(this.data);
        return data;
    }

    private void setData() {
        String[] name = {"Diwali", "Holi", "Onam", "Maha Shivaratri", "Krishna Janmashtami",
                "Makar Sankranti", "Ganesh Chaturthi", "Navratri – Dussehra – Durga Puja", "Rama Navami", "Ugadi"};
        String[] description = {
                "The festival of lights – Diwali or Deepavali – is the most popular festival on the Indian subcontinent.",
                "Holi is a festival of colour and a harbinger of spring in India. The onset of Holi is marked by the burning of an effigy of Holika – an evil entity from Hindu mythology – to signify the triumph of good over evil.",
                "Onam is the official state festival of Kerala, and is celebrated with the utmost fervour and festivities that include traditional sports like boat races and tug of war.",
                "Shiva is the foremost deity in the Hindu pantheon and regarded as the destroyer.",
                "Lord Krishna has a prominent place in Hindu folklore. Krishna Janmashtami is the joyous festival celebrating the birth of Krishna, with a lot of merriment, dancing and singing.",
                "In the Hindu calendar, the sun enters the Makara (Capricorn) part of the zodiac on 14 January every year. Surya (the sun god) is also worshipped all across the country with unparalleled devotion on this day.",
                "Ganesh Chaturthi’s status as one of the most popular festivals in the country is partly due to its eccentricity, something the festival shares with its corresponding deity, Lord Ganesh. Ganesh is the son of Lord Shiva, the destroyer.",
                "Akin to the recurring theme in Hindu mythology of the victory of good over evil, the legend behind the Navratri festival has to do with Lord Rama’s triumph over Ravana, a demonic entity.",
                "The epic poem of the Ramayana has vast religious significance in Hinduism. Its protagonist, Lord Rama, with his divine prowess and benevolence, slays immoral beings, conquers the realm and establishes order.",
                "Conforming to the Hindu calendar, Ugadi is New Year’s Day for Hindus. The festival of Ugadi is celebrated predominantly in the South Indian states of Karnataka, Andhra Pradesh, Tamil Nadu and Telangana."
        };
        String[] imgUri = {
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/jya670.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/by6whj.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/ex4h8a.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/p4jfgw.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/shutterstock_editorial_9848265t.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/eg9r7w.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/e4ymke.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/shutterstock_editorial_9940197h.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/fxftdt.jpg",
                "https://img.theculturetrip.com/1440x/smart/wp-content/uploads/2019/07/eaey4g.jpg"
        };
        String[] place = {
                "India",
                "India",
                "India",
                "India",
                "India",
                "India",
                "India",
                "India",
                "India",
                "India",

        };
        for (int i = 0; i < 10; i++) {
            data.add(new Festival(imgUri[i], "Name : "+name[i],"Place : "+place[i], description[i]));
        }

    }
}
