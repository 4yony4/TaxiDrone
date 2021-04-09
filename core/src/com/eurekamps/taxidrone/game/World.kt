package com.eurekamps.taxidrone.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class World {
    var batch: SpriteBatch? = null
    var img: Texture? = null

    constructor(){
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")

    }

    fun process(){

    }

    fun draw(){
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch!!.begin()
        batch!!.draw(img, 0f, 0f)
        batch!!.end()


    }

    fun destroy(){
        batch!!.dispose()
        img!!.dispose()
    }


}