package com.example.mycourselistfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.mycourselistfragment.data.Course;
import com.example.mycourselistfragment.data.CourseArrayAdapter;
import com.example.mycourselistfragment.data.CourseData;
import com.example.mycourselistfragment.util.ScreenUtility;

import java.util.List;
import java.util.zip.Inflater;

public class MyFragment extends ListFragment {
    List<Course> courses = new CourseData().coursesList();

    public MyFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility = new ScreenUtility((getActivity()));

        Log.d("Width :",screenUtility.getDpHeight());

        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_listitem, courses);
        setListAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        return view;
    }
}
