package com.example.tech.cs622_hw4_t8;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

//    private TextView mTextMessage;
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_shop:
//                    mTextMessage.setText(R.string.title_shop);
//                    return true;
//                case R.id.navigation_wallet:
//                    mTextMessage.setText(R.string.title_wallet);
//                    return true;
//                case R.id.navigation_cart:
//                    mTextMessage.setText(R.string.title_cart);
//                    return true;
//            }
//            return false;
//        }
//    };

    //private RecyclerView recyclerView;
    //private RecyclerView.Adapter adapter;

    //TOASTS CAN BE USED FOR POP-UP WINDOWS (ALERT WINDOWS FOR BUDGET INPUT)
    //HOW TO IMPLEMENT THE PRIORITY AND QUANTITY?



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new WalletFragment());
    }

    //below method was private, changed to public 4/15/18
    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.navigation_shop:
                fragment = new ShopFragment();
                break;
            case R.id.navigation_wallet:
                fragment = new WalletFragment();
                break;
            case R.id.navigation_cart:
                fragment = new CartFragment();
                break;
        }


        return loadFragment(fragment);
    }
}
