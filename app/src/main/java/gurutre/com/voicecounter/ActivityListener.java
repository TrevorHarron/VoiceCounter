package gurutre.com.voicecounter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by tharron on 9/18/14.
 */
public class ActivityListener implements View.OnClickListener {

    private CounterActivity context;
    private static String TAG = "Activity-Listener";
    protected static final int RESULT_SPEECH = 1;

    public ActivityListener(CounterActivity c){
        this.context = c;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.voice:
                Log.v(TAG, "Voice clicked");
                listenToVoice();
                break;
            default:
                break;
        }
    }
    private void listenToVoice() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
            Log.v(TAG,"Starting up the voice recognition");
            context.startActivityForResult(intent, RESULT_SPEECH);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "Error: Speech to Text not supported", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
