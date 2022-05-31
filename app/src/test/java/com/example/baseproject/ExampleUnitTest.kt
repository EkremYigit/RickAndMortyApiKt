package com.example.baseproject

import com.example.baseproject.feature.data.model.rickandmorty.Characters
import com.example.baseproject.feature.data.repository.MainRepository
import com.example.baseproject.feature.presentation.State
import com.example.baseproject.feature.presentation.viewmodels.MainViewModel
import com.google.common.truth.Truth
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response


@ExperimentalCoroutinesApi
class ExampleUnitTest {
    private val testCoroutineDispatcher = StandardTestDispatcher()
    private lateinit var mainViewModel: MainViewModel
    private val mainRepository: MainRepository = mockk(relaxed = true)


    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
        MockKAnnotations.init(this)
        mainViewModel = MainViewModel(mainRepository)
    }


    @Test
    fun `getAllCharacters is not null or empty`() = runTest {
        val data = Response.success(spyk(Characters().apply {
            this.info = mockkClass(Info::class)
        }))
        coEvery { mainRepository.getAllCharacters() } returns flowOf(BaseResponse.Success(data))
        mainViewModel.apiDataObserver.test {
            awaitItem() // Empty state
            mainViewModel.getApiData()
            awaitItem() // Loading state
            Truth.assertThat((awaitItem() as State.Loaded<Characters>).data).isNotNull()
        }
    }

    @After
    fun tearDown() {
        clearAllMocks()
        Dispatchers.resetMain()
        testCoroutineDispatcher.cancel()
    }

}