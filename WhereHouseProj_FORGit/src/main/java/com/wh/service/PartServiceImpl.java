package com.wh.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.exceptions.PartNotFoundException;
import com.wh.model.Part;
import com.wh.repo.PartRepository;
import com.wh.utills.MyColl;
@Service
public class PartServiceImpl implements IPartService {
@Autowired
private PartRepository repo;
@Override
public Integer savePart(Part part) {
              return repo.save(part).getId();
}
@Override
public List<Part> getAllParts() {
           return repo.findAll();
}
@Override
public void deletePart(Integer id) {
Part part= getOnePart(id);
repo.delete(part);
}
@Override
public Part getOnePart(Integer id) {
	Optional<Part> opt=repo.findById(id);
	if(opt.isPresent()) {
		return (Part) opt.get();
	}
	else {
		throw new PartNotFoundException("Part '"+id+"' Not exist");
	}
//	Part part = repo.findById(id).orElseThrow(()-> new PartNotFoundException("Part '"+id+"' Not exist"));
}
@Override
public void updatePart(Part part) {
repo.save(part);
}

@Override
	public boolean getIfPartDuplicate(String partCde) {
if(repo.getDuplicateCode(partCde)==0)
	return false;
else
	return true;
	}//getIfPartDuplicate

@Override
	public Map<Integer, String> getAllPartsAsMapIdAndCode() {
	return 
	MyColl.listToMap(repo.getAllPartIDAndCode());	
	}//getAllPartsAsMapIdAndCode

}//class