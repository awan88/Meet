package com.example.meet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.facebook.react.modules.core.PermissionListener
import org.jitsi.meet.sdk.JitsiMeetActivityInterface
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import org.jitsi.meet.sdk.JitsiMeetView
import java.net.URL

class MainActivity : AppCompatActivity(), JitsiMeetActivityInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnJoin = findViewById<Button>(R.id.button)

        val url = "https://meet.jit.si/RandomConcentrationsElevateConstantly"


//        val options = JitsiMeetConferenceOptions.Builder()
//            .setServerURL(URL(https://meet.jit.si/))
//            .setRoom("RandomConcentrationsElevateConstantly")
//            .setAudioMuted(false)
//            .setVideoMuted(false)
//            .setAudioOnly(false)
//            .setConfigOverride("awan 22", true)
//            .build()

        btnJoin.setOnClickListener {
            val view = JitsiMeetView(this)
            val options = JitsiMeetConferenceOptions.Builder()
                .setServerURL(URL(url))
                .setRoom("Breakout room #3")
                .setAudioMuted(false)
                .setVideoMuted(false)
                .setAudioOnly(false)
                .build()

            view.join(options)
            setContentView(view)
        }
    }

    override fun requestPermissions(p0: Array<out String>?, p1: Int, p2: PermissionListener?) {

    }
}