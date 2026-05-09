
public class MainApplication {
    private Diaries diaries;

    public static void main(String[] args) {
        Diaries diaries = new Diaries();


        diaries.add("adriana", "pass246");
        diaries.add("adriel", "securePass");

        Diary adrianaDiary = diaries.findByUsername("adriana");
        adrianaDiary.unlockDiary("pass246");
        adrianaDiary.createEntry("Day 1", "Today was a great day!");
        adrianaDiary.createEntry("Day 2", "Learned how to cook afang soup.");


        Entry entry = adrianaDiary.findEntryById(1);
        System.out.println("Found: " + entry);


        adrianaDiary.updateEntry(1, "Day 1 Updated", "Even better day!");
        System.out.println("Updated: " + adrianaDiary.findEntryById(1));

        adrianaDiary.lockDiary();
        System.out.println("Adriana's diary locked: " + adrianaDiary.isLocked());


        diaries.delete("adriel", "securePass");
        System.out.println("Remaining diaries: " + diaries.getDiaries().size());
    }
}