package io.olid16.infrastructure.dependency_injection;

import com.google.inject.AbstractModule;
import io.olid16.domain.collections.Timelines;
import io.olid16.domain.collections.Users;
import io.olid16.domain.collections.Walls;
import io.olid16.infrastructure.repositories.InMemoryTimelines;
import io.olid16.infrastructure.repositories.InMemoryUsers;
import io.olid16.infrastructure.repositories.InMemoryWalls;

import javax.inject.Singleton;

public class ChitcatModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(Users.class).to(InMemoryUsers.class).in(Singleton.class);
        bind(Timelines.class).to(InMemoryTimelines.class).in(Singleton.class);
        bind(Walls.class).to(InMemoryWalls.class).in(Singleton.class);
    }
}
