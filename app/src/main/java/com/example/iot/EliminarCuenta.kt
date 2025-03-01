package com.example.iot

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EliminarCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eliminarcuenta)

        val inputUsuarioEliminar = findViewById<EditText>(R.id.inputUsuarioEliminar)
        val inputPasswordEliminar = findViewById<EditText>(R.id.inputPasswordEliminar)
        val btnConfirmarEliminarCuenta = findViewById<Button>(R.id.btnConfirmarEliminarCuenta)
        val btnVolverLoginEliminar = findViewById<Button>(R.id.btnVolverLoginEliminar)

        // Lógica para eliminar cuenta
        btnConfirmarEliminarCuenta.setOnClickListener {
            val usuarioEliminar = inputUsuarioEliminar.text.toString()
            val passwordEliminar = inputPasswordEliminar.text.toString()

            val sharedPreferences = getSharedPreferences("guardado", Context.MODE_PRIVATE)
            val usuarioGuardado = sharedPreferences.getString("usuario", "")
            val contrasenaGuardada = sharedPreferences.getString("contrasena", "")

            if (usuarioEliminar == usuarioGuardado && passwordEliminar == contrasenaGuardada) {
                // Eliminar los datos de la cuenta
                val editor = sharedPreferences.edit()
                editor.clear() // Elimina todas las preferencias
                editor.apply()

                Toast.makeText(this, "Cuenta eliminada con éxito", Toast.LENGTH_SHORT).show()
                // Regresar a la pantalla de inicio de sesión
                finish() // Cierra la actividad actual
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para el botón de Volver al Login
        btnVolverLoginEliminar.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la anterior
        }
    }
}
