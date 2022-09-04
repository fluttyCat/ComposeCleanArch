package  dev.roshana.data.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.roshana.data.network.api.ApiService
import dev.roshana.data.repository.ArticleRepositoryImpl
import dev.roshana.domain.repositories.ArticleRepository
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /*@Provides
    @Singleton
    internal open fun providesArticleRepository(
        application: Application,
        apiService: ApiService
    ) = ArticleRepositoryImpl(application, apiService) as ArticleRepository*/

    /*@Binds
    abstract fun providesArticleRepository(impl: ArticleRepositoryImpl): ArticleRepository*/

    @Provides
    fun providesArticleRepository(retrofit: Retrofit): ArticleRepository {
        return ArticleRepositoryImpl(retrofit.create(ApiService::class.java))
    }
}
