import java.util.ArrayList;
import java.util.List;

    public class Diary {
        private String username;
        private String password;
        private boolean isLocked;
        private List<Entry> entries;

        public Diary(String username, String password) {
            this.username = username;
            this.password = password;
            this.isLocked = true;
            this.entries = new ArrayList<>();
        }

        public void unlockDiary(String password) {
            if (this.password.equals(password)) {
                this.isLocked = false;
            } else {
                throw new IllegalArgumentException("Incorrect password");
            }
        }

        public void lockDiary() {
            this.isLocked = true;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void createEntry(String title, String body) {
            if (isLocked) throw new IllegalStateException("Diary is locked. Unlock it first.");
            int id = entries.size() + 1;
            entries.add(new Entry(id, title, body));
        }

        public void deleteEntry(int id) {
            if (isLocked) throw new IllegalStateException("Diary is locked. Unlock it first.");
            entries.removeIf(entry -> entry.getId() == id);
        }

        public Entry findEntryById(int id) {
            if (isLocked) throw new IllegalStateException("Diary is locked. Unlock it first.");

            for (Entry entry : entries) {
                if (entry.getId() == id) {
                    return entry;
                }
            }
            throw new IllegalArgumentException("Entry not found with id: " + id);
        }

        public void updateEntry(int id, String newTitle, String newBody) {
            if (isLocked) throw new IllegalStateException("Diary is locked. Unlock it first.");
            Entry entry = findEntryById(id);
            entry.setTitle(newTitle);
            entry.setBody(newBody);
        }

        public String getUsername() { return username; }
        public List<Entry> getEntries() { return entries; }
    }

