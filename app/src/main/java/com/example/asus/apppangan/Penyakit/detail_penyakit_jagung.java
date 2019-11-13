package com.example.asus.apppangan.Penyakit;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.apppangan.DBHelper;
import com.example.asus.apppangan.R;

public class detail_penyakit_jagung extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    ImageView imageView;
    TextView tv_deskripsip;
    TextView tv_idpenyakit;
    TextView tv_nama_penyakit;
    TextView tv_pencegahanp;
    TextView tv_penyebabp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_detail_penyakit);
        this.dbHelper = new DBHelper(this);
        this.tv_idpenyakit = (TextView) findViewById(R.id.tv_idpenyakit);
        this.tv_nama_penyakit = (TextView) findViewById(R.id.tv_nama_penyakit);
        this.tv_deskripsip = (TextView) findViewById(R.id.tv_deskripsip);
        this.tv_penyebabp = (TextView) findViewById(R.id.tv_penyebabp);
        this.tv_pencegahanp = (TextView) findViewById(R.id.tv_pencegahanp);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.cursor = this.dbHelper.getReadableDatabase().rawQuery("SELECT * FROM penyakitjagung WHERE namapenyakit = " + getIntent().getStringExtra("namapenyakit"), null);
        this.cursor.moveToFirst();
        if (this.cursor.getCount() > 0) {
            this.cursor.moveToPosition(0);
            this.imageView.setImageResource(this.cursor.getInt(this.cursor.getColumnIndex("gambar")));
            this.tv_idpenyakit.setText(this.cursor.getString(0).toString());
            this.tv_nama_penyakit.setText(this.cursor.getString(1).toString());
            this.tv_deskripsip.setText(this.cursor.getString(2).toString());
            this.tv_penyebabp.setText(this.cursor.getString(3).toString());
            this.tv_pencegahanp.setText(this.cursor.getString(4).toString());
        }
    }
}
