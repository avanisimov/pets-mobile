package ru.alira.pets.profile.ui

import dev.icerock.moko.resources.desc.Raw
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.alira.pets.core.ui.*
import ru.alira.pets.profile.ui.vo.AchievementVO

interface ProfileViewModel : Clearable {
    val petAvatar: Flow<DataState<PetAvatarVO, BaseError>>
    val achievements: Flow<DataState<List<AchievementVO>, BaseError>>
}

class ProfileViewModelImpl constructor(

) : BaseViewModel(), ProfileViewModel {
    private val _petAvatar = MutableStateFlow<DataState<PetAvatarVO, BaseError>>(DataState.Blank)
    private val _achievements = MutableStateFlow<DataState<List<AchievementVO>, BaseError>>(DataState.Blank)

    override val petAvatar: Flow<DataState<PetAvatarVO, BaseError>> = _petAvatar
    override val achievements: Flow<DataState<List<AchievementVO>, BaseError>> = _achievements

    init {
        launch {
            _petAvatar.emit(DataState.Loading)
            delay(2000)
            _petAvatar.emit(
                DataState.Ready(
                    PetAvatarVO(
                        id = "PetAvatarVO",
                        imageVO = ImageVO.Url("https://images.wallpaperscraft.ru/image/single/kot_morda_seryy_polosatyy_56515_1600x1200.jpg"),
                        name = StringVO.Raw("Барсик")
                    )
                )
            )
            _achievements.emit(
                DataState.Ready(
                    listOf(
                        AchievementVO(
                            id = "friends_count",
                            value = StringVO.Raw("123"),
                            description = StringVO.Raw("друзей"),
                        ),
                        AchievementVO(
                            id = "friends_count",
                            value = StringVO.Raw("11.5k"),
                            description = StringVO.Raw("подписчиков"),
                        ),
                        AchievementVO(
                            id = "friends_count",
                            value = StringVO.Raw("11.5k"),
                            description = StringVO.Raw("подписок"),
                        ),
                    )
                )
            )
        }
    }
}

data class PetAvatarVO(
    override val id: String,
    val imageVO: ImageVO,
    val name: StringVO
) : ViewObject