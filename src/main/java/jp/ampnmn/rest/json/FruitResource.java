package jp.ampnmn.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    private final Set<Fruit> fruits = Collections.newSetFromMap(
            Collections.synchronizedMap(new LinkedHashMap<>())
    );

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    public Response list() {
        return Response.ok(fruits).build();
    }

    @POST
    public Response add(Fruit fruit) {
        fruits.add(fruit);
        return Response.ok(fruits).build();
    }

    @DELETE
    public Response delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return Response.ok(fruits).build();
    }
}
