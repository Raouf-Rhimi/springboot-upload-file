package bridge.nosql.workshop.controller;

import bridge.nosql.workshop.dto.MembershipDTO;
import bridge.nosql.workshop.model.Membership;
import bridge.nosql.workshop.service.impl.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<MembershipDTO> addMembership(@RequestParam Long userId, @RequestParam Long groupId) {
        return ResponseEntity.status(201).body(membershipService.addMembership(userId, groupId));
    }

    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMembership(@PathVariable Long id) {
        membershipService.removeMembership(id);
        return ResponseEntity.noContent().build();
    }
}
