package fgori.ft_hanguots

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "ft_hangouts.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_CONTACTS = "contacts"
        const val COLUMN_ID = "_id" // Nome standard per la chiave primaria
        const val COLUMN_NAME = "name"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_ADDRESS = "address"
        const val COLUMN_IMAGE_URI = "image_uri"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE = "CREATE TABLE $TABLE_CONTACTS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME TEXT NOT NULL," +
                "$COLUMN_PHONE TEXT NOT NULL," +
                "$COLUMN_EMAIL TEXT," +
                "$COLUMN_ADDRESS TEXT," +
                "$COLUMN_IMAGE_URI TEXT)"


        db.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    /**
     * Inserisce un nuovo contatto nel database.
     */
    fun addContact(contact: Contact) {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_NAME, contact.getValue("name"))
            put(COLUMN_PHONE, contact.getValue("phone"))
            put(COLUMN_EMAIL, contact.getValue("email"))
            put(COLUMN_ADDRESS, contact.getValue("address"))
            put(COLUMN_IMAGE_URI, contact.getValue("img"))
        }

        db.insert(TABLE_CONTACTS, null, values)

        db.close()
    }
}
