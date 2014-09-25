package gurutre.com.voicecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.ArrayList;


public class CounterActivity extends Activity {

    private static final int RESULT_SPEECH = 1;
    private int cCount;
    View.OnClickListener listener;
    Button voiceButton;
    Button plusOneButton;
    Button clearButton;

    TextView currentCount;
    TextView goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener = new ActivityListener(this);
        setContentView(R.layout.activity_counter);
        if(savedInstanceState.containsKey("count"))
            cCount = savedInstanceState.getInt("count");
        else
            cCount = 0;

        voiceButton = (Button)findViewById(R.id.voice);
        if(voiceButton!=null) voiceButton.setOnClickListener(listener);
        plusOneButton = (Button)findViewById(R.id.plus_one);
        if(voiceButton!=null) voiceButton.setOnClickListener(listener);
    }

    public void plusOneCallback(){

    }

    public void clearCallback(){

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String words = "";
                    for(String word: text) words += word+".";

                    if( text.contains("one")){
                        cCount += 1;
                    }
                }
                break;
            }
        }
    }

}
