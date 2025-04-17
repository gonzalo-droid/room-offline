package com.julianvelandia.bizorder.domain

import com.julianvelandia.bizorder.data.local.room.OrderEntity

data class Order(
    val id: String,
    val customerName: String,
    val item: String,
    val total: Double,
    val imageUrl: String
) {
    companion object {

        fun Order.toEntity(): OrderEntity {
            return OrderEntity(
                id = id,
                customerName = customerName,
                item = item,
                total = total,
                imageUrl = imageUrl
            )
        }

    }
}