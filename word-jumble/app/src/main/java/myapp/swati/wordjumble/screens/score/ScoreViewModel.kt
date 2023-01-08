package myapp.swati.wordjumble.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController

class ScoreViewModel(finalScore: Int) : ViewModel() {
    private val _score= MutableLiveData<Int>()
    val score: LiveData<Int>
        get()= _score

    private val _eventPlayAgain= MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get()= _eventPlayAgain

    init{
        _score.value= finalScore
        _eventPlayAgain.value= false
    }

    fun onPlayAgain() {
        _eventPlayAgain.value= true

    }

    fun onPlayAgainFinished(){
        _eventPlayAgain.value= false
    }
}