package saityan.misc.unsplashdemo.navigation.screens.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import saityan.misc.unsplashdemo.model.UnsplashImage
import saityan.misc.unsplashdemo.R

@ExperimentalCoilApi
@Composable
fun UnsplashItem(unsplashImage: UnsplashImage) {
    val painter = rememberImagePainter(data = unsplashImage.urls.regular) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_placeholder)
        placeholder(R.drawable.ic_placeholder)
    }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .clickable {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://unsplash.com/@${unsplashImage.user.username}?utm_source=DemoApp&utm_medium=referral")
                )
                ContextCompat.startActivity(context, browserIntent, null)
            }
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "Unsplash Image",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black
        ) {}
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(unsplashImage.user.username)
                    }
                    append(" on Unsplash")
                },
                color = Color.White,
                fontSize = MaterialTheme.typography.caption.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            LikeCounter(
                modifier = Modifier.weight(3f),
                painter = painterResource(id = R.drawable.ic_heart),
                likes = "${unsplashImage.likes}"
            )
        }
    }
}
