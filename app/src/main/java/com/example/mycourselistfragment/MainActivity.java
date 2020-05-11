package com.example.mycourselistfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.mycourselistfragment.data.Course;

public class MainActivity extends AppCompatActivity implements CourseListFragment.Callbacks {
    private boolean isTwoPage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.detailContainer) != null) {
            isTwoPage = true;
        }
    }

    @Override
    public void onItemSelected(Course course, int position) {
        if (isTwoPage) {
            Bundle bundle = new Bundle();
            bundle.putInt("course_id", position);

            FragmentManager fragmentManager = getSupportFragmentManager();
            CourseDetailFragment fragment = new CourseDetailFragment();
            fragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.detailContainer, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(MainActivity.this, CourseDetailActivity.class);
            intent.putExtra("course_id", position);
            startActivity(intent);

        }

    }
}
