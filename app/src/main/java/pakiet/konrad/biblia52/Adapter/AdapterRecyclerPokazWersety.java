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
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import java.util.Objects;
import pakiet.konrad.biblia52.R;

public class AdapterRecyclerPokazWersety extends RecyclerView.Adapter<AdapterRecyclerPokazWersety.ObiektDanychHolder> {
    private List<String> mListaWersetow;
    private Integer mRozmiar_Czcionki;
    private String mNazwa_Czcionki;
    private Activity activity;

    private String mNumer_rozdzialu;

    public AdapterRecyclerPokazWersety(FragmentActivity fragment_pokazWersety, List<String> ListaWersetow, String numer_rozdzialu) {
        this.mListaWersetow = ListaWersetow;
        this.activity=fragment_pokazWersety;
        SharedPreferences sharedPref                 = Objects.requireNonNull(activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE));
        this.mNazwa_Czcionki = sharedPref.getString("NazwaCzcionkiWerset","fonts/SansSerif/Quantico-Regular.ttf");
        this.mRozmiar_Czcionki = sharedPref.getInt("RozmiarCzcionkiWerset",18);
        this.mNumer_rozdzialu=numer_rozdzialu;


    }

    @NonNull
    @Override
    public ObiektDanychHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wyglad_wiersza_wersetow, parent, false);

        return new ObiektDanychHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObiektDanychHolder obiektDanychHolder, int position) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(),mNazwa_Czcionki);
        obiektDanychHolder.wers.setText(Html.fromHtml(mListaWersetow.get(position)));
        obiektDanychHolder.wers.setTextSize(TypedValue.COMPLEX_UNIT_DIP, mRozmiar_Czcionki);
        obiektDanychHolder.wers.setTypeface(tf);




    }


    @Override
    public int getItemCount() {
        return mListaWersetow.size();
    }




    class ObiektDanychHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView wers;

        ObiektDanychHolder(@NonNull View itemView) {
            super(itemView);
            wers = itemView.findViewById(R.id.tv_wers);


wers.setOnCreateContextMenuListener(this);







        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
menu.setHeaderTitle("Akcje do Wykonania");
menu.add(getAdapterPosition()+1,Integer.parseInt(mNumer_rozdzialu),0,"Pokaż Przypis");
menu.add(getAdapterPosition(),122,1,"Kopiuj Werset");

        }
    }
}
