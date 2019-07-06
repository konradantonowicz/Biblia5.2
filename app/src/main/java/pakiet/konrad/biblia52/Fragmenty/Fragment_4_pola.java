package pakiet.konrad.biblia52.Fragmenty;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;

import pakiet.konrad.biblia52.Adapter.AdapterRecyclerPokazKomentarz_4_pola;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.R;


public class Fragment_4_pola extends Fragment
{

private static final String Arg_text = "arg_text";
    String numerek = null;
    public static Fragment_4_pola newInstance (String ksiega)
    {

        Fragment_4_pola fragment_4_pola = new Fragment_4_pola();

        Bundle args = new Bundle();

        args.putString(Arg_text,ksiega);

        fragment_4_pola.setArguments(args);

        return fragment_4_pola;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
                View    rootView = inflater.inflate(R.layout.fragment_komentarz, container, false);

        Biblia_Komentarze bibliaKomentarze = new Biblia_Komentarze(getContext());

        if (getArguments()!=null)
        {
          numerek = (String) getArguments().get(Arg_text);
        }

        RecyclerView recyclerView_komentarz = rootView.findViewById(R.id.recyler_komentarz);
        recyclerView_komentarz.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView_komentarz.setLayoutManager(layoutManager);
        AdapterRecyclerPokazKomentarz_4_pola adapter_recyclera_komentarz = new AdapterRecyclerPokazKomentarz_4_pola(Objects.requireNonNull(getActivity()),bibliaKomentarze.LadujKomentarzeDoFragmentu_4_pola(numerek));
        recyclerView_komentarz.setAdapter(adapter_recyclera_komentarz);


        return rootView;
    }

}
