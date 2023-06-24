package f290_dsm_tp2_testes_unitarios.model;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class EstanteTest {

    @BeforeAll
    static void setUpAll() {
        System.out.println("setUpAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tearDownAll");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    
    @DisplayName("Deve criar com sucesso uma estante sem nenhum livro")
    @Test
    void testCriarEstante(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        // Arrange
        Estante estante = new Estante();

        // Act
        List<Livro> livros = estante.getLivros();

        // Assert
        Assertions.assertTrue(livros.isEmpty());
    }

    @Test
    void testAdicionarLivro(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        // Arrange
        Estante estante = new Estante();

        // Act
        estante.adicionarLivro(new Livro("Pai Pobre Pai Rico"), new Livro("Pai Pobre Pai Rico"));

        // Assert
        Assertions.assertFalse(estante.getLivros().isEmpty());
        Assertions.assertEquals(2, estante.getLivros().size());
    }
}
