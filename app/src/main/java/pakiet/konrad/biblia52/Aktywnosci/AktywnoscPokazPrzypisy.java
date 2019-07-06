package pakiet.konrad.biblia52.Aktywnosci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import pakiet.konrad.biblia52.Adapter.AdapterRecyclerSzukanychSlow;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.R;

public class AktywnoscPokazPrzypisy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_pokaz_przypisy);


        Biblia_Komentarze bibliaKomentarze = new Biblia_Komentarze(this);

        Intent intent = getIntent();

        String ksiega = intent.getStringExtra("NumerKsiegi");
        String rozdzial = intent.getStringExtra("NumerRozdzialu");
        String werset = intent.getStringExtra("NumerWersetu");


        RecyclerView recyclerView = findViewById(R.id.id_recycler_DialogBox);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRecyclerSzukanychSlow adapter_recyclera_szukaj = new AdapterRecyclerSzukanychSlow(bibliaKomentarze.PokazOdnosniki(ksiega, rozdzial, werset));
        recyclerView.setAdapter(adapter_recyclera_szukaj);


    }
}
