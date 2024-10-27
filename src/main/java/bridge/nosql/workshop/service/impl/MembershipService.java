package bridge.nosql.workshop.service.impl;

import bridge.nosql.workshop.dto.MembershipDTO;
import bridge.nosql.workshop.model.Group;
import bridge.nosql.workshop.model.Membership;
import bridge.nosql.workshop.model.User;
import bridge.nosql.workshop.repository.GroupRepository;
import bridge.nosql.workshop.repository.MembershipRepository;
import bridge.nosql.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public MembershipDTO addMembership(Long userId, Long groupId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Membership membership = new Membership(user, group);
        membershipRepository.save(membership);

        // Create and return dto
        MembershipDTO dto = new MembershipDTO();
        dto.setId(membership.getId());
        dto.setUserId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setGroupId(group.getId());
        dto.setGroupName(group.getName());

        return dto;
    }

    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public void removeMembership(Long membershipId) {
        membershipRepository.deleteById(membershipId);
    }

}
