package com.example.utmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText courseNameET, courseCreditET, courseGradeET;
    EditText courseName2ET, courseCredit2ET, courseGrade2ET;

    TextView gradePointTV, gradePoint2TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseNameET = (EditText) findViewById(R.id.courseNameET);
        courseCreditET = (EditText) findViewById(R.id.courseCreditET);
        courseGradeET = (EditText) findViewById(R.id.courseGradeET);
        courseName2ET = (EditText) findViewById(R.id.courseName2ET);
        courseCredit2ET = (EditText) findViewById(R.id.courseCredit2ET);
        courseGrade2ET = (EditText) findViewById(R.id.courseGrade2ET);

        gradePointTV = (TextView) findViewById(R.id.coursePointTV);
        gradePoint2TV = (TextView) findViewById(R.id.coursePoint2TV);

        Button calculateBtn = (Button) findViewById(R.id.calculateGPABtn);
        Button resetBtn = (Button) findViewById(R.id.resetBtn);

        displayGradePoint();

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int credit = Integer.parseInt(courseCreditET.getText().toString());
                String grade = courseGradeET.getText().toString();
                Double gradePoint = credit*getGradePoint(grade);
                gradePointTV.setText(gradePoint.toString());
            }
        });

    }

    private Double getGradePoint(String grade){
        Double gradePoint=0.0;
        switch (grade){
            case "A+": gradePoint=4.0;
                       break;
            case "A":  gradePoint= 4.0;
                       break;
            case"A-":  gradePoint= 3.67;
                       break;
            case"B+":  gradePoint= 3.33;
                       break;
            case "B":  gradePoint= 3.00;
                       break;
            case "B-": gradePoint=2.67;
                       break;
            case "C+": gradePoint=2.33;
                       break;
            case "C":  gradePoint=2.0;
                       break;
            case "C-": gradePoint=1.67;
                       break;
            case "D+": gradePoint=1.33;
                       break;
            case "D":  gradePoint=1.00;
                       break;
            case "D-": gradePoint=0.67;
                       break;
            case "E":  gradePoint=0.0;
                       break;
        }
        return gradePoint;
    }

    private boolean isEmpty(int stringLength) {
        if (stringLength==0) return true;
        return false;
    }

    private void displayGradePoint(){
        courseGradeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        courseGrade2ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean displayPoint = true;
                // check whether both the fields are empty or not
                if (isEmpty(courseCredit2ET.length())) {
                    courseCredit2ET.setError("This field is required");
                    displayPoint = false;
                }
                if (isEmpty(courseCredit2ET.length())){
                    courseCredit2ET.setError("This field is required");
                    displayPoint = false;
                }

                if(displayPoint==true) {
                    int credit = Integer.parseInt(courseCredit2ET.getText().toString());
                    String grade = courseGrade2ET.getText().toString();
                    Double gradePoint = credit * getGradePoint(grade);
                    gradePoint2TV.setText(gradePoint.toString());
                }
            }
        });

    }

}