//package com.example.cinemaxv3
//
//import com.example.cinemaxv3.domain.repository.MovieRepository
//import com.example.cinemaxv3.domain.use_cases.popularMovies_usecase.PopularMoviesUseCase
//import com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel.PopularMoviesViewModel
//import io.mockk.mockk
//import junit.framework.TestCase.assertEquals
//import junit.framework.TestCase.assertFalse
//import junit.framework.TestCase.assertNull
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//
//class PopularViewModelTest {
//
//
//    @Test
//    fun `getPopularMovies updates UI state correctly when an exception occurs`() = runBlocking {
//        // Mock dependencies
//        val getPopularMoviesUseCase: PopularMoviesUseCase = mockk()
//        val repository: MovieRepository = mockk()
//
//        // Create ViewModel instance
//        val viewModel = PopularMoviesViewModel(getPopularMoviesUseCase, repository)
//
//        // Stub repository method to throw an exception
//        whenever(repository.getPopularMovies(1)).thenThrow(RuntimeException("Some error"))
//
//        // Call the method under test
//        viewModel.getPopularMovies()
//
//        // Verify UI state
//        val uiState = viewModel.popularMoviesUiState.value
//        assertFalse(uiState.isLoading)
//        assertEquals("An unexpected error occurred", uiState.error)
//        assertNull(uiState.popularMovies)
//    }
//
//
//}