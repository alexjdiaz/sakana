package se.sakana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.vector.PathParser
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel
import se.sakana.extensions.LocalCharacterSettings
import se.sakana.extensions.LocalPathParser
import se.sakana.module.AppModule
import se.sakana.module.SharedModule
import se.sakana.navigation.SakanaRoute
import se.sakana.theme.SakanaTheme
import se.sakana.ui.character.CharacterRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            KoinApplication(application = { modules(SharedModule.module, AppModule.module) }) {
                val viewModel = koinViewModel<MainViewModel>()
                val navController = rememberNavController()

                SakanaTheme {
                    NavHost(
                        navController = navController,
                        startDestination = SakanaRoute.Character,
                    ) {
                        composable<SakanaRoute.Character> {
                            CompositionLocalProvider(
                                LocalCharacterSettings provides viewModel.settings,
                                LocalPathParser provides PathParser(),
                            ) {
                                CharacterRoute(
                                    onBackPressed = {},
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}
