package myapp.swati.wordjumble.screens.score

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import myapp.swati.wordjumble.R

class ScoreFragmentDirections private constructor() {
    companion object {
        fun actionRestart(): NavDirections = ActionOnlyNavDirections(R.id.action_restart)
    }
}
