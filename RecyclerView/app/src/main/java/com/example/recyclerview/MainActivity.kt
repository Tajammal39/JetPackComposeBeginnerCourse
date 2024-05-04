package com.example.recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recyclerview.ui.theme.RecyclerViewTheme
import com.example.recyclerview.DataSource as DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListItem(data = dummyData())
                }
            }
        }
    }
}

@Composable
fun ListItem(data: List<DataSource>){
    LazyColumn(Modifier.fillMaxSize()) {
        itemsIndexed(data) { index, d ->
           EachRow(d)
            if (index != data.size - 1) {
                Divider(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun EachRow(d: DataSource) {
//    Column {

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxSize()
               ) {
                Image(
                    painter = painterResource(id = d.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(alignment = Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(10.dp)))
                )
                Text(text =d.string, modifier = Modifier.padding(8.dp))
            }
        }
}

