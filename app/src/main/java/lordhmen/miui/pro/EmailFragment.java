package lordhmen.miui.pro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailFragment extends Fragment {
    private Button buttonSend;
    private EditText textSubject;
    private EditText textMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_email, container, false);
        buttonSend = (Button) rootView.findViewById(R.id.buttonSend);
        textSubject = (EditText) rootView.findViewById(R.id.editTextSubject);
        textMessage = (EditText) rootView.findViewById(R.id.editTextMessage);

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"lordhmen@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //для того чтобы запросить email клиент устанавливаем тип
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, getString(R.string.emailclient)));

            }
        });
        TextView telegram1 = (TextView) rootView.findViewById(R.id.telegram1);

        telegram1.setText(Html.fromHtml("Telegram: <a href='https://t.me/joinchat/DdYe5UOfUc3GoHTK-IctYg'>MIUI8-Free</a>"));

        telegram1.setMovementMethod(LinkMovementMethod.getInstance());

        return rootView;
    }


}