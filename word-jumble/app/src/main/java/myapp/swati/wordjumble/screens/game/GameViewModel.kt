package myapp.swati.wordjumble.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import java.util.Collections.shuffle

private val CORRECT_BUZZ_PATTERN = longArrayOf(100, 100, 100, 100, 100, 100)
private val PANIC_BUZZ_PATTERN = longArrayOf(0, 200)
private val GAME_OVER_BUZZ_PATTERN = longArrayOf(0, 2000)
private val NO_BUZZ_PATTERN = longArrayOf(0)

class GameViewModel: ViewModel() {

    enum class BuzzType(val pattern: LongArray) {
        CORRECT(CORRECT_BUZZ_PATTERN),
        GAME_OVER(GAME_OVER_BUZZ_PATTERN),
        COUNTDOWN_PANIC(PANIC_BUZZ_PATTERN),
        NO_BUZZ(NO_BUZZ_PATTERN)
    }

    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L
        // This is the time when the phone will start buzzing each second
        private const val COUNTDOWN_PANIC_SECONDS = 10L
        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L
        // This is the total time of the game
        const val COUNTDOWN_TIME = 60000L
    }



    private val timer: CountDownTimer
    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
    get()= _word

    // The current score
    private val _score= MutableLiveData<Int>()
    val score : LiveData<Int>
    get()= _score

    private val _eventGameFinish= MutableLiveData<Boolean>()
    val eventGameFinish : LiveData<Boolean>
        get()= _eventGameFinish

    private val _currentTime= MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get()= _currentTime

    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    //buzzer logic
    private val _eventBuzz = MutableLiveData<BuzzType>()
    val eventBuzz: LiveData<BuzzType>
        get() = _eventBuzz
    //end of buzzer logic

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init{

        _score.value=0
        _word.value=""
        resetList()
        nextWord()
        _eventGameFinish.value= false
        _currentTime.value=0L
        _eventBuzz.value= BuzzType.NO_BUZZ

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value= millisUntilFinished/ ONE_SECOND
                if (millisUntilFinished / ONE_SECOND <= COUNTDOWN_PANIC_SECONDS) {
                    _eventBuzz.value = BuzzType.COUNTDOWN_PANIC
                }
            }

            override fun onFinish() {
                _eventGameFinish.value= true
                _eventBuzz.value = BuzzType.GAME_OVER
                _currentTime.value = DONE
            }
        }

        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    /**
     * Resets the list of words and randomizes the order
     */


        private val correctWordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )



    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }



    /**
     * Moves to the next word in the list
     */
    fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
        }

        var currWord = wordList.removeAt(0)
        var charList: MutableList<Char> = currWord.toMutableList()
        charList.shuffle()
        //Log.i("here", charList.toString())
        _word.value = String(charList.toCharArray())


    }



    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value=(_score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value=(_score.value)?.plus(1)
        _eventBuzz.value = BuzzType.CORRECT
        nextWord()
    }
    fun onGameFinished(){
        _eventGameFinish.value= false
    }

    //start of buzzer logic
    fun onBuzzComplete() {
        _eventBuzz.value = BuzzType.NO_BUZZ
    }

    //end of buzzer logic

}