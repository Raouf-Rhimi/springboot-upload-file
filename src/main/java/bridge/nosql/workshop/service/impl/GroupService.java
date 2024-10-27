package bridge.nosql.workshop.service.impl;

import bridge.nosql.workshop.model.Group;
import bridge.nosql.workshop.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(String name) {
        return groupRepository.save(new Group(name));
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    public Group updateGroup(Long id, String name) {
        Group group = getGroupById(id);
        group.setName(name);
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
