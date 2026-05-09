import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;

    @BeforeEach
    void setUp() {
        diary = new Diary("alice", "pass123");
    }


    @Test
    void testDiaryIsLockedOnCreation() {
        assertTrue(diary.isLocked());
    }

    @Test
    void testUnlockDiaryWithCorrectPassword() {
        diary.unlockDiary("pass123");
        assertFalse(diary.isLocked());
    }

    @Test
    void testUnlockDiaryWithWrongPasswordThrows() {
        assertThrows(IllegalArgumentException.class, () -> diary.unlockDiary("wrongPass"));
    }

    @Test
    void testLockDiaryAfterUnlocking() {
        diary.unlockDiary("pass123");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }


    @Test
    void testCreateEntryWhenUnlocked() {
        diary.unlockDiary("pass123");
        diary.createEntry("Title", "Body");
        assertEquals(1, diary.getEntries().size());
    }

    @Test
    void testCreateEntryWhenLockedThrows() {
        assertThrows(IllegalStateException.class, () -> diary.createEntry("Title", "Body"));
    }

    @Test
    void testFindEntryById() {
        diary.unlockDiary("pass123");
        diary.createEntry("Title", "Body");
        Entry entry = diary.findEntryById(1);
        assertEquals("Title", entry.getTitle());
        assertEquals("Body", entry.getBody());
    }

    @Test
    void testFindEntryByInvalidIdThrows() {
        diary.unlockDiary("pass123");
        assertThrows(IllegalArgumentException.class, () -> diary.findEntryById(99));
    }

    @Test
    void testDeleteEntry() {
        diary.unlockDiary("pass123");
        diary.createEntry("Title", "Body");
        diary.deleteEntry(1);
        assertEquals(0, diary.getEntries().size());
    }

    @Test
    void testUpdateEntry() {
        diary.unlockDiary("pass123");
        diary.createEntry("Old Title", "Old Body");
        diary.updateEntry(1, "New Title", "New Body");
        Entry entry = diary.findEntryById(1);
        assertEquals("New Title", entry.getTitle());
        assertEquals("New Body", entry.getBody());
    }

    @Test
    void testFindEntryWhenLockedThrows() {
        assertThrows(IllegalStateException.class, () -> diary.findEntryById(1));
    }

    @Test
    void testThatDiaryIsLockedOnEntry(){
    assertTrue(diary.isLocked());

    }
    @Test
    void testDeleteEntryThrowsErrorWhenIdIsNotFound() {
        assertThrows(IllegalStateException.class, () -> diary.deleteEntry(1));

    }
    @Test
    void testFindEntryByIdWhenItIsLocked() {
//
        assertThrows(IllegalStateException.class, () -> diary.findEntryById(2));
    }

}