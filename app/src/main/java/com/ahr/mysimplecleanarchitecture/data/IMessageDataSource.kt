package com.ahr.mysimplecleanarchitecture.data

import com.ahr.mysimplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}