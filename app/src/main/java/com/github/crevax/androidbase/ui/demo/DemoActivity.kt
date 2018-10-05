package com.github.crevax.androidbase.ui.demo

import android.os.Bundle
import android.support.constraint.ConstraintSet
import com.github.crevax.androidbase.R.string.all_submit
import com.github.crevax.androidbase.R.string.demo_welcome_message
import org.jetbrains.anko.constraint.layout.constraintLayout
import com.github.crevax.androidbase.ui.common.base.BaseActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.sdk25.coroutines.onClick

class DemoActivity : BaseActivity<DemoViewModel>() {

    companion object {
        const val WELCOME_MESSAGE = 1
        const val INPUT_TEXT = 2
        const val SUBMIT_BUTTON = 3
    }

    // TODO: Figure out how ViewModels fit in properly with Anko Layouts
    override val viewModelClassToken = DemoViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        constraintLayout {
            lparams(matchParent, matchParent)

            val welcomeMessage = textView {
                id = WELCOME_MESSAGE
                text = getString(demo_welcome_message)
            }.lparams(0)

            val inputText = editText {
                id = INPUT_TEXT
            }.lparams(0)

            val submitButton = button {
                id = SUBMIT_BUTTON
                text = getString(all_submit)
                onClick { toast((vm.submit(inputText.text)))  }
            }

            applyConstraintSet {
                welcomeMessage {
                    connect(
                        ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.START of ConstraintSet.PARENT_ID margin dip(16),
                        ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID margin dip(8),
                        ConstraintSetBuilder.Side.END to ConstraintSetBuilder.Side.END of ConstraintSet.PARENT_ID margin dip(16),
                        ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID margin dip(8)
                    )
                }

                inputText {
                    connect(
                            ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.START of welcomeMessage,
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of welcomeMessage margin dip(8),
                            ConstraintSetBuilder.Side.END to ConstraintSetBuilder.Side.END of welcomeMessage
                    )
                }

                submitButton {
                    connect(
                            ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.START of ConstraintSet.PARENT_ID margin dip(8),
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of inputText margin dip(8),
                            ConstraintSetBuilder.Side.END to ConstraintSetBuilder.Side.END of ConstraintSet.PARENT_ID
                    )
                }
            }
        }
    }
}
