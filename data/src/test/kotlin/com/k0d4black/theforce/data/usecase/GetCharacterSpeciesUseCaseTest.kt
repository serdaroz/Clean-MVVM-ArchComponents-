package com.k0d4black.theforce.data.usecase

import com.k0d4black.theforce.data.repository.CharacterDetailsRepository
import com.k0d4black.theforce.data.usecases.GetCharacterSpeciesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class GetCharacterSpeciesUseCaseTest {
    @Mock
    private lateinit var characterDetailsRepositoryMock: CharacterDetailsRepository

    private lateinit var getCharacterSpeciesUseCase: GetCharacterSpeciesUseCase

    @Before
    fun setup() {
        getCharacterSpeciesUseCase = GetCharacterSpeciesUseCase(characterDetailsRepositoryMock)
    }

    @Test
    fun `when request for character then get character details`() {
        runBlocking {
            //Given
            val characterId = 10

            //When
            getCharacterSpeciesUseCase.execute(characterId)

            //Then
            verify(characterDetailsRepositoryMock).getCharacterSpecies(characterId)
        }
    }
}