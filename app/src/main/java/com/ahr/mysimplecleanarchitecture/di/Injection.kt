package com.ahr.mysimplecleanarchitecture.di

import com.ahr.mysimplecleanarchitecture.data.IMessageDataSource
import com.ahr.mysimplecleanarchitecture.data.MessageDataSource
import com.ahr.mysimplecleanarchitecture.data.MessageRepository
import com.ahr.mysimplecleanarchitecture.domain.IMessageRepository
import com.ahr.mysimplecleanarchitecture.domain.MessageInteractor
import com.ahr.mysimplecleanarchitecture.domain.MessageUseCase

object Injection {
    fun provideMessageUseCase(): MessageUseCase {
        val messageRepository = provideMessageRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideMessageRepository(): IMessageRepository {
        val messageDataSource = provideMessageDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideMessageDataSource(): IMessageDataSource = MessageDataSource()
}