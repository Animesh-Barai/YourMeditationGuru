package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MediList extends AppCompatActivity {
        //https://bit.ly/2ZvQdGq

    ArrayList Musictitle = new ArrayList<String>();
    ArrayList MusicImage = new ArrayList<>();
//    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
//    ArrayList personImages = new ArrayList<>(Arrays.asList("https://bit.ly/2ZvQdGq",
//            "https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq",
//            "https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq",
//            "https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq",
//            "https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq",
//            "https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_list);

        Intent intent = getIntent();
        String user_name = intent.getStringExtra("id");
       // FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Music");

        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot
//                        collectMusicTitles( dataSnapshot.getValue());
//                        System.out.println(dataSnapshot.getValue());
                        for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                            String category = (String) messageSnapshot.child("Category").getValue();
                            System.out.println("can u see mee"+category+user_name);
                            if (category.equals(user_name))
                            {
                                String name = (String) messageSnapshot.child("Name").getValue();
                                String imgurl = (String) messageSnapshot.child("ImageUrl").getValue();

                                useValue(name,imgurl);

                            }
                            //System.out.println(name+imgurl);

                        }



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });



        Handler handler=new Handler();
        int delay=2000;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!Musictitle.isEmpty())
                {

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                    recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                    //  call the constructor of CustomAdapter to send the reference and data to Adapter
                    musicListAdapter customAdapter = new musicListAdapter(MediList.this, Musictitle,MusicImage);
                    recyclerView.setAdapter(customAdapter);

                }else
                    handler.postDelayed(this,delay);
            }
        },delay);


    }

    private void useValue(String name, String imgurl)
    {
        Musictitle.add(name);
        MusicImage.add(imgurl);

    }

//
//    private void collectMusicTitles(Map<String,Object>Music) {
//
//
//        //iterate through each user, ignoring their UID
//        for (Map.Entry<String, Object> entry : Music.entrySet()){
//
//            //Get user map
//            Map singleUser = (Map) entry.getValue();
//            //Get phone field and append to list
//            Musictitle.add((Long) singleUser.get("Name"));
//        }
//        for (Map.Entry<String, Object> entry : Music.entrySet()){
//
//            //Get user map
//            Map singleUser = (Map) entry.getValue();
//            //Get phone field and append to list
//            MusicImage.add((Long) singleUser.get("ImageUrl"));
//        }


//        private void collectMusicTitles(Object value) {
//
//
////            //iterate through each user, ignoring their UID
////            for (Map.Entry<String, Object> entry : Music.entrySet()){
////
////                //Get user map
////                Map singleUser = (Map) entry.getValue();
////                //Get phone field and append to list
////                Musictitle.add((Long) singleUser.get("Name"));
////            }
////            for (Map.Entry<String, Object> entry : Music.entrySet()){
////
////                //Get user map
////                Map singleUser = (Map) entry.getValue();
////                //Get phone field and append to list
////                MusicImage.add((Long) singleUser.get("ImageUrl"));
//            }
}
//
