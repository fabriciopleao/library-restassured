package librarye2e.restassured.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

	// Random Data

	private static final Faker faker = new Faker();

	public static String tituloLivroRandom() {
        return faker.book().title();
    }

    public static String autorRandom() {
        return faker.book().author();
    }

    public static int quantidadeEstoqueRandom() {
        return faker.number().numberBetween(1, 10000);
    }

    public static String editoraRandom() {
        return faker.book().publisher();
    }

    public static int anoPublicacaoRandom() {
        return faker.number().numberBetween(1800, 2024);
    }

    public static String generoRandom() {
        return faker.book().genre();
    }
}
