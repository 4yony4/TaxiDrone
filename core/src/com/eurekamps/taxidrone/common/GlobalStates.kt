package com.eurekamps.taxidrone.common

class GlobalStates {
    companion object{
        val I_MAIN_MENU_STATE=0
        val I_NEW_GAME_STATE=1
        val I_EXIT_GAME_STATE=2

        val instance=GlobalStates()
    }

    var listener:GlobalStatesListener?=null
    var iState=I_MAIN_MENU_STATE

    fun changeState(newState:Int){
        val oldState=iState
        iState=newState
        listener?.stateChanged(oldState,iState)
    }


}

interface GlobalStatesListener{
    fun stateChanged(oldState:Int,newState:Int){}
}