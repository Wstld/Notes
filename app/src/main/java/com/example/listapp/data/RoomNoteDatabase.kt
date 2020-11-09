package com.example.listapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

private const val DATABASE = "notesDatabase"
private val DATA = listOf<Note>(
    Note(
        title = "Kul",
        date = "2020-01-15",
        body = "test"
    ),   Note(
        title = "Sak",
        date = "2020-02-15",
        body = "test2"
    ),   Note(
        title = "Hej",
        date = "2020-03-15",
        body = "test 3"
    )
)
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class RoomNoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: RoomNoteDatabase? = null

        fun getInstance(context: Context): RoomNoteDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): RoomNoteDatabase {
            return Room.databaseBuilder(context.applicationContext, RoomNoteDatabase::class.java, DATABASE)
                .addCallback(object:Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val ex = Executors.newSingleThreadExecutor()
                        ex.execute {
                            getInstance(context).noteDao().insertData(DATA)
                        }
                    }
                }
                )
                .build()
        }
    }
}