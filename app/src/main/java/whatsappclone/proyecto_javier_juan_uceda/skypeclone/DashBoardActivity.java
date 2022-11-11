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
//            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setServerURL(serverURL).setFeatureFlag("welcomepage.enabled", false).build();
//            JitsiMeet.setDefaultConferenceOptions(options);


// Somewhere early in your app.
            JitsiMeetConferenceOptions defaultOptions
                    = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverURL)
                    // When using JaaS, set the obtained JWT here
                    //.setToken("MyJWT")
                    // Different features flags can be set
                    // .setFeatureFlag("toolbox.enabled", false)
                    // .setFeatureFlag("filmstrip.enabled", false)
                    .setFeatureFlag("welcomepage.enabled", false)
                    .build();


            btnJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    JitsiMeetConferenceOptions m_options = new JitsiMeetConferenceOptions.Builder().setRoom(etCodeInput.getText().toString()).build();
//                    JitsiMeetActivity.launch(getApplicationContext(), m_options);

// Build options object for joining the conference. The SDK will merge the default
// one we set earlier and this one when joining.
                    JitsiMeetConferenceOptions options
                            = new JitsiMeetConferenceOptions.Builder()
                            .setRoom(etCodeInput.getText().toString())
                            // Settings for audio and video
                            //.setAudioMuted(true)
                            //.setVideoMuted(true)
                            .build();
// Launch the new activity with the given options. The launch() method takes care
// of creating the required Intent and passing the options.
                    JitsiMeetActivity.launch(getApplicationContext(), options);


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