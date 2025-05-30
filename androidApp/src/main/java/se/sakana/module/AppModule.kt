package se.sakana.module

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import se.sakana.MainViewModel
import se.sakana.ui.character.CharacterViewModel

object AppModule {
    val module: Module = module {
        viewModelOf(::MainViewModel)
        viewModelOf(::CharacterViewModel)
    }
}
