package com.example.tictactoe;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private View winningLine;
    private GridLayout gridLayout;
    int flag = 0;
    int count = 0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    boolean isGameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        winningLine = findViewById(R.id.winningLine);
        gridLayout = findViewById(R.id.gridLayout);
        initButton();
    }

    private void initButton() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
    }

    public void check(View v) {
        if (isGameOver) return;
        Button btnCurrent = (Button) v;

        if (btnCurrent.getText().toString().equals("")) {
            count++;

            // Tap animation
            ScaleAnimation scale = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scale.setDuration(200);
            btnCurrent.startAnimation(scale);

            if (flag == 0) {
                btnCurrent.setText("X");
                btnCurrent.setTextColor(ContextCompat.getColor(this, R.color.playerX));
                flag = 1;
            } else {
                btnCurrent.setText("O");
                btnCurrent.setTextColor(ContextCompat.getColor(this, R.color.playerO));
                flag = 0;
            }

            if (count > 4) {
                b1 = button1.getText().toString();
                b2 = button2.getText().toString();
                b3 = button3.getText().toString();
                b4 = button4.getText().toString();
                b5 = button5.getText().toString();
                b6 = button6.getText().toString();
                b7 = button7.getText().toString();
                b8 = button8.getText().toString();
                b9 = button9.getText().toString();

                //Winning Conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    showWin(b1, 1);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    showWin(b4, 2);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    showWin(b7, 3);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    showWin(b1, 4);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    showWin(b2, 5);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    showWin(b3, 6);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    showWin(b1, 7);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    showWin(b3, 8);
                } else if (count == 9) {
                    Toast.makeText(this, "Match is Draw", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(this::newGame, 1500);
                }
            }
        }
    }

    private void showWin(String winner, int condition) {
        isGameOver = true;
        Toast.makeText(this, "Winner is: " + winner, Toast.LENGTH_SHORT).show();

        drawWinningLine(condition);

        new Handler().postDelayed(this::newGame, 2500);
    }

    private void drawWinningLine(int condition) {
        winningLine.setVisibility(View.VISIBLE);
        float gridWidth = gridLayout.getWidth();
        float gridHeight = gridLayout.getHeight();

        winningLine.setPivotX(0);
        winningLine.setPivotY(winningLine.getHeight() / 2f);

        switch (condition) {
            case 1: // Row 1
                winningLine.setTranslationY(button1.getY() + button1.getHeight() / 2f);
                winningLine.setTranslationX(button1.getX());
                winningLine.setRotation(0);
                break;
            case 2: // Row 2
                winningLine.setTranslationY(button4.getY() + button4.getHeight() / 2f);
                winningLine.setTranslationX(button4.getX());
                winningLine.setRotation(0);
                break;
            case 3: // Row 3
                winningLine.setTranslationY(button7.getY() + button7.getHeight() / 2f);
                winningLine.setTranslationX(button7.getX());
                winningLine.setRotation(0);
                break;
            case 4: // Col 1
                winningLine.setTranslationX(button1.getX() + button1.getWidth() / 2f);
                winningLine.setTranslationY(button1.getY());
                winningLine.setRotation(90);
                break;
            case 5: // Col 2
                winningLine.setTranslationX(button2.getX() + button2.getWidth() / 2f);
                winningLine.setTranslationY(button2.getY());
                winningLine.setRotation(90);
                break;
            case 6: // Col 3
                winningLine.setTranslationX(button3.getX() + button3.getWidth() / 2f);
                winningLine.setTranslationY(button3.getY());
                winningLine.setRotation(90);
                break;
            case 7: // Diagonal 1
                winningLine.setTranslationX(button1.getX());
                winningLine.setTranslationY(button1.getY());
                winningLine.setRotation(45);
                winningLine.setScaleX(1.4f);
                break;
            case 8: // Diagonal 2
                winningLine.setTranslationX(button3.getX() + button3.getWidth());
                winningLine.setTranslationY(button3.getY());
                winningLine.setRotation(135);
                winningLine.setScaleX(1.4f);
                break;
        }

        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        winningLine.startAnimation(fadeIn);
    }

    public void restartGame(View v) {
        newGame();
    }

    public void newGame() {
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        winningLine.setVisibility(View.INVISIBLE);
        winningLine.setScaleX(1.0f);
        count = 0;
        flag = 0;
        isGameOver = false;
    }
}