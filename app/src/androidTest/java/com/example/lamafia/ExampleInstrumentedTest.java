/*
 * Copyright (c)
 *  * "La Mafia se Sienta en la Mesa,Cordoba" - Todos los derechos reservados.
 *  * Título:       [La Mafia se Sienta en la Mesa,Cordoba]
 *  * Descripción:  [Restaurante Italiano]
 *  * Autor:        [Nelson Villalba Vergara]
 *  * Sitio web:    [La Mafia se Sienta en la Mesa,Cordoba]
 *  * Contacto:     [nelson_ariel@hotmail.es]
 *  * Fecha:        [2024]
 *  * Aviso Legal:
 *  * Este archivo y el código fuente adjunto son parte de [La Mafia se Sienta en la Mesa,Cordoba].
 *  * Todos los derechos sobre el código fuente, diseño y recursos visuales
 *  * pertenecen a [Nelson Villalba Vergara].
 *  * Queda prohibida la reproducción, distribución o modificación no autorizada
 *  * de este código fuente o cualquier otro componente de la aplicación.
 *  * [La Mafia se Sienta en la Mesa,Cordoba] es una marca registrada de [Nelson Villalba Vergara].
 *
 *
 */

package com.example.lamafia;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.lamafia", appContext.getPackageName());
    }
}