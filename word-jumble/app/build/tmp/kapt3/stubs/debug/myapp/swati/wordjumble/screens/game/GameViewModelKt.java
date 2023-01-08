package myapp.swati.wordjumble.screens.game;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"CORRECT_BUZZ_PATTERN", "", "GAME_OVER_BUZZ_PATTERN", "NO_BUZZ_PATTERN", "PANIC_BUZZ_PATTERN", "app_debug"})
public final class GameViewModelKt {
    private static final long[] CORRECT_BUZZ_PATTERN = {100L, 100L, 100L, 100L, 100L, 100L};
    private static final long[] PANIC_BUZZ_PATTERN = {0L, 200L};
    private static final long[] GAME_OVER_BUZZ_PATTERN = {0L, 2000L};
    private static final long[] NO_BUZZ_PATTERN = {0L};
}