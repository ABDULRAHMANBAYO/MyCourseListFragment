package com.example.mycourselistfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mycourselistfragment.data.Course;
import com.example.mycourselistfragment.data.CourseData;

public class CourseDetailActivity extends AppCompatActivity {
    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);


        if (savedInstanceState == null) {
            Bundle extra= getIntent().getExtras();

            int position = extra.getInt("course_id");
            course = new CourseData().coursesList().get(position);

            Toast.makeText(getApplicationContext(),"Position: " + position,Toast.LENGTH_SHORT).show();

            CourseDetailFragment courseDetailFragment = new CourseDetailFragment();
            courseDetailFragment.setArguments(extra);

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .add(R.id.detailContainer, courseDetailFragment)
                    .commit();
        }
    }
}
