package br.com.bercalini.cadastro;

import br.com.bercalini.repository.RestauranteRepository;
import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestauranteResourceTest {
    @Inject
    RestauranteRepository restauranteRepository;

    @Test
    @DataSet(value = "application-restaurante-cenario-1.yaml")
    public void testBuscarRestaurantes() {
            given()
                .when().get("/api/restaurantes")
                .then()
                .statusCode(200)
                .extract().asString();
     //  Approvals.verifyJson(restaurante.toString());
    }
}
