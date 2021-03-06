package mum.swe.mumsched.subsystem.sectionreg.facade;

import java.util.List;

import mum.swe.mumsched.model.Section;

interface RegisterSectionService {
	Iterable<Section> getList();

	Section save(Section Section);

	Section findSectionById(Long id);
	
	Iterable<Section> getStudentSectionList();

	List<Section> findByEntryId(Long entryId);
}
