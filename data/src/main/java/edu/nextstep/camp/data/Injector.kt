package edu.nextstep.camp.data

import android.content.Context
import edu.nextstep.camp.domain.calculator.CalculationRecordsRepository

object Injector {
    fun provideCalculationRecordsRepository(context: Context): CalculationRecordsRepository {
        return AppDatabase.getInstance(context).calculationRecordDao().let {
            DefaultCalculationRecordsRepository(it)
        }
    }
}