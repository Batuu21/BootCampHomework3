package com.example.homework3

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment


class SplashFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bar: ProgressBar = view.findViewById(R.id.progress_circular)
        var text: TextView = view.findViewById(R.id.countdown_time)
        var progress : Int

        var timer = object: CountDownTimer(3000, 1000){
            override fun onTick(timeLeft: Long) {
                progress = (timeLeft.toInt() / 1000)
                update(bar, text, progress)
            }
            override fun onFinish() {
                navigateToNextFragment(R.id.action_splashFragment_to_homeFragment)
            }
        }
        timer.start()
    }

    private fun update(bar: ProgressBar, text: TextView, progres: Int){
        bar.progress = progres * 33
        text.text = "$progres"
    }
}