package com.example.hishigbayr.tabhost;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class LoginActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TabHost tabHost = getTabHost();

        this.setNewTab(this, tabHost, "tab1", R.string.textTabTitle1, android.R.drawable.star_off, R.id.tab1);
        this.setNewTab(this, tabHost, "tab2", R.string.textTabTitle2, android.R.drawable.star_off, R.id.tab2);


    }

    private void setNewTab(Context context, TabHost tabHost, String tag, int title, int icon, int contentID ){
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(getTabIndicator(tabHost.getContext(), title, icon)); // new function to inject our own tab layout
        tabSpec.setContent(contentID);
        tabHost.addTab(tabSpec);
    }

    private View getTabIndicator(Context context, int title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(title);
        return view;
    }

    public void clickSignUpUser(View v)
    {
        Intent intent = new Intent(LoginActivity.this, SignUpUserActivity.class);
        startActivity(intent);
    }
    public void clickSignUpDriver(View v)
    {
        Intent intent = new Intent(LoginActivity.this, SignUpDriverActivity.class);
        startActivity(intent);
    }
}
