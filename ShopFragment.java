package com.example.tech.cs622_hw4_t8;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    //private RecyclerView.Adapter adapter;
    private List<ListItem> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_shop, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        MyAdapter myAdapter = new MyAdapter(list, getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myAdapter);

        return view;

        //return inflater.inflate(R.layout.fragment_shop, null);
    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Store testStore = new Store();
        list = new ArrayList<>();
        List<Integer> itemPhotos = new ArrayList<>();
        itemPhotos.add(R.drawable.batteries);
        itemPhotos.add(R.drawable.conditioner);
        itemPhotos.add(R.drawable.dish_soap);
        itemPhotos.add(R.drawable.dog_food);
        itemPhotos.add(R.drawable.paper_towerls);
        itemPhotos.add(R.drawable.shampoo);
        itemPhotos.add(R.drawable.tide);
        //itemPhotos.add(R.drawable.tissue_box); //not using tissue box
        itemPhotos.add(R.drawable.toilet_paper);
        itemPhotos.add(R.drawable.toothpaste);
        itemPhotos.add(R.drawable.trash_bags);



        for(int i = 0; i < 10; i++)
        {
            ListItem listItem = new ListItem(
                    testStore.getItemName(i),
                    testStore.getItemPrice(i),
                    itemPhotos.get(i)
            );

            list.add(listItem);

        }
    }

}
