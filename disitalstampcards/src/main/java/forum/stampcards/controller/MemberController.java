package forum.stampcards.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import forum.stampcards.entity.Member;
import forum.stampcards.repository.IMemberRepo;

@RestController
public class MemberController {
	
	IMemberRepo memberRepo;
	
	@Autowired
	public MemberController(IMemberRepo meberRepo){
		this.memberRepo = meberRepo;
	}
	
	@PostMapping("/members")
	public ResponseEntity<Member> save(@RequestBody Member member) {
		try {
			return new ResponseEntity<>(memberRepo.save(member), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/members")
	public ResponseEntity<Member> getMemer(@RequestHeader(name="ct-remote-user", required = false) String crUsr, @RequestParam(name="id", required = false) String id) {
		String employeeId = null;
		if(crUsr != null && !crUsr.isEmpty()) {
			employeeId = crUsr;
		}
		if(id != null && !id.isEmpty()) {
			employeeId = id;
		}
		Optional<Member> member = memberRepo.findById(employeeId);
		if (member.isPresent()) {
			return new ResponseEntity<>(member.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
