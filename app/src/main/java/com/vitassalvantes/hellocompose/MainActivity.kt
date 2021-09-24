package com.vitassalvantes.hellocompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitassalvantes.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                MessageCard(
                    Message(
                        "Colleague",
                        "Hey, take a look at Jetpack Compose, It's great!"
                    )
                )
            }
        }
    }

    class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        // Add padding around our message
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    // Add border to image
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text(
                        text = msg.body,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(all = 4.dp)
                    )
                }
            }
        }
    }

    @Preview(
        showSystemUi = true,
        name = "Normal Mode"
    )
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showSystemUi = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        HelloComposeTheme {
            MessageCard(Message("Android", "Hello Compose!"))
        }
    }
}