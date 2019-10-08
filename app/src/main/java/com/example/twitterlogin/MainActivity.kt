package com.example.twitterlogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.TwitterCore
import com.twitter.sdk.android.core.identity.TwitterLoginButton


class MainActivity : AppCompatActivity() {

    lateinit var btnLogin:TwitterLoginButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = TwitterConfig.Builder(this)
            .logger(DefaultLogger(Log.DEBUG))
            .twitterAuthConfig(TwitterAuthConfig("", ""))
            .debug(true)
            .build()
        Twitter.initialize(config)
        setContentView(R.layout.activity_main)

        btnLogin=findViewById(R.id.login_button)
        btnLogin.setCallback(object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                val session = TwitterCore.getInstance().sessionManager.activeSession
                val authToken = session.authToken
                Toast.makeText(applicationContext,"Auth token: "+authToken,Toast.LENGTH_SHORT).show()

                loginMethod(session)
            }

            override fun failure(exception: TwitterException) {
                Toast.makeText(getApplicationContext(),"Login fail", Toast.LENGTH_LONG).show()
                exception.printStackTrace()
            }
        })


    }

    private fun loginMethod(session: TwitterSession?) {
        val userName = session?.userName
        Toast.makeText(this,"User name is "+userName,Toast.LENGTH_LONG).show()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result to the login button.
        btnLogin.onActivityResult(requestCode, resultCode, data);
    }
}
