package com.example.tugasbesarkotlin3.Models
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.io.Serializable

@Entity
class User(var name: String?, var lastName: String?, var email: String?, var password: String?) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", lastName='" + lastName + '\''.toString() +
                ", email='" + email + '\''.toString() +
                ", password='" + password + '\''.toString() +
                '}'.toString()
    }
}
