package com.example.android.viewpager4;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity
{
    List<Question> quesList;
    int qid=0;
    Question currentQ;



    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        initialisePaging();
    }

    private void initialisePaging()
    {

        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions(); //get all the questions from database

        //getting the id of the question
        currentQ = quesList.get(qid);
        List<FirstFragment> fragments =new Vector<FirstFragment>();
        fragments.add(FirstFragment.newInstance(0,currentQ.getQUESTION(),currentQ.getOPTA(),currentQ.getOPTB(),currentQ.getOPTC()));
        qid++;
        currentQ = quesList.get(qid);
        fragments.add(FirstFragment.newInstance(1,currentQ.getQUESTION(),currentQ.getOPTA(),currentQ.getOPTB(),currentQ.getOPTC()));
        qid++;
        currentQ = quesList.get(qid);
        fragments.add(FirstFragment.newInstance(2,currentQ.getQUESTION(),currentQ.getOPTA(),currentQ.getOPTB(),currentQ.getOPTC()));


        mPagerAdapter = new com.example.android.viewpager4.PagerAdapter(this.getSupportFragmentManager(),fragments);
         ViewPager pager =(ViewPager)findViewById(R.id.viewpager);
         pager.setAdapter(mPagerAdapter);
    }
}
