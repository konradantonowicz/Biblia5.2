package pakiet.konrad.biblia52.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class AdapterSwipeKomentarz extends FragmentPagerAdapter
{
    private List<Fragment> fragments;
    public AdapterSwipeKomentarz(FragmentManager supportFragmentManager, List<Fragment> fragments)
    {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position)
    {
        return fragments.get(position);
    }

    @Override
    public int getCount()
    {
        return fragments.size();
    }
}
