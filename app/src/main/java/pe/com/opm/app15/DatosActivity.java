package pe.com.opm.app15;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

public class DatosActivity extends AppCompatActivity {



    TextView nombre;
    ProfilePictureView profilePictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        Intent intent = getIntent();


        nombre = (TextView) findViewById(R.id.tv_nombre_face);
        profilePictureView = (ProfilePictureView) findViewById(R.id.imageFace);

        nombre.setText(intent.getStringExtra("nombre"));
        profilePictureView.setProfileId(intent.getStringExtra("userId"));




    }
}
