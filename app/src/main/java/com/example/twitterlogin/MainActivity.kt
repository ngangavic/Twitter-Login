package com.example.twitterlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.TwitterConfig
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Twitter.initialize(this)

        val config = TwitterConfig.Builder(this)
            .logger(DefaultLogger(Log.DEBUG))
            .twitterAuthConfig(TwitterAuthConfig("QofiFEEDdUVPtAmpTTc0AyAw1", "q6fKdh2wZlVaSYrXBwRCnD8MJpom6ZOt7r67otfsafW7EVZqx8"))
            .debug(true)
            .build()
        Twitter.initialize(config)


    }
}
