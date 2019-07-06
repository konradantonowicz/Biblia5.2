package pakiet.konrad.biblia52.Fragmenty;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import pakiet.konrad.biblia52.Adapter.AdapterRecyclerPokazWersety;
import pakiet.konrad.biblia52.Aktywnosci.AktywnoscPokazPrzypisy;
import pakiet.konrad.biblia52.Aktywnosci.AktywnoscPokazWersety;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.R;

public class FragmentPokazWersety extends Fragment
{

    RecyclerView recyclerView;

    String NumerKsiegi;
    String numer_rozdzialu;

    public FragmentPokazWersety()
    {
        // Required empty public constructor
    }


    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
    {

        Biblia_Komentarze mBazaDanych = new Biblia_Komentarze(getContext());
        View              rootView    = inflater.inflate(R.layout.fragment_pokaz_wersety,container,false);

        AktywnoscPokazWersety activity = (AktywnoscPokazWersety) getActivity();
        Bundle bundle = getArguments();
        assert bundle != null;
        assert activity != null;

         NumerKsiegi = activity.NumerKsiegi();


        numer_rozdzialu = bundle.getString("autalna_strona_swipe");


        recyclerView = rootView.findViewById(R.id.wersy_recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRecyclerPokazWersety adapter_recyclera_wersety = new AdapterRecyclerPokazWersety(getActivity(),mBazaDanych.PokazWersetyBibli(NumerKsiegi,numer_rozdzialu), numer_rozdzialu);
        recyclerView.setAdapter(adapter_recyclera_wersety);
        return rootView;
    }




    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getTitle().toString())
        {
            case "Pokaż Przypis":



            {


                Intent intent_pokaz_odnosniki = new Intent(getContext(),AktywnoscPokazPrzypisy.class);

                intent_pokaz_odnosniki.putExtra("NumerKsiegi", NumerKsiegi);
                intent_pokaz_odnosniki.putExtra("NumerRozdzialu", String.valueOf(item.getItemId()));
                intent_pokaz_odnosniki.putExtra("NumerWersetu", String.valueOf(item.getGroupId()));


                startActivity(intent_pokaz_odnosniki);








            }

            return true;




            default:        return super.onContextItemSelected(item);

        }



    }


}
