package com.example.mycourselistfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.mycourselistfragment.data.Course;
import com.example.mycourselistfragment.data.CourseArrayAdapter;
import com.example.mycourselistfragment.data.CourseData;
import com.example.mycourselistfragment.util.ScreenUtility;

import java.util.List;

public class CourseListFragment extends ListFragment {
    List<Course> courses = new CourseData().coursesList();

    private Callbacks activity;

    public CourseListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility = new ScreenUtility((getActivity()));

        Log.d("Width :", String.valueOf(screenUtility.getDpHeight()));

        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_listitem, courses);
        setListAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_list_fragment, container, false);
        return view;
    }

    public interface Callbacks {
        public void onItemSelected(Course course,int position);

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Course course = courses.get(position);
        this.activity.onItemSelected(course,position);


//        Toast.makeText(getActivity(),"Name:" + course.getCourseName(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (Callbacks) context;
    }
}
