package kr.ac.yeonsung.seoj.mobile1_project_0926;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t_user, t_email; //사용자이름, 이메일주소

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnInfo = findViewById(R.id.btn_info); //사용자 정보입력
        btnInfo.setOnClickListener(btnListener);
        t_user = findViewById(R.id.text_user);
        t_email = findViewById(R.id.text_email);

    }
    //버튼이 클릭되면 온클릭 리스너 실행됨
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            View toastView = View.inflate(MainActivity.this, R.layout.toast_cancel,null);
            View dlgView = View.inflate(MainActivity.this, R.layout.dialog_user_info,null);
            EditText edit_user = dlgView.findViewById(R.id.edittext_username);
            EditText edit_email = dlgView.findViewById(R.id.edittext_email);
            edit_user.setText(t_user.getText().toString());
            edit_email.setText(t_email.getText().toString());
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle(R.string.dialog_title); //<string name="dialog_title">사용자 정보입력</string>
            dlg.setIcon(R.drawable.ic_user);
            dlg.setView(dlgView);
            //대화상자안에 취소버튼을 넣으면 토스트가 보이게 함
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast t = new Toast(MainActivity.this);
                    t.setView(toastView);
                    t.setDuration(Toast.LENGTH_SHORT);
                    t.show();

                }
            });
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String userName = edit_user.getText().toString();
                    String userEmail = edit_email.getText().toString();
                    t_user.setText(userName);
                    t_email.setText(userEmail);
                }
            });
            dlg.show();
            //다이얼로그에 필요한 뷰를 작성하려면 dialog_user_info.xml 리소스파일 추가해서 더 작성해야함
        }
    };
}
//7장 끝 8,9장 공부할 필요없음!!!!!!!!!!!!
