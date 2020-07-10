package com.example.masahirosakurai;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    BottomNavigationView navigation;

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.mybutton);
        Drawable icon = getResources().getDrawable(R.drawable.ic_home_black_24dp);
        icon.setColorFilter(getResources().getColor(R.color.colorDarkModeText), PorterDuff.Mode.SRC_IN);
        item.setIcon(icon);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mybutton:
                changeFragment(new IntroFragment(), View.INVISIBLE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_descricao:
                    changeFragment(new DescricaoFragment(), View.VISIBLE);
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.menu_cur:
                    changeFragment(new MainTabFragment(), View.VISIBLE);
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.menu_jogos:
                    changeFragment(new GamesFragment(), View.VISIBLE);
                    //mTextMessage.setText(R.string.menu_descricao);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntroFragment frag = new IntroFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentReplace, frag, frag.getTag()).commit();

        //mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setVisibility(View.INVISIBLE);
    }

    public void changeFragment(Fragment f, int visible){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().setCustomAnimations(R.animator.fade_in, R.animator.fade_out).replace(R.id.fragmentReplace, f, f.getTag()).commit();
        navigation.setVisibility(visible);
    }

}
