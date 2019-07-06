package pakiet.konrad.biblia52.Aktywnosci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import pakiet.konrad.biblia52.Adapter.AdapterRecyclerListaTematowKomentarzy;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.Interface.SluchaczKliknietegoElementuInterfaceTematyKomentarzy;
import pakiet.konrad.biblia52.R;

public class AktywnoscPokazTematyKomentarzy extends AppCompatActivity implements SluchaczKliknietegoElementuInterfaceTematyKomentarzy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_pokaz_tematy);


        Biblia_Komentarze baza_BibliaKomentarze = new Biblia_Komentarze(this);

        Intent intent = getIntent();
        String ksiega = intent.getStringExtra("ksiega");

        RecyclerView recyclerView = findViewById(R.id.id_recycler_lista_tematow);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterRecyclerListaTematowKomentarzy(this,baza_BibliaKomentarze.PokazTematyKomentarzy(Integer.parseInt(ksiega)-1),ksiega));
        AdapterRecyclerListaTematowKomentarzy.UstawSluczaczaKliknieciaRozneTematy(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(this.getResources().getDrawable(R.drawable.item_decorator));
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public void klik_na_temat(String numer_ksiegi, String numer_tematu,Integer liczbaTematow) {
        Intent intent1 = new Intent(AktywnoscPokazTematyKomentarzy.this.getApplicationContext(),AktywnoscPokazKomentarz.class);
        intent1.putExtra("numer_tematu",numer_tematu);
        intent1.putExtra("ksiega",numer_ksiegi);
        intent1.putExtra("ilosctematow",liczbaTematow);
        AktywnoscPokazTematyKomentarzy.this.startActivity(intent1);
        //Toast.makeText(this, numer_ksiegi+numer_tematu+liczbaTematow, Toast.LENGTH_SHORT).show();

    }
}
