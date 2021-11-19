package com.ahr.mysimplecleanarchitecture.data

import com.ahr.mysimplecleanarchitecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity = MessageEntity("Hello $name, Welcome to Clean Architecture!")
}