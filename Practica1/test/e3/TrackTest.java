package e3;

    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    /* Tracks. */

    // SFF/PL original double A-Side.
    private static Track beatlesSFFPennyLane01;
    private static Track beatlesSFFPennyLane02;

    // PL promotional release.
    private static Track beatlesPennyLanePromo01;
    private static Track beatlesPennyLanePromo02;

    // SFF digital one-track version.
    private static Track beatlesSFFDigital01;

    @BeforeAll
    static void setUp() {
        /* Recordings. */
        String recBeatlesSFF = "6f5f27e2-fe6d-4c98-be0b-1e58d569909c";
        String recBeatlesPennyLane = "5a6becfb-07e3-4286-8de0-5b4fa826f3f2";

        /* Tracks.
         * Note that some are credited to "Beatles" and some to "The Beatles".
         * Lengths may also vary slightly. */

        // https://musicbrainz.org/release/eadb40cc-9394-3787-80c3-644ed4a167c0
        beatlesSFFPennyLane01 = new Track("A", recBeatlesSFF, "The Beatles","Strawberry Fields Forever", 251);
        beatlesSFFPennyLane02 = new Track("AA", recBeatlesPennyLane,"The Beatles","Penny Lane", 178);

        // https://musicbrainz.org/release/0173d355-016f-4d28-8c57-cdb0b6fd30a0
        beatlesPennyLanePromo01 = new Track("A", recBeatlesPennyLane, "Beatles", "Penny Lane", 180);
        beatlesPennyLanePromo02 = new Track("B", recBeatlesSFF, "Beatles","Strawberry Fields Forever", 245);

        // https://musicbrainz.org/release/af20e7d5-8ab2-4967-8608-c508213b821d
        beatlesSFFDigital01 = new Track("1", recBeatlesSFF,"The Beatles","Strawberry Fields Forever (Remastered 2009)", 238);
    }

    @Test
    void testEquals() {
        assertEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo02);
        assertEquals(beatlesSFFPennyLane02, beatlesPennyLanePromo01);
        assertEquals(beatlesSFFPennyLane01, beatlesSFFDigital01);
    }

    @Test
    void testNotEquals(){
        assertNotEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo01); // Completely different songs.
    }

    @Test
    void testHashCode() {
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo02.hashCode());
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesSFFDigital01.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Posición: A\nDuración: 251\nGrabación: 6f5f27e2-fe6d-4c98-be0b-1e58d569909c\n";
        assertEquals(expectedString, beatlesSFFPennyLane01.toString());
    }

    @Test
    void testInvalidParameters() {
        assertThrows(NullPointerException.class, () -> new Track(null, "recordingID", "artist", "title", 200));
        assertThrows(NullPointerException.class, () -> new Track("A", null, "artist", "title", 200));
        assertThrows(NullPointerException.class, () -> new Track("A", "recordingID", null, "title", 200));
        assertThrows(IllegalArgumentException.class, () -> new Track("A", "recordingID", "artist", "title", -10));
    }
}
