package gal.uvigo.esei.dm.mypingpongapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PongActivity extends AppCompatActivity {
    PingPongData pingPongData=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pong_layout);


        pingPongData = (PingPongData)getIntent().getSerializableExtra(PingActivity.PING_PONG_DATA_EXTRA_KEY);
        TextView textView = findViewById(R.id.textViewCounterPong);
        textView.setText(pingPongData.getCounter()+"");

        MyCustomPingPongApplication myCustomPingPongApplication = (MyCustomPingPongApplication)getApplication();
        myCustomPingPongApplication.setMyCustomValue("Round " + (pingPongData.getCounter()+1));
        textView =findViewById(R.id.textViewRoundPong);
        textView.setText(myCustomPingPongApplication.getMyCustomValue());


        Toast.makeText(getBaseContext(), pingPongData.getValue(), Toast.LENGTH_SHORT).show();
        Button button = findViewById(R.id.buttonPing);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPingActivity();
            }
        });

    }

    private void launchPingActivity() {
        pingPongData.setCounter(pingPongData.getCounter()+1);
        pingPongData.setValue("Hola desde Pong!");
        Intent intent=new Intent();
        intent.putExtra(PingActivity.PING_PONG_DATA_EXTRA_KEY, pingPongData);
        setResult(PingActivity.PONG_REQUEST_CODE, intent);
        finish();
    }
}
