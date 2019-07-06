package pakiet.konrad.biblia52.Aktywnosci;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pakiet.konrad.biblia52.Adapter.AdapterRecyclerKsiag;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.BazaDanych.Slownik_fts3;
import pakiet.konrad.biblia52.Interface.SluchaczKliknietegoElementuInterfaceKsiegi;
import pakiet.konrad.biblia52.ModelDanych.NazwyKsiagCzyJestKomentarz;
import pakiet.konrad.biblia52.R;



public class AktywnoscGlowna extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SluchaczKliknietegoElementuInterfaceKsiegi {
    Biblia_Komentarze BibliaKomentarze;
    AdapterRecyclerKsiag adapterRecyclerKsiag;
    List<NazwyKsiagCzyJestKomentarz> ListaNazwKsiagIkonaKomentarzy;
    NazwyKsiagCzyJestKomentarz nazwyKsiagCzyJestKomentarz;
    Slownik_fts3 slownik_fts3;
    boolean twice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BibliaKomentarze = new Biblia_Komentarze(this);
        slownik_fts3= new Slownik_fts3(this);

        Runnable zrobListeNazwKsiag = new ZrobListeNazwKsiag();
        Runnable sprawdzCzyJestBazaDanych = new SprawdzCzyJestBazaDanych();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(zrobListeNazwKsiag);
        pool.execute(sprawdzCzyJestBazaDanych);




        NavigationView navigationView = findViewById(R.id.id_nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void klik_na_ksiega(String Ksiega) {

         Intent intentPokazRozdzialy = new Intent(this, AktywnoscPokazRozdzialy.class);
         intentPokazRozdzialy.putExtra("ksiega", ZamienNazweKsiegiNaNumerKsiegi(Ksiega));
         startActivity(intentPokazRozdzialy);


    }
    @Override
    public void klik_na_komentarz(String Ksiega){
        Intent intent = new Intent(this, AktywnoscPokazTematyKomentarzy.class);
        intent.putExtra("ksiega",ZamienNazweKsiegiNaNumerKsiegi(Ksiega).trim());
        startActivity(intent);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.StaryTestament: {
                RecyclerKsiegi(ListaNazwKsiagIkonaKomentarzy.subList(0, 39));
            }
            break;
            case R.id.NowyTestament: {
                RecyclerKsiegi(ListaNazwKsiagIkonaKomentarzy.subList(39, 66));
            }
            break;
            case R.id.StaryNowyTestament: {
                RecyclerKsiegi(ListaNazwKsiagIkonaKomentarzy.subList(0,66));
            }
            break;
            case R.id.Komentarz: {
                RecyclerKsiegi(ListaNazwKsiagIkonaKomentarzy.subList(66, 70));
            }
            break;
            case R.id.Ustawienia: {Intent intent = new Intent(this,AktywnoscUstawienia.class);startActivity(intent);
            }
            break;
            case R.id.tematy_rozne: {
                Intent intent = new Intent(this, AktywnoscPokazTematyKomentarzy.class);
                intent.putExtra("ksiega","67");
                startActivity(intent);
            }
            break;
            case R.id.Szukaj:{
                Intent intent = new Intent(this,AktywnoscSzukanieSlow.class);startActivity(intent);}

            break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    @Override
    public void onBackPressed() {
        if (twice)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice=true;
        Toast.makeText(this,"Chcesz Wyjść? kliknij jeszcze raz",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
            }
        },3000);
    }


