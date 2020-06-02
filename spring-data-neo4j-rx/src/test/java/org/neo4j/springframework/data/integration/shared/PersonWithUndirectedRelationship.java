/*
 * Copyright (c) 2019-2020 "Neo4j,"
 * Neo4j Sweden AB [https://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.springframework.data.integration.shared;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;

/**
 * @author Tamer Saadeh
 */
@Node
public class PersonWithUndirectedRelationship {

	@Id @GeneratedValue private Long id;

	private final String name;

	@Relationship(type = "FRIEND", direction = Relationship.Direction.UNDIRECTED)
	private Set<PersonWithUndirectedRelationship> friends = new HashSet<>();

	public PersonWithUndirectedRelationship(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void beFriend(PersonWithUndirectedRelationship person) {
		friends.add(person);
		person.friends.add(this);
	}

	public boolean isFriendsWith(PersonWithUndirectedRelationship person) {
		return friends.contains(person);
	}

	public Set<PersonWithUndirectedRelationship> getFriends() {
		return friends;
	}

	public void setFriends(Set<PersonWithUndirectedRelationship> friends) {
		this.friends = friends;
	}
}
