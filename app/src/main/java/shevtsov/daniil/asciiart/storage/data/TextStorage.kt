package shevtsov.daniil.asciiart.storage.data

import shevtsov.daniil.asciiart.core.di.AppScope
import javax.inject.Inject

@AppScope
class TextStorage @Inject constructor() {
    private val items = mutableMapOf<String, InformationItemDto>()

    fun save(key: String, value: InformationItemDto) {
        items[key] = value
    }

    fun get(key: String): InformationItemDto? = items[key]

    fun getAll(): List<InformationItemDto> = items.values.toList()

}