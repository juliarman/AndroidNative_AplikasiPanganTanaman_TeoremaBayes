package com.example.asus.apppangan.Konsultasi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.asus.apppangan.DBHelper;
import com.example.asus.apppangan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hasil_konsultasi_padi extends AppCompatActivity  {


    protected ListAdapter adapter;
    protected Cursor cursor1;
    protected Cursor cursor2;
    protected Cursor cursor3;
    DBHelper dbHelper;
    protected ListView list_view;
    String namapenyakit_terbesar;
    String[] penyakit_terpilih;
    double prob_aturan;
    double prob_baru;
    double prob_hasil;
    double prob_lama;
    double prob_pembagi;
    double prob_penyakit;
    double prob_terbesar;
    double[] probabilitas_terpilih;
    TextView text1;
    TextView text2;
    double total_pembagi;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


       int i;
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_hasil_konsultasi_padi);

        this.dbHelper = new DBHelper(this);

        SQLiteDatabase db = this.dbHelper.getReadableDatabase();

        this.list_view = (ListView) findViewById(R.id.lv_namapenyakit);
        this.cursor1 = db.rawQuery("SELECT p.namapenyakit from rulepadi r inner join penyakitpadi p on r.id_penyakit = p.id_penyakit inner join gejalapadi g on r.id_gejala = g.id_gejala where g.namagejala in (" + getIntent().getStringExtra("namagejala") + ") group by p.namapenyakit order by namapenyakit ASC", null);
        this.penyakit_terpilih = new String[this.cursor1.getCount()];
        this.probabilitas_terpilih = new double[this.cursor1.getCount()];
        for (i = 0; i < this.cursor1.getCount(); i++) {

            int j;
            this.cursor1.moveToPosition(i);
            this.penyakit_terpilih[i] = this.cursor1.getString(0);
            this.cursor2 = db.rawQuery("SELECT r.probabilitas from rulepadi r inner join penyakitpadi p on r.id_penyakit  = p.id_penyakit inner join gejalapadi g on r.id_gejala = g.id_gejala where g.namagejala  in(" + getIntent().getStringExtra("namagejala") + ") AND p.namapenyakit = '" + this.penyakit_terpilih[i] + "'", null);
            this.cursor3 = db.rawQuery("SELECT  p.probabilitas from penyakitpadi p inner join rulepadi r on r.id_penyakit  = p.id_penyakit inner join gejalapadi g on r.id_gejala = g.id_gejala where g.namagejala  in(" + getIntent().getStringExtra("namagejala") + ") AND p.namapenyakit = '" + this.penyakit_terpilih[i] + "'", null);
            int jmlh = this.cursor2.getCount();

            if (jmlh == 1) {
                this.cursor2.moveToFirst();
                this.cursor3.moveToNext();
                this.prob_aturan = this.cursor2.getDouble(0);
                this.prob_penyakit = this.cursor3.getDouble(0);
                this.prob_pembagi = this.prob_aturan * this.prob_penyakit;
                this.prob_hasil = this.prob_pembagi;
                this.probabilitas_terpilih[i] = this.prob_hasil;
                if (this.prob_terbesar < this.prob_hasil) {
                    this.prob_terbesar = this.prob_hasil;
                    this.namapenyakit_terbesar = this.penyakit_terpilih[i];
                }
            } else if (jmlh > 1) {
                int jj = 1;
                for (j = 0; j < this.cursor2.getCount(); j++) {
                    this.cursor2.moveToPosition(j);
                    if (jj == 1) {
                        this.cursor2.moveToFirst();
                        this.cursor3.moveToNext();
                        this.prob_aturan = this.cursor2.getDouble(0);
                        this.prob_penyakit = this.cursor3.getDouble(0);
                        this.prob_pembagi = this.prob_aturan * this.prob_penyakit;
                    } else if (jj == 2) {
                        this.prob_baru = this.cursor2.getDouble(0);
                        this.prob_pembagi = this.prob_baru * this.prob_pembagi;
                        if (jmlh == 2) {
                            this.prob_hasil = this.prob_pembagi;
                            this.probabilitas_terpilih[i] = this.prob_hasil;
                            if (this.prob_terbesar < this.prob_hasil) {
                                this.prob_terbesar = this.prob_hasil;
                                this.namapenyakit_terbesar = this.penyakit_terpilih[i];
                            }
                        }
                    } else if (jj >= 3) {
                        this.prob_lama = this.prob_pembagi;
                        this.prob_baru = this.cursor2.getDouble(0);
                        this.prob_pembagi = this.prob_baru * this.prob_lama;
                        if (jmlh == jj) {
                            this.prob_hasil = this.prob_pembagi;
                            this.probabilitas_terpilih[i] = this.prob_hasil;
                            if (this.prob_terbesar < this.prob_hasil) {
                                this.prob_terbesar = this.prob_hasil;
                                this.namapenyakit_terbesar = this.penyakit_terpilih[i];
                            }
                        }
                    }
                    jj++;
                }
            }
            this.total_pembagi += this.prob_pembagi;
        }
        List<HashMap<String, String>> ListHsl = new ArrayList<>();
        for (i = 0; i < this.penyakit_terpilih.length; i++) {
            int j;
            for (j = i + 1; j < this.penyakit_terpilih.length; j++) {
                if (this.probabilitas_terpilih[j] > this.probabilitas_terpilih[i]) {
                    double t = this.probabilitas_terpilih[i];
                    this.probabilitas_terpilih[i] = this.probabilitas_terpilih[j];
                    this.probabilitas_terpilih[j] = t;
                    String tmp = this.penyakit_terpilih[i];
                    this.penyakit_terpilih[i] = this.penyakit_terpilih[j];
                    this.penyakit_terpilih[j] = tmp;
                }
            }
            HashMap<String, String> hm = new HashMap();
            hm.put("lv_namapnyakit", this.penyakit_terpilih[i]);
            hm.put("listview_jumlah", String.format("%.2f%%", new Object[]{Double.valueOf((this.probabilitas_terpilih[i] / this.total_pembagi) * 100.0d)}));
            ListHsl.add(hm);
        }
        String[] from = new String[]{"lv_namapnyakit", "listview_jumlah"};
        int[] to = new int[]{R.id.lv_namapenyakit, R.id.listview_jumlah};
        this.list_view = (ListView) findViewById(R.id.lv_viewpenyakit);
        this.adapter = new SimpleAdapter(getBaseContext(), ListHsl, R.layout.listview_hasil, from, to);
        this.list_view.setAdapter(this.adapter);
        this.list_view.setTextFilterEnabled(true);
        this.text1 = (TextView) findViewById(R.id.textView2);
        this.text2 = (TextView) findViewById(R.id.textView3);
        this.text1.setText(String.format("%.2f%%", new Object[]{Double.valueOf((this.prob_terbesar / this.total_pembagi) * 100.0d)}));
        this.text2.setText(this.namapenyakit_terbesar);
    }



    /*public void prosesapadi(View view) {
        String nama_penyakit = ((TextView) view.findViewById(R.id.textView3)).getText().toString();
        Intent i = new Intent(this, detail_penyakit_padi.class);
        i.putExtra("namapenyakit", '\"' + nama_penyakit + '\"');
        startActivity(i);
    }
    */


}