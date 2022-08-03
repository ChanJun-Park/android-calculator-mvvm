package com.nextstep.camp.calculator.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
    val expression: String,
    val result: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
