package edu.mines.csci448.examples.samodelkin.data.database

import android.content.Context
import androidx.room.*
import edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter

@Database(entities=[SamodelkinCharacter::class], version = 1)
@TypeConverters(SamodelkinTypeConverters::class)
abstract class SamodelkinDatabase : RoomDatabase (){

    companion object {
        @Volatile private  var INSTANCE: SamodelkinDatabase? = null
        fun getInstance(context: Context): SamodelkinDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context = context,
                        klass = SamodelkinDatabase::class.java,
                        name = "samodelkin-database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    abstract val samodelkinDao: SamodelkinDao
}