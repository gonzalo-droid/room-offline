package com.julianvelandia.bizorder.data.local.room
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.julianvelandia.bizorder.domain.Order

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey val id: String,
    val customerName: String,
    val item: String,
    val total: Double,
    val imageUrl: String
) {
    companion object {
        fun OrderEntity.toDomain(): Order {
            return Order(
                id = id,
                customerName = customerName,
                item = item,
                total = total,
                imageUrl = imageUrl
            )
        }
    }
}


