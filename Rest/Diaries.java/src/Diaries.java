import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries;

    public Diaries() {
        this.diaries = new ArrayList<>();
    }

    public void add(String username, String password) {
        diaries.add(new Diary(username, password));
    }

    public Diary findByUsername(String username) {
        return diaries.stream()
                .filter(diary -> diary.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Diary not found for user: " + username));
    }

    public void delete(String username, String password) {
        Diary diary = findByUsername(username);
        diary.unlockDiary(password);
        diaries.removeIf(d -> d.getUsername().equals(username));
    }

    public List<Diary> getDiaries() { return diaries; }
}