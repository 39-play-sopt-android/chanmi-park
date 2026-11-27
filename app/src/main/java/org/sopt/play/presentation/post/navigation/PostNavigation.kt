package org.sopt.play.presentation.post.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.play.core.navigation.Route
import org.sopt.play.presentation.post.PostRoute

fun NavController.navigateToPost(
    navOptions: NavOptions? = null,
) = navigate(Post, navOptions)

fun NavGraphBuilder.postGraph(
    innerPadding: PaddingValues,
) {
    composable<Post> {
        PostRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object Post : Route
