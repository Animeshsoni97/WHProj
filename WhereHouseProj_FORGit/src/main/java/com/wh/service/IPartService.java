package com.wh.service;

import java.util.List;
import java.util.Map;

import com.wh.model.Part;

public interface IPartService {
    public Integer savePart(Part part);
    public List<Part> getAllParts();
    public void updatePart(Part part);
    public void deletePart(Integer id);
    public Part getOnePart(Integer id);
    public boolean getIfPartDuplicate(String partCde);
    public Map<Integer,String> getAllPartsAsMapIdAndCode();
}
	