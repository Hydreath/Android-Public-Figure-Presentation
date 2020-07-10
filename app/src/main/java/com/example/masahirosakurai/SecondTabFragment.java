package com.example.masahirosakurai;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondTabFragment extends Fragment {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.i1, R.drawable.i2,
            R.drawable.i3,R.drawable.i4
            ,R.drawable.i5,R.drawable.i6};

    public SecondTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_tab, container, false);
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

        init(view);

        // Inflate the layout for this fragment
        return view;
    }

    //Adicionar Imagens ao SlidingImageAdapter
    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }

    //Juntar o adapter ao viewpager para adicionar as imagens ao slider
    private void init(View view) {
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(getContext(),imageModelArrayList));
        final float density = getResources().getDisplayMetrics().density;
    }

}
