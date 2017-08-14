package com.goeat;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = (Button)findViewById(R.id.calorie_calculate_button);

        final EditText height=(EditText)findViewById(R.id.height_input),
            weight=(EditText)findViewById(R.id.weight_input),
            age=(EditText)findViewById(R.id.age_input);



        final RadioGroup gender=(RadioGroup)findViewById(R.id.gender_rg);

        final RadioButton gender_male=(RadioButton)findViewById(R.id.gender_male),
                gender_female=(RadioButton)findViewById(R.id.gender_female);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText noExercise=(EditText)findViewById(R.id.calorie_no_exercise),
                        lightExercise=(EditText)findViewById(R.id.calorie_light_exercise),
                        moderateExercise=(EditText)findViewById(R.id.calorie_moderate_exercise),
                        heavyExercise=(EditText)findViewById(R.id.calorie_heavy_exercise),
                        veryHeavyExercise=(EditText)findViewById(R.id.calorie_very_heavy_exercise);
                int selectedId = gender.getCheckedRadioButtonId();
                long result;
                double calories= 10*Integer.parseInt(weight.getText().toString()) + (6.25)*Integer.parseInt(height.getText().toString()) - 5*Integer.parseInt(age.getText().toString());
                if (selectedId==gender_male.getId()){
                    calories += 5;
                }
                else{
                    calories -= 161;
                }

                noExercise.setText(String.valueOf(Math.round(calories*1.2)));
                lightExercise.setText(String.valueOf(Math.round(calories*1.375)));
                moderateExercise.setText(String.valueOf(Math.round(calories*1.55)));
                heavyExercise.setText(String.valueOf(Math.round(calories*1.725)));
                veryHeavyExercise.setText(String.valueOf(Math.round(calories*1.9)));

            }
        });
    }


}
