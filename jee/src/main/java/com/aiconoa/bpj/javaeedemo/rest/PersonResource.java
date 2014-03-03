/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 AICONOA
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.aiconoa.bpj.javaeedemo.rest;

import com.aiconoa.bpj.javaeedemo.model.Person;
import com.aiconoa.bpj.javaeedemo.service.PersonService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by thomasgros on 2/25/14.
 */
@Path("/persons")
public class PersonResource {
    @Inject
    PersonService ps;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons(@Context UriInfo uriInfo) {
        List<Person> persons = ps.findAllPersons();
        JsonArrayBuilder personsBuilder = Json.createArrayBuilder();
        for(Person person: persons) {
            personsBuilder.add(
                    Json.createObjectBuilder()
                            .add("@id", uriInfo.getBaseUriBuilder().path(PersonResource.class).path("" + person.getId()).build().toString())
                            .add("@type", "Catalog")
                            .add("id", person.getId())
                            .add("firstName", person.getFirstName())
            );
        }

        JsonObject model = Json.createObjectBuilder()
                .add("@id", uriInfo.getBaseUriBuilder().path(PersonResource.class).build().toString())
                .add("@type", "Persons")
                .add("persons", personsBuilder)
                .build();

        return Response.ok(model)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getPerson(@PathParam("id") long id, @Context UriInfo uriInfo) {

        Person person = ps.findPerson(id);

        if(person == null) {
            throw new NotFoundException("Person " + id + " not found");
        }


        JsonObject model = Json.createObjectBuilder()
                .add("@id", uriInfo.getBaseUriBuilder().path(PersonResource.class).path("" + person.getId()).build().toString())
                .add("@type", "Person")
                .add("firstName", person.getFirstName())
                .build();

        return model.toString();
    }
}
