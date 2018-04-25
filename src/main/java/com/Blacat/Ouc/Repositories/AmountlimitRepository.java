package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.support.Repositories;
import com.Blacat.Ouc.Entities.Amountlimit;

public interface AmountlimitRepository extends CrudRepository<Amountlimit,Long>{
	public Amountlimit findBySid(int sid);

}
