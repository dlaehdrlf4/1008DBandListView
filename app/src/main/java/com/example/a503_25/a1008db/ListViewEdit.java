package com.example.a503_25.a1008db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewEdit extends AppCompatActivity {

    //ListView 출력을 위한 변수
    private List<String> list;
    private ListView listView;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_edit);

        list = new ArrayList<>();
        list.add("cobe brayent");

        //adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,list);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,list);
        listView = (ListView)findViewById(R.id.listView);
        //listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        Button insert = (Button)findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.word);

                //입력한 내용의 공백을 제거하고 가져오기
                String word = editText.getText().toString().trim();
                if(word.length() == 0){
                    Toast.makeText(ListViewEdit.this,"삽입할 단어를 입력하세요",Toast.LENGTH_LONG).show();
                    return;
                }
                list.add(word);
                //리스트 뷰 다시 출력
                adapter.notifyDataSetChanged();
            }
        });/*
        //싱글 삭제
        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선택된 행 번호 가져오기
                int pos = listView.getCheckedItemPosition();
                //선택한 행 번호가 List 안의 번호인지 확인해서 아니면 리턴
                if(pos < 0 || pos >= list.size()){
                    Toast.makeText(ListViewEdit.this,"선택하고 삭제를 누르세요 !!",Toast.LENGTH_LONG).show();
                    return;
                }
                //데이터를 삭제
                list.remove(pos);*/
        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //선택 여부를 배열로 받아오기
        SparseBooleanArray sb = listView.getCheckedItemPositions();
        //순서대로 접근해서 삭제
       /* for(int i=0;i<sb.size();i=i+1) {
            Toast.makeText(ListViewEdit.this,sb.get(i) + "",Toast.LENGTH_LONG).show();
            if (sb.get(i) == true) {*/
              //  list.remove(i);
        //    }
        //}
                //뒤에서부터 삭제를 수행해야 합니다.
                //for(int i = 0; i<listView.getCount() ; i=i+1){
                    //if(sb.get(listView.getCount()-(i+1))){
                        //list.remove(listView.getCount()-(i+1));
                    //}
                //}
                for(int i = listView.getCount()-1; i>=0; i=i-1){
                    if(sb.get(i)){
                        list.remove(i);
                    }
                }

                adapter.notifyDataSetChanged();
                listView.clearChoices();
                Toast.makeText(ListViewEdit.this,"삭제성공 뜨룹뜨룹뜨룹",Toast.LENGTH_LONG).show();
            }
        });
   }
}
