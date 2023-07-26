package com.igk.heysup.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.igk.heysup.activity.ui.theme.HeySupTheme
import dagger.hilt.android.AndroidEntryPoint
import io.getstream.chat.android.compose.ui.messages.MessagesScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@AndroidEntryPoint
class MessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val channelId = intent.getStringExtra(KEY_CHANNEL_ID)

        if(channelId==null){
            finish()
            return
        }

        setContent {
            ChatTheme {
                MessagesScreen(
                    channelId = channelId,
                    messageLimit = 30,
                    onBackPressed = {finish()}
                )
            }
        }
    }
    companion object{
        private const val KEY_CHANNEL_ID = "channelId"

        fun getIntent(context: Context,channelId:String):Intent{
            return Intent(context, MessageActivity::class.java).apply{
                putExtra(KEY_CHANNEL_ID,channelId)
            }
        }
    }
}

