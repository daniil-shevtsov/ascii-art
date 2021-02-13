package shevtsov.daniil.asciiart.creation.presentation

sealed class CreationScreenEvent {

    data class ShowItemSaved(val itemName: String) : CreationScreenEvent()

}