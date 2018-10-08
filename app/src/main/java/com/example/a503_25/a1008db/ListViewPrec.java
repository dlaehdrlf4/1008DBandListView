package com.example.a503_25.a1008db;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewPrec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_prec);

        //출력할 데이터 배열이나 List 생성
        String [] player = {"르브론","커리","커존스","크리스 폴","데릭 로즈","코비브라이언트","스티븐 내쉬","테이텀","제임스하든"};

        /*ArrayList<String> list = new ArrayList<>();
        list.add("");
        */

        //위의 데이터를 가지고 Adapter 생성
        //첫번째 매개변수 Context
        //두번째는 출력할 셀의 모양 : 제공되는 모샹 사용
        //세번째는 출력할 데이터
        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,player);


        //ListView에 위의 Adapter을 연결
        ListView listView = (ListView)findViewById(R.id.listView);

        // 2번의 방법
       ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.player, android.R.layout.simple_list_item_1);
       listView.setAdapter(adapter);

       listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
       listView.setDivider(new ColorDrawable(Color.RED));
       listView.setDividerHeight(3);

       listView.setOnItemClickListener(new ListView.OnItemClickListener(){
           @Override
           //첫번째 매개변수는 이벤트가 발생한 객체
           //두번째 매개변수는 항목 뷰 - 선택한 항목의 뷰
           //세번째 매개변수는 클릭한 항목 뷰의 인덱스
           //네번째 매개변수는 항목 뷰의 아이디
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(ListViewPrec.this, position + "번째 선택",Toast.LENGTH_LONG).show();
           }
       });
    }
}
