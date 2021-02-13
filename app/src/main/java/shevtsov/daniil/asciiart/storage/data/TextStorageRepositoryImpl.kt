package shevtsov.daniil.asciiart.storage.data

import shevtsov.daniil.asciiart.storage.domain.InformationItem
import shevtsov.daniil.asciiart.storage.domain.TextStorageRepository
import javax.inject.Inject

class TextStorageRepositoryImpl @Inject constructor(
    private val storage: TextStorage,
    private val mapper: InformationItemMapper
) : TextStorageRepository {


    override fun saveText(itemName: String, text: String) {
        storage.save(
            key = itemName,
            value = InformationItemDto(id = itemName, name = itemName, content = text)
        )
    }

    override fun getItems(): List<InformationItem> = storage.getAll().map(mapper::map)

    override fun getItem(itemId: String): InformationItem? =
        storage.get(key = itemId)?.let { mapper.map(dto = it) }
}