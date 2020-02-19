package com.example.tech.cs622_hw4_t8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<ListItem> listItems;
    private Context context;

    //Code from or similar to original shopping cart program
    private Store testStore = new Store();
    private List<String> storeItems = new ArrayList<String>();
    private static ShoppingCart tempCart = new ShoppingCart();

    public static ShoppingCart getTempCart() {
        return tempCart;
    }

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        for(int i = 0; i < 10; i++)
        {
            storeItems.add(testStore.getItemName(i));
        }

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.itemImgView.setImageResource(listItem.getPhoto());

        //The code for handling the addItemBtn which is a button that adds
        //an item to the shopping cart list.
        //**********WHEN IMPLEMENTING THE BELOW CODE TO ADD AN ITEM TO THE SHOPPING CART,
        //MAKE SURE THAT HITTING THE "ADD ITEM" BUTTON ONLY ADDS AN ITEM ONCE
        //AND DOES NOT CHANGE ITS QUANTITY. CHANGING THE QUANTITY MUST BE DONE
        //ON THE CART FRAGMENT.*************

        holder.addItemBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //holder.textViewHead.setText("Changed!");

                String tempS = holder.textViewDesc.getText().toString();//This grabs the price of the item.

                try{
                    if(tempCart.getCartSize() != 0){
                        boolean tempB = true;

                        for(int i = 0; i < (tempCart.getCartSize());i++){
                            if(holder.textViewHead.getText().toString() == tempCart.getName(i)){
                                //Context context1 = view.getContext();//COULD BE AN ISSUE HERE WITH THE V REF?
                                String text = "ITEM ALREADY ADDED";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                tempB = false;
                                System.out.println("entered toast block");
                            }
                        }

                        if(tempB)
                        {
                            tempCart.createItem(holder.textViewHead.getText().toString(), 1, 1, tempS);
                            String text = "ITEM ADDED";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            System.out.println(holder.textViewHead.getText().toString() + "****added to cart in 1st if****");
                            tempCart.displayList();

                        }

                        //tempCart.createItem(holder.textViewDesc.getText().toString(), 1, 1, tempS);
                        //*******ADD CODE HERE THAT UPDATES THE COST TEXT VIEW IN THE CART FRAGMENT*************
                    }
                    else{
                        tempCart.createItem(holder.textViewHead.getText().toString(), 1, 1, tempS);
                        String text = "ITEM ADDED";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        System.out.println(holder.textViewHead.getText().toString() + "****added to cart in else****");
                        //*******ADD CODE HERE THAT UPDATES THE COST TEXT VIEW IN THE CART FRAGMENT*************
                    }

                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

                //Toast that says Item Added

                //Toast that says Item Already Added
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView itemImgView;
        Button addItemBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            this.textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            this.itemImgView = (ImageView) itemView.findViewById(R.id.img_contact);
            this.addItemBtn = (Button) itemView.findViewById(R.id.addItem);
        }
    }
}
