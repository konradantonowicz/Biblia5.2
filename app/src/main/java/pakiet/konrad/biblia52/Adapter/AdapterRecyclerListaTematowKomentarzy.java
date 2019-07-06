package pakiet.konrad.biblia52.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import pakiet.konrad.biblia52.Aktywnosci.AktywnoscPokazTematyKomentarzy;
import pakiet.konrad.biblia52.R;

public class AdapterRecyclerListaTematowKomentarzy extends RecyclerView.Adapter<AdapterRecyclerListaTematowKomentarzy.ViewHolder>{


    private static AktywnoscPokazTematyKomentarzy sluchaczKliknietegoElementuInterfaceTematy;
    private List<String> mListaTematow;
private String mnumer_ksiegi;

    public AdapterRecyclerListaTematowKomentarzy(AktywnoscPokazTematyKomentarzy aktywnoscPokazTematy, List<String> ListaTematow, String numer_ksiegi) {
        this.mListaTematow=ListaTematow;
        this.mnumer_ksiegi=numer_ksiegi;
    }

    public static void UstawSluczaczaKliknieciaRozneTematy(AktywnoscPokazTematyKomentarzy aktywnoscPokazTematy) {
    sluchaczKliknietegoElementuInterfaceTematy=aktywnoscPokazTematy;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wyglad_wiersza_tematy_komentarzy, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.itemTv.setText(mListaTematow.get(position));
    }


    @Override
    public int getItemCount() {
        return mListaTematow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           itemTv=itemView.findViewById(R.id.wiersz_nazwa_tematu);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   sluchaczKliknietegoElementuInterfaceTematy.klik_na_temat(mnumer_ksiegi, String.valueOf(ViewHolder.this.getAdapterPosition()),mListaTematow.size());
               }
           });

        }
    }


}
