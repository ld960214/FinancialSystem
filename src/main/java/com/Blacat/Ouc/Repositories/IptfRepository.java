package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Iptf;

public interface IptfRepository extends CrudRepository<Iptf, Long> {
	public List<Iptf> findBySubid(int subid);
	public Iptf findByIid(int iid);
}
