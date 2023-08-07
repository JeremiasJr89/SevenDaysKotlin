package com.example.sevendayskotlin.ui.theme.screnn

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sevendayskotlin.model.Movie as Movie1


@Composable
fun Movie(movies: List<Movie1>) {
    MaterialTheme(
    ) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {

                val movies = listOf(
                    Movie1(
                        title = "The Shawshank Redemption",
                        image = "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg",
                        rating = 9.2,
                        year = 1994
                    ),
                    Movie1(
                        title = "The Godfather",
                        image = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg",
                        rating = 9.2,
                        year = 1972
                    ),
                    Movie1(
                        title = "The Dark Knight",
                        image = "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg",
                        rating = 9.0,
                        year = 2008
                    )
                )
                LazyColumn {
                    items(movies) { movie -> MovieItem(movie) }
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie1) {
    val image = "https://www.imdb.com/title/tt6791350/mediaviewer/rm1222125825/?ref_=tt_ov_i"
    Column(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                0.5.dp,
                Color.Gray.copy(alpha = 0.5f),
                RoundedCornerShape(20.dp)
            )
    ) {
        AsyncImage(
            model = image,
            contentDescription = "Imagem de capa",
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                ),
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(Color.Gray)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Star,
                    "ícone de estrela para nota",
                    tint = Color.Yellow,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    "9.2",
                    modifier = Modifier
                        .padding(start = 2.dp),
                    color = Color(0xffeeeeee),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                "2023",
                fontSize = 14.sp,
                color = Color(0xffeeeeee),
            )
        }
        Text(
            "Guardians of the Galaxy Vol. 3",
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            ),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

