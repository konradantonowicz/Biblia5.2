package pakiet.konrad.biblia52.Fragmenty;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import pakiet.konrad.biblia52.Adapter.AdapterRecyclerSzukanychSlow;
import pakiet.konrad.biblia52.BazaDanych.Biblia_Komentarze;
import pakiet.konrad.biblia52.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDialoxBoxOdnosnik extends DialogFragment {


    public FragmentDialoxBoxOdnosnik  () {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View    rootView = inflater.inflate(R.layout.fragment_fragment_dialox_box_odnosnik, container, false);
        Biblia_Komentarze bibliaKomentarze = new Biblia_Komentarze(getContext());

        Bundle b = getArguments();
        assert b != null;
        String ksiega = b.getString("NumerKsiegi", " ");
        String rozdzial = b.getString("String Nr_rozdzialu", " ");
        String werset = b.getString("String Nr_wersetu", " ");

        RecyclerView recyclerView = rootView.findViewById(R.id.id_recycler_DialogBox);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRecyclerSzukanychSlow adapter_recyclera_szukaj = new AdapterRecyclerSzukanychSlow(bibliaKomentarze.PokazOdnosniki(ksiega, rozdzial, werset));
        recyclerView.setAdapter(adapter_recyclera_szukaj);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            Objects.requireNonNull(dialog.getWindow()).setLayout(width, height);
    }
}
}
