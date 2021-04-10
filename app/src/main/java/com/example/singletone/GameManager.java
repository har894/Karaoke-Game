package com.example.singletone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameManager {
    private Team team1;
    private Team team2;
    private int gameScore;
    private int roundDuration;
    private static ArrayList<String> singerDB;
    private ArrayList<Integer> temp = new ArrayList<>();
    private boolean turn;

    public GameManager(String team1Name, String team2Name, int gameScore, int roundDuration, boolean rusChecked, boolean engChecked){
        team1 = new Team(team1Name);
        team2 = new Team(team2Name);
        this.gameScore = gameScore;
        this.roundDuration = roundDuration;
        createDB(rusChecked,engChecked);
    }

    private void createDB(boolean rusChecked, boolean engChecked) {
        singerDB = new ArrayList<>();
        String arm[] = new String[]{"Արամե", "Արամ Mp3", "Արամ Ասատրյան", "Արման Հովհաննիսյան", "Արմո", "Արմենչիկ", "Արտո Թունջբոյաջյան", "Արտաշ Ասատրյան", "Ազատ Հակոբյան", "Արսեն Սաֆարյան", "Աստղիկ Սաֆարյան", "Արա Մարտիրոսյան", "Անի Քրիստի", "Անահիտ Սիմոնյան", "Արևիկ", "Աղասի Իսպիրյան", "Արաբո Իսպիրյան", "Արձագանք", "Արթուր Մեսչյան", "Անդի", "Արսեն Գրիգորյան", "Անդրե", "Ինգա և Անուշ Արշակյաններ", "Ալլա Լևոնյան", "Արաքսյա Վարդերեսյան", "Աիդա Սարգսյան", "Գևորգ Մարտիրոսյան", "Գոռ Սուջյան", "«Գոհար» համույթ", "Գուրգեն Դաբաղյան", "Գոհար Հովհաննիսյան", "Գայանե Սերոբյան", "Գաթա Բենդ", "Դալիթա", "Դավիթ Սասունցի", "Եվա Ռիվաս", "Զարուհի Բաբայան", "Էմմի", "Էրիկ Կարապետյան", "Էլլա Տարունց", "Empyray", "Թաթուլ Ավոյան", "Թաթա Սիմոնյան", "Իվետա Մուկուչյան", "Լիլիթ Հովհաննիսյան", "Լայանա", "Լեյլա Սարիբեկյան", "Լիլիթ Կարապետյան", "Լիանա", "Լիլու", "Լուսինե Զաքարյան", "Լուսինե Պողոսյան", "Լիդուշիկ", "Կոմիտաս", "Կաթիլ", "ՀԱՅՔ", "ՀՏ Հայկո", "Հայկ Ղևոնդյան", "Հայկո", "Հռիփսիմե Հակոբյան", "Հարութ Բալյան", "Հարություն Փամբուկչյան", "Հասմիկ Կարապետյան", "Հայրիկ Մուրադյան", "Հովհաննես Բադալյան", "Միհրան Ծառուկյան", "Մարտին Մկրտչյան", "Միշո", "Մհեր Armenia", "Մարիաննա Հովհաննիսյան", "Մանուել Մենենգիչյան", "Մարտին Յորգանց", "Նարեկ Բավեյան", "Նանա", "Ներսիկ Իսպիրյան", "Նունե Եսայան", "Նարե Գևորգյան", "Nemra ", "Շպռոտ", "Շուշան Պետրոսյան", "Շառլ Ազնավուր", "Պապին Պողոսյան", "Ռազմիկ Ամյան", "Ռուբեն Հախվերդյան", "Ռուբեն Մաթևոսյան", "Ռուզաննա Անդրեասյան", "Ռեինկարնացիա", "Ռոբերտ Ամիրխանյան", "Ռուբեն Սասունցի", "Սիրուշո", "Սյուզան Մարգարյան", "Սյուզի Մելիքյան", "Սիլվա Հակոբյան", "Սոնա Շահգելդյան", "Սուպեր Սաքո", "Սարո", "Սարգիս Ավետիսյան", "Սոֆի Մխեյան", "Սոնա Ռուբինյան", "Սոնա (Մեր բակ)", "Սոնյա", "Սևակ Ամրոյան", "Սևակ Խանաղյան", "Սրբուհի Սարգսյան", "Վաչե Ամարյան", "Վարդան Բադալյան", "Վլադիմիր Արզումանյան", "Վահագ Ռաշ", "Տաթևիկ Հովհաննիսյան", "Տիգրան Ժամկոչյան", "Տիգրան Ասատրյան", "Քրիստինե Պեպելյան", "Օֆելյա Համբարձումյան", "Ֆորշ", "Ֆլորա Մարտիրոսյան", "Ռիչարդ Մադլենյան", "Արազ Դարե", "Արմեն Ալոյան", "Մեր Հովո", "Վարդան Ուրումյան", "Ժորա Դիլբարյան", "Աշոտ Սարուխանյան", "Օլգա Այվազյան", "Երևանսկի", "Փոլ Բաղդադլյան", "Վարդան Սարգսյան", "Արա Բաբաջանյան", "Շավո", "Մի քանի հոգի", "Արամ Ավագյան",};
        String rus[] = new String[]{"Ирина ДубцоваТаня Буланова", "Сергей Лазарев", "Адлер Коцба", "HammAli & Navai", "Виа Гра", "Любэ", "Дима Билан", "Дискотека Авария", "Руслана", "Zivert", "Елка", "Тина Кароль", "Полина Гагарина", "Непара", "Guf", "GAYAZOV$ BROTHER$", "Жасмин", "Dato", "Время и Стекло", "Михаил Шуфутинский", "Мот", "Максим Фадеев", "Глюкоза", "LOBODA", "Катя Лель", "Тима Белорусских", "Валерия", "A'Studio", "Егор Крид", "Алла Пугачева", "Авраам Руссо", "Лолита", "Земфира", "Бьянка", "Dan Balan", "Бумбокс", "Жанна Фриске", "Ленинград", "Баста", "Вера Брежнева", "Сосо Павлиашвили", "Филипп Киркоров", "Рефлекс", "Кристина Орбакайте", "Бутырка", "Владимир Висоцкий", "Валерий Леонтьев", "Анна Семенович", "SEREBRO", "Эльдар Далгатов", "Ани Лорак", "Элджей", "Наташа Королева", "Ёлка", "Корни", "Леонид Агутин", "Валерий Меладзе", "Алсу", "Генералы песчаных карьеров", "Би-2", "Олег Газманов", "НАСТЯ КАМЕНСКИХ", "Mr. Credo", "Лариса Долина", "Тату", "Ирина Аллегрова", "Земляне", "Леша Свик", "Александр Рыбак"};
        String eng[] = new String[]{"Jessie J", "The Weeknd", "Jennifer Lopez", "Daddy Yankee", "Taylor Swift", "Michel Teló", "David Guetta", "James Arthur", "will.i.am", "Twenty One Pilots", "Bon Jovi", "Willy William", "Miley Cyrus", "XXXTENTACION", "Enrique Iglesias", "Mike Posner", "Kygo", "ZAYN", "Arctic Monkeys", "Pitbull", "Lil Pump", "P!nk", "Whitney Houston", "John Newman", "Tove Lo", "Nirvana", "System Of A Down", "Bebe Rexha", "Gotye", "DJ Khaled", "Ed Sheeran", "Dua Lipa", "The Cranberries", "Skrillex", "Scorpions", "Ariana Grande", "Drake", "Luis Fonsi", "Europe", "Avicii", "Post Malone", "PSY", "PULCINO PIO", "Adele", "AronChupa", "Beyoncé", "Maroon 5", "J. Balvin", "Shakira", "Charlie Puth", "Lukas Graham", "The Police", "Jason Derulo", "MAGIC!", "LMFAO", "Justin Timberlake", "Fun", "OMI", "Sam Smith", "Sia", "Nicki Minaj", "Rag'n'Bone Man", "MACKLEMORE", "Naughty Boy", "Crazy Frog", "Pharrell Williams", "Coldplay", "Carly Rae Jepsen", "Martin Garrix", "Lorde", "Wiz Khalifa", "Katy Perry", "Queen", "Fifth Harmony", "John Legend", "50 Cent", "Calvin Harris", "Eminem", "Ricky Martin", "One Direction", "The Chainsmokers", "Marc Anthony", "Michael Jackson", "Major Lazer", "Mark Ronson", "Iggy Azalea", "No Doubt", "Chris Brown", "Ellie Goulding", "Lady Gaga", "Clean Bandit", "Justin Bieber", "OneRepublic", "Marshmello", "Imagine Dragons", "Ylvis", "Alan Walker", "Passenger", "Christina Perri", "Adam Levine", "Guns N' Roses"};

        if(rusChecked){
            singerDB.addAll(Arrays.asList(rus));
        }
        if(engChecked){
            singerDB.addAll(Arrays.asList(eng));
        }
        singerDB.addAll(Arrays.asList(arm));
    }

    public Team getCurrentPlayer() {
        if(turn){
            return team2;
        }
        return team1;
    }

    public void changeTurn(){
        if(turn){
            turn = false;
        } else {
            turn = true;
        }
    }

    public String getRandomSinger() {
        Random random = new Random();
        int id = random.nextInt(singerDB.size());
        if(temp.size()==singerDB.size()){
            return "Բառերն ավարտվեցին";
        }
        while (temp.contains(id)){
            id = random.nextInt(singerDB.size());
        }
        temp.add(id);

        return singerDB.get(id);
    }

    public String getScore(){
        return team1.getName()+ " : " +team1.getScore() + "\n\n" + team2.getName()+ " : " +team2.getScore();
    }

    public int getRoundDuration() {
        return roundDuration;
    }

    void plusScore(){
        getCurrentPlayer().plusScore();
    }

    public int isWinner(){
        if(team1.getScore() > gameScore && team1.getScore() > team2.getScore()) {

            return 1;
        }
        if(team2.getScore() > gameScore && team2.getScore() > team1.getScore()) {

            return 2;
        }

        return 0;
    }

}
