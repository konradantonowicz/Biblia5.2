package pakiet.konrad.biblia52.Aktywnosci;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import pakiet.konrad.biblia52.Adapter.AdapterSwipeKomentarz;
import pakiet.konrad.biblia52.Fragmenty.Fragment_4_pola;
import pakiet.konrad.biblia52.R;

public class AktywnoscPokazKomentarz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_pokaz_komentarz);


        Intent intent          = getIntent();
        int numer_tematu    = Integer.parseInt(intent.getStringExtra("numer_tematu").trim());
        String         ksiega          = intent.getStringExtra("ksiega");
        int iloscTematow = intent.getIntExtra("ilosctematow",0);


        List<Fragment> fragments       = new ArrayList<>();


         for (int x=0;x<iloscTematow;x++)       {
                fragments.add(Fragment_4_pola.newInstance(ksiega.trim()+x));

        }
        //Toast.makeText(this, ksiega, Toast.LENGTH_SHORT).show();
        ViewPager vp      = findViewById(R.id.viewpager);
        AdapterSwipeKomentarz adapter = new AdapterSwipeKomentarz(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);
        vp.setCurrentItem(numer_tematu);

    }
}
