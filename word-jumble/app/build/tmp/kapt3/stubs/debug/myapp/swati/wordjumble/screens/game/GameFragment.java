package myapp.swati.wordjumble.screens.game;

import java.lang.System;

/**
 * Fragment where the game is played
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lmyapp/swati/wordjumble/screens/game/GameFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lmyapp/swati/wordjumble/databinding/GameFragmentBinding;", "viewModel", "Lmyapp/swati/wordjumble/screens/game/GameViewModel;", "buzz", "", "pattern", "", "gameFinished", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class GameFragment extends androidx.fragment.app.Fragment {
    private myapp.swati.wordjumble.databinding.GameFragmentBinding binding;
    private myapp.swati.wordjumble.screens.game.GameViewModel viewModel;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * Called when the game is finished
     */
    private final void gameFinished() {
    }
    
    private final void buzz(long[] pattern) {
    }
    
    public GameFragment() {
        super();
    }
}