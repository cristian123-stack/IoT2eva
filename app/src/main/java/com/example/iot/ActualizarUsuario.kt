package com.example.iot

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActualizarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actualizarusuario)

        val inputUsuarioAnterior = findViewById<EditText>(R.id.inputUsuarioAnterior)
        val inputNuevoUsuario = findViewById<EditText>(R.id.inputNuevoUsuario)
        val btnActualizarUsuario = findViewById<Button>(R.id.btnActualizarUsuario)

        btnActualizarUsuario.setOnClickListener {
            val usuarioAnterior = inputUsuarioAnterior.text.toString()
            val nuevoUsuario = inputNuevoUsuario.text.toString()

            val sharedPreferences = getSharedPreferences("guardado", Context.MODE_PRIVATE)
            val usuarioGuardado = sharedPreferences.getString("usuario", "")

            if (usuarioAnterior == usuarioGuardado) {
                val editor = sharedPreferences.edit()
                editor.putString("usuario", nuevoUsuario)
                editor.apply()
                Toast.makeText(this, "Usuario actualizado con éxito", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuario anterior incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para el botón de Volver al Login
        val btnVolverLogin: Button = findViewById(R.id.btnVolverLogin)
        btnVolverLogin.setOnClickListener {
            finish() // Para cerrar la actividad actual y volver a la anterior
        }
    }
}
