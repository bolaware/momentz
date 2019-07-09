package com.bolaware.viewstimerstory

import android.view.View

interface ProgressStoryCallback{
    fun done()

    fun onNextCalled(view: View, progressStory : ProgressStory, index: Int)
}
