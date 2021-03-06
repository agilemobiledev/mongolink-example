/*
 * MongoLink, Object Document Mapper for Java and MongoDB
 *
 * Copyright (c) 2012, Arpinum or third-party contributors as
 * indicated by the @author tags
 *
 * MongoLink is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MongoLink is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License
 * along with MongoLink.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.mongolink.example.web.resources;

import org.junit.Rule;
import org.junit.Test;
import org.mongolink.example.test.ClientResource;
import org.mongolink.example.test.WithWebApplication;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class HomeResourceTest {

    @Rule
    public WithWebApplication webTester = new WithWebApplication();

    @Test
    public void canRepresent() throws IOException {
        ClientResource resource = webTester.newClientResource("/");

        Representation representation = resource.get();

        assertThat(resource.getStatus()).isEqualTo(Status.SUCCESS_OK);
        assertThat(representation.getMediaType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(representation.getText()).isEqualTo("{ \"message\": \"hello!\" }");
    }
}
