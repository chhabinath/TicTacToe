// Import necessary packages and classes
package com.chhabinath.tictactoe;

// Import AppCompatActivity class from the androidx.appcompat.app package
import androidx.appcompat.app.AppCompatActivity;

// Import classes for Bundle, View, Button, and Toast
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// MainActivity class extending AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Declaration of Button variables for each grid position
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    // String variables to store X or O in each grid position
    String b1;
    String b2;
    String b3;
    String b4;
    String b5;
    String b6;
    String b7;
    String b8;
    String b9;

    // Flag to toggle between X and O
    int flag = 0;

    // Counter to keep track of the number of moves
    int count = 0;

    TextView textView;

    // onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the content view to activity_main layout

        init(); // Call the init method to initialize buttons


    }

    // Method to initialize buttons
    private void init(){
        // Initialize each Button variable with corresponding view ID
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        textView = findViewById(R.id.result);
    }

    // Method to check for winning condition or draw
    @SuppressLint("SetTextI18n")
    public void check(View view){
        Button currentButton = (Button) view;


        // Check if the current button is empty
        if(currentButton.getText().toString().equals("")){
            count++; // Increment move counter
            // Toggle between X and O
            if(flag == 0){
                currentButton.setText("X");
                currentButton.setTextColor(Color.parseColor("#015981"));
                flag = 1;
            }else {
                currentButton.setText("O");
                currentButton.setTextColor(Color.parseColor("#FF9800"));
                flag = 0;
            }

            // Check for winning conditions or draw after 5 moves
            if(count > 4){
                // Get text of each button to check for winning conditions
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                // Check for all possible winning conditions or draw
                if(b1.equals(b2) && b2.equals(b3) && !b1.equals("")){ // first column
                    Toast.makeText(this,"Winner is: "+b1,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b1);
//                    newGame(); // Start a new game
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")){ // mid column
                    Toast.makeText(this,"Winner is: "+b4,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b4);
//                    newGame();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")){ // last column
                    Toast.makeText(this,"Winner is: "+b7,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b7);
//                    newGame();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")){ // first row
                    Toast.makeText(this,"Winner is: "+b1,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b1);
//                    newGame();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")){ // mid row
                    Toast.makeText(this,"Winner is: "+b2,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b2);
//                    newGame();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")){ // last row
                    Toast.makeText(this,"Winner is: "+b3,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b3);
//                    newGame();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")){ // left Diagonal
                    Toast.makeText(this,"Winner is: "+b1,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is :"+b1);
//                    newGame();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")){ // right diagonal
                    Toast.makeText(this,"Winner is: "+b3,Toast.LENGTH_SHORT).show();
                    textView.setText("Winner is : "+b3);
//                    newGame();
                } else if(count == 9){ // draw Condition
                    Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
                    textView.setText("Draw");
                    newGame();
                }
            }
        }
    }

    // Method to start a new game
    public void newGame(){
        // Reset text of all buttons, move counter, and flag
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        textView.setText("");
        count = 0;
        flag = 0;
    }

    public void resetGame(View view){
        newGame();
    }


}
