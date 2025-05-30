package se.sakana.module

import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import se.sakana.domain.CharacterRepository

object SharedModule {
    val module: Module = module {
        factoryOf(::CharacterRepository)
    }
}

