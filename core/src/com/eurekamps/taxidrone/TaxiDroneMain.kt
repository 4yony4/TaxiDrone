package com.eurekamps.taxidrone

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.eurekamps.taxidrone.common.GlobalStates
import com.eurekamps.taxidrone.common.GlobalStatesListener
import com.eurekamps.taxidrone.game.World
import com.eurekamps.taxidrone.menu.MainMenu

class TaxiDroneMain: ApplicationAdapter(),GlobalStatesListener{

    lateinit var world:World
    lateinit var mainMenu:MainMenu

    override fun create() {
        GlobalStates.instance.listener=this

        mainMenu= MainMenu()
        world=World()
    }

    override fun render() {
        if(GlobalStates.instance.iState==GlobalStates.I_MAIN_MENU_STATE){
            mainMenu.draw()
        }
        else if(GlobalStates.instance.iState==GlobalStates.I_NEW_GAME_STATE){
            world.draw()
        }
        //world.draw()

    }

    override fun dispose() {
        world.destroy()
        mainMenu.destroy()

    }

    override fun stateChanged(oldState: Int, newState: Int) {
        super.stateChanged(oldState, newState)
    }
}