package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Iptf;
import com.Blacat.Ouc.Repositories.IptfRepository;

@Service
public class IptfService {
	@Autowired
	IptfRepository iptfRepository;

	public List<Iptf> getIptfs(int subid) {
		return iptfRepository.findBySubid(subid);

	}

	public Iptf getIptf(int iid) {
		return iptfRepository.findByIid(iid);
	}

	@Transactional
	public boolean delIptf(int iid) {
		Iptf d = iptfRepository.findByIid(iid);
		if (d != null) {
			iptfRepository.delete(d);
			return true;
		} else
			return false;
	}

	@Transactional
	public Iptf addIptf(Iptf iptf) {
		return iptfRepository.save(iptf);
	}

	@Transactional
	public List<Iptf> addIptfs(List<Iptf> iptf) {
		Iterable<Iptf> iptf2 = iptfRepository.saveAll(iptf);
		List<Iptf> result = new ArrayList<Iptf>();
		iptf2.forEach(single -> {
			result.add(single);
		});
		return result;
	}

	@Transactional
	public List<Iptf> upIptfs(List<Iptf> iptf) {
		Iterable<Iptf> iptf2 = iptfRepository.saveAll(iptf);
		List<Iptf> result = new ArrayList<Iptf>();
		iptf2.forEach(single -> {
			result.add(single);
		});
		return result;
	}

	@Transactional
	public int delIptfs(List<Integer> iptf) {
		List<Iptf> dlist = new ArrayList<Iptf>();
		iptf.forEach(a -> {
			dlist.add(iptfRepository.findByIid(a));
		});
		dlist.forEach(a -> {
			iptfRepository.delete(a);
		});
		return dlist.size();
	}

	@Transactional
	public boolean upIptf(Iptf iptf) {
		Iptf d = iptfRepository.save(iptf);
		return d != null;
	}
}
