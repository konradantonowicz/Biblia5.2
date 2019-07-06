package pakiet.konrad.biblia52.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pakiet.konrad.biblia52.Aktywnosci.AktywnoscPokazRozdzialy;
import pakiet.konrad.biblia52.Interface.SluchaczKliknietegoElementuInterfaceRozdzialy;
import pakiet.konrad.biblia52.R;

public class AdapterRecyclerRozdzialow extends RecyclerView.Adapter<AdapterRecyclerRozdzialow.ObiektDanychHolder>
{
    private Integer Nr_Ksiegi;
    private Integer mIloscRozdzialow;
    private Context mcontext;

   private SluchaczKliknietegoElementuInterfaceRozdzialy sluchaczKliknietegoElementuInterfaceRozdzialy;


    public AdapterRecyclerRozdzialow(Context context, Integer IloscRozdzialow, Integer ksiega)
    {
        this.mIloscRozdzialow=IloscRozdzialow;
        this.mcontext=context;
      this.Nr_Ksiegi = ksiega;
    }

    @NonNull
    @Override
    public ObiektDanychHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i)
    {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.wyglad_wiersza_rozdzialow,viewGroup, false);
        return new ObiektDanychHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerRozdzialow.ObiektDanychHolder obiektDanychHolder,int position)
    {
        obiektDanychHolder.tv_rozdzial.setText(String.valueOf(position+1));
    }


    @Override
    public int getItemCount()
    {
        return mIloscRozdzialow;
    }




    public void UstawSluchaczaKliknietegoRozdzialu(AktywnoscPokazRozdzialy aktywnoscPokazRozdzialy) {
        this.sluchaczKliknietegoElementuInterfaceRozdzialy = aktywnoscPokazRozdzialy;
    }

    public class ObiektDanychHolder extends ViewHolder implements View.OnClickListener
    {
        TextView tv_rozdzial;
        ObiektDanychHolder(@NonNull View itemView)
        {
            super(itemView);

            tv_rozdzial = itemView.findViewById(R.id.tv_rozdzial);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            sluchaczKliknietegoElementuInterfaceRozdzialy.klik_na_rozdzial(Nr_Ksiegi,getAdapterPosition()+1,mIloscRozdzialow);
        }
    }
}
