package fgori.ft_hanguots

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreateContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- ESEMPIO DI UTILIZZO DELLA CLASSE CONTACT ---

        // 1. Crei una nuova istanza (oggetto) della tua classe Contact.
        //    L'ID deve essere univoco, qui usiamo il timestamp corrente come esempio.
        val newContact = Contact(id = System.currentTimeMillis())

        // 2. Assegni i valori alle sue proprietà. In un'app reale, leggeresti
        //    questi valori da campi di testo (EditText) che l'utente ha compilato.
        newContact.name = "Mario Rossi"
        newContact.phone = "123456789"
        newContact.email = "mario.rossi@example.com"

        // Ora l'oggetto 'newContact' contiene tutti i dati e puoi salvarlo
        // in un database, passarlo a un'altra activity, ecc.
    }
}
