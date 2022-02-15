package ru.alira.pets.chat.ui

import dev.icerock.moko.resources.desc.Raw
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.alira.pets.chat.ui.vo.ChatListItemVO
import ru.alira.pets.core.ui.*

interface ChatListViewModel : Clearable {
    val items: Flow<List<ViewObject>>
}

class ChatListViewModelImpl constructor(

) : BaseViewModel(), ChatListViewModel {

    private val _items = MutableStateFlow<List<ViewObject>>(emptyList())

    override val items: Flow<List<ViewObject>> = _items

    init {
        launch {
            _items.emit(
                Array(6) { index ->
                    ChatListItemVO(
                        id = "chat_list_item_$index",
                        logo = ImageVO.Url("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Cat_eyes_2007-1.jpg/1200px-Cat_eyes_2007-1.jpg"),
                        name = StringVO.Raw("Пельмеш"),
                        lastMessage = StringVO.Raw("Твой человек уже убрал какашки?"),
                        date = StringVO.Raw("16:23"),
                    )
                }.toList()
            )
        }
    }
}