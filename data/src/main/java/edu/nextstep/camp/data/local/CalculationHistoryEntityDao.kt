package edu.nextstep.camp.data.local

import androidx.room.*
import edu.nextstep.camp.data.local.entity.CalculationHistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CalculationHistoryEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(calculationHistory: CalculationHistoryEntity)

    @Query("SELECT * FROM CalculationHistoryEntity ORDER BY id ASC")
    fun getAllCalculationHistoryEntity(): Flow<List<CalculationHistoryEntity>>
}