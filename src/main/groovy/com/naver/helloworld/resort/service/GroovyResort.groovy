package com.naver.helloworld.resort.service

import com.naver.helloworld.resort.domain.Guest;
import com.naver.helloworld.resort.repository.GuestRepository;

class GroovyResort implements ResortService {
	private GuestRepository repository
	
	GroovyResort(GuestRepository repository) {
		this.repository = repository
	}

	@Override
	List<String> findGuestNamesByCompany(String company) {
		List<Guest> all = repository.findAll()
		all.findAll { g -> g.company == company }
			.sort { g -> g.grade }
			.collect { g -> g.name }
	}
}
