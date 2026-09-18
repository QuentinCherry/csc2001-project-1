public record Session(int id, String title, String mentor, String date, String location, int participants, int maxParticipants) {
    @Override
    public String toString(){
        return "ID: " + id
                + "\t Title: " + title
                + "\t Mentor: " + mentor
                + "\t Date: " + date
                + "\t Location: " + location
                + "\t Participants: " + participants + "/" + maxParticipants;
    }
}