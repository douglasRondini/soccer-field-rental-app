package com.douglasrondini.arenacacerense.ui.fragments.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.douglasrondini.arenacacerense.R
import com.douglasrondini.arenacacerense.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progress.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        },4000)

        startLogoAnimation()

    }

    private fun startLogoAnimation() {
        val bouneAnim = ObjectAnimator.ofFloat(binding.logo,"translationY", 0f, -50f, 0f )
        bouneAnim.duration = 2000
        bouneAnim.repeatCount = ObjectAnimator.INFINITE
        bouneAnim.interpolator = BounceInterpolator()
        bouneAnim.start()
    }


}