package com.igk.heysup.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import io.getstream.chat.android.client.models.Filters
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme

@AndroidEntryPoint
class ChannelListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatTheme {
                ChannelsScreen(
                    filters = Filters.`in`(
                        fieldName = "type",
                        values = listOf("gaming","messaging","commerce","team","livestream",)
                    ),
                    title = "Channel List",
                    isShowingSearch = true,
                    onItemClick = {channel->
                        startActivity(MessageActivity.getIntent(this, channelId = channel.cid))
                    },
                    onBackPressed = {finish()}
                )
            }
        }
    }
}

