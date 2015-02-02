package io.olid16.domain.entities;

import com.google.common.collect.ImmutableSortedSet;
import io.olid16.domain.values.Chit;
import io.olid16.domain.values.Username;
import org.junit.Test;

import java.util.List;

import static builders.ChitBuilder.aChit;
import static com.google.common.truth.Truth.assertThat;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Arrays.asList;

public class WallShould {

    @Test public void
    format_chits_with_creation_instant_in_order(){
        Chit aliceChit = aChit().w("FirstAliceChit").w(now().minus(15, MINUTES).minus(10, SECONDS)).build();
        Chit bobChit = aChit().w(Username.create("Bob")).w("FirstBobChit").w(now().minus(5, SECONDS)).build();
        List<String> formattedWall = Wall.create(null,
                ImmutableSortedSet.of(bobChit, aliceChit)).
                formatWithCreationInstant();
        assertThat(formattedWall).containsSequence(asList("Alice - FirstAliceChit (15 minutes ago)", "Bob - FirstBobChit (5 seconds ago)"));
    }

    @Test public void
    return_empty_list_when_there_are_not_chits(){
        List<String> formattedWall = Wall.create(null, ImmutableSortedSet.of()).formatWithCreationInstant();
        assertThat(formattedWall).isEmpty();
    }

}