package com.example.fordv.fordquizchallenges;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.fordv.fordquizchallenges.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.fordv.fordquizchallenges.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private TextView mApiLevelTextView;

    private Button mShowAnswerButton;
    private static final String KEY_CHEATER = "Cheater";
    private boolean mAnswerShown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mApiLevelTextView = (TextView) findViewById(R.id.current_api_level_text_view);
        mApiLevelTextView.setText("API Level is " + Build.VERSION.SDK_INT);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);



        setAnswerShownResult(false);
        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswerShownResult(true);
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}