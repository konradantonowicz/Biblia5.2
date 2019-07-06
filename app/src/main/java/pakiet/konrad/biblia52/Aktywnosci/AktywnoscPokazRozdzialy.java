package pakiet.konrad.biblia52.Aktywnosci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import pakiet.konrad.biblia52.Adapter.AdapterRecyclerRozdzialow;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.Interface.SluchaczKliknietegoElementuInterfaceRozdzialy;
import pakiet.konrad.biblia52.R;

public class AktywnoscPokazRozdzialy extends AppCompatActivity implements SluchaczKliknietegoElementuInterfaceRozdzialy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_pokaz_rozdzialy);

        Biblia_Komentarze BibliaKomentarze = new Biblia_Komentarze(this);

        Intent intent = getIntent();

        String NrKsiegi = intent.getStringExtra("ksiega");
        int NrKsiegi_liczba = Integer.parseInt(NrKsiegi.trim());

        if (NrKsiegi_liczba<70)
        {
            RecyclerView recycler_rozdzialow = findViewById(R.id.id_recycler_rozdzialow);
            recycler_rozdzialow.setHasFixedSize(true);
            AdapterRecyclerRozdzialow mAdapter = new AdapterRecyclerRozdzialow(this,Integer.parseInt(BibliaKomentarze.IloscRozdzialow(NrKsiegi_liczba-1)),NrKsiegi_liczba-1);
            recycler_rozdzialow.setAdapter(mAdapter);
            mAdapter.UstawSluchaczaKliknietegoRozdzialu(this);
        }
        else
        {

            Intent intent1 = new Intent(AktywnoscPokazRozdzialy.this.getApplicationContext(),AktywnoscPokazKomentarz.class);
            intent1.putExtra("ksiega",NrKsiegi.substring(0,1)+"0");
            intent1.putExtra("numer_tematu",NrKsiegi.substring(1));
            intent1.putExtra("ilosctematow",2);
            AktywnoscPokazRozdzialy.this.startActivity(intent1);

        }





    }

    @Override
    public void klik_na_rozdzial(Integer Nr_Ksiegi,  Integer Nr_rozdzialu, Integer Ilosc_rozdzialow) {


        Intent intent = new Intent(this,AktywnoscPokazWersety.class);
        intent.putExtra("ksiega",Integer.toString(Nr_Ksiegi+1));
        intent.putExtra("rozdzial",Integer.toString(Nr_rozdzialu));
        intent.putExtra("ilosc_rozdzialow",Ilosc_rozdzialow);
        startActivity(intent);
    }
}
