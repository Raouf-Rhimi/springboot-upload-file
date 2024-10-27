package bridge.nosql.workshop.dto;

public class MembershipDTO {
    private Long id;
    private Long userId;
    private String username; // or any other user detail you want
    private Long groupId;
    private String groupName; // or any other group detail you want

    public MembershipDTO(Long id, Long userId, String username, Long groupId, String groupName) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.groupId = groupId;
        this.groupName = groupName;
    }
    public MembershipDTO() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
