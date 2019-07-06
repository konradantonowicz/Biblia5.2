package pakiet.konrad.biblia52.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import pakiet.konrad.biblia52.Aktywnosci.AktywnoscGlowna;
import pakiet.konrad.biblia52.Interface.SluchaczKliknietegoElementuInterfaceKsiegi;
import pakiet.konrad.biblia52.ModelDanych.NazwyKsiagCzyJestKomentarz;
import pakiet.konrad.biblia52.R;

public class AdapterRecyclerKsiag extends RecyclerView.Adapter<AdapterRecyclerKsiag.ObiektDanychHolder>
{

    private List<NazwyKsiagCzyJestKomentarz> mlista;
    private SluchaczKliknietegoElementuInterfaceKsiegi sluchaczKliknietegoElementuInterfaceKsiegi;




    public AdapterRecyclerKsiag(List<NazwyKsiagCzyJestKomentarz> ListaNazwKsiagKomentarzy) {
        this.mlista= ListaNazwKsiagKomentarzy;
    }


    @NonNull
    @Override
    public AdapterRecyclerKsiag.ObiektDanychHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_ksiag,parent,false);
        return new ObiektDanychHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ObiektDanychHolder holder,final int position)
    {
       holder.Tv_Ksiegi.setText(mlista.get(position).getNazwaKsiegi());

        holder.Im_Komentarz.setImageResource(mlista.get(position).getIkonaKomentarza());


    }


    @Override
    public int getItemCount()
    {
        return mlista.size();
    }

    public void UstawSluczaczaKlikniecia(AktywnoscGlowna aktywnoscGlowna)
    {
        this.sluchaczKliknietegoElementuInterfaceKsiegi = aktywnoscGlowna;
    }


    class ObiektDanychHolder extends RecyclerView.ViewHolder
    {
        TextView Tv_Ksiegi;
        ImageView Im_Komentarz;

        ObiektDanychHolder(View itemView)
        {
            super(itemView);
            Tv_Ksiegi = itemView.findViewById(R.id.tv_ksiega);
            Im_Komentarz = itemView.findViewById(R.id.im_komentarz);



          itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sluchaczKliknietegoElementuInterfaceKsiegi.klik_na_ksiega(Tv_Ksiegi.getText().toString());
                }
            });
                Im_Komentarz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sluchaczKliknietegoElementuInterfaceKsiegi.klik_na_komentarz(Tv_Ksiegi.getText().toString());
                }
            });

        }


    }

}
