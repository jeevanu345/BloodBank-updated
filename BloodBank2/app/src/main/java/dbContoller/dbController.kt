package dbContoller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbController(context: Context) : SQLiteOpenHelper(context, "bloodbank.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                sex TEXT,
                blood_group TEXT,
                contact TEXT,
                address TEXT,
                division TEXT,
                email TEXT,
                password TEXT,
                is_donor INTEGER
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
    fun validateUser(email: String, password: String): Boolean {
        val db = readableDatabase
        val query = "SELECT * FROM users WHERE email = ? AND password = ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))
        val isValid = cursor.count > 0
        cursor.close()
        return isValid
    }
    fun getDonorsByBloodAndDivision(bloodGroup: String, division: String): List<Map<String, String>> {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM users WHERE blood_group = ? AND division = ? AND is_donor = 1",
            arrayOf(bloodGroup, division)
        )

        val donors = mutableListOf<Map<String, String>>()
        while (cursor.moveToNext()) {
            val donor = mapOf(
                "name" to cursor.getString(cursor.getColumnIndexOrThrow("name")),
                "sex" to cursor.getString(cursor.getColumnIndexOrThrow("sex")),
                "blood_group" to cursor.getString(cursor.getColumnIndexOrThrow("blood_group")),
                "contact" to cursor.getString(cursor.getColumnIndexOrThrow("contact")),
                "address" to cursor.getString(cursor.getColumnIndexOrThrow("address")),
                "division" to cursor.getString(cursor.getColumnIndexOrThrow("division")),
                "email" to cursor.getString(cursor.getColumnIndexOrThrow("email"))
            )
            donors.add(donor)
        }
        cursor.close()
        return donors
    }
    fun updateUserByEmail(
        email: String,
        name: String,
        sex: String,
        bloodGroup: String,
        contact: String,
        address: String
    ): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("sex", sex)
            put("blood_group", bloodGroup)
            put("contact", contact)
            put("address", address)
        }
        return db.update("users", values, "email = ?", arrayOf(email))
    }
    fun getAllDonors(): List<Map<String, String>> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE is_donor = 1", null)

        val donors = mutableListOf<Map<String, String>>()
        while (cursor.moveToNext()) {
            val donor = mapOf(
                "name" to cursor.getString(cursor.getColumnIndexOrThrow("name")),
                "sex" to cursor.getString(cursor.getColumnIndexOrThrow("sex")),
                "blood_group" to cursor.getString(cursor.getColumnIndexOrThrow("blood_group")),
                "contact" to cursor.getString(cursor.getColumnIndexOrThrow("contact")),
                "address" to cursor.getString(cursor.getColumnIndexOrThrow("address")),
                "division" to cursor.getString(cursor.getColumnIndexOrThrow("division")),
                "email" to cursor.getString(cursor.getColumnIndexOrThrow("email"))
            )
            donors.add(donor)
        }
        cursor.close()
        return donors
    }
    fun getUserByEmail(email: String): Map<String, String>? {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE email = ?", arrayOf(email))
        return if (cursor.moveToFirst()) {
            mapOf(
                "name" to cursor.getString(cursor.getColumnIndexOrThrow("name")),
                "sex" to cursor.getString(cursor.getColumnIndexOrThrow("sex")),
                "blood_group" to cursor.getString(cursor.getColumnIndexOrThrow("blood_group")),
                "contact" to cursor.getString(cursor.getColumnIndexOrThrow("contact")),
                "address" to cursor.getString(cursor.getColumnIndexOrThrow("address")),
                "division" to cursor.getString(cursor.getColumnIndexOrThrow("division")),
                "email" to cursor.getString(cursor.getColumnIndexOrThrow("email"))
            )
        } else null
    }

    fun insertUser(
        name: String,
        sex: String,
        bloodGroup: String,
        contact: String,
        address: String,
        division: String,
        email: String,
        password: String,
        isDonor: Boolean
    ): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("sex", sex)
            put("blood_group", bloodGroup)
            put("contact", contact)
            put("address", address)
            put("division", division)
            put("email", email)
            put("password", password)
            put("is_donor", if (isDonor) 1 else 0)
        }
        return db.insert("users", null, values)
    }
}
