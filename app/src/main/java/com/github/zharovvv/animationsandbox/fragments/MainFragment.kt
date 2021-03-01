package com.github.zharovvv.animationsandbox.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.github.zharovvv.animationsandbox.R

class MainFragment : Fragment() {

    private val tweenAnimationExampleFragment = TweenAnimationExampleFragment()
    private val frameAnimationExampleFragment = FrameAnimationExampleFragment()
    private val propertyAnimationExampleFragment = PropertyAnimationExampleFragment()

    private lateinit var rootContainer: ViewGroup

    private lateinit var toTweenAnimationsButton: Button
    private lateinit var toFrameAnimationButton: Button
    private lateinit var toPropertyAnimationButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Вызов этого метода меняет жизненный цикл фрагмента, а именно, он
         * убирает из него вызовы onCreate и onDestroy при пересоздании Activity. Теперь
         * при пересоздании Activity этот фрагмент не будет уничтожен, и все его поля
         * сохранят свои значения. Но при этом остальные методы из жизненного цикла
         * Fragment будут вызваны, так что не возникнет проблем с заменой ресурсов в
         * зависимости от конфигурации.
         */
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.let { rootContainer = it }
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toTweenAnimationsButton = view.findViewById(R.id.tween_animation)
        toTweenAnimationsButton.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .setCustomAnimations(
                    R.animator.animation_enter,
                    R.animator.animation_exit,
                    R.animator.animation_pop_enter,
                    R.animator.animation_pop_exit
                )
                .replace(
                    rootContainer.id,
                    tweenAnimationExampleFragment,
                    "tweenAnimationExampleFragment"
                )
                .addToBackStack(null)
                .commit()
        }
        toFrameAnimationButton = view.findViewById(R.id.frame_animation)
        toFrameAnimationButton.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .setCustomAnimations(
                    R.animator.animation_enter,
                    R.animator.animation_exit,
                    R.animator.animation_pop_enter,
                    R.animator.animation_pop_exit
                )
                .replace(
                    rootContainer.id,
                    frameAnimationExampleFragment,
                    "frameAnimationExampleFragment"
                )
                .addToBackStack(null)
                .commit()
        }
        toPropertyAnimationButton = view.findViewById(R.id.property_animation)
        toPropertyAnimationButton.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .setCustomAnimations(
                    R.animator.animation_enter,
                    R.animator.animation_exit,
                    R.animator.animation_pop_enter,
                    R.animator.animation_pop_exit
                )
                .replace(
                    rootContainer.id,
                    propertyAnimationExampleFragment,
                    "propertyAnimationExampleFragment"
                )
                .addToBackStack(null)
                .commit()
        }
    }
}