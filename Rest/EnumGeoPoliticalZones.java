enum GeoPoliticalZone {
    NORTH_CENTRAL(new String[]{"Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"}),
    NORTH_EAST(new String[]{"Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"}),
    NORTH_WEST(new String[]{"Kaduna", "Katsina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"}),
    SOUTH_EAST(new String[]{"Abia", "Anambra", "Ebonyi", "Enugu", "Imo"}),
    SOUTH_SOUTH(new String[]{"Akwa-Ibom", "Bayelsa", "Cross-River", "Delta", "Edo", "Rivers"}),
    SOUTH_WEST(new String[]{"Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"});

    private String[] states;

    GeoPoliticalZone(String[] states) {
        this.states = states;
    }

    public String[] getStates() {
        return states;
    }
}
