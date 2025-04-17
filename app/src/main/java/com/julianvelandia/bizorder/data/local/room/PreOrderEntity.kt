package com.julianvelandia.bizorder.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.julianvelandia.bizorder.domain.PreOrder

@Entity(tableName = "pre_orders")
data class PreOrderEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val customerName: String,
    val item: String,
    val isSent: Boolean = false
) {
    companion object {
        fun PreOrderEntity.toDomain(): PreOrder {
            return PreOrder(
                id = id,
                customerName,
                product = item,
                isSent = isSent
            )
        }
    }
}