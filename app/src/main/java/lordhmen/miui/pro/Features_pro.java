package lordhmen.miui.pro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class Features_pro extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.features_pro, container, false);
        final TextView textView = (TextView) rootView.findViewById(R.id.features_pro);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DefaultHttpClient hc = new DefaultHttpClient();
                    ResponseHandler response = new BasicResponseHandler();
                    HttpGet http = new HttpGet("https://rawgit.com/Wileyfox-Swift-MIUI/MIUI-Pro/master/Features-Pro");
                    final String features_pro = (String) hc.execute(http, response);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(Html.fromHtml(features_pro));
                        }
                    });
                } catch (IOException e) {
                    Log.e("ch", e.toString());
                    e.printStackTrace();
                }
            }
        }).start();

        return rootView;
    }

}
