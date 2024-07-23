package com.example.mytestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.mytestapp.ui.theme.MyTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(color = MaterialTheme.colorScheme.primary) {
                        CreateBizzCard()
                    }
                }
            }
        }
    }
}

@Composable
fun CreateBizzCard(){
    val showPort = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardColors(
                contentColor = Color.Black,
                containerColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Magenta
            ),
            ){
            Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(modifier = Modifier
                    .size(150.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                    shape = CircleShape,
                    border = BorderStroke(0.5.dp, Color.Red),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                ) {
                    Image(painter = painterResource(id = R.drawable.profile_image), contentDescription = "Profile Image", modifier = Modifier.size(135.dp),
                        contentScale = ContentScale.Crop)
                }
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(thickness = 2.dp)
                Spacer(modifier = Modifier.height(8.dp))
                CreateInfo()
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    shape = RectangleShape,
                    onClick = {
                        showPort.value = !showPort.value
                    }
                ) {
                    Text(text = "Portfolio")
                }

                if(showPort.value){
                    ShowPortfolio()
                }


            }
        }
    }
}

@Preview
@Composable
private fun ShowPortfolio(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)), border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(dataProject = listOf("Project 1","Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(dataProject: List<String>) {
    LazyColumn{
        items(dataProject){ item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(5.dp)
            ){
                Surface(modifier = Modifier
                    .padding(3.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                    color = Color.Cyan,
                    shape = RoundedCornerShape(corner = CornerSize(5.dp)), border = BorderStroke(width = 2.dp, color = Color.LightGray)
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile_image),
                            contentDescription = "Profile Image",
                            modifier = Modifier.size(135.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.align(Alignment.CenterVertically)) {
                            Text(text = item, style = MaterialTheme.typography.bodyMedium)
                            Text(text = "Good", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Enrique F.",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Mobile Developer", style = MaterialTheme.typography.bodyMedium)
        Text(text = "@_kike_18", style = MaterialTheme.typography.bodySmall)

    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTestAppTheme {
        CreateBizzCard()
    }
}