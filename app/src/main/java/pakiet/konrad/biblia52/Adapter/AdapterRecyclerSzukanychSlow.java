package pakiet.konrad.biblia52.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import pakiet.konrad.biblia52.ModelDanych.Model_danych_szukaj_slowa;
import pakiet.konrad.biblia52.R;

public class AdapterRecyclerSzukanychSlow extends RecyclerView.Adapter<AdapterRecyclerSzukanychSlow.ViewHolder> {
    private List<Model_danych_szukaj_slowa> lista_wersetow_z_szukanym_slowem;

    public AdapterRecyclerSzukanychSlow(List<Model_danych_szukaj_slowa> wyniki_szukania_slowa) {
        this.lista_wersetow_z_szukanym_slowem=wyniki_szukania_slowa;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_szukane_slowa,parent,false);
        return new AdapterRecyclerSzukanychSlow.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.Tv_Ksiegi.setText(Html.fromHtml(lista_wersetow_z_szukanym_slowem.get(i).getNazwa_ksiegi_numer_rozdzialu()));
        viewHolder.Tv_wersy.setText(Html.fromHtml(lista_wersetow_z_szukanym_slowem.get(i).getNumer_wersu_tresc_wersu()));

    }

    @Override
    public int getItemCount() {
        return lista_wersetow_z_szukanym_slowem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
     TextView Tv_Ksiegi,Tv_wersy;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            Tv_Ksiegi = itemView.findViewById(R.id.szukaj_ksiega);
            Tv_wersy = itemView.findViewById(R.id.szukaj_rozdzial_wers);
        }
    }
}
