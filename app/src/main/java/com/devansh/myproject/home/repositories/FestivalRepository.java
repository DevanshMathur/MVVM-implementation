package com.devansh.myproject.home.repositories;

import androidx.lifecycle.MutableLiveData;

import com.devansh.myproject.home.model.Festival;

import java.util.ArrayList;

public class FestivalRepository {
    private static FestivalRepository instance;
    MutableLiveData<ArrayList<Festival>> data;
    private ArrayList<Festival> data1 = new ArrayList<>();
    int last = 0;

    public static FestivalRepository getInstance() {
        if (instance == null) {
            instance = new FestivalRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Festival>> getFestivals() {
        setData(last, last + 2);
        last += 2;
        data = new MutableLiveData<>();
        data.setValue(this.data1);
        return data;
    }

    private void setData(int a, int b) {
        String[] name = {"Diwali", "Holi", "Onam", "Maha Shivaratri", "Krishna Janmashtami",
                "Makar Sankranti", "Ganesh Chaturthi", "Navratri – Dussehra – Durga Puja", "Rama Navami", "Ugadi"};
        String[] description = {
                "The festival of lights – Diwali or Deepavali – is the most popular festival on the Indian subcontinent. The underlying essence of Diwali revolves around light superseding darkness, or the triumph of goodness over evil. Glimmering diyas (lamps) adorn every nook and cranny of every residence in the evening, and there are also fireworks and a delicious traditional banquet.",
                "Holi is a festival of colour and a harbinger of spring in India. The onset of Holi is marked by the burning of an effigy of Holika – an evil entity from Hindu mythology – to signify the triumph of good over evil. The night of revelry around the bonfire goes on until the embers die. The following morning kicks off with people smearing coloured powder on each other, more carousal and occasionally the consumption of bhang, an intoxicating edible cannabis preparation.",
                "Onam is the official state festival of Kerala, and is celebrated with the utmost fervour and festivities that include traditional sports like boat races and tug of war. The legend behind the celebration of Onam concerns the homecoming of a demigod called Mahabali, and is similar to the legend of Holika and the Holi festival. In both cases, the triumph of hope over despair is celebrated, although Mahabali is regarded with the utmost respect and Holika is not. Onam is growing beyond religious frontiers and establishing itself as a religiously diverse festival in Kerala.",
                "Shiva is the foremost deity in the Hindu pantheon and regarded as the destroyer. Maha Shivaratri, or ‘the great night of Shiva’, commemorates the supremacy of Shiva. People refrain from sleeping and instead pray to the great lord. Most dedicated disciples of Lord Shiva celebrate Maha Shivaratri by fasting and chanting the hymns to Tandava, a dance performed by Lord Shiva.",
                "Lord Krishna has a prominent place in Hindu folklore. Krishna Janmashtami is the joyous festival celebrating the birth of Krishna, with a lot of merriment, dancing and singing. The gaiety of Krishna Janmashtami is often accompanied by competitions, notably breaking a pot filled with yoghurt that is suspended high in the air. Competitors form human pyramids in an attempt to break the pot and spill the contents, which is then formally offered as prasada (ritual offering).",
                "In the Hindu calendar, the sun enters the Makara (Capricorn) part of the zodiac on 14 January every year. Surya (the sun god) is also worshipped all across the country with unparalleled devotion on this day. Although this day is popularly known as Makar Sankranti, the nomenclature varies from state to state, as do the corresponding customs. Tamils call it Pongal, Assamese celebrate it as Bihu and most North Indians call it Lohri. Regardless of the monikers, Makar Sankranti is a festival made unique by its celebrations, ranging from kite-flying to bonfires and riverbank rituals.",
                "Ganesh Chaturthi’s status as one of the most popular festivals in the country is partly due to its eccentricity, something the festival shares with its corresponding deity, Lord Ganesh. Ganesh is the son of Lord Shiva, the destroyer. Yet Ganesh is at odds with his father in his convictions and appearance. His face resembles that of an elephant, while his witty and playful temperament inspires devotion from people of all age groups. Ganesh Chaturthi commemorates the birth of Ganesh with the formal offering of prayers to a clay idol of the deity. The idol is later immersed in a body of water amid further festivities.",
                "Akin to the recurring theme in Hindu mythology of the victory of good over evil, the legend behind the Navratri festival has to do with Lord Rama’s triumph over Ravana, a demonic entity. An alternative legend revolves around the victories of the goddess Durga against the diabolical forces that once walked the face of the Earth. Navratri, meaning nine nights, is a time to honour the deities and plead for their blessings and goodwill.",
                "The epic poem of the Ramayana has vast religious significance in Hinduism. Its protagonist, Lord Rama, with his divine prowess and benevolence, slays immoral beings, conquers the realm and establishes order. The day marking the birth of Lord Rama is celebrated as Rama Navami, and the observances include charity, recitals and prayers.",
                "Conforming to the Hindu calendar, Ugadi is New Year’s Day for Hindus. The festival of Ugadi is celebrated predominantly in the South Indian states of Karnataka, Andhra Pradesh, Tamil Nadu and Telangana. Premises are decorated with mango leaves, flowers and other embellishments; floral patterns are drawn on the floor, and savoury snacks are prepared in a bid to welcome the new year on a high note. Additionally, the consumption of bevu bella – a blend of neem (bevu) and jaggery (bella) – is obligatory. Neem is bitter in taste and jaggery is sweet; together, they signify the acceptance of life’s bitterness and happiness in equal parts.",
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
        for (int i = a; i < b; i++) {
            data1.add(new Festival(imgUri[i], name[i], place[i], description[i]));
        }

    }

    public void updateData() {
        if (last + 2 > 10) {
            data1.clear();
            last = 0;
        }
        setData(last, last + 2);
        last += 2;
        data.setValue(data1);

    }
}
