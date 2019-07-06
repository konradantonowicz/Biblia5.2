package pakiet.konrad.biblia52.Aktywnosci;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pakiet.konrad.biblia52.Adapter.AdapterSwipeWersety;
import pakiet.konrad.biblia52.R;

public class AktywnoscPokazWersety extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_pokaz_wersety);

        Intent intent = getIntent();


        String rozdzial = intent.getStringExtra("rozdzial");
       Integer ilosc_rozdzialow =  intent.getIntExtra("ilosc_rozdzialow",0);



       ViewPager viewPager = findViewById(R.id.view_pager_wersety);
       viewPager.setOffscreenPageLimit(0);
       AdapterSwipeWersety adapterSwipeWersety = new AdapterSwipeWersety(getSupportFragmentManager(),ilosc_rozdzialow);
       viewPager.setAdapter(adapterSwipeWersety);
       viewPager.setCurrentItem(Integer.parseInt(rozdzial)-1);

    }
    public String NumerKsiegi()
    {
        Intent intent = getIntent();

        return intent.getStringExtra("ksiega");
    }



}
