package com.eurekamps.taxidrone.menu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.eurekamps.taxidrone.common.GlobalStates
import com.rafaskoberg.gdx.typinglabel.TypingLabel
import sun.rmi.runtime.Log


class MainMenu:ClickListener {

    lateinit var stage:Stage
    lateinit var label1Style:Label.LabelStyle
    lateinit var label:TypingLabel

    constructor(){
        val row_height = Gdx.graphics.width / 6f
        stage=Stage(ScreenViewport())
        label1Style= Label.LabelStyle()

        val generator = FreeTypeFontGenerator(Gdx.files.internal("fonts/ArchitectsDaughter-Regular.ttf"))
        val parameter = FreeTypeFontParameter()
        parameter.size = 110
        val font12 = generator.generateFont(parameter) // font size 12 pixels

        generator.dispose() // don't forget to dispose to avoid memory leaks!


        //val myFont = BitmapFont(Gdx.files.internal("bitmapfont/Amble-Regular-26.fnt"))
        //myFont = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("font.ttf"), FONT_CHARACTERS, 12.5f, 7.5f, 1.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //myFont.setColor(1f, 0f, 0f, 1f);
        //myFont.data.setScale(20f)
        label1Style.font = font12
        label1Style.fontColor = Color.RED

        label = TypingLabel("TaxiDrone", label1Style)
        label.setSize(Gdx.graphics.getWidth().toFloat(), row_height)
        label.setPosition(0f, Gdx.graphics.getHeight() - row_height * 2)
        label.setAlignment(Align.center)
        stage.addActor(label)

        val sMenuElements= arrayOf("Nuevo","Cargar","Opciones","Salir")
        var i=1
        for (name in sMenuElements){
            val labelM = TypingLabel(name, label1Style)
            labelM.addListener(this)
            labelM.setSize(Gdx.graphics.getWidth().toFloat(), row_height)
            labelM.setPosition(0f, Gdx.graphics.getHeight() - row_height * (2+i))
            labelM.setAlignment(Align.center)
            stage.addActor(labelM)
            i++
        }

        Gdx.input.setInputProcessor(stage)//NECESARIO PARA ACTIVAR LOS EVENTOS!!!!
        /*val button:Button=Button()
        button.setSize(Gdx.graphics.getWidth().toFloat(), row_height)
        button.setPosition(0f, Gdx.graphics.getHeight() - row_height * (2+i))
        stage.addActor(button)*/
        //stage.addListener(this)

    }

    fun draw(){
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // AFTER
        stage.act()
        stage.draw()


    }

    fun destroy(){
    }


    override fun clicked(event: InputEvent?, x: Float, y: Float) {
        super.clicked(event, x, y)
        val labelTemp=event?.target as TypingLabel
        if(labelTemp.textEquals("Nuevo")){
            //Gdx.app.log("MyTag", "Nuevo Juego")
            GlobalStates.instance.changeState(GlobalStates.I_NEW_GAME_STATE)
        }
        else if(labelTemp.textEquals("Salir")){
            System.exit(0)
        }


        //println("---->>>>>>>>>>>>>>>>>>>>>>>>>    "+event?.target)
    }

    /*override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
        super.touchUp(event, x, y, pointer, button)
        Gdx.app.log("MyTag", "my informative message")
    }

    override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
        val touched=super.touchDown(event, x, y, pointer, button)
        Gdx.app.log("MyTag", "my informative message")

        return touched
    }*/




}