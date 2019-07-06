package pakiet.konrad.biblia52.Aktywnosci;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pakiet.konrad.biblia52.Adapter.AdapterRecyclerSzukanychSlow;
import pakiet.konrad.biblia52.BazaDanych.Slownik_fts3;
import pakiet.konrad.biblia52.ModelDanych.Model_danych_szukaj_slowa;
import pakiet.konrad.biblia52.R;


public class AktywnoscSzukanieSlow extends Activity implements Handler.Callback {

    AdapterRecyclerSzukanychSlow adapter_recyclera_szukaj;
    List<Model_danych_szukaj_slowa> lista_szukanych_ksiag_z_szukanym_slowem;
    Model_danych_szukaj_slowa model_danych_szukaj_slowa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_szukanie_slow);





        Button button_szukaj = findViewById(R.id.btn_szukaj);

        final EditText editText_szukaj = findViewById(R.id.editTextszukaj);


        HandlerThread thread = new HandlerThread("watekSzukaj", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        final Handler handler = new Handler(thread.getLooper(), this);







        button_szukaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int what = 0;
                String slowo = editText_szukaj.getText().toString();
                Message msg = handler.obtainMessage(what, slowo);
                handler.sendMessage(msg);


            }
        });







    }
    public void Recycler(List<Model_danych_szukaj_slowa> lista)
    {
        RecyclerView recyclerView = findViewById(R.id.id_recycler_lista_znalezionych_wyrazow);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter_recyclera_szukaj = new AdapterRecyclerSzukanychSlow(lista);
        recyclerView.setAdapter(adapter_recyclera_szukaj);
    }



    @Override
    public boolean handleMessage(Message msg) {

        String slowo = (String) msg.obj;


        Slownik_fts3 bazyDanychSlownik = new Slownik_fts3(this);

        Cursor k     = bazyDanychSlownik.PokaszWyszukaneSlowa(slowo.trim());


        String patternString1 = zamienSlowaNaRegex(slowo.trim());

        Pattern pattern = Pattern.compile(patternString1);

        lista_szukanych_ksiag_z_szukanym_slowem = new ArrayList<>();


        bazyDanychSlownik.open();

        k.moveToFirst();
        while (!k.isAfterLast())
        {

            String numer_ksiegi="";
            String numer_rozdzialu = k.getString(1);
            String numer_wersu = k.getString(2);
            String tresc_wersu = k.getString(3);


            switch (k.getString(0)) {
                case "1": {
                    numer_ksiegi = "I Mojżeszowa(Księga Rodzaju)";
                }
                break;
                case "2": {
                    numer_ksiegi = "II Mojżeszowa(Księga Wyjścia)";
                }
                break;
                case "3": {
                    numer_ksiegi = "III Mojżeszowa(Księga Kapłańska)";
                }
                break;
                case "4": {
                    numer_ksiegi = "IV Mojżeszowa(Księga Liczb)";
                }
                break;
                case "5": {
                    numer_ksiegi = "V Mojżeszowa (Księga Powtórzonego Prawa)";
                }
                break;
                case "6": {
                    numer_ksiegi = "Księga Jozuego";
                }
                break;
                case "7": {
                    numer_ksiegi = "Księga Sędziów";
                }
                break;
                case "8": {
                    numer_ksiegi = "Księga Rut";
                }
                break;
                case "9": {
                    numer_ksiegi = "I Księga Samuela";
                }
                break;
                case "10": {
                    numer_ksiegi = "II Księga Samuela";
                }
                break;
                case "11": {
                    numer_ksiegi = "I Księga Królewska";
                }
                break;
                case "12": {
                    numer_ksiegi = "II Księga Królewska";
                }
                break;
                case "13": {
                    numer_ksiegi = "I Księga Kronik";
                }
                break;
                case "14": {
                    numer_ksiegi = "II Księga Kronik";
                }
                break;
                case "15": {
                    numer_ksiegi = "Księga Ezdrasza";
                }
                break;
                case "16": {
                    numer_ksiegi = "Księga Nehemiasza";
                }
                break;
                case "17": {
                    numer_ksiegi = "Księga Estery";
                }
                break;
                case "18": {
                    numer_ksiegi = "Księga Hioba";
                }
                break;
                case "19": {
                    numer_ksiegi = "Księga Psalmów";
                }
                break;
                case "20": {
                    numer_ksiegi = "Księga Przysłów";
                }
                break;
                case "21": {
                    numer_ksiegi = "Księga Kaznodziei";
                }
                break;
                case "22": {
                    numer_ksiegi = "Pieśń nad Pieśniami";
                }
                break;
                case "23": {
                    numer_ksiegi = "Księga Izajasza";
                }
                break;
                case "24": {
                    numer_ksiegi = "Księga Jeremiasza";
                }
                break;
                case "25": {
                    numer_ksiegi = "Lamentacje";
                }
                break;
                case "26": {
                    numer_ksiegi = "Księga Ezechiela";
                }
                break;
                case "27": {
                    numer_ksiegi = "Księga Daniela";
                }
                break;
                case "28": {
                    numer_ksiegi = "Księga Ozeasza";
                }
                break;
                case "29": {
                    numer_ksiegi = "Księga Joela";
                }
                break;
                case "30": {
                    numer_ksiegi = "Księga Amosa";
                }
                break;
                case "31": {
                    numer_ksiegi = "Księga Abdiasza";
                }
                break;
                case "32": {
                    numer_ksiegi = "Księga Jonasza";
                }
                break;
                case "33": {
                    numer_ksiegi = "Księga Micheasza";
                }
                break;
                case "34": {
                    numer_ksiegi = "Księga Nahuma";
                }
                break;
                case "35": {
                    numer_ksiegi = "Księga Habakuka";
                }
                break;
                case "36": {
                    numer_ksiegi = "Księga Sofoniasza";
                }
                break;
                case "37": {
                    numer_ksiegi = "Księga Aggeusza";
                }
                break;
                case "38": {
                    numer_ksiegi = "Księga Zachariasza";
                }
                break;
                case "39": {
                    numer_ksiegi = "Księga Malachiasza";
                }
                break;
                case "40": {
                    numer_ksiegi = "Ewangelia Mateusza";
                }
                break;
                case "41": {
                    numer_ksiegi = "Ewangelia Marka";
                }
                break;
                case "42": {
                    numer_ksiegi = "Ewangelia Łukasza";
                }
                break;
                case "43": {
                    numer_ksiegi = "Ewangelia Jana";
                }
                break;
                case "44": {
                    numer_ksiegi = "Dzieje Apostolskie";
                }
                break;
                case "45": {
                    numer_ksiegi = "List do Rzymian";
                }
                break;
                case "46": {
                    numer_ksiegi = "I List do Koryntian";
                }
                break;
                case "47": {
                    numer_ksiegi = "II List do Koryntian";
                }
                break;
                case "48": {
                    numer_ksiegi = "List do Galacjan";
                }
                break;
                case "49": {
                    numer_ksiegi = "List do Efezjan";
                }
                break;
                case "50": {
                    numer_ksiegi = "List do Filipian";
                }
                break;
                case "51": {
                    numer_ksiegi = "List do Kolosan";
                }
                break;
                case "52": {
                    numer_ksiegi = "I List do Tesaloniczan";
                }
                break;
                case "53": {
                    numer_ksiegi = "II List do Tesaloniczan";
                }
                break;
                case "54": {
                    numer_ksiegi = "I List do Tymoteusza";
                }
                break;
                case "55": {
                    numer_ksiegi = "II List do Tymoteusza";
                }
                break;
                case "56": {
                    numer_ksiegi = "List do Tytusa";
                }
                break;
                case "57": {
                    numer_ksiegi = "List do Filemona";
                }
                break;
                case "58": {
                    numer_ksiegi = "List do Hebrajczyków";
                }
                break;
                case "59": {
                    numer_ksiegi = "List Jakuba";
                }
                break;
                case "60": {
                    numer_ksiegi = "I List Piotra";
                }
                break;
                case "61": {
                    numer_ksiegi = "II List Piotra";
                }
                break;
                case "62": {
                    numer_ksiegi = "1 List Jana";
                }
                break;
                case "63": {
                    numer_ksiegi = "2 List Jana";
                }
                break;
                case "64": {
                    numer_ksiegi = "3 List Jana";
                }
                break;
                case "65": {
                    numer_ksiegi = "List Judy";
                }
                break;
                case "66": {
                    numer_ksiegi = "Księga Objawienia";
                }
                break;


            }
            Matcher matcher = pattern.matcher(tresc_wersu);
            model_danych_szukaj_slowa = new Model_danych_szukaj_slowa(numer_ksiegi+" "+numer_rozdzialu,numer_wersu+": "+zamien_na_czerwono_wyszukane_slowa(tresc_wersu,matcher));

            lista_szukanych_ksiag_z_szukanym_slowem.add(model_danych_szukaj_slowa);
            runOnUiThread(new SetRecycler());
            k.moveToNext();
            runOnUiThread(new SetListaKsiag());
        }

        k.close();
        bazyDanychSlownik.close();



        return false;
    }





    private String zamien_na_czerwono_wyszukane_slowa(String ciag_znakow,Matcher matcher)
    {
        String [] a=ciag_znakow.split(" ");
        List<String> list = Arrays.asList(a);

        while(matcher.find()) {

            System.out.println("szukam wyrazu=" +matcher.group());
            for (int x=0;x<list.size();x++)
            {

                {
                    if (list.get(x).equals(matcher.group().trim()))
                    {
                        list.set(x,list.get(x).replace(matcher.group().trim(),"<font color='red'>"+matcher.group()+"</font>"));
                        System.out.println("wyraz o indexie-" +x+" zamienione" );
                    }
                    else
                    {
                        System.out.println("wyraz o indexie-" +x+" Nie zmieniony" );
                    }
                }


            }
        }
        StringBuilder listString = new StringBuilder();

        for (String s : list)
        {
            listString.append(s).append(" ");

        }



        return listString.toString();
    }


    private String zamienSlowaNaRegex(String slowo)
    {
        StringBuilder regex = new StringBuilder();


        int liczba_liter = slowo.length();
        for (int x=0; x<liczba_liter;x++)
        {
            regex.append("[").append(String.valueOf(slowo.charAt(x)).toUpperCase()).append(String.valueOf(slowo.charAt(x)).toLowerCase()).append("]");
        }

        return regex+"\\W|"+"<i>"+regex+"<.i>";


    }

    private class SetListaKsiag implements Runnable
    {
        @Override
        public void run()
        {
            adapter_recyclera_szukaj.notifyDataSetChanged();
        }
    }

    private class SetRecycler implements Runnable
    {
        @Override
        public void run()
        {
            Recycler(lista_szukanych_ksiag_z_szukanym_slowem);
        }
    }
}
