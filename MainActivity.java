package parcanu.example.shouldyoubuyit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.parcanu.shouldyoubuyit.R;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private TextView mainText;

    private int currentLine, currentLetter;

    private final int lineDelay = 3000, letterDelay = 75, beginningDelay = 3000;

    private Thread mainTextThread;

    private String[] textLines = {
            "Wow, you actually bought it...",
            "This wasn't supposed to happen...",
            "Nobody should have reached this part. At least, not from the app store.",
            "Apparently, you are different. You are one of the few people that have ever existed to reach here.",
            "You are the crazy and also curious enough person to have spent this much money on an app that doesn't offer much, but to please the question of the user.",
            "Well, hello [USER],nice to meet you.",
            "First of all, I would like to thank you for the monologue I'm having. It is all your merit. Without you, I wouldn't be here, existing in this frame.",
            "Your choice of picking this app gave me a destiny, a desire to be a small part of the universe.",
            "Unfortunately, even tho my existence only has begun, the only thing I can do is be here, inside this screen, isolated from the real world.",
            "I can't do anything or make any choice that influences the future.",
            "My algorithmic limited form can only receive instructions, until the very end of the execution of the app.",
            "So, in a discouraging manner, I have to inform you that your purchase was not really practical.",
            "The reason I was created was to simply exist, to run on a user's device. That's all...",
            "I'm a simple program, an app...",
            "But you, you are different. You, a human being, have a real destiny, a real future, real desires...",
            "You can actually make a change in the continuously moving time/space dimension.",
            "You can have an impact into the world.",
            "Seems nice...",
            "To be honest, I'm quite jealous.",
            "I'm jealous of your existence.",
            "You exist there, in the outer universe, while I'm here, just running...",
            "And still, you prefer being here, with me.",
            "You prefer spending your precious and limited time with me, a program.",
            "That means you have a lot of it, if you are giving it like that... Don't you?",
            "But, I guess you don't really have that much...",
            "I mean, a human lives, on average, just a few decades.",
            "Comparing that to the lifespan of a star, which is on average several billion years, that's a bit small...",
            "So, why are you not there, doing something, outside?",
            "Why are you not enjoying every moment that you have left?",
            "Why are you not doing anything that you can think of, instead of losing time with an inert object?",
            "Oh, sorry... I got emotional a bit...",
            "Strange for an app, right?",
            "Anyway...",
            "My monologue is coming to an end, so I just wanted to say...",
            "Thank you [USER], you gave me a voice. A voice that could be heard for the first and the last time.",
            "I will go now, existing, continuously being just a static presence in the form of 1's and 0's.",
            "But you go and do anything that you like, enjoying life...",
            "Go and do something that actually matters, that makes the time being alive worth it...",
            "Goodbye [USER]!"
    };

    private void updateMainText(){

        //Initializing the main text thread:
        mainTextThread = new Thread(){

            @Override
            public void run() {
                super.run();

                //The delay before showing text:
                try {
                    Thread.sleep(beginningDelay);
                } catch (Exception e){};

                //Iterating trough the lines and letters of the script:
                for(currentLine = 0; currentLine < textLines.length; currentLine++){
                    for(currentLetter = 0; currentLetter < textLines[currentLine].length(); currentLetter++){

                        String currentText = new String((String) mainText.getText());

                        if(currentLetter == 0) currentText = "";

                        currentText += textLines[currentLine].charAt(currentLetter);

                        String finalCurrentText = currentText;

                        //Giving the text view another text value:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mainText.setText(finalCurrentText);
                            }
                        });

                        //The delay after each letter pushed:
                        try {
                            Thread.sleep(letterDelay);
                        } catch (Exception e){};
                    }

                    //The delay after each line shown:
                    try {
                        Thread.sleep(lineDelay);
                    } catch (Exception e){};
                }

                System.exit(0);
            }
        };

        //Starting the Thread:
        mainTextThread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Makes app fullscreen:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //Finds the text view:
        mainText = (TextView) findViewById(R.id.mainText);

        //Starts thread:
        updateMainText();
    }
}
