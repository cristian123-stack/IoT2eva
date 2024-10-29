package com.example.iot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActualizarPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actualizarpassword)

        val inputUsuario = findViewById<EditText>(R.id.inputUsuarioPassword)
        val inputPasswordAnterior = findViewById<EditText>(R.id.inputPasswordAnterior)
        val inputNuevaPassword = findViewById<EditText>(R.id.inputNuevaPassword)
        val btnActualizarPassword = findViewById<Button>(R.id.btnActualizarPassword)
        val btnVolverLogin = findViewById<Button>(R.id.btnVolverLoginPassword) // Asegúrate de que este ID esté correcto

        btnActualizarPassword.setOnClickListener {
            val usuario = inputUsuario.text.toString()
            val passwordAnterior = inputPasswordAnterior.text.toString()
            val nuevaPassword = inputNuevaPassword.text.toString()

            val sharedPreferences = getSharedPreferences("guardado", Context.MODE_PRIVATE)
            val usuarioGuardado = sharedPreferences.getString("usuario", "")
            val contrasenaGuardada = sharedPreferences.getString("contrasena", "")

            if (usuario == usuarioGuardado && passwordAnterior == contrasenaGuardada) {
                val editor = sharedPreferences.edit()
                editor.putString("contrasena", nuevaPassword)
                editor.apply()
                Toast.makeText(this, "Contraseña actualizada con éxito", Toast.LENGTH_SHORT).show()
                // Regresar a Opciones de Cuenta después de actualizar
                finish() // Cierra la actividad actual
            } else {
                Toast.makeText(this, "Usuario o contraseña anterior incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para el botón "Volver al Login"
        btnVolverLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual
        }
    }
}
