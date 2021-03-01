package com.github.zharovvv.animationsandbox.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.github.zharovvv.animationsandbox.R

class PropertyAnimationExampleFragment : Fragment() {

    private lateinit var rotatedImageView: ImageView

    private lateinit var rotateValueAnimator: ValueAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_animation_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRotateAnimator(view)
    }

    private fun setUpRotateAnimator(view: View) {
        rotatedImageView = view.findViewById(R.id.image_view_property_animation)
        rotateValueAnimator = ValueAnimator.ofFloat(0f, 360f).apply {
            addUpdateListener { animation ->
                val value = animation.animatedValue as Float
                rotatedImageView.rotation = value
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationRepeat(animation: Animator?) {
                    super.onAnimationRepeat(animation)
                }

                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                }

                override fun onAnimationCancel(animation: Animator?) {
                    super.onAnimationCancel(animation)
                }

                override fun onAnimationPause(animation: Animator?) {
                    super.onAnimationPause(animation)
                }

                override fun onAnimationStart(animation: Animator?) {
                    super.onAnimationStart(animation)
                }

                override fun onAnimationResume(animation: Animator?) {
                    super.onAnimationResume(animation)
                }
            })
            duration = 3000
            setInterpolator { progress ->
                progress
            }
        }

        rotatedImageView.setOnClickListener {
            if (rotateValueAnimator.isStarted) {
                rotateValueAnimator.end()
            } else {
                rotateValueAnimator.start()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
        rotateValueAnimator.end()
    }
}