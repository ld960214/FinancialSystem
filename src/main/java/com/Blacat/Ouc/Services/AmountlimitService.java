package com.Blacat.Ouc.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Amountlimit;
import com.Blacat.Ouc.Repositories.AmountlimitRepository;

@Service
public class AmountlimitService {

	@Autowired
	private AmountlimitRepository amountlimtRepository;
	
	
	public Boolean addOne(){
		
		return true;
	}
	
	public Amountlimit findBySid(int sid) {
		Amountlimit a = amountlimtRepository.findBySid(sid);
		return a;
		
	}
}
