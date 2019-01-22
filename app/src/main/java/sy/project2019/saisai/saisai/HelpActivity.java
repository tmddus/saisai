package sy.project2019.saisai.saisai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
<<<<<<< HEAD
<<<<<<< HEAD

        pager= (ViewPager)findViewById(R.id.mainViewpager);

        //ViewPager에 설정할 Adapter 객체 생성

        //ListView에서 사용하는 Adapter와 같은 역할.

        //다만. ViewPager로 스크롤 될 수 있도록 되어 있다는 것이 다름

        //PagerAdapter를 상속받은 CustomAdapter 객체 생성

        //CustomAdapter에게 LayoutInflater 객체 전달

        HelpAdapter adapter= new HelpAdapter(getLayoutInflater());
        //ViewPager에 Adapter 설정

        pager.setAdapter(adapter);
=======
>>>>>>> parent of 2f6d597... 뷰페이저(앱 사용 방법) 구현
=======
>>>>>>> parent of 2f6d597... 뷰페이저(앱 사용 방법) 구현
    }
}
