package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier
    .fillMaxSize()
        .wrapContentSize(Alignment.Center)
){
    var currentStep by remember { mutableStateOf(4) }

    when(currentStep){
        1 -> Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.lemon_tree_content_description),
                Modifier.background(color = Color.Green).padding(16.dp).wrapContentSize()
                    .clickable { currentStep = 2 },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.lemon_tree_text),
                fontSize = 18.sp,
            )
        }
        2 -> Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_squeeze),
                contentDescription = stringResource(R.string.lemon_content_description),
                Modifier.background(color = Color.Green).padding(16.dp).wrapContentSize()
                    .clickable { currentStep = 3 },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.lemon_text),
                fontSize = 18.sp,
                )
        }
        3 -> Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_drink),
                contentDescription = stringResource(R.string.lemonade_content_description),
                Modifier.background(color = Color.Green).padding(16.dp)
                    .wrapContentSize()
                    .clickable { currentStep = 4 },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.lemonade_text),
                fontSize = 18.sp,
                )
        }
        else -> Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_restart),
                contentDescription = stringResource(R.string.glass_content_description),
                Modifier.padding(16.dp)
                    .background(color = Color(204, 255, 169))
                    .wrapContentSize()
                    .clickable {
                        currentStep = 1
                    }
                    .border(border = BorderStroke(2.dp, Color(105, 205, 216)),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(4.dp)),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.glass_text),
                fontSize = 18.sp,
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}