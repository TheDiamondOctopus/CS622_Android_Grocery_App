package com.example.tech.cs622_hw4_t8;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class CartFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<CartData> list;
    static ShoppingCart cartFragmentCart = MyAdapter.getTempCart();
    static Budget userBudget = WalletFragment.getTestBudget();


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewCart);

        final CartAdapter cartAdapter = new CartAdapter(list, getContext());
        //final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);

        TextView cost = (TextView) view.findViewById(R.id.costAmount);
        cost.setText(cartFragmentCart.getCost());//This TextView, since it only sets on the creation of this fragment,
                                                //it does not update when you hit the plus/minus buttons on the Quantity.
                                                //It only updates when you navigate to another panel, and then navigate back, and the fragment gets created again.

        final Button checkoutBtn = (Button) view.findViewById(R.id.checkoutButton);

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cartFragmentCart.checkoutCart(userBudget);
                    //getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CartFragment());


                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });


        return view;

        //return inflater.inflate(R.layout.fragment_shop, null);
    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        int photo = R.drawable.batteries;


        for(int i = 0; i < cartFragmentCart.getCartSize(); i++) {
           /* CartData cartData = new CartData(
                    "Item Name " + (i+1),
                    "11.99",
                    "2",
                    "1"
            );*/

           if(cartFragmentCart.getName(i) == "Batteries")
               photo = R.drawable.batteries;
           else if(cartFragmentCart.getName(i) == "Conditioner")
               photo = R.drawable.conditioner;
           else if(cartFragmentCart.getName(i) == "Dish Soap")
               photo = R.drawable.dish_soap;
           else if(cartFragmentCart.getName(i) == "Dog Food")
               photo = R.drawable.dog_food;
           else if(cartFragmentCart.getName(i) == "Paper Towels")
               photo = R.drawable.paper_towerls;
           else if(cartFragmentCart.getName(i) == "Shampoo")
               photo = R.drawable.shampoo;
           else if(cartFragmentCart.getName(i) == "Laundry Detergent")
               photo = R.drawable.tide;
           else if(cartFragmentCart.getName(i) == "Toilet Paper")
               photo = R.drawable.toilet_paper;
           else if(cartFragmentCart.getName(i) == "Toothpaste")
               photo = R.drawable.toothpaste;
           else if(cartFragmentCart.getName(i) == "Conditioner")
               photo = R.drawable.trash_bags;

            CartData cartData = new CartData(
                    cartFragmentCart.getName(i),
                    cartFragmentCart.getPrice(i),
                    cartFragmentCart.getQuantity(i).toString(),
                    cartFragmentCart.getPriority(i).toString(),
                    //cartFragmentCart.getCost().toString(),
                    cartFragmentCart.getPurchasedFlag(i),
                    photo
            );

            list.add(cartData);
        }
    }
}
