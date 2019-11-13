package com.example.asus.apppangan.Panduan;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.asus.apppangan.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class Detail_Panduan extends AppCompatActivity {


    String ju,de;

    public HtmlTextView judll, dekspp;

    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__panduan);

        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();


        judll = (HtmlTextView) findViewById(R.id.judullll);
        dekspp = (HtmlTextView) findViewById(R.id.deskripsiiiii);

        Bundle extras = getIntent().getExtras();

        ju =extras.getString("judul");
        de = extras.getString("deskripsi");

        judll.setText(Html.fromHtml(ju));
        dekspp.setText(Html.fromHtml(de));


    }
}
