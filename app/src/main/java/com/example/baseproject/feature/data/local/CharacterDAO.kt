package com.example.baseproject.feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.example.baseproject.feature.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCharacters(user: List<CharacterEntity>?)

    @Transaction
    @Query("SELECT * FROM characterentity ORDER BY id ASC")
    fun getAllCharacterDetails() : Flow<List<CharacterEntity>>

}
