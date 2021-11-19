package com.ahr.mysimplecleanarchitecture.data

import com.ahr.mysimplecleanarchitecture.domain.IMessageRepository
import com.ahr.mysimplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity = messageDataSource.getMessageFromSource(name)
}