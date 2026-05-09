import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class DiariesTest {
        private Diaries diaries;

        @BeforeEach
        void setUp() {
            diaries = new Diaries();
        }

        @Test
        void testDiariesIsEmptyOnCreation() {
            assertEquals(0, diaries.getDiaries().size());
        }

        @Test
        void testAddDiary() {
            diaries.add("adriana", "pass246");
            assertEquals(1, diaries.getDiaries().size());
        }

        @Test
        void testFindDiaryByUsername() {
            diaries.add("adriana", "pass246");
            Diary diary = diaries.findByUsername("adriana");
            assertEquals("adriana", diary.getUsername());
        }

        @Test
        void testFindDiaryByInvalidUsernameThrows() {
            assertThrows(IllegalArgumentException.class, () -> diaries.findByUsername("Mini me"));
        }

        @Test
        void testDeleteDiary() {
            diaries.add("adriana", "pass246");
            diaries.delete("adriana", "pass246");
            assertEquals(0, diaries.getDiaries().size());
        }

        @Test
        void testDeleteDiaryWithWrongPasswordThrows() {
            diaries.add("adriana", "pass123");
            assertThrows(IllegalArgumentException.class, () -> diaries.delete("adriana", "wrongPass"));
        }

        @Test
        void testAddMultipleDiaries() {
            diaries.add("adriana", "pass246");
            diaries.add("adriel", "securePass");
            assertEquals(2, diaries.getDiaries().size());
        }
    }

