package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;
    private int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryTextView = findViewById(R.id.storyTextView);
        mBottomButton = findViewById(R.id.buttonBottom);
        mTopButton = findViewById(R.id.buttonTop);

        if (savedInstanceState == null) {
            mStoryIndex = 1;
        } else {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        }
        showText();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mStoryIndex) {
                    case 1:
                    case 2:
                        mStoryIndex = 3;
                        break;
                    case 3:
                        mStoryIndex = 6;
                        break;
                    default:
                        mStoryIndex = 0;
                }
                showText();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mStoryIndex) {
                    case 1:
                        mStoryIndex = 2;
                        break;
                    case 2:
                        mStoryIndex = 4;
                        break;
                    case 3:
                        mStoryIndex = 5;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        mStoryIndex = 1;
                        break;
                    default:
                        mStoryIndex = 0;
                }
                showText();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex", mStoryIndex);
    }

    private void showText() {
        int mStoryText;
        int mButtonTopText = 0;
        int mButtonBottomText = 0;

        switch (mStoryIndex) {
            case 1:
                mStoryText = R.string.T1_Story;
                mButtonTopText = R.string.T1_Ans1;
                mButtonBottomText = R.string.T1_Ans2;
                break;
            case 2:
                mStoryText = R.string.T2_Story;
                mButtonTopText = R.string.T2_Ans1;
                mButtonBottomText = R.string.T2_Ans2;
                break;
            case 3:
                mStoryText = R.string.T3_Story;
                mButtonTopText = R.string.T3_Ans1;
                mButtonBottomText = R.string.T3_Ans2;
                break;
            case 4:
                mStoryText = R.string.T4_End;
                mButtonBottomText = R.string.T0_Ans2;
                break;
            case 5:
                mStoryText = R.string.T5_End;
                mButtonBottomText = R.string.T0_Ans2;
                break;
            case 6:
                mStoryText =R.string.T6_End;
                mButtonBottomText = R.string.T0_Ans2;
                break;
             default:
                mStoryText = R.string.T0_ERROR;
        }

        mStoryTextView.setText(mStoryText);
        if (mStoryIndex == 0) {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        } else if (mStoryIndex > 3) {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setText(mButtonBottomText);
        } else {
            mTopButton.setVisibility(View.VISIBLE);
            mBottomButton.setVisibility(View.VISIBLE);
            mTopButton.setText(mButtonTopText);
            mBottomButton.setText(mButtonBottomText);
        }
    }
}
