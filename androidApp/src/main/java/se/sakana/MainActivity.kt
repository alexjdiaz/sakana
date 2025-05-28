package se.sakana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.koin.compose.KoinApplication
import org.koin.ksp.generated.module
import se.sakana.module.AppModule
import se.sakana.module.SharedModule
import se.sakana.theme.SakanaTheme
import se.sakana.ui.CharacterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            KoinApplication(
                application = { modules(SharedModule.module, AppModule.module) }
            ) {
                SakanaTheme {
                    CharacterScreen(
                        onBackPressed = {},
                    )
                }
            }
        }
    }
}
