package com.example.tuant.custombottombar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.tuant.custombottombar.fragment.CupFragment;
import com.example.tuant.custombottombar.fragment.FootballFragment;
import com.example.tuant.custombottombar.fragment.HomeFragment;
import com.example.tuant.custombottombar.fragment.NotifycationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home)
    ItemBottomBar home;

    @BindView(R.id.football)
    ItemBottomBar football;

    @BindView(R.id.cup)
    ItemBottomBar cup;

    @BindView(R.id.notifycation)
    ItemBottomBar notifycation;

    public static final int TAB_HOME = 1;
    public static final int TAB_FOOTBALL = 2;
    public static final int TAB_CUP = 3;
    public static final int TAB_NOTIFYCATION = 4;

    public int currentPostion = TAB_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setActiveTabBottom(TAB_HOME);
        changeTabBottom(TAB_HOME);
        setBackgroundActive(TAB_HOME);
    }

    @OnClick({R.id.home, R.id.football, R.id.cup, R.id.notifycation})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.home:
                setActiveTabBottom(TAB_HOME);
                changeTabBottom(TAB_HOME);
                setBackgroundActive(TAB_HOME);
                break;
            case R.id.football:
                setActiveTabBottom(TAB_FOOTBALL);
                changeTabBottom(TAB_FOOTBALL);
                setBackgroundActive(TAB_FOOTBALL);
                break;
            case R.id.cup:
                setActiveTabBottom(TAB_CUP);
                changeTabBottom(TAB_CUP);
                setBackgroundActive(TAB_CUP);
                break;
            case R.id.notifycation:
                setActiveTabBottom(TAB_NOTIFYCATION);
                changeTabBottom(TAB_NOTIFYCATION);
                setBackgroundActive(TAB_NOTIFYCATION);
                break;
            default:
                setActiveTabBottom(TAB_HOME);
                changeTabBottom(TAB_HOME);
                setBackgroundActive(TAB_HOME);
                break;
        }
    }

    public void setBackgroundActive(int index) {
        home.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.transparent ));
        football.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.transparent ));
        cup.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.transparent ));
        notifycation.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.transparent ));

        if (index == TAB_HOME) {
            home.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.white));
        } else if (index == TAB_FOOTBALL) {
            football.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.white));

        } else if (index == TAB_CUP) {
            cup.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.white));

        } else if (index == TAB_NOTIFYCATION) {
            notifycation.setBackgroundActive(ContextCompat.getColor(getApplicationContext(), R.color.white));
        }
    }

    public void setActiveTabBottom(int pos) {
        home.setActiveIcon(false);
        football.setActiveIcon(false);
        cup.setActiveIcon(false);
        notifycation.setActiveIcon(false);

        home.setActiveTextView(false);
        football.setActiveTextView(false);
        cup.setActiveTextView(false);
        notifycation.setActiveTextView(false);

        if (pos == TAB_HOME) {
            home.setActiveIcon(true);
            home.setActiveTextView(true);

        } else if (pos == TAB_FOOTBALL) {
            football.setActiveIcon(true);
            football.setActiveTextView(true);

        } else if (pos == TAB_CUP) {
            cup.setActiveIcon(true);
            cup.setActiveTextView(true);

        } else if (pos == TAB_NOTIFYCATION) {
            notifycation.setActiveTextView(true);
            notifycation.setActiveIcon(true);

        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void changeTabBottom(int index) {
        Fragment fragment = null;
        try {
            switch (index) {
                case TAB_HOME:
                    fragment = new HomeFragment();
                    break;
                case TAB_FOOTBALL:
                    fragment = new FootballFragment();
                    break;
                case TAB_CUP:
                    fragment = new CupFragment();
                    break;
                case TAB_NOTIFYCATION:
                    fragment = new NotifycationFragment();
                    break;
                default:
                    fragment = new HomeFragment();
                    break;
            }

            replaceFragment(fragment);
            setActiveTabBottom(index);
            currentPostion = index;

        } catch (Exception e) {
        }
    }
}
