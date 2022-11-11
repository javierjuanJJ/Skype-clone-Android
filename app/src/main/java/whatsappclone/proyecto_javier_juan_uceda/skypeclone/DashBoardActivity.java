package whatsappclone.proyecto_javier_juan_uceda.skypeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DashBoardActivity extends AppCompatActivity {

    private EditText etCodeInput;
    private Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        setUI();

    }

    private void setUI() {
        etCodeInput = findViewById(R.id.etCodeInput);
        btnJoin = findViewById(R.id.btnJoin);

        try {
            URL serverURL;

            serverURL = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setServerURL(serverURL).build();
            JitsiMeet.setDefaultConferenceOptions(options);
            btnJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    JitsiMeetConferenceOptions m_options = new JitsiMeetConferenceOptions.Builder().setRoom(etCodeInput.getText().toString()).build();
                    JitsiMeetActivity.launch(getApplicationContext(), m_options);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}