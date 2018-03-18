package android.fanharil.com.fanharilardian_1202150022_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listDataMahasiswa(View view) {
        Toast.makeText(this, "List Data Mahasiswa terpilih",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(
                MainActivity.this, ListNamaMahasiswa.class);
        startActivity(intent);

    }

    public void pencariGambar(View view) {
        Toast.makeText(this, "Pencari Gambar terpilih",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(
                MainActivity.this, PencariGambar.class);
        startActivity(intent);
    }
}
