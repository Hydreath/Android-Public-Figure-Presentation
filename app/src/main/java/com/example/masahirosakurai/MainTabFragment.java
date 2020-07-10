package com.example.masahirosakurai;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainTabFragment extends Fragment {

    TabbedFragmentPagerAdapter fragmentPagerAdapter;

    public MainTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_main_tab, container, false);
        //Criar TabAdapter
        fragmentPagerAdapter = new TabbedFragmentPagerAdapter(getChildFragmentManager());
        //Adicionar fragmentos ao TabAdapter
        fragmentPagerAdapter.addFragment(new FirstTabFragment(), "Factos");
        fragmentPagerAdapter.addFragment(new SecondTabFragment(), "Imagens");

        //Juntar o tabadapter ao viewpager  e o viewpager ao tablayout
        ViewPager vp = (ViewPager) ret.findViewById(R.id.view_pager);
        vp.setAdapter(fragmentPagerAdapter);
        TabLayout tabLayout = (TabLayout)ret.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vp);
        return ret;
    }

}
