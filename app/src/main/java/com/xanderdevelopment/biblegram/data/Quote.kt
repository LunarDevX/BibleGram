package com.xanderdevelopment.biblegram.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.xanderdevelopment.biblegram.R

data class Quote(
    @DrawableRes val imageResourceId: Int,
    @StringRes val text: Int,
    @StringRes val author: Int
)

val quotes = listOf(
    Quote(R.drawable.android_quote2, R.string.quote_1, R.string.author_1),
    Quote(R.drawable.android_quote1, R.string.quote_2, R.string.author_2),
    Quote(R.drawable.android_quote3, R.string.quote_3, R.string.author_3),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_4, R.string.author_4),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_5, R.string.author_5),
    Quote(R.drawable.android_quote6, R.string.quote_6, R.string.author_6),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_7, R.string.author_7),
    //Quote(R.drawable.android_quote8, R.string.quote_8, R.string.author_8),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_9, R.string.author_9),
    Quote(R.drawable.android_quote10, R.string.quote_10, R.string.author_10),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_11, R.string.author_11),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_12, R.string.author_12),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_13, R.string.author_13),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_14, R.string.author_14),
    //Quote(R.drawable.ic_biblegram_logo, R.string.quote_15, R.string.author_15)
    Quote(R.drawable.ic_biblegram_logo, R.string.about_app_description, R.string.about_app)
)
