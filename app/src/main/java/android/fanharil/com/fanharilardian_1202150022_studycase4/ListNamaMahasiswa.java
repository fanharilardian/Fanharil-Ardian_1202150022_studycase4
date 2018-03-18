package android.fanharil.com.fanharilardian_1202150022_studycase4;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNamaMahasiswa extends AppCompatActivity {
    private String[] names = {
            "Fanharil",
            "Ridho",
            "Ardian",
            "Naruto",
            "Sasuke",
            "Hinata",
            "Gaara",
            "Luffy",
            "Robby",
            "Kakashi",
            "Suci",
            "Didi",
            "Bumi",
            "Rizaldi",
            "Punky"
    };
    ListView listView;

    // BARU
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_nama_mahasiswa);

        // BARU
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        //new MyTask().execute();

    }

    public void onClick(View v) {
        // membuat objek baru untuk kelas MyTask
        MyTask myTask = new MyTask();
        // disable tombol ketika di tap
        button.setEnabled(false);
        // jalankan kode pada class MyTask
        myTask.execute();

    }

    class MyTask extends AsyncTask<Void, String, String> {

        ArrayAdapter<String> adapter;
        ProgressBar progressBar;

        //BARU
        ProgressDialog progressDialog;
        Context context;
        TextView textView;
        Button button;

        MyTask() {
            this.context = context;
            this.textView = textView;
            this.button = button;
        }

        int count;

        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) listView.getAdapter();

            progressBar = (ProgressBar) findViewById(R.id.progress_bar);
            progressBar.setMax(15);
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);
            count = 0;
        }

        /*@Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("Download in Progress...");
            progressDialog.setMax(15);
            progressDialog.setProgress(0);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }
        */


        @Override
        protected String doInBackground(Void... params) {
            for (String Name : names) {

                try {
                    Thread.sleep(200);
                    publishProgress(Name);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "All the Names were added Successfully";
        }

        /*@Override
        protected String doInBackground(Void... params) {
            int i = 0;
            synchronized (this) {
                while (i<16) {
                    try {
                        i++;
                        wait(300);
                        publishProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return "Download complete...";
        }
        */

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            progressBar.setProgress(count);

        }

        /*@Override
        protected void onProgressUpdate(Integer... values) {
            int progress = values[0];
            progressDialog.setProgress(progress);
            textView.setText("Download in Progress...");
        }*/

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }

        /*@Override
        protected void onPostExecute(String result) {
            textView.setText(result);
            button.setEnabled(true);
            progressDialog.hide();
        }*/

    }

}
