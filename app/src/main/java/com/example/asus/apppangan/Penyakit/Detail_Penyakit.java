package com.example.asus.apppangan.Penyakit;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;

import com.example.asus.apppangan.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class Detail_Penyakit extends AppCompatActivity {

    String judulpenyakit,deskripsipenyakit;

    public HtmlTextView judll, dekspp;

    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__penyakit);


        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();


        judll = (HtmlTextView) findViewById(R.id.judulpenyakit);
        dekspp = (HtmlTextView) findViewById(R.id.deskripsipenyakit);

        Bundle extras = getIntent().getExtras();

        judulpenyakit =extras.getString("judul");
        deskripsipenyakit = extras.getString("deskripsi");

        judll.setText(Html.fromHtml(judulpenyakit));
        dekspp.setText(Html.fromHtml(deskripsipenyakit));

    }
}
