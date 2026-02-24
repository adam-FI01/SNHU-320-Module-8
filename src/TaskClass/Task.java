package TaskClass;

public class Task {

    private String uniqueId;
    private String fullName;
    private String description;

    private final boolean validateID(String uniqueID) {
        if(uniqueID == null || uniqueID.length() > 10) {
            return false;
        }
        return uniqueID.matches("\\d+");
    }

    private final boolean validateName(String fullName) {
        if(fullName == null || fullName.length() > 20 || fullName.equals("")) {
            return false;
        }
        return true;
    }

    private final boolean validateDescription(String description) {
        if(description == null || description.length() > 50 || description.equals("")) {
            return false;
        }
        return true;
    }

    public Task(String uniqueId, String fullName, String description) {

        if(!this.validateID(uniqueId)) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if(!this.validateName(fullName)) {
            throw new IllegalArgumentException("Invalid name");
        }

        if(!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }

        setId(uniqueId);
        setName(fullName);
        setDescription(description);
    }

    public int getUniqueId() {
        return Integer.valueOf(uniqueId);
    }

    private void setId(String uniqueId){
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        if(!this.validateName(fullName)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(!this.validateDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}