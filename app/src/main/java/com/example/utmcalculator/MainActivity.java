package com.example.utmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
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

        courseGradeET.addTextChangedListener(new EditTextChangeText());
        courseCreditET.addTextChangedListener(new EditTextChangeText());
        courseGrade2ET.addTextChangedListener(new EditTextChangeText());
        courseCredit2ET.addTextChangedListener(new EditTextChangeText());

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
        int credit=0;
        String grade="E";
        Double gradePoint=0.0;
        boolean displayPoint = true;
        boolean displayPoint2 = true;

        // check whether both the fields are empty or not for first Course
        if (isEmpty(courseCreditET.length())) {
            courseCreditET.setError("This field is required");
            displayPoint = false;
        }
        if (isEmpty(courseGradeET.length())){
            courseGradeET.setError("This field is required");
            displayPoint = false;
        }

        // check whether both the fields are empty or not for second Course
        if (isEmpty(courseCredit2ET.length())) {
            courseCredit2ET.setError("This field is required");
            displayPoint2 = false;
        }
        if (isEmpty(courseGrade2ET.length())){
            courseGrade2ET.setError("This field is required");
            displayPoint2 = false;
        }

        if(displayPoint==true) {
            credit = Integer.parseInt(courseCreditET.getText().toString());
            grade = courseGradeET.getText().toString();
            gradePoint = credit * getGradePoint(grade);
            gradePointTV.setText(gradePoint.toString());
        }
        else gradePointTV.setText("0.0");

        if(displayPoint2==true) {
            credit = Integer.parseInt(courseCredit2ET.getText().toString());
            grade = courseGrade2ET.getText().toString();
            gradePoint = credit * getGradePoint(grade);
            gradePoint2TV.setText(gradePoint.toString());
            Log.d("Test","Line 125");
        }
        else gradePoint2TV.setText("0.0");

    }

    class EditTextChangeText implements TextWatcher{
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            displayGradePoint();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

}