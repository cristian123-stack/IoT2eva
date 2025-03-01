package com.example.iot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OpcionesCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.opciones_cuenta)

        // Lógica para el botón de Volver al Login
        val btnVolverLogin: Button = findViewById(R.id.btnVolverLogin)
        btnVolverLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Para cerrar la actividad actual
        }

        // Lógica para el botón de Actualizar Usuario
        val btnActualizarUsuario: Button = findViewById(R.id.btnActualizarUsuario)
        btnActualizarUsuario.setOnClickListener {
            val intent = Intent(this, ActualizarUsuario::class.java)
            startActivity(intent) // Redirigir a ActualizarUsuario
        }

        // Lógica para el botón de Actualizar Contraseña
        val btnActualizarPassword: Button = findViewById(R.id.btnActualizarPassword)
        btnActualizarPassword.setOnClickListener {
            val intent = Intent(this, ActualizarPassword::class.java)
            startActivity(intent)
        }

        // Lógica para el botón de Eliminar Cuenta
        val btnEliminarCuenta: Button = findViewById(R.id.btnEliminarCuenta)
        btnEliminarCuenta.setOnClickListener {
            val intent = Intent(this, EliminarCuenta::class.java)
            startActivity(intent) // Redirigir a EliminarCuenta
        }
    }
}
