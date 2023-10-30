package forum.stampcards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import forum.stampcards.entity.Stampcard;
import forum.stampcards.repository.IStampcardRepo;

@RestController
public class StampcardController {
	
	@Autowired
	IStampcardRepo stampRepo;
	
	@PostMapping("/stampcards")
	public ResponseEntity<Stampcard> save(@RequestBody Stampcard stamp) {
		try {
			return new ResponseEntity<>(stampRepo.save(stamp), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/stampcards/{employeeId}")
	public ResponseEntity<List<Stampcard>> getStamps(@PathVariable String employeeId) {
		try {
			List<Stampcard> list = stampRepo.findByEmployeeIdOrderByStampNumberAscStampDateAsc(employeeId);
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/stampcards/{employeeId}/{stampNumber}")
	public ResponseEntity<List<Stampcard>> getStamps(@PathVariable String employeeId, @PathVariable Integer stampNumber) {
		try {
			List<Stampcard> list = stampRepo.findFirstByEmployeeIdAndStampNumberOrderByStampDateDesc(employeeId, stampNumber);
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
