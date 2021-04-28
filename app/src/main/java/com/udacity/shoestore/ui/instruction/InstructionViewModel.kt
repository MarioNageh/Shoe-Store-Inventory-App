package com.udacity.shoestore.ui.instruction

import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {

    private val _instructionList = mutableListOf<String>()
    val instructionWord:String
    get() = _instructionList[0]

    init {
        _instructionList.add("Don't Wash It")
        _instructionList.add("Don't Hurt It")
        _instructionList.add("Don't Pull It Very Hard")
        _instructionList.shuffle()


    }


}