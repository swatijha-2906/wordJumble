package myapp.swati.wordjumble.screens.title

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import myapp.swati.wordjumble.R

class TitleFragmentDirections private constructor() {
    companion object {
        fun actionTitleToGame(): NavDirections = ActionOnlyNavDirections(R.id.action_title_to_game)
    }
}
