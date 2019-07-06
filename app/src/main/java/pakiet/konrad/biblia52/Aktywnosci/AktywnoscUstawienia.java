package pakiet.konrad.biblia52.Aktywnosci;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pakiet.konrad.biblia52.R;


    public class AktywnoscUstawienia extends Activity
    {

        List<Integer> lista_rozmiar_czcionki;
        List<String> lista_kolor_czcionki,lista_nazwa_czcionki;


        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_aktywnosc_ustawienia);

            lista_rozmiar_czcionki = new ArrayList<>();
            lista_rozmiar_czcionki.add(10);
            lista_rozmiar_czcionki.add(12);
            lista_rozmiar_czcionki.add(14);
            lista_rozmiar_czcionki.add(16);
            lista_rozmiar_czcionki.add(18);
            lista_rozmiar_czcionki.add(20);
            lista_rozmiar_czcionki.add(22);
            lista_rozmiar_czcionki.add(24);
            lista_rozmiar_czcionki.add(26);

            lista_kolor_czcionki = new ArrayList<>();
            lista_kolor_czcionki.add("Biały");
            lista_kolor_czcionki.add("Szary");
            lista_kolor_czcionki.add("Czerwony");
            lista_kolor_czcionki.add("Żółty");
            lista_kolor_czcionki.add("Niebieski");
            lista_kolor_czcionki.add("Cyjan");
            lista_kolor_czcionki.add("Czarny");

            lista_nazwa_czcionki= new ArrayList<>();

            lista_nazwa_czcionki.add("Lato-Light");
            lista_nazwa_czcionki.add("Montserrat-Light.ttf");
            lista_nazwa_czcionki.add("Montserrat-Thin.ttf");
            lista_nazwa_czcionki.add("Mukta-Light.ttf");
            lista_nazwa_czcionki.add("Mukta-Medium.ttf");
            lista_nazwa_czcionki.add("Muli-Light.ttf");
            lista_nazwa_czcionki.add("OpenSans-Light.ttf");
            lista_nazwa_czcionki.add("OpenSansCondensed-Light.ttf");
            lista_nazwa_czcionki.add("Oswald-Light.ttf");
            lista_nazwa_czcionki.add("Oswald-Medium.ttf");
            lista_nazwa_czcionki.add("Poppins-Light.ttf");
            lista_nazwa_czcionki.add("Poppins-Medium.ttf");
            lista_nazwa_czcionki.add("Poppins-Thin.ttf");
            lista_nazwa_czcionki.add("Roboto-Light.ttf");
            lista_nazwa_czcionki.add("Roboto-Thin.ttf");
            lista_nazwa_czcionki.add("RobotoCondensed-Light.ttf");
            lista_nazwa_czcionki.add("Sarabun-Light.ttf");
            lista_nazwa_czcionki.add("Sarabun-Thin.ttf");
            lista_nazwa_czcionki.add("TitilliumWeb-Light.ttf");
            lista_nazwa_czcionki.add("TitilliumWeb-Regular.ttf");
            lista_nazwa_czcionki.add("Ubuntu-Light.ttf");
            lista_nazwa_czcionki.add("Ubuntu-Medium.ttf");
            lista_nazwa_czcionki.add("Quantico-Regular.ttf");
            lista_nazwa_czcionki.add("Oxygen-Light.ttf");
            lista_nazwa_czcionki.add("Oxygen-Regular.ttf");
            lista_nazwa_czcionki.add("Charm-Regular.ttf");
            lista_nazwa_czcionki.add("KiteOne-Regular.ttf");



            spinner_rozmiar_czcionki_werset();
            spinner_kolor_czcionki_werset();
            spinner_nazwa_czcionki_werset();
            spinner_kolor_czcionki_rozdzial();
            spinner_rozmiar_czcionki_komentarz();
            spinner_nazwa_czcionki_komentarz();
            spinner_kolor_czcionki_komentarz1();
            spinner_kolor_czcionki_komentarz2();

        }
        private void spinner_nazwa_czcionki_werset()
        {



            SharedPreferences sharedPref                    = getApplicationContext().getSharedPreferences("MyPref",0);
            final SharedPreferences.Editor editor                        = sharedPref.edit();
            String                   nazwa_czcionki                = sharedPref.getString("NazwaCzcionkiWerset","fonts/SansSerif/Quantico-Regular.ttf");
            Spinner spinner_nazwa_czcionki_werset = findViewById(R.id.id_werset_spiner_nazwa_czcionki);
            ArrayAdapter<String> dataAdapter                   = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_nazwa_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_nazwa_czcionki_werset.setAdapter(dataAdapter);


            switch (Objects.requireNonNull(nazwa_czcionki))
            {



                case "fonts/SansSerif/Lato-Light":           spinner_nazwa_czcionki_werset.setSelection(0);break;
                case "fonts/SansSerif/Montserrat-Light.ttf": spinner_nazwa_czcionki_werset.setSelection(1);break;
                case "fonts/SansSerif/Montserrat-Thin.ttf":   spinner_nazwa_czcionki_werset.setSelection(2);break;
                case "fonts/SansSerif/Mukta-Light.ttf":        spinner_nazwa_czcionki_werset.setSelection(3);break;
                case "fonts/SansSerif/Mukta-Medium.ttf":          spinner_nazwa_czcionki_werset.setSelection(4);break;
                case "fonts/SansSerif/Muli-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(5);break;
                case "fonts/SansSerif/OpenSans-Light.ttf":           spinner_nazwa_czcionki_werset.setSelection(6);break;
                case "fonts/SansSerif/OpenSansCondensed-Light.ttf":       spinner_nazwa_czcionki_werset.setSelection(7);break;
                case "fonts/SansSerif/Oswald-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(8);break;
                case "fonts/SansSerif/Oswald-Medium.ttf":         spinner_nazwa_czcionki_werset.setSelection(9);break;
                case "fonts/SansSerif/Poppins-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(10);break;
                case "fonts/SansSerif/Poppins-Medium.ttf":         spinner_nazwa_czcionki_werset.setSelection(11);break;
                case "fonts/SansSerif/Poppins-Thin.ttf":         spinner_nazwa_czcionki_werset.setSelection(12);break;
                case "fonts/SansSerif/Roboto-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(13);break;
                case "fonts/SansSerif/Roboto-Thin.ttf":         spinner_nazwa_czcionki_werset.setSelection(14);break;
                case "fonts/SansSerif/RobotoCondensed-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(15);break;
                case "fonts/SansSerif/Sarabun-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(16);break;
                case "fonts/SansSerif/Sarabun-Thin.ttf":         spinner_nazwa_czcionki_werset.setSelection(17);break;
                case "fonts/SansSerif/TitilliumWeb-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(18);break;
                case "fonts/SansSerif/TitilliumWeb-Regular.ttf":         spinner_nazwa_czcionki_werset.setSelection(19);break;
                case "fonts/SansSerif/Ubuntu-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(20);break;
                case "fonts/SansSerif/Ubuntu-Medium.ttf":         spinner_nazwa_czcionki_werset.setSelection(21);break;
                case "fonts/SansSerif/Quantico-Regular.ttf":         spinner_nazwa_czcionki_werset.setSelection(22);break;
                case "fonts/SansSerif/Oxygen-Light.ttf":         spinner_nazwa_czcionki_werset.setSelection(23);break;
                case "fonts/SansSerif/Oxygen-Regular.ttf":         spinner_nazwa_czcionki_werset.setSelection(24);break;
                case "fonts/Reczne/Charm-Regular.ttf":         spinner_nazwa_czcionki_werset.setSelection(25);break;
                case "fonts/Reczne/KiteOne-Regular.ttf":         spinner_nazwa_czcionki_werset.setSelection(26);break;



            }


            spinner_nazwa_czcionki_werset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    switch (position)
                    {
                        case 0:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Lato-Light.ttf");   break;
                        case 1:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Montserrat-Light.ttf");break;
                        case 2:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Montserrat-Thin.ttf"); break;
                        case 3:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Mukta-Light.ttf");      break;
                        case 4:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Mukta-Medium.ttf");        break;
                        case 5:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Muli-Light.ttf");       break;
                        case 6:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/OpenSans-Light.ttf");         break;
                        case 7:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/OpenSansCondensed-Light.ttf");         break;
                        case 8:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Oswald-Light.ttf");         break;
                        case 9:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Oswald-Medium.ttf");         break;
                        case 10:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Poppins-Light.ttf");         break;
                        case 11:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Poppins-Medium.ttf");         break;
                        case 12:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Poppins-Thin.ttf");         break;
                        case 13:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Roboto-Light.ttf");         break;
                        case 14:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Roboto-Thin.ttf");         break;
                        case 15:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/RobotoCondensed-Light.ttf");         break;
                        case 16:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Sarabun-Light.ttf");         break;
                        case 17:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Sarabun-Thin.ttf");         break;
                        case 18:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/TitilliumWeb-Light.ttf");         break;
                        case 19:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/TitilliumWeb-Regular.ttf");         break;
                        case 20:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Ubuntu-Light.ttf");         break;
                        case 21:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Ubuntu-Medium.ttf");         break;
                        case 22:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Quantico-Regular.ttf");         break;
                        case 23:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Oxygen-Light.ttf");         break;
                        case 24:editor.putString("NazwaCzcionkiWerset","fonts/SansSerif/Oxygen-Regular.ttf");         break;
                        case 25:editor.putString("NazwaCzcionkiWerset","fonts/Reczne/Charm-Regular.ttf");         break;
                        case 26:editor.putString("NazwaCzcionkiWerset","fonts/Reczne/KiteOne-Regular.ttf");         break;


                    }
                    editor.apply();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });


        }
        private void spinner_nazwa_czcionki_komentarz()
        {
            SharedPreferences        sharedPref                    = getApplicationContext().getSharedPreferences("MyPref",0);
            final SharedPreferences.Editor editor                        = sharedPref.edit();
            String                   nazwa_czcionki_komentarz                = sharedPref.getString("NazwaCzcionkiKomentarz","fonts/Reczne/KiteOne-Regular.ttf");
            Spinner                  spinner_nazwa_czcionki_komentarz = findViewById(R.id.id_komentarz_spiner_nazwa_czcionki);
            ArrayAdapter<String>     dataAdapter                   = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_nazwa_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_nazwa_czcionki_komentarz.setAdapter(dataAdapter);


            switch (Objects.requireNonNull(nazwa_czcionki_komentarz))
            {
                case "fonts/SansSerif/Lato-Light":           spinner_nazwa_czcionki_komentarz.setSelection(0);break;
                case "fonts/SansSerif/Montserrat-Light.ttf": spinner_nazwa_czcionki_komentarz.setSelection(1);break;
                case "fonts/SansSerif/Montserrat-Thin.ttf":   spinner_nazwa_czcionki_komentarz.setSelection(2);break;
                case "fonts/SansSerif/Mukta-Light.ttf":        spinner_nazwa_czcionki_komentarz.setSelection(3);break;
                case "fonts/SansSerif/Mukta-Medium.ttf":          spinner_nazwa_czcionki_komentarz.setSelection(4);break;
                case "fonts/SansSerif/Muli-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(5);break;
                case "fonts/SansSerif/OpenSans-Light.ttf":           spinner_nazwa_czcionki_komentarz.setSelection(6);break;
                case "fonts/SansSerif/OpenSansCondensed-Light.ttf":       spinner_nazwa_czcionki_komentarz.setSelection(7);break;
                case "fonts/SansSerif/Oswald-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(8);break;
                case "fonts/SansSerif/Oswald-Medium.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(9);break;
                case "fonts/SansSerif/Poppins-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(10);break;
                case "fonts/SansSerif/Poppins-Medium.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(11);break;
                case "fonts/SansSerif/Poppins-Thin.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(12);break;
                case "fonts/SansSerif/Roboto-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(13);break;
                case "fonts/SansSerif/Roboto-Thin.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(14);break;
                case "fonts/SansSerif/RobotoCondensed-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(15);break;
                case "fonts/SansSerif/Sarabun-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(16);break;
                case "fonts/SansSerif/Sarabun-Thin.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(17);break;
                case "fonts/SansSerif/TitilliumWeb-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(18);break;
                case "fonts/SansSerif/TitilliumWeb-Regular.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(19);break;
                case "fonts/SansSerif/Ubuntu-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(20);break;
                case "fonts/SansSerif/Ubuntu-Medium.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(21);break;
                case "fonts/SansSerif/Quantico-Regular.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(22);break;
                case "fonts/SansSerif/Oxygen-Light.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(23);break;
                case "fonts/SansSerif/Oxygen-Regular.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(24);break;
                case "fonts/Reczne/Charm-Regular.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(25);break;
                case "fonts/Reczne/KiteOne-Regular.ttf":         spinner_nazwa_czcionki_komentarz.setSelection(26);break;


            }

            spinner_nazwa_czcionki_komentarz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {
                    switch (position)
                    {

                        case 0:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Lato-Light.ttf");   break;
                        case 1:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Montserrat-Light.ttf");break;
                        case 2:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Montserrat-Thin.ttf"); break;
                        case 3:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Mukta-Light.ttf");      break;
                        case 4:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Mukta-Medium.ttf");        break;
                        case 5:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Muli-Light.ttf");       break;
                        case 6:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/OpenSans-Light.ttf");         break;
                        case 7:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/OpenSansCondensed-Light.ttf");         break;
                        case 8:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Oswald-Light.ttf");         break;
                        case 9:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Oswald-Medium.ttf");         break;
                        case 10:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Poppins-Light.ttf");         break;
                        case 11:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Poppins-Medium.ttf");         break;
                        case 12:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Poppins-Thin.ttf");         break;
                        case 13:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Roboto-Light.ttf");         break;
                        case 14:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Roboto-Thin.ttf");         break;
                        case 15:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/RobotoCondensed-Light.ttf");         break;
                        case 16:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Sarabun-Light.ttf");         break;
                        case 17:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Sarabun-Thin.ttf");         break;
                        case 18:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/TitilliumWeb-Light.ttf");         break;
                        case 19:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/TitilliumWeb-Regular.ttf");         break;
                        case 20:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Ubuntu-Light.ttf");         break;
                        case 21:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Ubuntu-Medium.ttf");         break;
                        case 22:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Quantico-Regular.ttf");         break;
                        case 23:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Oxygen-Light.ttf");         break;
                        case 24:editor.putString("NazwaCzcionkiKomentarz","fonts/SansSerif/Oxygen-Regular.ttf");         break;
                        case 25:editor.putString("NazwaCzcionkiKomentarz","fonts/Reczne/Charm-Regular.ttf");         break;
                        case 26:editor.putString("NazwaCzcionkiKomentarz","fonts/Reczne/KiteOne-Regular.ttf");         break;

                    }
                    editor.apply();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });

        }
        private void spinner_rozmiar_czcionki_werset()
        {


            SharedPreferences        sharedPref                      = getApplicationContext().getSharedPreferences("MyPref",0);
            final SharedPreferences.Editor editor                          = sharedPref.edit();
            int rozmiar_czcionki                = sharedPref.getInt("RozmiarCzcionkiWerset",18);
            Spinner                  spinner_rozmiar_czcionki_werset = findViewById(R.id.id_werset_spiner_rozmiar_czcionki);
            ArrayAdapter<Integer>    dataAdapter                     = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_rozmiar_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_rozmiar_czcionki_werset.setAdapter(dataAdapter);

            switch (rozmiar_czcionki)
            {
                case 10:
                    spinner_rozmiar_czcionki_werset.setSelection(0);
                    break;
                case 12:
                    spinner_rozmiar_czcionki_werset.setSelection(1);
                    break;
                case 14:
                    spinner_rozmiar_czcionki_werset.setSelection(2);
                    break;
                case 16:
                    spinner_rozmiar_czcionki_werset.setSelection(3);
                    break;
                case 18:
                    spinner_rozmiar_czcionki_werset.setSelection(4);
                    break;
                case 20:
                    spinner_rozmiar_czcionki_werset.setSelection(5);
                    break;
                case 22:
                    spinner_rozmiar_czcionki_werset.setSelection(6);
                    break;
                case 24:
                    spinner_rozmiar_czcionki_werset.setSelection(7);
                    break;
                case 26:
                    spinner_rozmiar_czcionki_werset.setSelection(8);
                    break;
                default: spinner_rozmiar_czcionki_werset.setSelection(4);

            }

            spinner_rozmiar_czcionki_werset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {
                    Integer item = (Integer) parent.getItemAtPosition(position);


                    editor.putInt("RozmiarCzcionkiWerset",item);
                    editor.apply();


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });
        }
        private void spinner_rozmiar_czcionki_komentarz()
        {


            SharedPreferences        sharedPref                         = getApplicationContext().getSharedPreferences("MyPref",0);
            final SharedPreferences.Editor editor                             = sharedPref.edit();
            int rozmiar_czcionki_komentarz         = sharedPref.getInt("RozmiarCzcionkiKomentarz",18);
            Spinner                  spinner_rozmiar_czcionki_komentarz = findViewById(R.id.id_komentarz_spiner_rozmiar_czcionki);
            ArrayAdapter<Integer>    dataAdapter                        = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_rozmiar_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_rozmiar_czcionki_komentarz.setAdapter(dataAdapter);
            switch (rozmiar_czcionki_komentarz)
            {
                case 10:
                    spinner_rozmiar_czcionki_komentarz.setSelection(0);
                    break;
                case 12:
                    spinner_rozmiar_czcionki_komentarz.setSelection(1);
                    break;
                case 14:
                    spinner_rozmiar_czcionki_komentarz.setSelection(2);
                    break;
                case 16:
                    spinner_rozmiar_czcionki_komentarz.setSelection(3);
                    break;
                case 18:
                    spinner_rozmiar_czcionki_komentarz.setSelection(4);
                    break;
                case 20:
                    spinner_rozmiar_czcionki_komentarz.setSelection(5);
                    break;
                case 22:
                    spinner_rozmiar_czcionki_komentarz.setSelection(6);
                    break;
                case 24:
                    spinner_rozmiar_czcionki_komentarz.setSelection(7);
                    break;
                case 26:
                    spinner_rozmiar_czcionki_komentarz.setSelection(8);
                    break;

            }
            spinner_rozmiar_czcionki_komentarz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {
                    Integer item = (Integer) parent.getItemAtPosition(position);


                    editor.putInt("RozmiarCzcionkiKomentarz",item);
                    editor.apply();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });
        }
        private void spinner_kolor_czcionki_werset()
        {


            SharedPreferences        sharedPref                    = getApplicationContext().getSharedPreferences("MyPref",0);
            final SharedPreferences.Editor editor                        = sharedPref.edit();
            String                  kolor_czcionki_werset                = sharedPref.getString("KolorCzcionkiWerset","<font color='#FFFFFF'>");
            Spinner                  spinner_kolor_czcionki_werset = findViewById(R.id.id_werset_spiner_kolor_czcionki);
            ArrayAdapter<String>     dataAdapter                   = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_kolor_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_kolor_czcionki_werset.setAdapter(dataAdapter);

            switch (Objects.requireNonNull(kolor_czcionki_werset))
            {
                case "<font color='#FFFFFF'>":
                    spinner_kolor_czcionki_werset.setSelection(0);
                    break;
                case "<font color='#808080'>":
                    spinner_kolor_czcionki_werset.setSelection(1);
                    break;
                case "<font color='#FF0000'>":
                    spinner_kolor_czcionki_werset.setSelection(2);
                    break;
                case "<font color='#FFFF00'>":
                    spinner_kolor_czcionki_werset.setSelection(3);
                    break;
                case "<font color='#0000FF'>":
                    spinner_kolor_czcionki_werset.setSelection(4);
                    break;
                case "<font color='#00FFFF'>":
                    spinner_kolor_czcionki_werset.setSelection(5);
                    break;

            }


            spinner_kolor_czcionki_werset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {


                    switch (position)
                    {
                        case 0:
                            editor.putString("KolorCzcionkiWerset","<font color='#FFFFFF'>");
                            break;
                        case 1:
                            editor.putString("KolorCzcionkiWerset","<font color='#808080'>");
                            break;
                        case 2:
                            editor.putString("KolorCzcionkiWerset","<font color='#FF0000'>");
                            break;
                        case 3:
                            editor.putString("KolorCzcionkiWerset","<font color='#FFFF00'>");
                            break;
                        case 4:
                            editor.putString("KolorCzcionkiWerset","<font color='#0000FF'>");
                            break;
                        case 5:
                            editor.putString("KolorCzcionkiWerset","<font color='#00FFFF'>");
                            break;

                    }
                    editor.apply();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });
        }
        private void spinner_kolor_czcionki_rozdzial()
        {


            SharedPreferences        sharedPref                      = getApplicationContext().getSharedPreferences("MyPref",0);
            final SharedPreferences.Editor editor                          = sharedPref.edit();
            String           kolor_czcionki_rozdzial         = sharedPref.getString("KolorCzcionkiRozdzial","<font color='#FF0000'>");
            Spinner                  spinner_kolor_czcionki_rozdzial = findViewById(R.id.id_rozdzial_spiner_kolor_czcionki);
            ArrayAdapter<String>     dataAdapter                     = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_kolor_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_kolor_czcionki_rozdzial.setAdapter(dataAdapter);

            switch (Objects.requireNonNull(kolor_czcionki_rozdzial))
            {
                case "<font color='#FFFFFF'>":
                    spinner_kolor_czcionki_rozdzial.setSelection(0);
                    break;
                case "<font color='#808080'>":
                    spinner_kolor_czcionki_rozdzial.setSelection(1);
                    break;
                case "<font color='#FF0000'>":
                    spinner_kolor_czcionki_rozdzial.setSelection(2);
                    break;
                case "<font color='#FFFF00'>":
                    spinner_kolor_czcionki_rozdzial.setSelection(3);
                    break;
                case "<font color='#0000FF'>":
                    spinner_kolor_czcionki_rozdzial.setSelection(4);
                    break;
                case "<font color='#00FFFF'>":
                    spinner_kolor_czcionki_rozdzial.setSelection(5);
                    break;

            }


            spinner_kolor_czcionki_rozdzial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {


                    switch (position)
                    {
                        case 0:
                            editor.putString("KolorCzcionkiRozdzial","<font color='#FFFFFF'>");
                            break;
                        case 1:
                            editor.putString("KolorCzcionkiRozdzial","<font color='#808080'>");
                            break;
                        case 2:
                            editor.putString("KolorCzcionkiRozdzial","<font color='#FF0000'>");
                            break;
                        case 3:
                            editor.putString("KolorCzcionkiRozdzial","<font color='#FFFF00'>");
                            break;
                        case 4:
                            editor.putString("KolorCzcionkiRozdzial","<font color='#0000FF'>");
                            break;
                        case 5:
                            editor.putString("KolorCzcionkiRozdzial","<font color='#00FFFF'>");
                            break;

                    }


                    editor.apply();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });


        }
        private void spinner_kolor_czcionki_komentarz1()
        {
            SharedPreferences        sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
            final SharedPreferences.Editor editor     = sharedPref.edit();

            int kolor_czcionki_komentarz = sharedPref.getInt("KolorCzcionkiKomentarz1",0xff007FFF);


            Spinner              spinner_kolor_czcionki_komentarz = findViewById(R.id.id_komentarz1_spiner_kolor_czcionki);
            ArrayAdapter<String> dataAdapter                      = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_kolor_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_kolor_czcionki_komentarz.setAdapter(dataAdapter);

            switch (kolor_czcionki_komentarz)
            {
                case 0xffffffff:
                    spinner_kolor_czcionki_komentarz.setSelection(0);
                    break;
                case 0xff888888:
                    spinner_kolor_czcionki_komentarz.setSelection(1);
                    break;
                case 0xffFF2400:
                    spinner_kolor_czcionki_komentarz.setSelection(2);
                    break;
                case 0xffffff00:
                    spinner_kolor_czcionki_komentarz.setSelection(3);
                    break;
                case 0xff007FFF:
                    spinner_kolor_czcionki_komentarz.setSelection(4);
                    break;
                case 0xff00ffff:
                    spinner_kolor_czcionki_komentarz.setSelection(5);
                    break;
                case 0xff000000:
                    spinner_kolor_czcionki_komentarz.setSelection(6);
                    break;

            }


            spinner_kolor_czcionki_komentarz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {


                    switch (position)
                    {
                        case 0:  editor.putInt("KolorCzcionkiKomentarz1",0xffffffff);break;
                        case 1:  editor.putInt("KolorCzcionkiKomentarz1",0xff888888);break;
                        case 2:  editor.putInt("KolorCzcionkiKomentarz1",0xffFF2400);break;
                        case 3:  editor.putInt("KolorCzcionkiKomentarz1",0xffffff00);break;
                        case 4:  editor.putInt("KolorCzcionkiKomentarz1",0xff007FFF );break;
                        case 5:  editor.putInt("KolorCzcionkiKomentarz1",0xff00ffff);break;
                        case 6:  editor.putInt("KolorCzcionkiKomentarz1",0xff000000);break;

                    }


                    editor.apply();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });

        }
        private void spinner_kolor_czcionki_komentarz2()
        {
            SharedPreferences        sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
            final SharedPreferences.Editor editor     = sharedPref.edit();

            int kolor_czcionki_komentarz = sharedPref.getInt("KolorCzcionkiKomentarz2",0xffffff00);


            Spinner              spinner_kolor_czcionki_komentarz = findViewById(R.id.id_komentarz2_spiner_kolor_czcionki);
            ArrayAdapter<String> dataAdapter                      = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista_kolor_czcionki);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_kolor_czcionki_komentarz.setAdapter(dataAdapter);

            switch (kolor_czcionki_komentarz)
            {
                case 0xffffffff:
                    spinner_kolor_czcionki_komentarz.setSelection(0);
                    break;
                case 0xff888888:
                    spinner_kolor_czcionki_komentarz.setSelection(1);
                    break;
                case 0xffff0000:
                    spinner_kolor_czcionki_komentarz.setSelection(2);
                    break;
                case 0xffffff00:
                    spinner_kolor_czcionki_komentarz.setSelection(3);
                    break;
                case 0xff0000ff:
                    spinner_kolor_czcionki_komentarz.setSelection(4);
                    break;
                case 0xff00ffff:
                    spinner_kolor_czcionki_komentarz.setSelection(5);
                    break;
                case 0xff000000:
                    spinner_kolor_czcionki_komentarz.setSelection(6);
                    break;

            }


            spinner_kolor_czcionki_komentarz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                {


                    switch (position)
                    {
                        case 0:  editor.putInt("KolorCzcionkiKomentarz2",0xffffffff);break;
                        case 1:  editor.putInt("KolorCzcionkiKomentarz2",0xff888888);break;
                        case 2:  editor.putInt("KolorCzcionkiKomentarz2",0xffff0000);break;
                        case 3:  editor.putInt("KolorCzcionkiKomentarz2",0xffffff00);break;
                        case 4:  editor.putInt("KolorCzcionkiKomentarz2",0xff0000ff);break;
                        case 5:  editor.putInt("KolorCzcionkiKomentarz2",0xff00ffff);break;
                        case 6:  editor.putInt("KolorCzcionkiKomentarz2",0xff000000);break;

                    }


                    editor.apply();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });

        }


    }
