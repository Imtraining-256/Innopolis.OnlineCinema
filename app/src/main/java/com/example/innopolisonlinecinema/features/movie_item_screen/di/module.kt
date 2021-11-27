import com.example.innopolisonlinecinema.domain.model.MovieDomainModel
import com.example.innopolisonlinecinema.features.movie_item_screen.ui.MovieItemCardViewModel
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieItemCardModule = module {
    viewModel<MovieItemCardViewModel> {
        MovieItemCardViewModel(get<MovieDomainModel>(), get<Router>())
    }
}