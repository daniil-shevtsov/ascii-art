package shevtsov.daniil.asciiart.main.presentation

sealed class MainScreenEvent {

    object OpenCreation : MainScreenEvent()

    object OpenLearning : MainScreenEvent()

    object OpenStructure : MainScreenEvent()

}