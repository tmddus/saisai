package sy.project2019.saisai.saisai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    String clientId = "SbRr_H2ViieimDdws4SB";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "ixus2XgXQM";//애플리케이션 클라이언트 시크릿값";

    ImageView jpRec;
    ImageView korRec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        jpRec = findViewById(R.id.jp_record);
        korRec = findViewById(R.id.kor_record);
        jpRec.setOnClickListener(recListner);
        korRec.setOnClickListener(recListner);
=======
        ImageView helpBtn = findViewById(R.id.helpBtn);

        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            }
        });

>>>>>>> parent of 2f6d597... 뷰페이저(앱 사용 방법) 구현

    }

    View.OnClickListener recListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                String source;
                String target;

                String transResult;

                if(v.getId() == R.id.jp_record) {
                    source = "ja";
                    target = "ko";
                } else{
                    source="ko";
                    target = "ja";
                }
                TextView targetText = findViewById(R.id.transTest);

                String text = URLEncoder.encode(targetText.getText().toString(), "UTF-8");
                String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                // post request
                String postParams = "source="+source +"&target="+target+"&text=" + text;
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(postParams);
                wr.flush();
                wr.close();
                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                transResult = response.toString();
                targetText.setText(transResult);


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

}
