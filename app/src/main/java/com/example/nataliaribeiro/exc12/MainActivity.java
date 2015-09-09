package com.example.nataliaribeiro.exc12;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Spinner;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "br.usjt.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void listarVoo(View view) {

        String sp = "São Paulo/Rio de Janeiro: 9h" +
                "\nSão Paulo/Rio de Janeiro: 11h" +
                "\nSão Paulo/Rio de Janeiro: 13h";

        String rj = "Rio de Janeiro/São Paulo: 15h" +
                "\nRio de Janeiro/São Paulo: 17h" +
                "\nRio de Janeiro/São Paulo: 19h";

        Intent intent = new Intent(this, Voo.class);
        Spinner spinnerOrigem = (Spinner)findViewById(R.id.spinnerOrigem);
        String origem = spinnerOrigem.getSelectedItem().toString();
        Spinner spinnerDestino = (Spinner)findViewById(R.id.spinnerDestino);
        String destino = spinnerDestino.getSelectedItem().toString();

        if((origem.equals("Sao Paulo")) && (destino.equals("Rio de Janeiro"))) {
            intent.putExtra(EXTRA_MESSAGE, sp);

        }
        if((origem.equals("Rio de Janeiro")) && (destino.equals("Sao Paulo"))) {
            intent.putExtra(EXTRA_MESSAGE, rj);

        }

        startActivity(intent);
    }
}
