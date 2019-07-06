package pakiet.konrad.biblia52.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import pakiet.konrad.biblia52.ModelDanych.Model_danych_komentarze;
import pakiet.konrad.biblia52.R;


public class AdapterRecyclerPokazKomentarz_4_pola extends RecyclerView.Adapter<AdapterRecyclerPokazKomentarz_4_pola.ObiektDanychHolder> {
    private Integer mRozmiar_Czcionki_werset,mRozmiar_Czcionki_komentarz,mKolor_Czcionki_komentarz1,mKolor_Czcionki_komentarz2;
    private String mNazwa_Czcionki_werset,mNazwa_Czcionki_komentarz,mKolor_Czcionki_werset,mKolor_Czcionki_rozdzial;
    private Activity activity;
    private List<Model_danych_komentarze> mmodel_danych_komentarze;

    public AdapterRecyclerPokazKomentarz_4_pola(FragmentActivity activity, List<Model_danych_komentarze> model_danych_komentarze) {
        this.activity=activity;
        SharedPreferences sharedPref                 = Objects.requireNonNull(activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE));
        this.mmodel_danych_komentarze=model_danych_komentarze;





        this.mRozmiar_Czcionki_werset = sharedPref.getInt("RozmiarCzcionkiWerset",18);
        this.mRozmiar_Czcionki_komentarz= sharedPref.getInt("RozmiarCzcionkiKomentarz",18);
        this.mKolor_Czcionki_komentarz1= sharedPref.getInt("KolorCzcionkiKomentarz1",0xff007FFF);
        this.mKolor_Czcionki_komentarz2= sharedPref.getInt("KolorCzcionkiKomentarz2",0xffffff00);
        this.mKolor_Czcionki_werset= sharedPref.getString("KolorCzcionkiWerset","<font color='#FFFFFF'>");
        this.mKolor_Czcionki_rozdzial= sharedPref.getString("KolorCzcionkiRozdzial","<font color='#FF0000'>");
        this.mNazwa_Czcionki_werset= sharedPref.getString("NazwaCzcionkiWerset","fonts/SansSerif/Quantico-Regular.ttf");
        this.mNazwa_Czcionki_komentarz  = sharedPref.getString("NazwaCzcionkiKomentarz","fonts/Reczne/KiteOne-Regular.ttf");


    }



    @NonNull
    @Override
    public ObiektDanychHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_komentarzy_4_pola, parent, false);
        return new ObiektDanychHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObiektDanychHolder holder, int position) {
        if (mmodel_danych_komentarze.get(position).getRozdzialy() == null)
        {
            holder.tvrozdzialy.setVisibility(View.GONE);
        }
        else
        {
            holder.tvrozdzialy.setVisibility(View.VISIBLE);
            holder.tvrozdzialy.setText(mmodel_danych_komentarze.get(position).getRozdzialy());
        }

        if(mmodel_danych_komentarze.get(position).getVerse() == null)
        {
            holder.tvWers.setVisibility(View.GONE);
        }
        else
        {
            holder.tvWers.setVisibility(View.VISIBLE);
            holder.tvWers.setText(Html.fromHtml(mKolor_Czcionki_rozdzial+mmodel_danych_komentarze.get(position).getVerse()+"</font>"+mKolor_Czcionki_werset+"&nbsp;"+mmodel_danych_komentarze.get(position).getScripture()+"</font>"));
        }

        if (mmodel_danych_komentarze.get(position).getKomentarz1() == null)
        {
            holder.tvKomentarz1.setVisibility(View.GONE);
        }
        else
        {
            holder.tvKomentarz1.setVisibility(View.VISIBLE);
            holder.tvKomentarz1.setText(mmodel_danych_komentarze.get(position).getKomentarz1());
        }


    }



    @Override
    public int getItemCount() {
        return mmodel_danych_komentarze.size();
    }

    class ObiektDanychHolder extends RecyclerView.ViewHolder {
        TextView tvrozdzialy,tvWers,tvKomentarz1;
        ObiektDanychHolder(View itemView) {
            super(itemView);
            Typeface typeface_komentarz = Typeface.createFromAsset(activity.getAssets(),mNazwa_Czcionki_komentarz);
            Typeface typeface_werset    = Typeface.createFromAsset(activity.getAssets(),mNazwa_Czcionki_werset);



            tvrozdzialy = itemView.findViewById(R.id.tvrozdzialy);
            tvrozdzialy.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mRozmiar_Czcionki_komentarz);
            tvrozdzialy.setTypeface(typeface_komentarz);
            tvrozdzialy.setTextColor(mKolor_Czcionki_komentarz1);

            tvWers = itemView.findViewById(R.id.tvWers);
            tvWers.setTypeface(typeface_werset);
            tvWers.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mRozmiar_Czcionki_werset);

            tvKomentarz1 = itemView.findViewById(R.id.tvKomentarz1);
            tvKomentarz1.setTypeface(typeface_komentarz);
            tvKomentarz1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mRozmiar_Czcionki_komentarz);
            tvKomentarz1.setTextColor(mKolor_Czcionki_komentarz2);


        }
    }
}
