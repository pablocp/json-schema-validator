/*
 * Copyright (c) 2012, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.fge.jsonschema.metaschema;

import com.github.fge.jsonschema.main.JsonSchemaException;
import com.github.fge.jsonschema.ref.JsonRef;

/**
 * Utility class to distribute schema URIs
 *
 * <p>Drafts define URIs to locate metaschemas, this class provides them.</p>
 *
 * <p>Note that it is currently buggy: the default URI is supposed to be {@code
 * http://json-schema.org/schema#}, but this URI is not accounted for at this
 * time.</p>
 *
 * @deprecated use {@link MetaSchema} instead
 */

// TODO: remove in next version
public final class SchemaURIs
{
    private static final JsonRef DRAFTV3_CORE;
    private static final JsonRef DRAFTV3_HYPERSCHEMA;
    private static final JsonRef DRAFTV4_CORE;

    // No making new instances of this class
    private SchemaURIs()
    {
    }

    static {
        String uri;
        try {
            // Draft v3
            uri = "http://json-schema.org/draft-03/schema#";
            DRAFTV3_CORE = JsonRef.fromString(uri);
            uri = "http://json-schema.org/draft-03/hyper-schema#";
            DRAFTV3_HYPERSCHEMA = JsonRef.fromString(uri);
            uri = "http://json-schema.org/draft-04/schema#";
            DRAFTV4_CORE = JsonRef.fromString(uri);
        } catch (JsonSchemaException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Return the defined URI for draft v3
     *
     * @return the URI as a {@link JsonRef}
     */
    public static JsonRef draftV3Core()
    {
        return DRAFTV3_CORE;
    }

    /**
     * Return the defined URI for draft v3 hyper schema
     *
     * @return the URI as a {@link JsonRef}
     */
    public static JsonRef draftV3HyperSchema()
    {
        return DRAFTV3_HYPERSCHEMA;
    }

    /**
     * Return the defined URI for draft v4
     *
     * @return the URI as a {@link JsonRef}
     */
    public static JsonRef draftV4Core()
    {
        return DRAFTV4_CORE;
    }
}