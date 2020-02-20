package com.example.tech.cs622_hw4_t8;

//import android.app.Fragment; //changed 4/15/18
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Callable;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<CartData> cartModelData;
    private Context context;
    private ShoppingCart cartAdapterCart = MyAdapter.getTempCart();


    public CartAdapter(List<CartData> cartModelData, Context context) {
        this.cartModelData = cartModelData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_cart, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final CartData cartData = cartModelData.get(position);

        holder.itemName.setText(cartData.getItemName());
        holder.itemPrice.setText(cartData.getItemPrice());
        holder.itemQuantity.setText(cartData.getItemQuantity());
        holder.itemPriority.setText(cartData.getItemPriority());
        holder.itemImg.setImageResource(cartData.getPhoto());
        //holder.costAmount.setText(cartData.getCostAmount());
        //holder.costAmount.setText("99");

        for(int i = 0; i < cartAdapterCart.getCartSize(); i++)
        {
            if(cartAdapterCart.getPurchasedFlag(i) == true)
            {
                holder.purchasedFlag.setText("Purchased");
            }
        }


        //********Buttons for Priority, Quantity, and Checkout Below**********
        //Increase Quantity Button
        holder.incQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cartAdapterCart.incQuantity(cartAdapterCart, holder.itemName.getText().toString());

                    for(int i = 0; i < cartAdapterCart.getCartSize(); i++) {
                        if(cartAdapterCart.getName(i) == holder.itemName.getText().toString()) {
                            holder.itemQuantity.setText(cartAdapterCart.getQuantity(i).toString());
                            //holder.itemQuantity.setText("99");
                            //holder.costAmount.setText(cartAdapterCart.getCost().toString());
                            System.out.println(cartAdapterCart.getQuantity(i).toString());

                            //added 4/17/18
                            notifyAll();
                        }
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

        //Decrease Quantity Button
        holder.decQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cartAdapterCart.decQuantity(cartAdapterCart, holder.itemName.getText().toString());
                    for(int i = 0; i < cartAdapterCart.getCartSize(); i++) {
                        if(cartAdapterCart.getName(i) == holder.itemName.getText().toString()){
                            holder.itemQuantity.setText(cartAdapterCart.getQuantity(i).toString());

                            //added 4/171/8
                            notifyAll();
                        }
                    }

                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

        //Increase Priority
        holder.incPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cartAdapterCart.incPriority(cartAdapterCart, holder.itemName.getText().toString());
                    for(int i = 0; i < cartAdapterCart.getCartSize(); i++) {
                        if(cartAdapterCart.getName(i) == holder.itemName.getText().toString()){
                            holder.itemPriority.setText(cartAdapterCart.getPriority(i).toString());

                            //added 4/171/8
                            notifyAll();
                        }
                    }

                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

        //Decrease Priority
        holder.decPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    cartAdapterCart.decPriority(cartAdapterCart, holder.itemName.getText().toString());
                    for(int i = 0; i < cartAdapterCart.getCartSize(); i++) {
                        if(cartAdapterCart.getName(i) == holder.itemName.getText().toString()){
                            holder.itemPriority.setText(cartAdapterCart.getPriority(i).toString());

                            //added 4/17/18
                            notifyAll();
                        }
                    }

                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return cartModelData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView itemName;
        public TextView itemPrice;
        public TextView itemQuantity;
        public TextView itemPriority;
        public ImageView itemImg;

        //public TextView costAmount;
        public TextView purchasedFlag;

        //BUTTONS BELOW
        Button incQuantity;
        Button decQuantity;
        Button incPriority;
        Button decPriority;

        //Button checkoutBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            this.itemName = (TextView) itemView.findViewById(R.id.itemName); //ADDED THIS TO THESE FIVE LINES AT 6:29PM ON 4/11/18, IN CASE THINGS SUDDENLY DON'T WORK
            this.itemPrice = (TextView) itemView.findViewById(R.id.itemPrice);
            this.itemQuantity = (TextView) itemView.findViewById(R.id.quantityText);
            this.itemPriority = (TextView) itemView.findViewById(R.id.priorityText);
            this.itemImg = (ImageView) itemView.findViewById(R.id.itemImg);

            //this.costAmount = (TextView) itemView.findViewById(R.id.costAmount);

            this.purchasedFlag = (TextView) itemView.findViewById(R.id.purchasedFlag);

            //BUTTONS BELOW
            this.incQuantity = (Button) itemView.findViewById(R.id.incQuantity);
            this.decQuantity = (Button) itemView.findViewById(R.id.decQuantity);
            this.incPriority = (Button) itemView.findViewById(R.id.incPriority);
            this.decPriority = (Button) itemView.findViewById(R.id.decPriority);

            //this.checkoutBtn = (Button) itemView.findViewById(R.id.checkoutButton);
        }
    }
}
