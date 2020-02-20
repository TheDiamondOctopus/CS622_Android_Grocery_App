package com.example.tech.cs622_hw4_t8;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WalletFragment extends Fragment {

    private View view;
    private TextView budgetDisplay;
    private TextView budgetInput;
    private static Budget testBudget = new Budget(); //Do i need to make this static??***** comment added 4/10/18
                                                //Look into onPause() and onSaveInstanceState() for the above

    private static ShoppingCart walletCart = MyAdapter.getTempCart();
    public static Budget getTestBudget(){
        return testBudget;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wallet, null);

        budgetDisplay = (TextView) view.findViewById(R.id.budgetDisplay);
        budgetInput = (TextView) view.findViewById(R.id.budgetInput);
        final Button submitBudget = (Button) view.findViewById(R.id.submitBudget);
        budgetDisplay.setText("$" + testBudget.getUserBudget());

        submitBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //"works" now, but still some underlying issues shown in console
                //New Issue: Budget does not stay in text view, and does not stay in object.
                //Seems like new Budget instance created every time we leave that fragment and enter
                //a new budget.
                try {
                    if (walletCart.getCartSize() == 0) {

                        if (testBudget.setUserBudget(budgetInput.getText().toString())) {
                            //budgetDisplay.setText("$" + budgetInput.getText());
                            //testBudget.setUserBudget(budgetInput.getText().toString()); //this didn't work in keeping the budget from changing after items were added to cart
                            budgetDisplay.setText("$" + testBudget.getUserBudget());
                            testBudget.displayUserBudget();
                            Context context = view.getContext();
                            String text = "Budget Submitted";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            Context context = view.getContext();
                            String text = "INVALID INPUT";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }
                    else{
                        Context context = view.getContext();
                        String text = "IITEMS ALREADY ADDED, BUDGET CANNOT BE RESET";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                //budgetDisplay.setText("$" + budgetInput.getText() + ".00");
            }
        });

        return view;
    }
}
