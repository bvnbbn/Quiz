package com.example.android.viewpager4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vikas on 6/19/2016.
 */
public class FirstFragment extends Fragment {
    // Store instance variables
    private String question;
    private String radio_1,radio_2,radio_3;

    private int page;



    List<Question> quesList;

    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;


    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String question,String radio_1,String radio_2,String radio_3)
    {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("some_question", question);
        args.putString("some_option1",radio_1);
        args.putString("some_option1",radio_2);
        args.putString("some_option1",radio_3);

        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        DbHelper db = new DbHelper(getContext());
        quesList = db.getAllQuestions(); //get all the questions from database

        //getting the id of the question
        currentQ = quesList.get(qid);
        page = getArguments().getInt("someInt", 0);
        question = getArguments().getString("some_question",currentQ.getQUESTION());
        radio_1=getArguments().getString("some_option1", currentQ.getOPTA());
        radio_2=getArguments().getString("some_option2", currentQ.getOPTB());
        radio_3=getArguments().getString("some_option3", currentQ.getOPTC());
        qid++;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        TextView question_view = (TextView) view.findViewById(R.id.question_id);
        question_view.setText(question);
        rda=(RadioButton)view.findViewById(R.id.radioButton1);
        rdb=(RadioButton)view.findViewById(R.id.radioButton2);
        rdc=(RadioButton)view.findViewById(R.id.radioButton3);
        rda.setText(radio_1);
        rdb.setText(radio_2);
        rdc.setText(radio_3);
        return view;
    }
}
