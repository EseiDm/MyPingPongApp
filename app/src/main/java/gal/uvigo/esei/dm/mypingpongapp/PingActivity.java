package gal.uvigo.esei.dm.mypingpongapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PingActivity extends AppCompatActivity {

    public static final int PONG_REQUEST_CODE = 0;
    public static final String PING_PONG_DATA_EXTRA_KEY = "PING_PONG_DATA_EXTRA_KEY";
    private PingPongData pingPongData=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ping_layout);

        MyCustomPingPongApplication myCustomPingPongApplication = (MyCustomPingPongApplication)getApplication();
        myCustomPingPongApplication.setMyCustomValue("Round " + 0);
        TextView textView =findViewById(R.id.textViewRoundPing);
        textView.setText(myCustomPingPongApplication.getMyCustomValue());


        Button button = findViewById(R.id.buttonPong);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPongActivity();
            }
        });
    }

    private void launchPongActivity() {
        Intent intent = new Intent(getBaseContext(), PongActivity.class);
        if (pingPongData==null)
            pingPongData = new PingPongData(0, "Hola desde Ping!");
        else{
            pingPongData.setCounter(pingPongData.getCounter()+1);
            pingPongData.setValue("Hola desde Ping!");
        }
        intent.putExtra(PING_PONG_DATA_EXTRA_KEY, pingPongData);
        startActivityForResult(intent,PONG_REQUEST_CODE);

    }

    @Override
    protected void onResume() {
        MyCustomPingPongApplication myCustomPingPongApplication = (MyCustomPingPongApplication)getApplication();
        TextView textView =findViewById(R.id.textViewRoundPing);
        textView.setText(myCustomPingPongApplication.getMyCustomValue());
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PONG_REQUEST_CODE){
            pingPongData = (PingPongData) data.getSerializableExtra(PING_PONG_DATA_EXTRA_KEY);
            TextView textView= findViewById(R.id.textViewCounterPing);
            textView.setText(pingPongData.getCounter()+"");
            Toast.makeText(getBaseContext(), pingPongData.getValue(), Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
