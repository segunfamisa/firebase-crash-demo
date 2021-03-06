package com.segunfamisa.firebasecrash.launchpadbuild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private Button mCrashButton;
    private CheckBox mCheckCatchError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup views
        mCrashButton = (Button) findViewById(R.id.button_crash);
        mCheckCatchError = (CheckBox) findViewById(R.id.checkbox_catch_error);


        mCrashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if catch error checkbox is checked, do a try-catch
                if (mCheckCatchError.isChecked()) {
                    try {
                        // do some dangerous operations that throw an exception
                        throw new Exception("Handled exception in button click");
                    } catch (Exception e) {
                        // handle exception
                        e.printStackTrace();
                    }
                } else {
                    // cause an exception
                    causeNullPointerException();
                }
            }
        });
    }

    /**
     * Throws a new null pointer exception
     */
    private void causeNullPointerException() {
        throw new NullPointerException("NullPointerException has been thrown");
    }
}
