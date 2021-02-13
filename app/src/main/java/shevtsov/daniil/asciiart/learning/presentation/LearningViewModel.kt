package shevtsov.daniil.asciiart.learning.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import shevtsov.daniil.asciiart.core.util.toImmutable
import shevtsov.daniil.asciiart.learning.navigation.LearningInitArguments
import shevtsov.daniil.asciiart.storage.domain.GetSavedItemUseCase
import javax.inject.Inject

class LearningViewModel @Inject constructor(
    private val getSavedItem: GetSavedItemUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<LearningViewState>(value = createInitialState())
    val state = _state.toImmutable()

    private val _events = MutableSharedFlow<LearningScreenEvent>()
    val events = _events.toImmutable()

    fun onArguments(arguments: LearningInitArguments) {
        when (arguments) {
            is LearningInitArguments.Empty -> handleEmpty()
            is LearningInitArguments.SelectedItem -> handleSelectedItem(id = arguments.itemId)
        }

    }

    private fun handleEmpty() {

    }

    private fun handleSelectedItem(id: String) {
        val item = getSavedItem.invoke(itemId = id)
        if (item != null) {
            val state = LearningViewState(
                itemName = item.name,
                itemContent = item.content
            )
            viewModelScope.launch { _state.emit(value = state) }
        }
    }

    private fun createInitialState(): LearningViewState {
        return LearningViewState(
            itemName = "",
            itemContent = ""
        )
    }

}