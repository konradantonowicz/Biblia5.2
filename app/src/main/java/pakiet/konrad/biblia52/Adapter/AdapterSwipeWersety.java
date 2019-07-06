package pakiet.konrad.biblia52.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import pakiet.konrad.biblia52.Fragmenty.FragmentPokazWersety;

public class AdapterSwipeWersety extends FragmentStatePagerAdapter
{
    Integer m_ilosc_rozdzialow;
    public AdapterSwipeWersety(FragmentManager supportFragmentManager, int ilosc_rozdzialow) {
        super(supportFragmentManager);
        this.m_ilosc_rozdzialow=ilosc_rozdzialow;
    }

    @Override
    public int getCount() {
        return m_ilosc_rozdzialow;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentPokazWersety();
        Bundle   bundle   =new Bundle();
        bundle.putString("autalna_strona_swipe", String.valueOf(position+1));
        fragment.setArguments(bundle);

        return fragment;
    }



}