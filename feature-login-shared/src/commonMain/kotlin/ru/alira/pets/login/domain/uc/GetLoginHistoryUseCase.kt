package ru.alira.pets.login.domain.uc

import kotlinx.coroutines.delay
import ru.alira.pets.MR
import ru.alira.pets.login.ui.ImageVO
import ru.alira.pets.login.ui.LoginMessageSource
import ru.alira.pets.login.ui.LoginMessageVO

interface GetLoginHistoryUseCase {
    suspend operator fun invoke(): List<LoginMessageVO>
}

class GetLoginHistoryUseCaseImpl:GetLoginHistoryUseCase {

    override suspend operator fun invoke(): List<LoginMessageVO> {
        delay(2000)
        return listOf(
            LoginMessageVO("Привет :)", source = LoginMessageSource.SYSTEM),
            LoginMessageVO("Добро пожаловать в мир питомцев!", source = LoginMessageSource.SYSTEM),
            LoginMessageVO("Уже знаешь про нас?", source = LoginMessageSource.SYSTEM),
            LoginMessageVO("Нет, расскажите", source = LoginMessageSource.USER),
            LoginMessageVO(
                "В нашем приложении ты можешь находить новых друзей своему питомцу",
                image = ImageVO.Resource(MR.images.example_friends_search),
                source = LoginMessageSource.SYSTEM
            ),
            LoginMessageVO(
                "Общаться со знакомыми, делиться фотографиями и видео",
                image = ImageVO.Resource(MR.images.example_pets_photos),
                source = LoginMessageSource.SYSTEM
            ),
            LoginMessageVO(
                "Узнавать новое про мир животных, делиться полезными советами",
                image = ImageVO.Resource(MR.images.example_pets_news),
                source = LoginMessageSource.SYSTEM
            ),
            LoginMessageVO(
                "Найти зоомагазины и ветеринарные клиники рядом со своим домом",
                source = LoginMessageSource.SYSTEM
            ),
            LoginMessageVO("Готов присоедениться?", source = LoginMessageSource.SYSTEM),
            LoginMessageVO("Да", source = LoginMessageSource.USER),
            LoginMessageVO("Введи номер телефона", source = LoginMessageSource.SYSTEM),
            LoginMessageVO("+7 977 459-90-30", source = LoginMessageSource.USER),
            LoginMessageVO(
                "Мы отправили смс на номер +7 977 459-90-30",
                source = LoginMessageSource.SYSTEM
            ),
            LoginMessageVO(" * * * * ", source = LoginMessageSource.USER),
        )
    }
}