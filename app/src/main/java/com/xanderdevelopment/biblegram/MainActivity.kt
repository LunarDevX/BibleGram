package com.xanderdevelopment.biblegram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.xanderdevelopment.biblegram.data.Quote
import com.xanderdevelopment.biblegram.data.quotes
import com.xanderdevelopment.biblegram.ui.theme.BibleGramTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibleGramTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BibleGramApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BibleGramApp() {
    Scaffold(
        topBar = {
            BibleGramAppBar()
        }

    ) {it ->
        LazyColumn(contentPadding = it) {
            items(quotes) {
                QuoteItem(
                    quote = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }

    }
}

@Composable
fun QuoteItem(
    quote: Quote,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
                    .sizeIn(minHeight = 72.dp)
            ) {
                QuoteIcon(quote.imageResourceId)
                QuoteText(quote.text, modifier = Modifier.weight(1f))
                QuoteItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded}
                )
            }
            if (expanded) {
                AboutQuoteText(
                    aboutText = quote.author,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun AboutQuoteText(
    @StringRes aboutText: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = stringResource(aboutText),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun QuoteItemButton(
    expanded: Boolean,
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
   IconButton(
       onClick = onClick,
       modifier = modifier
   ) {
       Icon(
           imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
           contentDescription = stringResource(R.string.expand_button_content_description),
           tint = MaterialTheme.colorScheme.secondary
       )
   }
}


@Composable
fun QuoteText(
    @StringRes quoteText: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(quoteText),
        modifier = modifier.padding(top= dimensionResource(R.dimen.padding_small)),
        style = MaterialTheme.typography.labelMedium,
    )
}

@Composable
fun QuoteIcon(
    @DrawableRes quoteIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Fit,
        painter = painterResource(quoteIcon),
        contentDescription = null
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BibleGramAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                )
            }
        }
    )
}


