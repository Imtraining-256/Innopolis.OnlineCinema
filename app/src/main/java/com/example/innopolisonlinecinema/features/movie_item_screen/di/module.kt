import com.example.innopolisonlinecinema.features.movie_item_screen.ui.MovieItemCardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieItemCardModule = module {
    viewModel {
        MovieItemCardViewModel(get())
    }
}