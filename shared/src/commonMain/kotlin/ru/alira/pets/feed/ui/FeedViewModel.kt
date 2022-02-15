package ru.alira.pets.feed.ui

import dev.icerock.moko.resources.desc.Raw
import kotlinx.coroutines.flow.MutableStateFlow
import ru.alira.pets.core.ui.*
import ru.alira.pets.core.util.CFlow
import ru.alira.pets.core.util.wrap
import ru.alira.pets.feed.ui.vo.FeedItemAuthorVO
import ru.alira.pets.feed.ui.vo.FeedItemVO

interface FeedViewModel : Clearable {

    val items: CFlow<List<ViewObject>>
}

class FeedViewModelImpl constructor(

) : BaseViewModel(), FeedViewModel {

    private val _feedItems = MutableStateFlow<List<ViewObject>>(emptyList())

    override val items: CFlow<List<ViewObject>> = _feedItems.wrap()

    init {
        launch {
            _feedItems.emit(
                Array(10) { index ->
                    FeedItemVO(
                        id = "$index",
                        author = FeedItemAuthorVO(
                            id = "$index",
                            name = StringVO.Raw("author $index"),
                            image = ImageVO.Url("https://litbro.ru/wp-content/uploads/2019/12/Velsh-korgi-3-640x420.jpg")
                        ),
                        date = StringVO.Raw("20.12.2022 16:35"),
                        text = StringVO.Raw("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In scelerisque varius arcu, ac facilisis nibh ullamcorper sit amet. Nulla feugiat id augue vel ultricies. Suspendisse potenti. Nunc tempor felis quis turpis viverra, in lacinia nunc egestas. Fusce dui orci, faucibus sed consectetur in, tincidunt quis elit. Nam faucibus venenatis efficitur. Integer lectus nisl, rutrum quis enim sit amet, mollis porta leo. Cras mattis tortor pretium sapien dignissim, nec mattis enim fermentum. Etiam gravida lacinia massa feugiat placerat. Fusce at massa a magna tristique varius ac vitae lectus. Aenean dolor erat, efficitur id eleifend eu, auctor eget lacus. Sed sed ante quis leo iaculis cursus. Sed a pretium neque, nec porttitor felis."),
                        images = null,
                        videoUrl = null
                    )
                }.toList()
            )
        }
    }
}

