package shevtsov.daniil.asciiart.storage.domain

interface TextStorageRepository {

    fun saveText(itemName: String, text: String)

    fun getItems(): List<InformationItem>

    fun getItem(itemId: String): InformationItem?

}