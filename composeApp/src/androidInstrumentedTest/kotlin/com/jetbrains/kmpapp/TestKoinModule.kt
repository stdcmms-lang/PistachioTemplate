package com.jetbrains.kmpapp

import com.jetbrains.kmpapp.data.InMemoryMuseumStorage
import com.jetbrains.kmpapp.data.MuseumApi
import com.jetbrains.kmpapp.data.MuseumObject
import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.data.MuseumStorage
import kotlinx.coroutines.runBlocking
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Creates fake museum objects for testing
 */
fun createFakeMuseumObjects(): List<MuseumObject> {
    return listOf(
        MuseumObject(
            objectID = 1,
            title = "The Starry Night",
            artistDisplayName = "Vincent van Gogh",
            medium = "Oil on canvas",
            dimensions = "73.7 × 92.1 cm",
            objectURL = "https://example.com/starry-night",
            objectDate = "1889",
            primaryImage = "https://example.com/starry-night-large.jpg",
            primaryImageSmall = "https://example.com/starry-night-small.jpg",
            repository = "Museum of Modern Art",
            department = "Painting and Sculpture",
            creditLine = "Acquired through the Lillie P. Bliss Bequest"
        ),
        MuseumObject(
            objectID = 2,
            title = "The Great Wave off Kanagawa",
            artistDisplayName = "Katsushika Hokusai",
            medium = "Woodblock print",
            dimensions = "25.7 × 37.9 cm",
            objectURL = "https://example.com/great-wave",
            objectDate = "1830-1832",
            primaryImage = "https://example.com/great-wave-large.jpg",
            primaryImageSmall = "https://example.com/great-wave-small.jpg",
            repository = "Metropolitan Museum of Art",
            department = "Asian Art",
            creditLine = "H. O. Havemeyer Collection"
        ),
        MuseumObject(
            objectID = 3,
            title = "Water Lilies",
            artistDisplayName = "Claude Monet",
            medium = "Oil on canvas",
            dimensions = "89.5 × 100.3 cm",
            objectURL = "https://example.com/water-lilies",
            objectDate = "1919",
            primaryImage = "https://example.com/water-lilies-large.jpg",
            primaryImageSmall = "https://example.com/water-lilies-small.jpg",
            repository = "Musée d'Orsay",
            department = "Painting",
            creditLine = "Gift of the artist"
        ),
        MuseumObject(
            objectID = 4,
            title = "The Persistence of Memory",
            artistDisplayName = "Salvador Dalí",
            medium = "Oil on canvas",
            dimensions = "24 × 33 cm",
            objectURL = "https://example.com/persistence-memory",
            objectDate = "1931",
            primaryImage = "https://example.com/persistence-memory-large.jpg",
            primaryImageSmall = "https://example.com/persistence-memory-small.jpg",
            repository = "Museum of Modern Art",
            department = "Painting and Sculpture",
            creditLine = "Given anonymously"
        ),
        MuseumObject(
            objectID = 5,
            title = "Girl with a Pearl Earring",
            artistDisplayName = "Johannes Vermeer",
            medium = "Oil on canvas",
            dimensions = "44.5 × 39 cm",
            objectURL = "https://example.com/pearl-earring",
            objectDate = "1665",
            primaryImage = "https://example.com/pearl-earring-large.jpg",
            primaryImageSmall = "https://example.com/pearl-earring-small.jpg",
            repository = "Mauritshuis",
            department = "Dutch Paintings",
            creditLine = "Collection of the Mauritshuis"
        ),
        MuseumObject(
            objectID = 6,
            title = "The Scream",
            artistDisplayName = "Edvard Munch",
            medium = "Tempera and pastel on cardboard",
            dimensions = "91 × 73.5 cm",
            objectURL = "https://example.com/scream",
            objectDate = "1893",
            primaryImage = "https://example.com/scream-large.jpg",
            primaryImageSmall = "https://example.com/scream-small.jpg",
            repository = "National Gallery",
            department = "Modern Art",
            creditLine = "Purchased in 1910"
        ),
        MuseumObject(
            objectID = 7,
            title = "Sunflowers",
            artistDisplayName = "Vincent van Gogh",
            medium = "Oil on canvas",
            dimensions = "92 × 73 cm",
            objectURL = "https://example.com/sunflowers",
            objectDate = "1888",
            primaryImage = "https://example.com/sunflowers-large.jpg",
            primaryImageSmall = "https://example.com/sunflowers-small.jpg",
            repository = "National Gallery",
            department = "European Paintings",
            creditLine = "Bought by the National Gallery"
        ),
        MuseumObject(
            objectID = 8,
            title = "The Birth of Venus",
            artistDisplayName = "Sandro Botticelli",
            medium = "Tempera on canvas",
            dimensions = "172.5 × 278.5 cm",
            objectURL = "https://example.com/birth-venus",
            objectDate = "1485-1486",
            primaryImage = "https://example.com/birth-venus-large.jpg",
            primaryImageSmall = "https://example.com/birth-venus-small.jpg",
            repository = "Uffizi Gallery",
            department = "Italian Renaissance",
            creditLine = "Collection of the Uffizi"
        ),
        MuseumObject(
            objectID = 9,
            title = "Guernica",
            artistDisplayName = "Pablo Picasso",
            medium = "Oil on canvas",
            dimensions = "349.3 × 776.6 cm",
            objectURL = "https://example.com/guernica",
            objectDate = "1937",
            primaryImage = "https://example.com/guernica-large.jpg",
            primaryImageSmall = "https://example.com/guernica-small.jpg",
            repository = "Museo Reina Sofía",
            department = "Modern Art",
            creditLine = "Collection of Museo Reina Sofía"
        ),
        MuseumObject(
            objectID = 10,
            title = "The Night Watch",
            artistDisplayName = "Rembrandt van Rijn",
            medium = "Oil on canvas",
            dimensions = "363 × 437 cm",
            objectURL = "https://example.com/night-watch",
            objectDate = "1642",
            primaryImage = "https://example.com/night-watch-large.jpg",
            primaryImageSmall = "https://example.com/night-watch-small.jpg",
            repository = "Rijksmuseum",
            department = "Dutch Golden Age",
            creditLine = "Collection of the Rijksmuseum"
        ),
        MuseumObject(
            objectID = 11,
            title = "Les Demoiselles d'Avignon",
            artistDisplayName = "Pablo Picasso",
            medium = "Oil on canvas",
            dimensions = "243.9 × 233.7 cm",
            objectURL = "https://example.com/demoiselles",
            objectDate = "1907",
            primaryImage = "https://example.com/demoiselles-large.jpg",
            primaryImageSmall = "https://example.com/demoiselles-small.jpg",
            repository = "Museum of Modern Art",
            department = "Painting and Sculpture",
            creditLine = "Acquired through the Lillie P. Bliss Bequest"
        ),
        MuseumObject(
            objectID = 12,
            title = "The Garden of Earthly Delights",
            artistDisplayName = "Hieronymus Bosch",
            medium = "Oil on oak panels",
            dimensions = "220 × 389 cm",
            objectURL = "https://example.com/garden-delights",
            objectDate = "1490-1510",
            primaryImage = "https://example.com/garden-delights-large.jpg",
            primaryImageSmall = "https://example.com/garden-delights-small.jpg",
            repository = "Museo del Prado",
            department = "Flemish Painting",
            creditLine = "Collection of the Museo del Prado"
        ),
        MuseumObject(
            objectID = 13,
            title = "A Sunday Afternoon on the Island of La Grande Jatte",
            artistDisplayName = "Georges Seurat",
            medium = "Oil on canvas",
            dimensions = "207.6 × 308 cm",
            objectURL = "https://example.com/grande-jatte",
            objectDate = "1884-1886",
            primaryImage = "https://example.com/grande-jatte-large.jpg",
            primaryImageSmall = "https://example.com/grande-jatte-small.jpg",
            repository = "Art Institute of Chicago",
            department = "European Painting",
            creditLine = "Helen Birch Bartlett Memorial Collection"
        ),
        MuseumObject(
            objectID = 14,
            title = "The Last Supper",
            artistDisplayName = "Leonardo da Vinci",
            medium = "Tempera and oil on plaster",
            dimensions = "460 × 880 cm",
            objectURL = "https://example.com/last-supper",
            objectDate = "1495-1498",
            primaryImage = "https://example.com/last-supper-large.jpg",
            primaryImageSmall = "https://example.com/last-supper-small.jpg",
            repository = "Santa Maria delle Grazie",
            department = "Renaissance Art",
            creditLine = "Mural painting"
        ),
        MuseumObject(
            objectID = 15,
            title = "The Kiss",
            artistDisplayName = "Gustav Klimt",
            medium = "Oil and gold leaf on canvas",
            dimensions = "180 × 180 cm",
            objectURL = "https://example.com/kiss",
            objectDate = "1907-1908",
            primaryImage = "https://example.com/kiss-large.jpg",
            primaryImageSmall = "https://example.com/kiss-small.jpg",
            repository = "Belvedere Museum",
            department = "Modern Art",
            creditLine = "Collection of the Belvedere"
        ),
        MuseumObject(
            objectID = 16,
            title = "Nighthawks",
            artistDisplayName = "Edward Hopper",
            medium = "Oil on canvas",
            dimensions = "84.1 × 152.4 cm",
            objectURL = "https://example.com/nighthawks",
            objectDate = "1942",
            primaryImage = "https://example.com/nighthawks-large.jpg",
            primaryImageSmall = "https://example.com/nighthawks-small.jpg",
            repository = "Art Institute of Chicago",
            department = "American Art",
            creditLine = "Friends of American Art Collection"
        ),
        MuseumObject(
            objectID = 17,
            title = "The Arnolfini Portrait",
            artistDisplayName = "Jan van Eyck",
            medium = "Oil on oak panel",
            dimensions = "82.2 × 60 cm",
            objectURL = "https://example.com/arnolfini",
            objectDate = "1434",
            primaryImage = "https://example.com/arnolfini-large.jpg",
            primaryImageSmall = "https://example.com/arnolfini-small.jpg",
            repository = "National Gallery",
            department = "Early Netherlandish",
            creditLine = "Collection of the National Gallery"
        ),
        MuseumObject(
            objectID = 18,
            title = "The Hay Wain",
            artistDisplayName = "John Constable",
            medium = "Oil on canvas",
            dimensions = "130.2 × 185.4 cm",
            objectURL = "https://example.com/hay-wain",
            objectDate = "1821",
            primaryImage = "https://example.com/hay-wain-large.jpg",
            primaryImageSmall = "https://example.com/hay-wain-small.jpg",
            repository = "National Gallery",
            department = "British Art",
            creditLine = "Collection of the National Gallery"
        ),
        MuseumObject(
            objectID = 19,
            title = "Wanderer above the Sea of Fog",
            artistDisplayName = "Caspar David Friedrich",
            medium = "Oil on canvas",
            dimensions = "94.8 × 74.8 cm",
            objectURL = "https://example.com/wanderer",
            objectDate = "1818",
            primaryImage = "https://example.com/wanderer-large.jpg",
            primaryImageSmall = "https://example.com/wanderer-small.jpg",
            repository = "Hamburger Kunsthalle",
            department = "Romanticism",
            creditLine = "Collection of the Hamburger Kunsthalle"
        ),
        MuseumObject(
            objectID = 20,
            title = "The Raft of the Medusa",
            artistDisplayName = "Théodore Géricault",
            medium = "Oil on canvas",
            dimensions = "491 × 716 cm",
            objectURL = "https://example.com/medusa",
            objectDate = "1818-1819",
            primaryImage = "https://example.com/medusa-large.jpg",
            primaryImageSmall = "https://example.com/medusa-small.jpg",
            repository = "Musée du Louvre",
            department = "French Painting",
            creditLine = "Collection of the Musée du Louvre"
        ),
    )
}

/**
 * No-op implementation of MuseumApi for testing
 */
class TestMuseumApi : MuseumApi {
    override suspend fun getData(): List<MuseumObject> = emptyList()
}

/**
 * Test Koin module that provides a MuseumStorage pre-populated with fake data
 * and a MuseumRepository that doesn't try to fetch from the API
 */
fun createTestDataModule(): org.koin.core.module.Module {
    return org.koin.dsl.module {
        // Override MuseumApi with a no-op implementation
        single<MuseumApi> { TestMuseumApi() }
        
        // Override MuseumStorage with pre-populated fake data
        single<MuseumStorage> {
            val storage = InMemoryMuseumStorage()
            // Pre-populate with fake data
            runBlocking {
                storage.saveObjects(createFakeMuseumObjects())
            }
            storage
        }
        
        // Override MuseumRepository without calling initialize() to avoid API calls
        single {
            MuseumRepository(get(), get())
            // Note: We don't call initialize() here since we've already populated the storage
        }
    }
}