    private class WyswietlKsiegiWRecyclerView implements Runnable {
        @Override
        public void run() {
            RecyclerKsiegi(ListaNazwKsiagIkonaKomentarzy.subList(0, 66));
        }
    }
    private class ZrobListeNazwKsiag implements Runnable {
        @Override
        public void run() {
            ListaNazwKsiagIkonaKomentarzy = new ArrayList<>();
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I Mojżeszowa(Księga Rodzaju)", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II Mojżeszowa(Księga Wyjścia)", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("III Mojżeszowa(Księga Kapłańska)", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("IV Mojżeszowa(Księga Liczb)", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("V Mojżeszowa (Księga Powtórzonego Prawa)", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Jozuego", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Sędziów", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Rut", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I Księga Samuela", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II Księga Samuela", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I Księga Królewska", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II Księga Królewska", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I Księga Kronik", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II Księga Kronik", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Ezdrasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Nehemiasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Estery", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Hioba", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Psalmów", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Przysłów", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Kaznodziei", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Pieśń nad Pieśniami", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Izajasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Jeremiasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Lamentacje", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Ezechiela", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Daniela", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Ozeasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Joela", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Amosa", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Abdiasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Jonasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Micheasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Nahuma", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Habakuka", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Sofoniasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Aggeusza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Zachariasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Malachiasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Ewangelia Mateusza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Ewangelia Marka", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Ewangelia Łukasza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Ewangelia Jana", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Dzieje Apostolskie", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Rzymian", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I List do Koryntian", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II List do Koryntian", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Galacjan", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Efezjan", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Filipian", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Kolosan", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I List do Tesaloniczan", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II List do Tesaloniczan", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I List do Tymoteusza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II List do Tymoteusza", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Tytusa", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Filemona", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Hebrajczyków", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List Jakuba", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I List Piotra", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II List Piotra", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("1 List Jana", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("2 List Jana", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("3 List Jana", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List Judy", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("Księga Objawienia", 0);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Rzymian", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("I List do Koryntian", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("II List do Koryntian", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);
            nazwyKsiagCzyJestKomentarz = new NazwyKsiagCzyJestKomentarz("List do Hebrajczyków", R.drawable.reading);
            ListaNazwKsiagIkonaKomentarzy.add(nazwyKsiagCzyJestKomentarz);

            runOnUiThread(new WyswietlKsiegiWRecyclerView());
        }
    }
    private class SprawdzCzyJestBazaDanych implements Runnable {
        @Override
        public void run() {
            if(!BibliaKomentarze.sprawdz())
            {
                ZrobSlownikFts3();
            }
        }
    }

    private void RecyclerKsiegi(List<NazwyKsiagCzyJestKomentarz> lista) {

        RecyclerView recycler_glowny = findViewById(R.id.recyler_glowny);
        recycler_glowny.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_glowny.setLayoutManager(layoutManager);
        adapterRecyclerKsiag = new AdapterRecyclerKsiag(lista);
        recycler_glowny.setAdapter(adapterRecyclerKsiag);
        adapterRecyclerKsiag.UstawSluczaczaKlikniecia(this);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(this.getResources().getDrawable(R.drawable.item_decorator));
        recycler_glowny.addItemDecoration(dividerItemDecoration);


    }
    public  String ZamienNazweKsiegiNaNumerKsiegi(String NazwaKsiegi) {

        switch (NazwaKsiegi) {
            case "I Mojżeszowa(Księga Rodzaju)":                 return "1";
            case "II Mojżeszowa(Księga Wyjścia)":                return "2";
            case "III Mojżeszowa(Księga Kapłańska)":             return "3";
            case "IV Mojżeszowa(Księga Liczb)":                  return "4";
            case "V Mojżeszowa (Księga Powtórzonego Prawa)":     return "5";
            case "Księga Jozuego":                               return "6";
            case "Księga Sędziów":                               return "7";
            case "Księga Rut":                                   return "8";
            case "I Księga Samuela":                             return "9";
            case "II Księga Samuela":                            return "10";
            case "I Księga Królewska":                           return "11";
            case "II Księga Królewska":                          return "12";
            case "I Księga Kronik":                              return "13";
            case "II Księga Kronik":                             return "14";
            case "Księga Ezdrasza":                              return "15";
            case "Księga Nehemiasza":                            return "16";
            case "Księga Estery":                                return "17";
            case "Księga Hioba":                                 return "18";
            case "Księga Psalmów":                               return "19";
            case "Księga Przysłów":                              return "20";
            case "Księga Kaznodziei":                            return "21";
            case "Pieśń nad Pieśniami":                          return "22";
            case "Księga Izajasza":                              return "23 ";
            case "Księga Jeremiasza":                            return "24 ";
            case "Lamentacje":                                   return "25 ";
            case "Księga Ezechiela":                             return "26 ";
            case "Księga Daniela":                               return "27 ";
            case "Księga Ozeasza":                               return "28 ";
            case "Księga Joela":                                 return "29 ";
            case "Księga Amosa":                                 return "30 ";
            case "Księga Abdiasza":                              return "31 ";
            case "Księga Jonasza":                               return "32 ";
            case "Księga Micheasza":                             return "33 ";
            case "Księga Nahuma":                                return "34 ";
            case "Księga Habakuka":                              return "35 ";
            case "Księga Sofoniasza":                            return "36 ";
            case "Księga Aggeusza":                              return "37 ";
            case "Księga Zachariasza":                           return "38 ";
            case "Księga Malachiasza":                           return "39 ";
            case "Ewangelia Mateusza":                           return "40 ";
            case "Ewangelia Marka":                              return "41 ";
            case "Ewangelia Łukasza":                            return "42 ";
            case "Ewangelia Jana":                               return "43 ";
            case "Dzieje Apostolskie":                           return "44 ";
            case "List do Rzymian":                              return "45 ";
            case "I List do Koryntian":                          return "46 ";
            case "II List do Koryntian":                         return "47 ";
            case "List do Galacjan":                             return "48 ";
            case "List do Efezjan":                              return "49 ";
            case "List do Filipian":                             return "50 ";
            case "List do Kolosan":                              return "51 ";
            case "I List do Tesaloniczan":                       return "52 ";
            case "II List do Tesaloniczan":                      return "53 ";
            case "I List do Tymoteusza":                         return "54 ";
            case "II List do Tymoteusza":                        return "55 ";
            case "List do Tytusa":                               return "56 ";
            case "List do Filemona":                             return "57 ";
            case "List do Hebrajczyków":                         return "58 ";
            case "List Jakuba":                                  return "59 ";
            case "I List Piotra":                                return "60 ";
            case "II List Piotra":                               return "61 ";
            case "1 List Jana":                                  return "62 ";
            case "2 List Jana":                                  return "63 ";
            case "3 List Jana":                                  return "64 ";
            case "List Judy":                                    return "65 ";
            case "Księga Objawienia":                            return "66 ";

        }
        return "0";
    }
    public void ZrobSlownikFts3()  {
        Cursor k = BibliaKomentarze.Cursor_zrob_slownik();
        slownik_fts3.open();
        BibliaKomentarze.openDatabase();
        k.moveToFirst();
        while (!k.isAfterLast())
        {
            slownik_fts3.insertRow(k.getString(0),k.getString(1),k.getString(2),k.getString(3));
            k.moveToNext();
        }
        k.close();
        BibliaKomentarze.closeDatabase();
        slownik_fts3.close();
    }



}
