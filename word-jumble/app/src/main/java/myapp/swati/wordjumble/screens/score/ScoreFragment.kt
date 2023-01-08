/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package myapp.swati.wordjumble.screens.score

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import myapp.swati.wordjumble.R
import myapp.swati.wordjumble.databinding.ScoreFragmentBinding

/**
 * Fragment where the final score is shown, after the game is over
 */
class ScoreFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.score_fragment,
                container,
                false
        )

        // Get args using by navArgs property delegate
        val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()

        val viewModelFactory = ScoreViewModelFactory(scoreFragmentArgs.score)
        val viewModel= ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)

        binding.scoreViewModel= viewModel
        binding.setLifecycleOwner(this)


        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer{ playAgain->
            if(playAgain){
                findNavController().navigate(ScoreFragmentDirections.actionRestart())
                viewModel.onPlayAgainFinished()
            }

        })

        setHasOptionsMenu(true)

        return binding.root
    }

     //Creating our Share Intent
    private fun getShareIntent() : Intent {
        val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, scoreFragmentArgs.score))
        return shareIntent
    }
    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_score, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.isVisible = false
        }
    }
    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}
