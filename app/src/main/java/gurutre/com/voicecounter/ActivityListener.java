package gurutre.com.voicecounter;

import android.content.Context;
import android.view.View;

/**
 * Created by tharron on 9/18/14.
 */
public class ActivityListener implements View.OnClickListener {

    private CounterActivity context;

    public ActivityListener(CounterActivity c){
        this.context = c;
    }

    @Override
    public void onClick(View view) {

    }
}
